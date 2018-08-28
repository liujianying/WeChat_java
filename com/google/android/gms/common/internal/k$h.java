package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.k.a;

protected final class k$h extends a {
    final /* synthetic */ k aOj;

    public k$h(k kVar) {
        this.aOj = kVar;
        super(kVar, 0, null);
    }

    protected final void h(ConnectionResult connectionResult) {
        k.a(this.aOj).b(connectionResult);
        k.pf();
    }

    protected final boolean pj() {
        k.a(this.aOj).b(ConnectionResult.aJB);
        return true;
    }
}
