package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.ae;
import com.tencent.mm.plugin.game.ui.GameDetailUI2.14;

class GameDetailUI2$14$1 implements Runnable {
    final /* synthetic */ ae jXu;
    final /* synthetic */ 14 jXw;

    GameDetailUI2$14$1(14 14, ae aeVar) {
        this.jXw = 14;
        this.jXu = aeVar;
    }

    public final void run() {
        GameDetailUI2.a(this.jXw.jXr, this.jXu);
        if (this.jXw.jXr.iwc != null) {
            this.jXw.jXr.iwc.dismiss();
        }
    }
}
