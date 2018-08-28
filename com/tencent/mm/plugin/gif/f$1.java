package com.tencent.mm.plugin.gif;

import android.os.SystemClock;

class f$1 implements Runnable {
    final /* synthetic */ f kiu;

    f$1(f fVar) {
        this.kiu = fVar;
    }

    public final void run() {
        if (!f.a(this.kiu)) {
            if ((this.kiu.isRunning() || f.b(this.kiu) == 0) && SystemClock.uptimeMillis() >= f.c(this.kiu)) {
                f.a(this.kiu, System.currentTimeMillis());
                this.kiu.invalidateSelf();
            }
        }
    }
}
