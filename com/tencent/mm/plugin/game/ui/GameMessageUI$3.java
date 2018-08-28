package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.ui.r.a;

class GameMessageUI$3 implements a {
    final /* synthetic */ GameMessageUI kbc;

    GameMessageUI$3(GameMessageUI gameMessageUI) {
        this.kbc = gameMessageUI;
    }

    public final void Xa() {
    }

    public final void Xb() {
        if (GameMessageUI.b(this.kbc).getCount() == 0) {
            GameMessageUI.e(this.kbc).setVisibility(8);
            GameMessageUI.a(this.kbc, 0);
            this.kbc.enableOptionMenu(false);
            return;
        }
        GameMessageUI.e(this.kbc).setVisibility(0);
        GameMessageUI.a(this.kbc, 8);
        this.kbc.enableOptionMenu(true);
    }
}
