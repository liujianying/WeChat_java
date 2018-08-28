package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;

class e$6 implements Runnable {
    final /* synthetic */ e tHE;

    e$6(e eVar) {
        this.tHE = eVar;
    }

    public final void run() {
        x.i("MicroMsg.BaseChattingUIFragment", "[doStop] activity:%s isPreLoaded:%b", new Object[]{this.tHE.tHx, Boolean.valueOf(this.tHE.tHA)});
    }
}
