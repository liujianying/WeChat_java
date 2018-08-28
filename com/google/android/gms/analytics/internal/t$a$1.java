package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.internal.t.a;

class t$a$1 implements Runnable {
    final /* synthetic */ d aGw;
    final /* synthetic */ a aGx;

    t$a$1(a aVar, d dVar) {
        this.aGx = aVar;
        this.aGw = dVar;
    }

    public final void run() {
        if (!this.aGx.aGt.isConnected()) {
            this.aGx.aGt.aP("Connected to service after a timeout");
            t tVar = this.aGx.aGt;
            d dVar = this.aGw;
            q.nx();
            tVar.aGq = dVar;
            tVar.ny();
            tVar.aFn.nt().onServiceConnected();
        }
    }
}
