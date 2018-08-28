package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.d.bf;
import com.tencent.mm.plugin.game.model.aq.1;

class aq$1$1 implements Runnable {
    final /* synthetic */ bf jOy;
    final /* synthetic */ 1 jOz;

    aq$1$1(1 1, bf bfVar) {
        this.jOz = 1;
        this.jOy = bfVar;
    }

    public final void run() {
        aq.a(this.jOy);
        if (this.jOz.jOx != null) {
            this.jOz.jOx.b(this.jOy);
        }
    }
}
