package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.x;

class ad$1 implements Runnable {
    final /* synthetic */ ad tRG;

    ad$1(ad adVar) {
        this.tRG = adVar;
    }

    public final void run() {
        if (!ad.a(this.tRG)) {
            ad.b(this.tRG);
            ad.c(this.tRG);
            if (this.tRG.bAG != null) {
                this.tRG.bAG.avj();
            }
            x.i("MicroMsg.ChattingUI.SearchComponent", "dismiss fts highlight");
        }
    }
}
