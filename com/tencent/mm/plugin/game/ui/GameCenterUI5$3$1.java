package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.ui.GameCenterUI5.3;

class GameCenterUI5$3$1 implements Runnable {
    final /* synthetic */ 3 jVI;

    GameCenterUI5$3$1(3 3) {
        this.jVI = 3;
    }

    public final void run() {
        if (!this.jVI.jVE.isFinishing()) {
            GameCenterUI5.a(this.jVI.jVE, c.dD(this.jVI.jVE));
            GameCenterUI5.a(this.jVI.jVE).show();
        }
    }
}
