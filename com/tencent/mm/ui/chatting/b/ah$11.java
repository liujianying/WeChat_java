package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.chatting.b.b.p;

class ah$11 implements Runnable {
    final /* synthetic */ ah tSj;
    final /* synthetic */ ai tSx;

    ah$11(ah ahVar, ai aiVar) {
        this.tSj = ahVar;
        this.tSx = aiVar;
    }

    public final void run() {
        x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify updateGoBackToHistoryMessage up UnDeliver:%d, UnRead:%d", new Object[]{Integer.valueOf(this.tSx.field_UnDeliverCount), Integer.valueOf(this.tSx.field_unReadCount)});
        ((p) this.tSj.bAG.O(p.class)).a(this.tSx, true);
    }
}
