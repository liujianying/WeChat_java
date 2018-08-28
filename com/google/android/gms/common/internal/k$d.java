package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.internal.k.i;
import com.google.android.gms.common.internal.r.a;

public final class k$d extends a {
    private k aOl;
    private final int aOm;

    public k$d(k kVar, int i) {
        this.aOl = kVar;
        this.aOm = i;
    }

    public final void a(int i, IBinder iBinder, Bundle bundle) {
        w.j(this.aOl, "onPostInitComplete can be called only once per call to getRemoteService");
        this.aOl.a(i, iBinder, bundle, this.aOm);
        this.aOl = null;
    }

    public final void b(int i, Bundle bundle) {
        w.j(this.aOl, "onAccountValidationComplete can be called only once per call to validateAccount");
        k kVar = this.aOl;
        kVar.mHandler.sendMessage(kVar.mHandler.obtainMessage(5, this.aOm, -1, new i(kVar, i, bundle)));
        this.aOl = null;
    }
}
