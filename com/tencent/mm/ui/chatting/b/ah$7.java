package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.b.p;

class ah$7 implements Runnable {
    final /* synthetic */ ah tSj;
    final /* synthetic */ int tSs;

    ah$7(ah ahVar, int i) {
        this.tSj = ahVar;
        this.tSs = i;
    }

    public final void run() {
        x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onGetFinish mLastBigFault[%s] skipNextTopLoad true", new Object[]{Boolean.valueOf(ah.a(this.tSj))});
        if (ah.a(this.tSj)) {
            ((p) this.tSj.bAG.O(p.class)).an(this.tSs, true);
            ah.b(this.tSj);
        }
        this.tSj.tSg = true;
    }
}
