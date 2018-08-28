package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.k.a;

protected final class k$i extends a {
    final /* synthetic */ k aOj;

    public k$i(k kVar, int i, Bundle bundle) {
        this.aOj = kVar;
        super(kVar, i, bundle);
    }

    protected final void h(ConnectionResult connectionResult) {
        k.a(this.aOj).c(connectionResult);
        k.pf();
    }

    protected final boolean pj() {
        k.a(this.aOj).c(ConnectionResult.aJB);
        return true;
    }
}
