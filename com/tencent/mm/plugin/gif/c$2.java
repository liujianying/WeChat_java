package com.tencent.mm.plugin.gif;

import android.os.SystemClock;

class c$2 implements Runnable {
    final /* synthetic */ c kie;

    c$2(c cVar) {
        this.kie = cVar;
    }

    public final void run() {
        if ((this.kie.isRunning() || c.b(this.kie) == 0) && SystemClock.uptimeMillis() >= c.c(this.kie)) {
            c.a(this.kie, System.currentTimeMillis());
            this.kie.invalidateSelf();
            if (c.a(this.kie) != null) {
                c.a(this.kie).invalidate();
            }
        }
    }
}
