package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.g.e;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.source.e.a;

public final class c implements e, a {
    public final e ady;
    private a arL;
    public long arM = -9223372036854775807L;
    public long arN = -9223372036854775807L;
    private a[] arO = new a[0];
    private boolean arP = true;

    public c(e eVar) {
        this.ady = eVar;
    }

    public final void a(a aVar, long j) {
        this.arL = aVar;
        this.ady.a(this, this.arM + j);
    }

    public final void kx() {
        this.ady.kx();
    }

    public final m ky() {
        return this.ady.ky();
    }

    public final long a(e[] eVarArr, boolean[] zArr, i[] iVarArr, boolean[] zArr2, long j) {
        int i;
        boolean z;
        this.arO = new a[iVarArr.length];
        i[] iVarArr2 = new i[iVarArr.length];
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= iVarArr.length) {
                break;
            }
            this.arO[i] = (a) iVarArr[i];
            iVarArr2[i] = this.arO[i] != null ? this.arO[i].ack : null;
            i2 = i + 1;
        }
        long a = this.ady.a(eVarArr, zArr, iVarArr2, zArr2, j + this.arM);
        if (this.arP) {
            if (this.arM != 0) {
                Object obj;
                for (e eVar : eVarArr) {
                    if (eVar != null && !g.at(eVar.lH().adW)) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    z = true;
                    this.arP = z;
                }
            }
            z = false;
            this.arP = z;
        }
        z = a == this.arM + j || (a >= this.arM && (this.arN == Long.MIN_VALUE || a <= this.arN));
        com.google.android.exoplayer2.i.a.ap(z);
        i2 = 0;
        while (i2 < iVarArr.length) {
            if (iVarArr2[i2] == null) {
                this.arO[i2] = null;
            } else if (iVarArr[i2] == null || this.arO[i2].ack != iVarArr2[i2]) {
                this.arO[i2] = new a(this, iVarArr2[i2], this.arM, this.arN, this.arP);
            }
            iVarArr[i2] = this.arO[i2];
            i2++;
        }
        return a - this.arM;
    }

    public final void E(long j) {
        this.ady.E(this.arM + j);
    }

    public final long kz() {
        boolean z = false;
        if (this.arP) {
            for (a aVar : this.arO) {
                if (aVar != null) {
                    aVar.arQ = false;
                }
            }
            this.arP = false;
            long kz = kz();
            if (kz != -9223372036854775807L) {
                return kz;
            }
            return 0;
        }
        long kz2 = this.ady.kz();
        if (kz2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z2;
        if (kz2 >= this.arM) {
            z2 = true;
        } else {
            z2 = false;
        }
        com.google.android.exoplayer2.i.a.ap(z2);
        if (this.arN == Long.MIN_VALUE || kz2 <= this.arN) {
            z = true;
        }
        com.google.android.exoplayer2.i.a.ap(z);
        return kz2 - this.arM;
    }

    public final long kA() {
        long kA = this.ady.kA();
        if (kA == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        if (this.arN == Long.MIN_VALUE || kA < this.arN) {
            return Math.max(0, kA - this.arM);
        }
        return Long.MIN_VALUE;
    }

    public final long F(long j) {
        boolean z = false;
        for (a aVar : this.arO) {
            if (aVar != null) {
                aVar.arR = false;
            }
        }
        long F = this.ady.F(this.arM + j);
        if (F == this.arM + j || (F >= this.arM && (this.arN == Long.MIN_VALUE || F <= this.arN))) {
            z = true;
        }
        com.google.android.exoplayer2.i.a.ap(z);
        return F - this.arM;
    }

    public final long kB() {
        long kB = this.ady.kB();
        if (kB == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        if (this.arN == Long.MIN_VALUE || kB < this.arN) {
            return kB - this.arM;
        }
        return Long.MIN_VALUE;
    }

    public final boolean G(long j) {
        return this.ady.G(this.arM + j);
    }

    public final void a(e eVar) {
        boolean z = (this.arM == -9223372036854775807L || this.arN == -9223372036854775807L) ? false : true;
        com.google.android.exoplayer2.i.a.ap(z);
        this.arL.a(this);
    }
}
