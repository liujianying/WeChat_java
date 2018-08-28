package com.google.android.gms.analytics.internal;

import com.google.android.gms.c.aj;

public final class v extends o {
    private final aj aGF = new aj();

    v(q qVar) {
        super(qVar);
    }

    protected final void mE() {
        this.aFn.ns().qp().a(this.aGF);
        l nv = this.aFn.nv();
        String nc = nv.nc();
        if (nc != null) {
            this.aGF.aEV = nc;
        }
        String nb = nv.nb();
        if (nb != null) {
            this.aGF.aEW = nb;
        }
    }

    public final aj nG() {
        np();
        return this.aGF;
    }
}
