package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.ad.4;

class ad$4$1 implements Runnable {
    final /* synthetic */ int gIO;
    final /* synthetic */ int hW;
    final /* synthetic */ 4 tRH;

    ad$4$1(4 4, int i, int i2) {
        this.tRH = 4;
        this.hW = i;
        this.gIO = i2;
    }

    public final void run() {
        x.i("MicroMsg.ChattingUI.SearchComponent", "on search click, click position %d, set selection %d", Integer.valueOf(this.hW), Integer.valueOf(this.gIO));
        this.tRH.tRG.bAG.EV(this.gIO);
    }
}
