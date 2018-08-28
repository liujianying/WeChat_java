package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.ah.4;

class ah$4$1 implements Runnable {
    final /* synthetic */ 4 tSp;

    ah$4$1(4 4) {
        this.tSp = 4;
    }

    public final void run() {
        x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr needCheckHistoryTips run scrollToLastProtect BADCR_SCROLL_DELAY[%d]", new Object[]{Integer.valueOf(ah.tSa)});
        if (this.tSp.tSj.bAG != null) {
            this.tSp.tSj.bAG.lT(true);
        }
    }
}
