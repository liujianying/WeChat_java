package com.tencent.mm.plugin.af.a;

import com.tencent.mm.g.a.gw;
import com.tencent.mm.plugin.af.a.c.a;

class c$4 implements Runnable {
    final /* synthetic */ a mje;
    final /* synthetic */ gw mjg;

    c$4(a aVar, gw gwVar) {
        this.mje = aVar;
        this.mjg = gwVar;
    }

    public final void run() {
        if (this.mje != null && this.mjg != null && this.mjg.bQe != null) {
            if (this.mjg.bQe.ret == 1) {
                this.mje.hk(true);
            } else if (this.mjg.bQe.ret == 2) {
                this.mje.hk(false);
            }
        }
    }
}
