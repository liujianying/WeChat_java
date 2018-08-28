package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.R;

class o$14 implements Runnable {
    final /* synthetic */ o oMC;

    o$14(o oVar) {
        this.oMC = oVar;
    }

    public final void run() {
        i.bJI().stopRing();
        if (o.e(this.oMC)) {
            i.bJI().dO(R.k.playend, 0);
        } else {
            i.bJI().dO(R.k.playend, 1);
        }
    }
}
