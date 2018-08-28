package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import com.google.android.gms.analytics.internal.t.a;

class t$a$2 implements Runnable {
    final /* synthetic */ a aGx;
    final /* synthetic */ ComponentName aGy;

    t$a$2(a aVar, ComponentName componentName) {
        this.aGx = aVar;
        this.aGy = componentName;
    }

    public final void run() {
        t tVar = this.aGx.aGt;
        ComponentName componentName = this.aGy;
        q.nx();
        if (tVar.aGq != null) {
            tVar.aGq = null;
            tVar.d("Disconnected from device AnalyticsService", componentName);
            tVar.aFn.nt().nj();
        }
    }
}
