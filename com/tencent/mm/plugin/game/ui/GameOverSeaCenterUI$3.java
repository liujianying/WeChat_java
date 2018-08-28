package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;

class GameOverSeaCenterUI$3 implements Runnable {
    final /* synthetic */ GameOverSeaCenterUI kbp;

    GameOverSeaCenterUI$3(GameOverSeaCenterUI gameOverSeaCenterUI) {
        this.kbp = gameOverSeaCenterUI;
    }

    public final void run() {
        ((c) g.l(c.class)).aSk().a("pb_over_sea", GameOverSeaCenterUI.c(this.kbp));
    }
}
