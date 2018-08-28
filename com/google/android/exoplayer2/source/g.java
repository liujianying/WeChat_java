package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.c.k.a;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.k;

public final class g {
    private long[] aiA = new long[this.arX];
    private int[] aiy = new int[this.arX];
    private int arX = 1000;
    public int[] arY = new int[this.arX];
    private int[] arZ = new int[this.arX];
    private a[] asa = new a[this.arX];
    private Format[] asb = new Format[this.arX];
    public int asc;
    public int asd;
    public int ase;
    public long asf = Long.MIN_VALUE;
    public long asg = Long.MIN_VALUE;
    public boolean ash = true;
    public boolean asi = true;
    public Format asj;
    public int ask;
    public int length;
    private long[] offsets = new long[this.arX];

    public final synchronized boolean kG() {
        return this.ase != this.length;
    }

    public final synchronized Format kH() {
        return this.asi ? null : this.asj;
    }

    public final synchronized long kI() {
        return this.asg;
    }

    public final synchronized void rewind() {
        this.ase = 0;
    }

    public final synchronized int a(k kVar, e eVar, boolean z, boolean z2, Format format, a aVar) {
        int i = -4;
        synchronized (this) {
            if (kG()) {
                int cI = cI(this.ase);
                if (z || this.asb[cI] != format) {
                    kVar.aep = this.asb[cI];
                    i = -5;
                } else {
                    Object obj = (eVar.aig == null && eVar.aii == 0) ? 1 : null;
                    if (obj != null) {
                        i = -3;
                    } else {
                        eVar.aih = this.aiA[cI];
                        eVar.flags = this.arZ[cI];
                        aVar.size = this.aiy[cI];
                        aVar.mb = this.offsets[cI];
                        aVar.aml = this.asa[cI];
                        this.ase++;
                    }
                }
            } else if (z2) {
                eVar.flags = 4;
            } else if (this.asj == null || (!z && this.asj == format)) {
                i = -3;
            } else {
                kVar.aep = this.asj;
                i = -5;
            }
        }
        return i;
    }

