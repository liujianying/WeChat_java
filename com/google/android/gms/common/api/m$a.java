package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.signin.internal.AuthAccountResult;
import com.google.android.gms.signin.internal.b;
import java.lang.ref.WeakReference;

class m$a extends b {
    private final WeakReference<m> aLb;

    m$a(m mVar) {
        this.aLb = new WeakReference(mVar);
    }

    public final void a(ConnectionResult connectionResult, AuthAccountResult authAccountResult) {
        m mVar = (m) this.aLb.get();
        if (mVar != null) {
            mVar.aKG.a(new 1(this, mVar, mVar, connectionResult));
        }
    }
}
