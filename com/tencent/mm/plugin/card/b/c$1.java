package com.tencent.mm.plugin.card.b;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c htM;

    c$1(c cVar) {
        this.htM = cVar;
    }

    public final boolean vD() {
        x.i("MicroMsg.CardCodeMgr", "onTimerExpired, do request code");
        this.htM.xc(this.htM.htC);
        this.htM.awA();
        return true;
    }
}
