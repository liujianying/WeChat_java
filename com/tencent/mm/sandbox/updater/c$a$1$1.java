package com.tencent.mm.sandbox.updater;

import com.tencent.mm.sandbox.updater.c.a;
import com.tencent.mm.sandbox.updater.c.a.1;

class c$a$1$1 implements Runnable {
    final /* synthetic */ int sDW;
    final /* synthetic */ 1 sDX;

    c$a$1$1(1 1, int i) {
        this.sDX = 1;
        this.sDW = i;
    }

    public final void run() {
        if (a.a(this.sDX.sDV) <= a.b(this.sDX.sDV)) {
            a.c(this.sDX.sDV).co(a.b(this.sDX.sDV), a.a(this.sDX.sDV));
        }
        a.c(this.sDX.sDV).fW((long) this.sDW);
    }
}
