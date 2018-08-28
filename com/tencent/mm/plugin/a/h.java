package com.tencent.mm.plugin.a;

import android.util.Pair;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;

public final class h extends a {
    private int[] amv;
    long duration;
    long eyR;
    long[] eyU;
    List<g> eyW = new LinkedList();
    List<Pair> eyX = new LinkedList();
    long ezb;
    private long ezc;
    private long ezd;
    private long eze;
    private long ezf;
    private int[] ezg;
    private int[] ezh;
    private int[] ezi;
    private long[] ezj;
    private int[] ezk;
    private int[] ezl;

    public h(int i, long j, int i2) {
        super(i, j, i2, 0);
    }

    public final void c(RandomAccessFile randomAccessFile) {
        byte[] bArr = new byte[8];
        int read = randomAccessFile.read(bArr);
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        while (true) {
            int i = read;
            if (i < 8) {
                break;
            }
            Object obj6;
            Object obj7;
            Object obj8;
            int B = c.B(bArr, 0);
            int B2 = c.B(bArr, 4);
            long j = 0;
            if (B2 == a.akA) {
                this.ezb = randomAccessFile.getFilePointer();
                if (c.a(randomAccessFile, 4)) {
                    byte[] bArr2 = new byte[8];
                    if (randomAccessFile.read(bArr2, 0, 4) < 4) {
                        x.w("MicroMsg.StblAtom", "stts read entry count error");
                        j = -1;
                    } else {
                        read = c.B(bArr2, 0);
                        long j2 = 8 * ((long) read);
                        if (j2 > ((long) (B - 16)) || j2 <= 0) {
                            x.w("MicroMsg.StblAtom", "stts error entryCount : " + read);
                            j = -1;
                        } else {
                            int i2 = 0;
                            int i3 = 0;
                            this.eyU = new long[(((int) (this.duration / this.eyR)) + 2)];
                            read = 1;
                            this.eyU[0] = 1;
                            long j3 = 0;
                            int read2 = randomAccessFile.read(bArr2);
                            while (true) {
                                int i4 = read2;
                                if (i4 < 8) {
                                    break;
                                }
                                j3 += (long) i4;
                                int B3 = c.B(bArr2, 0);
                                int B4 = c.B(bArr2, 4);
                                i4 = 0;
                                while (true) {
                                    read2 = i3;
                                    if (i4 >= B3) {
                                        break;
                                    }
                                    g gVar = new g();
                                    gVar.eyZ = (long) B4;
                                    this.eyW.add(gVar);
                                    i3 = i2 + B4;
                                    read2++;
                                    while (true) {
                                        i2 = (((long) i3) > this.eyR ? 1 : (((long) i3) == this.eyR ? 0 : -1));
                                        if (i2 < 0) {
                                            break;
                                        }
                                        i2 = this.eyU.length;
                                        if (read >= i2) {
                                            break;
                                        }
                                        i3 = (int) (((long) i3) - this.eyR);
                                        this.eyU[read] = (long) read2;
                                        read++;
                                    }
                                    i4++;
                                }
                                i3 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                                if (i3 >= 0) {
                                    x.d("MicroMsg.StblAtom", "read stts Atom end");
                                    i3 = read2;
                                    break;
                                }
                                i4 = randomAccessFile.read(bArr2);
                            }
                            if (read < this.eyU.length) {
                                this.eyU[read] = (long) i3;
                            }
                            j = 8 + j3;
                        }
                    }
                } else {
                    j = -1;
                }
                obj = 1;
                obj6 = obj5;
                obj7 = obj4;
                obj8 = obj3;
            } else if (B2 == a.akD) {
                j = a(randomAccessFile, B);
                obj8 = 1;
                obj6 = obj5;
                obj7 = obj4;
            } else if (B2 == a.akG) {
                j = b(randomAccessFile, B);
                obj2 = 1;
                obj6 = obj5;
                obj7 = obj4;
                obj8 = obj3;
            } else if (B2 == a.akH) {
                j = c(randomAccessFile, B);
                obj2 = 1;
                obj6 = obj5;
                obj7 = obj4;
                obj8 = obj3;
            } else if (B2 == a.akE) {
                j = d(randomAccessFile, B);
                obj7 = 1;
                obj6 = obj5;
                obj8 = obj3;
            } else if (B2 == a.akB) {
                j = e(randomAccessFile, B);
                obj6 = 1;
                obj7 = obj4;
                obj8 = obj3;
            } else {
                obj6 = obj5;
                obj7 = obj4;
                obj8 = obj3;
            }
            if (c.a(randomAccessFile, (((long) B) - j) - ((long) i))) {
                if (obj != null && obj2 != null && obj8 != null && obj7 != null && obj6 != null) {
                    x.i("MicroMsg.StblAtom", "read stbl atom finish");
                    break;
                }
                read = randomAccessFile.read(bArr);
                obj5 = obj6;
                obj4 = obj7;
                obj3 = obj8;
            } else {
                throw new IOException("skip file error.");
            }
        }
        VN();
    }

