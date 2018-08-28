package com.tencent.mm.plugin.voip_cs.b.a;

import java.util.TimerTask;

class b$7 extends TimerTask {
    final /* synthetic */ b oXY;

    b$7(b bVar) {
        this.oXY = bVar;
    }

    public final void run() {
        b.p(this.oXY).post(new 1(this));
    }
}
