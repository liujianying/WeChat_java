package com.tencent.mm.ui.chatting;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

class e$10 implements Runnable {
    final /* synthetic */ e tHE;

    e$10(e eVar) {
        this.tHE = eVar;
    }

    public final void run() {
        int i = 0;
        x.i("MicroMsg.BaseChattingUIFragment", "[onExitBegin] activity:%s isPreLoaded:%b", new Object[]{this.tHE.tHx, Boolean.valueOf(this.tHE.tHA)});
        e eVar = this.tHE;
        boolean z = HardCoderJNI.hcQuitChattingEnable;
        int i2 = HardCoderJNI.hcQuitChattingDelay;
        int i3 = HardCoderJNI.hcQuitChattingCPU;
        int i4 = HardCoderJNI.hcQuitChattingIO;
        if (HardCoderJNI.hcQuitChattingThr) {
            i = g.Em().cij();
        }
        eVar.tHD = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcQuitChattingTimeout, TbsListener$ErrorCode.ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY, HardCoderJNI.hcQuitChattingAction, "ChattingUIFragment");
        e.a(this.tHE).cpK();
    }
}