    private long a(RandomAccessFile randomAccessFile, int i) {
        this.ezc = randomAccessFile.getFilePointer();
        if (!c.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[12];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            x.w("MicroMsg.StblAtom", "stsc read entry count error");
            return -1;
        }
        int B = c.B(bArr, 0);
        long j = 12 * ((long) B);
        if (j > ((long) (i - 16)) || j <= 0) {
            x.w("MicroMsg.StblAtom", "stsc error entryCount : " + B);
            return -1;
        }
        x.d("MicroMsg.StblAtom", "handle stsc entryCount : " + B);
        this.ezg = new int[B];
        this.ezh = new int[B];
        int i2 = 0;
        long j2 = 0;
        int read = randomAccessFile.read(bArr);
        while (read >= 12) {
            j2 += (long) read;
            this.ezg[i2] = c.B(bArr, 0);
            this.ezh[i2] = c.B(bArr, 4);
            i2++;
            if (j2 >= j) {
                x.d("MicroMsg.StblAtom", "read stsc atom end");
                break;
            }
            read = randomAccessFile.read(bArr);
        }
        return j2 + 8;
    }

    private long b(RandomAccessFile randomAccessFile, int i) {
        this.ezd = randomAccessFile.getFilePointer();
        if (!c.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[4];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            x.w("MicroMsg.StblAtom", "stco read entry count error");
            return -1;
        }
        int B = c.B(bArr, 0);
        long j = ((long) B) * 4;
        if (j <= 0 || j > ((long) (i - 16))) {
            x.w("MicroMsg.StblAtom", "stco error entryCount : " + B);
            return -1;
        }
        this.ezi = new int[(B + 1)];
        int i2 = 1;
        B = randomAccessFile.read(bArr);
        long j2 = 0;
        while (B >= 4) {
            j2 += (long) B;
            int i3 = i2 + 1;
            this.ezi[i2] = c.B(bArr, 0);
            if (j2 >= j) {
                x.d("MicroMsg.StblAtom", "read stco atom end");
                break;
            }
            B = randomAccessFile.read(bArr);
            i2 = i3;
        }
        return j2 + 8;
    }

    private long c(RandomAccessFile randomAccessFile, int i) {
        this.eze = randomAccessFile.getFilePointer();
        if (!c.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[8];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            x.w("MicroMsg.StblAtom", "co64 read entry count error");
            return -1;
        }
        int B = c.B(bArr, 0);
        long j = ((long) B) * 8;
        if (j <= 0 || j > ((long) (i - 16))) {
            x.w("MicroMsg.StblAtom", "stco error entryCount : " + B);
            return -1;
        }
        this.ezj = new long[(B + 1)];
        int i2 = 1;
        B = randomAccessFile.read(bArr);
        long j2 = 0;
        while (B >= 8) {
            j2 += (long) B;
            int i3 = i2 + 1;
            this.ezj[i2] = c.R(bArr);
            if (j2 >= j) {
                x.d("MicroMsg.StblAtom", "read stco atom end");
                break;
            }
            B = randomAccessFile.read(bArr);
            i2 = i3;
        }
        return j2 + 8;
    }

    private long d(RandomAccessFile randomAccessFile, int i) {
        this.ezf = randomAccessFile.getFilePointer();
        if (!c.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[4];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            x.w("MicroMsg.StblAtom", "stsz read sample size error");
            return -1;
        }
        int B = c.B(bArr, 0);
        if (B > 0) {
            this.amv = new int[1];
            this.amv[0] = B;
            x.i("MicroMsg.StblAtom", "all sample size is the same. size : " + B);
            return 8;
        } else if (randomAccessFile.read(bArr, 0, 4) < 4) {
            x.w("MicroMsg.StblAtom", "stsz read entry count error");
            return -1;
        } else {
            B = c.B(bArr, 0);
            long j = 4 * ((long) B);
            if (j <= 0 || j > ((long) (i - 20))) {
                x.w("MicroMsg.StblAtom", "stco error entryCount : " + B);
                return -1;
            }
            this.amv = new int[(B + 1)];
            int i2 = 1;
            int read = randomAccessFile.read(bArr);
            long j2 = 0;
            while (read >= 4) {
                j2 += (long) read;
                int i3 = i2 + 1;
                this.amv[i2] = c.B(bArr, 0);
                if (j2 >= j) {
                    x.d("MicroMsg.StblAtom", "read stsz atom end");
                    break;
                }
                read = randomAccessFile.read(bArr);
                i2 = i3;
            }
            return j2 + 12;
        }
    }

