package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.e;

protected class k$f implements e {
    final /* synthetic */ k aOj;

    public k$f(k kVar) {
        this.aOj = kVar;
    }

    public final void b(ConnectionResult connectionResult) {
        if (connectionResult.isSuccess()) {
            this.aOj.a(null, k.d(this.aOj));
        } else if (k.e(this.aOj) != null) {
            k.e(this.aOj).a(connectionResult);
        }
    }

    public final void c(ConnectionResult connectionResult) {
        throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
    }
}
