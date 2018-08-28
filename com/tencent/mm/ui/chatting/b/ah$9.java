package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.b.g;

class ah$9 implements Runnable {
    final /* synthetic */ ah tSj;
    final /* synthetic */ int tSt;
    final /* synthetic */ int tSu;
    final /* synthetic */ g tSv;

    ah$9(ah ahVar, int i, int i2, g gVar) {
        this.tSj = ahVar;
        this.tSt = i;
        this.tSu = i2;
        this.tSv = gVar;
    }

    public final void run() {
        this.tSj.bAG.eX(this.tSt, this.tSu);
        x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition 222 %s %s %s", new Object[]{Integer.valueOf(this.tSj.bAG.getFirstVisiblePosition()), Integer.valueOf(this.tSj.bAG.getLastVisiblePosition()), Integer.valueOf(this.tSv.getCount())});
    }
}
