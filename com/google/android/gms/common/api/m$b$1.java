package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.o.b;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.p.a;

class m$b$1 extends b {
    final /* synthetic */ m aLc;
    final /* synthetic */ ResolveAccountResponse aLf;
    final /* synthetic */ m.b aLg;

    m$b$1(m.b bVar, p pVar, m mVar, ResolveAccountResponse resolveAccountResponse) {
        this.aLg = bVar;
        this.aLc = mVar;
        this.aLf = resolveAccountResponse;
        super(pVar);
    }

    public final void oI() {
        m mVar = this.aLc;
        ResolveAccountResponse resolveAccountResponse = this.aLf;
        if (mVar.dn(0)) {
            ConnectionResult connectionResult = resolveAccountResponse.aLZ;
            if (connectionResult.isSuccess()) {
                mVar.aKU = a.g(resolveAccountResponse.aMV);
                mVar.aKT = true;
                mVar.aKV = resolveAccountResponse.aKV;
                mVar.aKW = resolveAccountResponse.aNk;
                mVar.oK();
            } else if (mVar.d(connectionResult)) {
                mVar.oO();
                mVar.oK();
            } else {
                mVar.e(connectionResult);
            }
        }
    }
}
