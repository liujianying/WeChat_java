package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;

class e$5 implements Runnable {
    final /* synthetic */ e tHE;

    e$5(e eVar) {
        this.tHE = eVar;
    }

    public final void run() {
        x.i("MicroMsg.BaseChattingUIFragment", "[doPause] activity:%s isPreLoaded:%b", new Object[]{this.tHE.tHx, Boolean.valueOf(this.tHE.tHA)});
        e.a(this.tHE).cpJ();
    }
}
