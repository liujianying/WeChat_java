package com.tencent.mm.ui.chatting;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.x;

class e$2 implements Runnable {
    final /* synthetic */ e tHE;

    e$2(e eVar) {
        this.tHE = eVar;
    }

    public final void run() {
        x.i("MicroMsg.BaseChattingUIFragment", "[onExitEnd] activity:%s isPreLoaded:%b", new Object[]{this.tHE.tHx, Boolean.valueOf(this.tHE.tHA)});
        e.a(this.tHE).cpL();
        e eVar = this.tHE;
        if (eVar.tHD != 0) {
            HardCoderJNI.stopPerformace(HardCoderJNI.hcQuitChattingEnable, eVar.tHD);
            eVar.tHD = 0;
        }
        this.tHE.bAG.eaR = false;
    }
}
