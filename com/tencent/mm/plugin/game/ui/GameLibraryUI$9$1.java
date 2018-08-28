package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.plugin.game.ui.GameLibraryUI.9;

class GameLibraryUI$9$1 implements Runnable {
    final /* synthetic */ aj jZO;
    final /* synthetic */ 9 jZQ;

    GameLibraryUI$9$1(9 9, aj ajVar) {
        this.jZQ = 9;
        this.jZO = ajVar;
    }

    public final void run() {
        GameLibraryUI.a(this.jZQ.jZN, this.jZO, this.jZQ.jZN.jNB != 0);
        this.jZQ.jZN.jUN = false;
        this.jZQ.jZN.gPU.setVisibility(8);
        this.jZQ.jZN.jNB = this.jZQ.jZN.jNB + 15;
        if (this.jZQ.jZN.iwc != null) {
            this.jZQ.jZN.iwc.dismiss();
        }
    }
}
