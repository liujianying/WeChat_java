package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.model.au;

class e$5 implements Runnable {
    final /* synthetic */ e ltL;

    e$5(e eVar) {
        this.ltL = eVar;
    }

    public final void run() {
        this.ltL.koX.stop();
        this.ltL.ltm = false;
        this.ltL.epT.zY();
        au.HV().setSpeakerphoneOn(this.ltL.ltn);
    }
}
