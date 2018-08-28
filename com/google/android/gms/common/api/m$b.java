package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.t.a;
import java.lang.ref.WeakReference;

class m$b extends a {
    private final WeakReference<m> aLb;

    m$b(m mVar) {
        this.aLb = new WeakReference(mVar);
    }

    public final void a(ResolveAccountResponse resolveAccountResponse) {
        m mVar = (m) this.aLb.get();
        if (mVar != null) {
            mVar.aKG.a(new 1(this, mVar, mVar, resolveAccountResponse));
        }
    }
}
