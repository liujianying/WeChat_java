package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.e;
import com.google.android.gms.common.internal.w;
import java.lang.ref.WeakReference;

class m$d implements e {
    private final WeakReference<m> aLb;
    private final a<?> aLh;
    final int aLi;

    public m$d(m mVar, a<?> aVar, int i) {
        this.aLb = new WeakReference(mVar);
        this.aLh = aVar;
        this.aLi = i;
    }

    public final void b(ConnectionResult connectionResult) {
        boolean z = false;
        m mVar = (m) this.aLb.get();
        if (mVar != null) {
            if (Looper.myLooper() == mVar.aKG.aKe) {
                z = true;
            }
            w.d(z, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            mVar.aKI.lock();
            try {
                if (mVar.dn(0)) {
                    if (!connectionResult.isSuccess()) {
                        mVar.b(connectionResult, this.aLh, this.aLi);
                    }
                    if (mVar.oJ()) {
                        mVar.oK();
                    }
                    mVar.aKI.unlock();
                }
            } finally {
                mVar.aKI.unlock();
            }
        }
    }

    public final void c(ConnectionResult connectionResult) {
        boolean z = true;
        m mVar = (m) this.aLb.get();
        if (mVar != null) {
            if (Looper.myLooper() != mVar.aKG.aKe) {
                z = false;
            }
            w.d(z, "onReportAccountValidation must be called on the GoogleApiClient handler thread");
            mVar.aKI.lock();
            try {
                if (mVar.dn(1)) {
                    if (!connectionResult.isSuccess()) {
                        mVar.b(connectionResult, this.aLh, this.aLi);
                    }
                    if (mVar.oJ()) {
                        mVar.oL();
                    }
                    mVar.aKI.unlock();
                }
            } finally {
                mVar.aKI.unlock();
            }
        }
    }
}
