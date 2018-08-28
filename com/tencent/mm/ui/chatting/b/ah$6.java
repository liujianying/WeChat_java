package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.b.w;

class ah$6 implements Runnable {
    final /* synthetic */ ah tSj;

    ah$6(ah ahVar) {
        this.tSj = ahVar;
    }

    public final void run() {
        if (this.tSj.bAG == null) {
            x.w("MicroMsg.ChattingUI.SilenceMsgComponent", "mChattingContext is null! maybe Chatting has exited!");
            return;
        }
        this.tSj.bAG.tTs.cub();
        if (this.tSj.tSc) {
            this.tSj.tSc = false;
            this.tSj.bAG.tTs.setIsBottomShowAll(((g) this.tSj.bAG.O(g.class)).ctK());
            this.tSj.bAG.tTs.setBottomViewVisible(((w) this.tSj.bAG.O(w.class)).cvQ());
            this.tSj.bAG.tTs.lK(false);
            x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onGetFinish set needCheckHistoryTips[%b]", new Object[]{Boolean.valueOf(this.tSj.tSc)});
        }
    }
}
