package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;

class e$7 implements Runnable {
    final /* synthetic */ e tHE;

    e$7(e eVar) {
        this.tHE = eVar;
    }

    public final void run() {
        x.i("MicroMsg.BaseChattingUIFragment", "[doDestroy] activity:%s isPreLoaded:%b", new Object[]{this.tHE.tHx, Boolean.valueOf(this.tHE.tHA)});
        if (!this.tHE.EH(16) || this.tHE.EH(8)) {
            this.tHE.bAG.eaR = false;
            e.b(this.tHE);
            return;
        }
        throw new RuntimeException(String.format("[doDestroy] never doPause, activity:%s isPreLoaded:%b isForeground:%b isFinishing:%b isNeverCreate:%b", new Object[]{this.tHE.tHx, Boolean.valueOf(this.tHE.tHA), Boolean.valueOf(this.tHE.bAG.eaR), Boolean.valueOf(this.tHE.isFinishing()), Boolean.valueOf(this.tHE.EH(2))}));
    }
}
