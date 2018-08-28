package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;

class GameDownloadGuidanceUI$3 implements Runnable {
    final /* synthetic */ GameDownloadGuidanceUI jXC;

    GameDownloadGuidanceUI$3(GameDownloadGuidanceUI gameDownloadGuidanceUI) {
        this.jXC = gameDownloadGuidanceUI;
    }

    public final void run() {
        ((c) g.l(c.class)).aSk().a("pb_over_sea", GameDownloadGuidanceUI.b(this.jXC));
    }
}
