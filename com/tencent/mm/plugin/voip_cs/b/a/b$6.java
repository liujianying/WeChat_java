package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.sdk.platformtools.x;

class b$6 implements Runnable {
    final /* synthetic */ b oXY;

    b$6(b bVar) {
        this.oXY = bVar;
    }

    public final void run() {
        x.i("MicroMsg.voipcs.VoipCSViewManager", "dismiss button");
        if (!b.j(this.oXY).isFinishing()) {
            b.k(this.oXY).setVisibility(8);
            b.l(this.oXY).setVisibility(8);
            b.m(this.oXY).setVisibility(8);
            b.n(this.oXY);
            b.o(this.oXY);
        }
    }
}
