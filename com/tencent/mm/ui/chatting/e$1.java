package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;

class e$1 implements Runnable {
    final /* synthetic */ e tHE;

    e$1(e eVar) {
        this.tHE = eVar;
    }

    public final void run() {
        this.tHE.bAG.eaR = true;
        e.a(this.tHE).cpF();
        x.i("MicroMsg.BaseChattingUIFragment", "[doCreate] activity:%s isPreLoaded:%b", new Object[]{this.tHE.tHx, Boolean.valueOf(this.tHE.tHA)});
    }
}
