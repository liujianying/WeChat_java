package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.model.v;

class GameCenterBaseUI$1 implements Runnable {
    final /* synthetic */ GameCenterBaseUI jVk;

    GameCenterBaseUI$1(GameCenterBaseUI gameCenterBaseUI) {
        this.jVk = gameCenterBaseUI;
    }

    public final void run() {
        GameCenterBaseUI.a(this.jVk);
        if (this.jVk.jVe) {
            GameCenterBaseUI.b(this.jVk);
            ((b) g.l(b.class)).aSi();
            v.aUa();
        }
    }
}
