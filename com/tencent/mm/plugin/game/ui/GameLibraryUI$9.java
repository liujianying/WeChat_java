package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.sdk.platformtools.ah;

class GameLibraryUI$9 implements Runnable {
    final /* synthetic */ a jVF;
    final /* synthetic */ GameLibraryUI jZN;

    GameLibraryUI$9(GameLibraryUI gameLibraryUI, a aVar) {
        this.jZN = gameLibraryUI;
        this.jVF = aVar;
    }

    public final void run() {
        a aVar = this.jVF;
        boolean z = GameLibraryUI.m(this.jZN) == 0 && !GameLibraryUI.n(this.jZN);
        aj ajVar = new aj(aVar, z, GameLibraryUI.m(this.jZN));
        GameLibraryUI.o(this.jZN);
        ah.A(new 1(this, ajVar));
    }
}
