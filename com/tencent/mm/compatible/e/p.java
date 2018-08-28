package com.tencent.mm.compatible.e;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public final class p {
    private RandomAccessFile deB;
    private RandomAccessFile deC;
    private a deD;
    private ArrayList<a> deE;
    private long pid = 0;

    public class a {
        int deF;
        long deG;
        long deH;
        long deI;
        int deJ;
        long mLastIdle;

        public a() {
            this.deF = 0;
            this.deG = 0;
            this.mLastIdle = 0;
            this.deH = 0;
            this.deI = 0;
            this.deJ = 0;
        }

        public a(long j) {
            this.deH = j;
        }

        public final void a(String[] strArr, String str) {
            if (this.deH <= 0) {
                f(strArr);
                return;
            }
            if (str != null && str.length() > 0) {
                String[] split = str.split("[ ]+");
                if (split != null && split.length > 0 && split[0] != null && Long.parseLong(split[0], 10) == this.deH) {
                    long parseLong = Long.parseLong(split[13], 10);
                    long parseLong2 = Long.parseLong(split[14], 10);
                    long parseLong3 = ((parseLong + parseLong2) + Long.parseLong(split[15], 10)) + Long.parseLong(split[16], 10);
                    long parseLong4 = Long.parseLong(strArr[4], 10);
                    long j = 0;
                    Object obj = 1;
                    for (String str2 : strArr) {
                        if (obj != null) {
                            obj = null;
                        } else {
                            j += Long.parseLong(str2, 10);
                        }
                    }
                    long j2 = j - this.deG;
                    long j3 = parseLong3 - this.deI;
                    this.deF = (int) ((((float) (j2 - (parseLong4 - this.mLastIdle))) / ((float) j2)) * 100.0f);
                    this.deJ = (int) ((((float) j3) / ((float) j2)) * 100.0f);
                    this.deG = j;
                    this.mLastIdle = parseLong4;
                    this.deI = parseLong3;
                    x.i(" MicroMsg.CpuUsage", "CpuUsageInfo(%d) CPU total=%d idle=%d usage=%d pid=%d pidTotal=%d mPidUsage=%d [%d, %d, %d, %d], [%d, %d, %d]", Integer.valueOf(hashCode()), Long.valueOf(j), Long.valueOf(parseLong4), Integer.valueOf(this.deF), Long.valueOf(this.deH), Long.valueOf(parseLong3), Integer.valueOf(this.deJ), Long.valueOf(parseLong), Long.valueOf(parseLong2), Long.valueOf(r12), Long.valueOf(r14), Long.valueOf(j2), Long.valueOf(r6), Long.valueOf(j3));
                    return;
                }
            }
            x.e(" MicroMsg.CpuUsage", "update but pid not match[%d, %s] update nothing", Long.valueOf(this.deH), str);
        }

        public final void f(String[] strArr) {
            long parseLong = Long.parseLong(strArr[4], 10);
            long j = 0;
            Object obj = 1;
            for (String str : strArr) {
                if (obj != null) {
                    obj = null;
                } else {
                    j += Long.parseLong(str, 10);
                }
            }
            long j2 = j - this.deG;
            this.deF = (int) ((((float) (j2 - (parseLong - this.mLastIdle))) / ((float) j2)) * 100.0f);
            this.deG = j;
            this.mLastIdle = parseLong;
            x.i(" MicroMsg.CpuUsage", "CpuUsageInfo(" + hashCode() + ") CPU total=" + j + "; idle=" + parseLong + "; usage=" + this.deF);
        }
    }

    public p(long j) {
        this.pid = j;
    }

    private void update() {
        try {
            this.deB = new RandomAccessFile("/proc/stat", "r");
            if (this.pid > 0) {
                this.deC = new RandomAccessFile("/proc/" + this.pid + "/stat", "r");
            }
            zu();
            if (this.deB != null) {
                this.deB.close();
            }
            if (this.deC != null) {
                this.deC.close();
            }
        } catch (Throwable e) {
            x.printErrStackTrace(" MicroMsg.CpuUsage", e, "update e:", new Object[0]);
            if (this.deB != null) {
                try {
                    this.deB.close();
                } catch (Exception e2) {
                }
                this.deB = null;
            }
            if (this.deC != null) {
                try {
                    this.deC.close();
                } catch (Exception e3) {
                }
                this.deC = null;
            }
        }
    }

    private void zu() {
        String readLine;
        String str = null;
        if (this.deC != null) {
            try {
                this.deC.seek(0);
                readLine = this.deC.readLine();
            } catch (IOException e) {
                x.e(" MicroMsg.CpuUsage", "Ops pidStatFile: " + e);
            }
            if (this.deB != null) {
                try {
                    this.deB.seek(0);
                    int i = -1;
                    while (true) {
                        String readLine2 = this.deB.readLine();
                        if (readLine2 == null || readLine2.length() <= 0) {
                            x.e(" MicroMsg.CpuUsage", "unable to get cpu line cpuId[%d]", Integer.valueOf(i));
                        } else {
                            String[] split = readLine2.split("[ ]+");
                            if (split[0].indexOf("cpu") != -1) {
                                if (i == -1) {
                                    if (this.deD == null) {
                                        this.deD = new a(this.pid);
                                    }
                                    this.deD.a(split, readLine);
                                } else {
                                    if (this.deE == null) {
                                        this.deE = new ArrayList();
                                    }
                                    if (i < this.deE.size()) {
                                        ((a) this.deE.get(i)).f(split);
                                    } else {
                                        a aVar = new a();
                                        aVar.f(split);
                                        this.deE.add(aVar);
                                    }
                                }
                            }
                        }
                        int i2 = i + 1;
                        if (readLine2 != null) {
                            i = i2;
                        } else {
                            return;
                        }
                    }
                } catch (IOException e2) {
                    x.e(" MicroMsg.CpuUsage", "Ops statFile: " + e2);
                }
            }
        }
        readLine = str;
        if (this.deB != null) {
            try {
                this.deB.seek(0);
                int i3 = -1;
                while (true) {
                    String readLine22 = this.deB.readLine();
                    if (readLine22 == null || readLine22.length() <= 0) {
                        x.e(" MicroMsg.CpuUsage", "unable to get cpu line cpuId[%d]", Integer.valueOf(i3));
                    } else {
                        String[] split2 = readLine22.split("[ ]+");
                        if (split2[0].indexOf("cpu") != -1) {
                            if (i3 == -1) {
                                if (this.deD == null) {
                                    this.deD = new a(this.pid);
                                }
                                this.deD.a(split2, readLine);
                            } else {
                                if (this.deE == null) {
                                    this.deE = new ArrayList();
                                }
                                if (i3 < this.deE.size()) {
                                    ((a) this.deE.get(i3)).f(split2);
                                } else {
                                    a aVar2 = new a();
                                    aVar2.f(split2);
                                    this.deE.add(aVar2);
                                }
                            }
                        }
                    }
                    int i22 = i3 + 1;
                    if (readLine22 != null) {
                        i3 = i22;
                    } else {
                        return;
                    }
                }
            } catch (IOException e22) {
                x.e(" MicroMsg.CpuUsage", "Ops statFile: " + e22);
            }
        }
    }

    public final int zv() {
        return bi.cX(this.deE) ? 1 : this.deE.size();
    }

    public final int zw() {
        update();
        return this.deD != null ? this.deD.deF : 0;
    }

    public final int zx() {
        int i = 0;
        if (this.deD != null) {
            i = this.deD.deJ;
        }
        if (this.deE == null || this.deE.size() <= 1) {
            return i;
        }
        return i * this.deE.size();
    }

    public final String toString() {
        update();
        StringBuffer stringBuffer = new StringBuffer();
        if (this.deD != null) {
            stringBuffer.append("Cpu Total : ");
            stringBuffer.append(this.deD.deF);
            stringBuffer.append("%");
            if (this.pid > 0) {
                stringBuffer.append("pid(");
                stringBuffer.append(this.pid + ") :");
                stringBuffer.append(this.deD.deJ);
                stringBuffer.append("%");
            }
        }
        if (this.deE != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.deE.size()) {
                    break;
                }
                a aVar = (a) this.deE.get(i2);
                stringBuffer.append(" Cpu Core(" + i2 + ") : ");
                stringBuffer.append(aVar.deF);
                stringBuffer.append("%");
                i = i2 + 1;
            }
        }
        return stringBuffer.toString();
    }
}
