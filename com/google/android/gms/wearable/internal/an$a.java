package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.k.b;

abstract class an$a<T> extends a {
    private b<T> beS;

    public an$a(b<T> bVar) {
        this.beS = bVar;
    }

    public final void aq(T t) {
        b bVar = this.beS;
        if (bVar != null) {
            bVar.ad(t);
            this.beS = null;
        }
    }
}
