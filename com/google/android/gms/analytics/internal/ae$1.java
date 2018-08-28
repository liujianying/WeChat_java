package com.google.android.gms.analytics.internal;

import android.os.Looper;

class ae$1 implements Runnable {
    final /* synthetic */ ae aHn;

    ae$1(ae aeVar) {
        this.aHn = aeVar;
    }

    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ae.a(this.aHn).ns().d((Runnable) this);
            return;
        }
        boolean of = this.aHn.of();
        ae.b(this.aHn);
        if (of && !ae.c(this.aHn)) {
            this.aHn.run();
        }
    }
}
