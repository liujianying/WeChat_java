package com.tencent.mm.plugin.clean.b;

import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.j.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class a implements Runnable {
    private static final Long hQA = Long.valueOf(604800000);
    private static final Long hQB = Long.valueOf(7776000000L);
    private long hQC;
    private long hQD;
    private long hQE;
    private long hQF;
    private HashMap<String, Long> hQG;
    private HashSet<String> hQH;
    private c hQI;
    private boolean isStop;

    public a(c cVar) {
        this.isStop = false;
        this.isStop = false;
        this.hQI = cVar;
        this.hQG = new HashMap();
        this.hQH = new HashSet();
    }

    public final void stop() {
        this.isStop = true;
        this.hQI = null;
    }

    private String avy() {
        return hashCode();
    }

    public final void run() {
        long VG = bi.VG();
        if (this.isStop) {
            x.i("MicroMsg.CleanCalcLogic", "%s start run but stop", new Object[]{avy()});
            return;
        }
        String str;
        long yv;
        List arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        a(arrayList, hashSet);
        int size = arrayList.size();
        int i = 0;
        while (!this.isStop && i < size) {
            str = (String) arrayList.get(i);
            if (!bi.oW(str)) {
                if (str.endsWith(File.separator + "sns" + File.separator)) {
                    yv = yv(str);
                } else if (str.endsWith(File.separator + "music")) {
                    yv = yw(str);
                } else {
                    yv = yu(str);
                }
                this.hQG.put(str, Long.valueOf(yv));
                x.d("MicroMsg.CleanCalcLogic", "%s path[%s] size[%d]", new Object[]{avy(), str, Long.valueOf(yv)});
                this.hQC += yv;
                if (hashSet.contains(str)) {
                    this.hQE = yv + this.hQE;
                }
                int i2 = i + 1;
                if (this.hQI != null) {
                    this.hQI.co(i2, size);
                }
                i = i2;
            }
        }
        this.hQD = b.avr().avs().avB();
        this.hQC += this.hQD;
        if (this.hQC <= 0) {
            this.hQC = 1;
            h.mEJ.a(714, 60, 1, false);
        }
        x.i("MicroMsg.CleanCalcLogic", "%s scan finish cost[%d] micromsg[%d] acc[%d] otherAcc[%d]", new Object[]{avy(), Long.valueOf(bi.bI(VG)), Long.valueOf(this.hQC), Long.valueOf(this.hQD), Long.valueOf(this.hQE)});
        HashSet hashSet2 = this.hQH;
        if (this.hQI != null) {
            this.hQI.a(this.hQC, this.hQD, this.hQE, hashSet2, this.hQG);
        }
        j.aBt();
        long aBa = j.aBa();
        j.aBt();
        yv = j.aBb();
        int i3 = (int) ((this.hQC * 100) / aBa);
        int i4 = (int) ((this.hQD * 100) / this.hQC);
        size = (int) ((this.hQE * 100) / this.hQC);
        long j = (this.hQC - this.hQD) - this.hQE;
        int i5 = (int) ((100 * j) / this.hQC);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.hQF).append(",");
        stringBuffer.append(this.hQC).append(",");
        stringBuffer.append(i3).append(",");
        stringBuffer.append(aBa - yv).append(",");
        stringBuffer.append(yv).append(",");
        stringBuffer.append(aBa).append(",");
        stringBuffer.append(this.hQD).append(",");
        stringBuffer.append(i4).append(",");
        stringBuffer.append(this.hQE).append(",");
        stringBuffer.append(size).append(",");
        stringBuffer.append(j).append(",");
        stringBuffer.append(i5);
        x.i("MicroMsg.CleanCalcLogic", "rpt content %s", new Object[]{stringBuffer.toString()});
        h.mEJ.k(14762, str);
        stop();
    }

    private long yu(String str) {
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                long j = 0;
                for (String str2 : list) {
                    String str22;
                    StringBuilder append = new StringBuilder().append(str);
                    if (!str.endsWith("/")) {
                        str22 = "/" + str22;
                    }
                    long yu = yu(append.append(str22).toString());
                    if (yu == -1) {
                        return -1;
                    }
                    j += yu;
                }
                return j;
            }
        }
        return file.length();
    }

    private int a(List<String> list, HashSet<String> hashSet) {
        String str = g.Ei().dqo;
        String str2 = g.Ei().dqp;
        x.i("MicroMsg.CleanCalcLogic", "%s get MicroMsg path root[%s] acc[%s]", new Object[]{avy(), str, str2});
        int i = 0;
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list2 = file.list();
            if (list2 != null) {
                int length = list2.length;
                int i2 = 0;
                while (i2 < length) {
                    int i3;
                    String str3 = list2[i2];
                    String str4 = str + str3 + "/";
                    x.d("MicroMsg.CleanCalcLogic", "%s sub file path[%s] sub[%s]", new Object[]{avy(), str4, str3});
                    if (!new File(str4).isDirectory()) {
                        list.add(str4);
                        i3 = i + 1;
                    } else if (str3.length() < 32) {
                        list.add(str4);
                        i3 = i + 1;
                    } else if (bi.fS(str2, str4)) {
                        list.add(str2.endsWith("/") ? str2 + "music" : str2 + File.separator + "music");
                        au.HU();
                        list.add(c.Gg());
                        au.HU();
                        list.add(c.getAccSnsPath());
                        au.HU();
                        list.add(c.Gm());
                        i3 = i;
                    } else {
                        hashSet.add(str4);
                        list.add(str4);
                        i3 = i + 1;
                        this.hQH.add(str3);
                    }
                    i2++;
                    i = i3;
                }
            }
        }
        return i;
    }

    private long yv(String str) {
        long j = 0;
        int i = 0;
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                int length = list.length;
                while (i < length) {
                    j += yv(str + "/" + list[i]);
                    i++;
                }
                return j;
            }
        } else if (System.currentTimeMillis() - file.lastModified() > hQA.longValue()) {
            x.i("MicroMsg.CleanCalcLogic", "Clean 7 days file in sns rootPath=%s", new Object[]{str});
            long cm = (long) e.cm(str);
            if (!file.delete()) {
                return 0;
            }
            this.hQF += cm;
            return 0;
        }
        return (long) e.cm(str);
    }

    private long yw(String str) {
        long j = 0;
        int i = 0;
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                int length = list.length;
                while (i < length) {
                    j += yw(str + "/" + list[i]);
                    i++;
                }
                return j;
            }
        } else if (System.currentTimeMillis() - file.lastModified() > hQB.longValue()) {
            x.i("MicroMsg.CleanCalcLogic", "Clean 90 days file in music rootPath=%s", new Object[]{str});
            long cm = (long) e.cm(str);
            if (!file.delete()) {
                return 0;
            }
            this.hQF += cm;
            return 0;
        }
        return (long) e.cm(str);
    }
}
