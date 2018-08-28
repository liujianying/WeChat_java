package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.source.c;
import com.google.android.exoplayer2.source.e;
import com.google.android.exoplayer2.source.f;
import com.google.android.exoplayer2.source.i;

final class i$a {
    private final r[] acG;
    private final g acH;
    public final i[] adA;
    public final boolean[] adB;
    public final long adC;
    public n$a adD;
    public boolean adE;
    public boolean adF;
    public i$a adG;
    public h adH;
    private h adI;
    private final s[] ade;
    final m adf;
    private final f adm;
    public final e ady;
    public final Object adz;
    public final int index;

    public i$a(r[] rVarArr, s[] sVarArr, long j, g gVar, m mVar, f fVar, Object obj, int i, n$a n_a) {
        e cVar;
        this.acG = rVarArr;
        this.ade = sVarArr;
        this.adC = j;
        this.acH = gVar;
        this.adf = mVar;
        this.adm = fVar;
        this.adz = a.Z(obj);
        this.index = i;
        this.adD = n_a;
        this.adA = new i[rVarArr.length];
        this.adB = new boolean[rVarArr.length];
        e a = fVar.a(n_a.aer, mVar.iA());
        if (n_a.aes != Long.MIN_VALUE) {
            cVar = new c(a);
            long j2 = n_a.aes;
            cVar.arM = 0;
            cVar.arN = j2;
        } else {
            cVar = a;
        }
        this.ady = cVar;
    }

    public final long iL() {
        return this.index == 0 ? this.adC : this.adC - this.adD.adK;
    }

    public final boolean iM() {
        return this.adE && (!this.adF || this.ady.kA() == Long.MIN_VALUE);
    }

    public final boolean iN() {
        boolean z;
        h a = this.acH.a(this.ade, this.ady.ky());
        h hVar = this.adI;
        if (hVar == null) {
            z = false;
        } else {
            for (int i = 0; i < a.aAx.length; i++) {
                if (!a.a(hVar, i)) {
                    z = false;
                    break;
                }
            }
            z = true;
        }
        if (z) {
            return false;
        }
        this.adH = a;
        return true;
    }

    public final long t(long j) {
        return a(j, false, new boolean[this.acG.length]);
    }

    public final long a(long j, boolean z, boolean[] zArr) {
        com.google.android.exoplayer2.g.f fVar = this.adH.aAx;
        int i = 0;
        while (i < fVar.length) {
            boolean z2;
            boolean[] zArr2 = this.adB;
            if (z || !this.adH.a(this.adI, i)) {
                z2 = false;
            } else {
                z2 = true;
            }
            zArr2[i] = z2;
            i++;
        }
        long a = this.ady.a(fVar.lK(), this.adB, this.adA, zArr, j);
        this.adI = this.adH;
        this.adF = false;
        for (int i2 = 0; i2 < this.adA.length; i2++) {
            if (this.adA[i2] != null) {
                boolean z3;
                if (fVar.aAu[i2] != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                a.ap(z3);
                this.adF = true;
            } else {
                a.ap(fVar.aAu[i2] == null);
            }
        }
        this.adf.a(this.acG, fVar);
        return a;
    }

    public final void release() {
        try {
            if (this.adD.aes != Long.MIN_VALUE) {
                this.adm.b(((c) this.ady).ady);
            } else {
                this.adm.b(this.ady);
            }
        } catch (RuntimeException e) {
        }
    }
}