    public final synchronized boolean e(long j, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            int cI = cI(this.ase);
            if (kG() && j >= this.aiA[cI] && (j <= this.asg || z)) {
                int a = a(cI, this.length - this.ase, j, true);
                if (a != -1) {
                    this.ase += a;
                    z2 = true;
                }
            }
        }
        return z2;
    }

    public final synchronized void kJ() {
        if (kG()) {
            this.ase = this.length;
        }
    }

    public final synchronized long f(long j, boolean z) {
        long j2;
        if (this.length == 0 || j < this.aiA[this.asd]) {
            j2 = -1;
        } else {
            int i;
            int a;
            if (z) {
                if (this.ase != this.length) {
                    i = this.ase + 1;
                    a = a(this.asd, i, j, false);
                    if (a != -1) {
                        j2 = -1;
                    } else {
                        j2 = cG(a);
                    }
                }
            }
            i = this.length;
            a = a(this.asd, i, j, false);
            if (a != -1) {
                j2 = cG(a);
            } else {
                j2 = -1;
            }
        }
        return j2;
    }

    public final synchronized long kK() {
        long j;
        if (this.ase == 0) {
            j = -1;
        } else {
            j = cG(this.ase);
        }
        return j;
    }

    public final synchronized long kL() {
        long j;
        if (this.length == 0) {
            j = -1;
        } else {
            j = cG(this.length);
        }
        return j;
    }

    public final synchronized boolean i(Format format) {
        boolean z = false;
        synchronized (this) {
            if (format == null) {
                this.asi = true;
            } else {
                this.asi = false;
                if (!t.i(format, this.asj)) {
                    this.asj = format;
                    z = true;
                }
            }
        }
        return z;
    }

    public final synchronized void a(long j, int i, long j2, int i2, a aVar) {
        if (this.ash) {
            if ((i & 1) != 0) {
                this.ash = false;
            }
        }
        com.google.android.exoplayer2.i.a.ap(!this.asi);
        I(j);
        int cI = cI(this.length);
        this.aiA[cI] = j;
        this.offsets[cI] = j2;
        this.aiy[cI] = i2;
        this.arZ[cI] = i;
        this.asa[cI] = aVar;
        this.asb[cI] = this.asj;
        this.arY[cI] = this.ask;
        this.length++;
        if (this.length == this.arX) {
            cI = this.arX + 1000;
            Object obj = new int[cI];
            Object obj2 = new long[cI];
            Object obj3 = new long[cI];
            Object obj4 = new int[cI];
            Object obj5 = new int[cI];
            Object obj6 = new a[cI];
            Object obj7 = new Format[cI];
            int i3 = this.arX - this.asd;
            System.arraycopy(this.offsets, this.asd, obj2, 0, i3);
            System.arraycopy(this.aiA, this.asd, obj3, 0, i3);
            System.arraycopy(this.arZ, this.asd, obj4, 0, i3);
            System.arraycopy(this.aiy, this.asd, obj5, 0, i3);
            System.arraycopy(this.asa, this.asd, obj6, 0, i3);
            System.arraycopy(this.asb, this.asd, obj7, 0, i3);
            System.arraycopy(this.arY, this.asd, obj, 0, i3);
            int i4 = this.asd;
            System.arraycopy(this.offsets, 0, obj2, i3, i4);
            System.arraycopy(this.aiA, 0, obj3, i3, i4);
            System.arraycopy(this.arZ, 0, obj4, i3, i4);
            System.arraycopy(this.aiy, 0, obj5, i3, i4);
            System.arraycopy(this.asa, 0, obj6, i3, i4);
            System.arraycopy(this.asb, 0, obj7, i3, i4);
            System.arraycopy(this.arY, 0, obj, i3, i4);
            this.offsets = obj2;
            this.aiA = obj3;
            this.arZ = obj4;
            this.aiy = obj5;
            this.asa = obj6;
            this.asb = obj7;
            this.arY = obj;
            this.asd = 0;
            this.length = this.arX;
            this.arX = cI;
        }
    }

    private synchronized void I(long j) {
        this.asg = Math.max(this.asg, j);
    }

    public final synchronized boolean J(long j) {
        boolean z = true;
        boolean z2 = false;
        synchronized (this) {
            if (this.length == 0) {
                if (j <= this.asf) {
                    z = false;
                }
            } else if (Math.max(this.asf, cH(this.ase)) >= j) {
                z = false;
            } else {
                int i = this.length;
                int cI = cI(this.length - 1);
                while (i > this.ase && this.aiA[cI] >= j) {
                    i--;
                    cI--;
                    if (cI == -1) {
                        cI = this.arX - 1;
                    }
                }
                cI = (this.asc + this.length) - (this.asc + i);
                if (cI >= 0 && cI <= this.length - this.ase) {
                    z2 = true;
                }
                com.google.android.exoplayer2.i.a.ao(z2);
                this.length -= cI;
                this.asg = Math.max(this.asf, cH(this.length));
            }
        }
        return z;
    }

    private int a(int i, int i2, long j, boolean z) {
        int i3 = -1;
        int i4 = 0;
        while (i4 < i2 && this.aiA[i] <= j) {
            if (!(z && (this.arZ[i] & 1) == 0)) {
                i3 = i4;
            }
            int i5 = i + 1;
            if (i5 == this.arX) {
                i5 = 0;
            }
            i4++;
            i = i5;
        }
        return i3;
    }

    private long cG(int i) {
        this.asf = Math.max(this.asf, cH(i));
        this.length -= i;
        this.asc += i;
        this.asd += i;
        if (this.asd >= this.arX) {
            this.asd -= this.arX;
        }
        this.ase -= i;
        if (this.ase < 0) {
            this.ase = 0;
        }
        if (this.length != 0) {
            return this.offsets[this.asd];
        }
        int i2 = (this.asd == 0 ? this.arX : this.asd) - 1;
        return ((long) this.aiy[i2]) + this.offsets[i2];
    }

    private long cH(int i) {
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int cI = cI(i - 1);
        int i2 = 0;
        long j = Long.MIN_VALUE;
        while (i2 < i) {
            j = Math.max(j, this.aiA[cI]);
            if ((this.arZ[cI] & 1) != 0) {
                break;
            }
            int i3 = cI - 1;
            if (i3 == -1) {
                i3 = this.arX - 1;
            }
            i2++;
            cI = i3;
        }
        return j;
    }

    public final int cI(int i) {
        int i2 = this.asd + i;
        return i2 < this.arX ? i2 : i2 - this.arX;
    }
}
