package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.m.a;
import com.google.android.gms.common.api.o.b;

class m$a$1 extends b {
    final /* synthetic */ m aLc;
    final /* synthetic */ ConnectionResult aLd;
    final /* synthetic */ a aLe;

    m$a$1(a aVar, p pVar, m mVar, ConnectionResult connectionResult) {
        this.aLe = aVar;
        this.aLc = mVar;
        this.aLd = connectionResult;
        super(pVar);
    }

    public final void oI() {
        m mVar = this.aLc;
        ConnectionResult connectionResult = this.aLd;
        if (!mVar.dn(2)) {
            return;
        }
        if (connectionResult.isSuccess()) {
            mVar.oM();
        } else if (mVar.d(connectionResult)) {
            mVar.oO();
            mVar.oM();
        } else {
            mVar.e(connectionResult);
        }
    }
}
