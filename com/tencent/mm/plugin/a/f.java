package com.tencent.mm.plugin.a;

import android.annotation.TargetApi;
import android.util.Pair;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.List;

public final class f {
    private long dQs;
    private long duration;
    private long eyR;
    private long[] eyU;
    public int eyV;
    private List<g> eyW;
    private List<Pair> eyX;
    public int eyY = 0;
    private String filePath;

    public final int VM() {
        try {
            if (this.eyX == null) {
                return 0;
            }
            if (this.eyY == 0) {
                this.eyY = (int) ((((Long) ((Pair) this.eyX.get(this.eyX.size() - 1)).second).longValue() / 1000) / 1000);
            }
            return this.eyY;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Mp4Parser", e, "get last key frame error.", new Object[0]);
            return 0;
        }
    }

    @TargetApi(5)
    public final boolean b(int i, PInt pInt, PInt pInt2) {
        boolean z;
        Throwable e;
        try {
            if (this.eyX == null) {
                return false;
            }
            boolean z2;
            int size = this.eyX.size();
            long j = 1000 * (((long) i) * 1000);
            pInt2.value = 0;
            pInt.value = 0;
            for (int i2 = 0; i2 < size; i2++) {
                Pair pair = (Pair) this.eyX.get(i2);
                if (((Long) pair.second).longValue() > j) {
                    pInt2.value = (int) ((((Long) pair.second).longValue() / 1000) / 1000);
                    z2 = true;
                    break;
                }
                pInt.value = (int) ((((Long) pair.second).longValue() / 1000) / 1000);
            }
            z2 = false;
            if (z2) {
                z = z2;
            } else {
                try {
                    pInt.value = (int) ((((Long) ((Pair) this.eyX.get(size - 1)).second).longValue() / 1000) / 1000);
                    pInt2.value = i;
                    z = true;
                } catch (Exception e2) {
                    e = e2;
                    z = z2;
                    x.printErrStackTrace("MicroMsg.Mp4Parser", e, "seekVFrame seekTime[%d]", new Object[]{Integer.valueOf(i)});
                    x.i("MicroMsg.Mp4Parser", "seek key Frame seekTime[%d] pre[%d] next[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value)});
                    return z;
                }
            }
            x.i("MicroMsg.Mp4Parser", "seek key Frame seekTime[%d] pre[%d] next[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value)});
            return z;
        } catch (Throwable e3) {
            e = e3;
            z = false;
        }
    }

    public final boolean a(int i, int i2, PInt pInt, PInt pInt2) {
        if (this.eyU == null) {
            return false;
        }
        if (i < 0) {
            i = 0;
        }
        int length = this.eyU.length;
        if (i >= length || i2 >= length) {
            i = length - 2;
            i2 = length - 1;
        }
        long j = this.eyU[i];
        long j2 = this.eyU[i2];
        if (i == 0) {
            pInt.value = 0;
            pInt2.value = (int) j2;
        } else {
            pInt.value = (int) j;
            pInt2.value = ((int) j2) - ((int) j);
        }
        return true;
    }

    public final int bw(int i, int i2) {
        int i3 = 0;
        if (this.eyU == null) {
            return 0;
        }
        int i4;
        long j = (long) (i + i2);
        int i5 = 0;
        while (true) {
            i4 = i3;
            if (i5 >= this.eyU.length) {
                break;
            } else if (this.eyU[i5] == j) {
                i4 = i5;
                break;
            } else {
                if (this.eyU[i5] >= j) {
                    if (this.eyU[i5] > j) {
                        break;
                    }
                    i3 = i4;
                } else {
                    i3 = i5;
                }
                i5++;
            }
        }
        return i4;
    }

    public final boolean s(String str, long j) {
        Throwable e;
        RandomAccessFile randomAccessFile;
        this.filePath = null;
        this.eyU = null;
        this.eyV = 0;
        this.duration = 0;
        this.eyR = 0;
        this.dQs = 0;
        if (this.eyW != null) {
            this.eyW.clear();
        }
        if (this.eyX != null) {
            this.eyX.clear();
        }
        this.eyY = 0;
        this.filePath = str;
        this.dQs = j;
        File file = new File(this.filePath);
        if (!file.exists()) {
            return false;
        }
        RandomAccessFile randomAccessFile2;
        try {
            byte[] bArr = new byte[8];
            randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                a a = a(randomAccessFile2, bArr, this.dQs);
                while (a != null) {
                    x.d("MicroMsg.Mp4Parser", "last trak atom file pos : " + a.eyw);
                    e b = i.b(randomAccessFile2, bArr);
                    if (b == null || !b.a(randomAccessFile2, bArr)) {
                        x.w("MicroMsg.Mp4Parser", "mdia atom parser fail.");
                        a = null;
                    } else {
                        int i;
                        if (b.eyS == ((long) e.eyO)) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (i == 0) {
                            long VL = a.VL() - randomAccessFile2.getFilePointer();
                            x.d("MicroMsg.Mp4Parser", "this trak atom is not video trak skip: " + VL);
                            a = a(randomAccessFile2, bArr, VL);
                        } else {
                            this.eyR = b.eyR;
                            this.duration = b.duration;
                            x.d("MicroMsg.Mp4Parser", "this trak atom is video trak. timeScale: " + this.eyR + " duration: " + this.duration);
                            randomAccessFile2.seek(b.eyT);
                            h hVar = (h) c.a(randomAccessFile2, bArr, a.ajU);
                            if (hVar != null) {
                                hVar.duration = this.duration;
                                hVar.eyR = this.eyR;
                                hVar.c(randomAccessFile2);
                                this.eyU = hVar.eyU;
                                this.eyV = this.eyU.length - 2;
                                this.eyW = hVar.eyW;
                                this.eyX = hVar.eyX;
                            }
                        }
                    }
                }
                try {
                    randomAccessFile2.close();
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.Mp4Parser", e2, "", new Object[0]);
                }
                return true;
            } catch (Exception e3) {
                e2 = e3;
                randomAccessFile = randomAccessFile2;
            } catch (Throwable th) {
                e2 = th;
            }
        } catch (Exception e4) {
            e2 = e4;
            randomAccessFile = null;
            try {
                x.printErrStackTrace("MicroMsg.Mp4Parser", e2, "", new Object[0]);
                x.e("MicroMsg.Mp4Parser", "parser mp4 error. e: " + e2.toString());
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.Mp4Parser", e22, "", new Object[0]);
                    }
                }
                return false;
            } catch (Throwable th2) {
                e22 = th2;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Throwable e5) {
                        x.printErrStackTrace("MicroMsg.Mp4Parser", e5, "", new Object[0]);
                    }
                }
                throw e22;
            }
        } catch (Throwable th3) {
            e22 = th3;
            randomAccessFile2 = null;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (Throwable e52) {
                    x.printErrStackTrace("MicroMsg.Mp4Parser", e52, "", new Object[0]);
                }
            }
            throw e22;
        }
    }

    private static i a(RandomAccessFile randomAccessFile, byte[] bArr, long j) {
        x.d("MicroMsg.Mp4Parser", "start to find trak atom.");
        if (c.a(randomAccessFile, j)) {
            return (i) c.a(randomAccessFile, bArr, a.ajR);
        }
        return null;
    }
}