    private long e(RandomAccessFile randomAccessFile, int i) {
        if (!c.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[4];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            x.w("MicroMsg.StblAtom", "stss rread entry count error");
            return -1;
        }
        int B = c.B(bArr, 0);
        long j = ((long) B) * 4;
        if (j <= 0 || j > ((long) (i - 16))) {
            x.w("MicroMsg.StblAtom", "stss error entryCount : " + B);
            return -1;
        }
        this.ezk = new int[B];
        B = randomAccessFile.read(bArr);
        long j2 = 0;
        int i2 = 0;
        while (B >= 4) {
            j2 += (long) B;
            int i3 = i2 + 1;
            this.ezk[i2] = c.B(bArr, 0);
            if (j2 >= j) {
                x.d("MicroMsg.StblAtom", "read stss atom end");
                break;
            }
            B = randomAccessFile.read(bArr);
            i2 = i3;
        }
        return j2 + 8;
    }

    private boolean VN() {
        int i;
        int i2;
        int i3;
        int i4;
        g gVar;
        int length = (this.ezi != null ? this.ezi.length : this.ezj.length) - 1;
        int length2 = this.ezg.length;
        for (i = 1; i < length2; i++) {
            this.ezg[i - 1] = this.ezg[i] - this.ezg[i - 1];
        }
        this.ezg[length2 - 1] = (length - this.ezg[length2 - 1]) + 1;
        this.ezl = new int[(length + 1)];
        this.ezl[0] = 0;
        i = 1;
        for (i2 = 0; i2 < length2; i2++) {
            i3 = this.ezg[i2];
            i4 = this.ezh[i2];
            for (length = 0; length < i3; length++) {
                this.ezl[i] = this.ezl[i - 1] + i4;
                i++;
            }
        }
        for (i2 = 0; i2 < this.eyU.length; i2++) {
            long j;
            i3 = (int) this.eyU[i2];
            i4 = iT(i3);
            length2 = this.ezl[i4 - 1] + 1;
            if (this.amv.length == 1) {
                j = ((long) this.amv[0]) * ((long) (i3 - length2));
            } else {
                j = 0;
                while (length2 <= i3) {
                    j += (long) this.amv[length2];
                    length2++;
                }
            }
            this.eyU[i2] = j + iU(i4);
        }
        long j2 = 0;
        long j3 = 0;
        length = 0;
        int i5 = 1;
        for (g gVar2 : this.eyW) {
            gVar2.size = this.amv[i5];
            i2 = iT(i5);
            if (i2 != length) {
                gVar2.start = iU(i2);
            } else {
                gVar2.start = j3;
            }
            long j4 = gVar2.start + ((long) gVar2.size);
            j2 += gVar2.eyZ;
            gVar2.eyZ = (long) ((((((float) j2) * 1.0f) / ((float) this.eyR)) * 1000.0f) * 1000.0f);
            gVar2.id = i5;
            j3 = j4;
            length = i2;
            i5++;
        }
        for (length = 0; length < this.ezk.length; length++) {
            gVar2 = (g) this.eyW.get(this.ezk[length] - 1);
            gVar2.eza = 1;
            x.d("MicroMsg.StblAtom", "stss key frame [%s %s]", new Object[]{r2.first, new Pair(Integer.valueOf(this.ezk[length] - 1), Long.valueOf(gVar2.eyZ)).second});
            this.eyX.add(r2);
        }
        return true;
    }

    private int iT(int i) {
        for (int i2 = 0; i2 < this.ezl.length; i2++) {
            if (i <= this.ezl[i2]) {
                return i2;
            }
        }
        return 0;
    }

    private long iU(int i) {
        if (this.ezi != null) {
            return (long) this.ezi[i];
        }
        if (this.ezj != null) {
            return this.ezj[i];
        }
        return 0;
    }
}
