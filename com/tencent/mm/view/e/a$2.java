package com.tencent.mm.view.e;

import com.tencent.mm.sdk.platformtools.x;

class a$2 implements Runnable {
    final /* synthetic */ a uWa;

    a$2(a aVar) {
        this.uWa = aVar;
    }

    public final void run() {
        x.v("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onLayoutChange handle");
        this.uWa.cCp();
    }
}
