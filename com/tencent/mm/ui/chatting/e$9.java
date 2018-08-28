package com.tencent.mm.ui.chatting;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.x;

class e$9 implements Runnable {
    final /* synthetic */ e tHE;

    e$9(e eVar) {
        this.tHE = eVar;
    }

    public final void run() {
        e.a(this.tHE).cpH();
        e eVar = this.tHE;
        HardCoderJNI.stopPerformace(HardCoderJNI.hcEnterChattingEnable, eVar.tHC);
        eVar.tHC = 0;
        x.i("MicroMsg.BaseChattingUIFragment", "[onEnterEnd] activity:%s isPreLoaded:%b", new Object[]{this.tHE.tHx, Boolean.valueOf(this.tHE.tHA)});
    }
}
