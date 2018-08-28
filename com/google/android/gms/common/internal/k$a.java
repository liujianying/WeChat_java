package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.k.c;

abstract class k$a extends c<Boolean> {
    public final Bundle aOi;
    final /* synthetic */ k aOj;
    public final int statusCode;

    protected k$a(k kVar, int i, Bundle bundle) {
        this.aOj = kVar;
        super(kVar, Boolean.valueOf(true));
        this.statusCode = i;
        this.aOi = bundle;
    }

    protected final /* synthetic */ void af(Object obj) {
        PendingIntent pendingIntent = null;
        if (((Boolean) obj) == null) {
            k.a(this.aOj, 1);
            return;
        }
        switch (this.statusCode) {
            case 0:
                if (!pj()) {
                    k.a(this.aOj, 1);
                    h(new ConnectionResult(8, null));
                    return;
                }
                return;
            case 10:
                k.a(this.aOj, 1);
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            default:
                k.a(this.aOj, 1);
                if (this.aOi != null) {
                    pendingIntent = (PendingIntent) this.aOi.getParcelable("pendingIntent");
                }
                h(new ConnectionResult(this.statusCode, pendingIntent));
                return;
        }
    }

    protected abstract void h(ConnectionResult connectionResult);

    protected abstract boolean pj();
}
