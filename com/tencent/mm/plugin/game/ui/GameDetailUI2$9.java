package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.base.h;

class GameDetailUI2$9 implements a {
    final /* synthetic */ String bAA;
    final /* synthetic */ GameDetailUI2 jXr;

    GameDetailUI2$9(GameDetailUI2 gameDetailUI2, String str) {
        this.jXr = gameDetailUI2;
        this.bAA = str;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            GameDetailUI2.a(this.jXr, this.bAA, str);
            h.bA(this.jXr, this.jXr.getResources().getString(i.confirm_dialog_sent));
            an.a(this.jXr.mController.tml, 12, 1207, 2, 14, GameDetailUI2.f(this.jXr), GameDetailUI2.g(this.jXr), null);
        }
    }
}
