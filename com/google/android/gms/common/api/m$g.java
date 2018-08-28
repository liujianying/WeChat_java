package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.api.c.c;

class m$g implements b, c {
    final /* synthetic */ m aLa;

    private m$g(m mVar) {
        this.aLa = mVar;
    }

    /* synthetic */ m$g(m mVar, byte b) {
        this(mVar);
    }

    public final void a(ConnectionResult connectionResult) {
        this.aLa.aKI.lock();
        try {
            if (this.aLa.d(connectionResult)) {
                this.aLa.oO();
                this.aLa.oM();
            } else {
                this.aLa.e(connectionResult);
            }
            this.aLa.aKI.unlock();
        } catch (Throwable th) {
            this.aLa.aKI.unlock();
        }
    }

    public final void dm(int i) {
    }

    public final void e(Bundle bundle) {
        this.aLa.aKQ.a(new m.b(this.aLa));
    }
}
