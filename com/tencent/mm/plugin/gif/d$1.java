package com.tencent.mm.plugin.gif;

import android.os.SystemClock;

class d$1 implements Runnable {
    final /* synthetic */ d kip;

    d$1(d dVar) {
        this.kip = dVar;
    }

    public final void run() {
        if (SystemClock.uptimeMillis() >= d.a(this.kip)) {
            this.kip.invalidateSelf();
        }
    }
}
