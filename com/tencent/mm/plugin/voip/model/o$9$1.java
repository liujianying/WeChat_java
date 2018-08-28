package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.g.a.tr;
import com.tencent.mm.plugin.voip.b.b;
import com.tencent.mm.plugin.voip.model.o.9;

class o$9$1 implements Runnable {
    final /* synthetic */ tr oMK;
    final /* synthetic */ 9 oML;

    o$9$1(9 9, tr trVar) {
        this.oML = 9;
        this.oMK = trVar;
    }

    public final void run() {
        switch (this.oMK.cfr.bIH) {
            case 1:
                if (b.yV(o.a(this.oML.oMC).mState)) {
                    this.oML.oMC.bKo();
                    return;
                } else {
                    this.oML.oMC.bKq();
                    return;
                }
            case 2:
                if (b.yV(o.a(this.oML.oMC).mState)) {
                    this.oML.oMC.bKn();
                    return;
                } else {
                    this.oML.oMC.bKp();
                    return;
                }
            case 3:
                this.oML.oMC.bKl();
                return;
            default:
                return;
        }
    }
}
