package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.m.b;

class GameDetailUI2$6 implements b {
    final /* synthetic */ GameDetailUI2 jXr;

    GameDetailUI2$6(GameDetailUI2 gameDetailUI2) {
        this.jXr = gameDetailUI2;
    }

    public final void f(int i, String str, boolean z) {
        if (GameDetailUI2.l(this.jXr) != null) {
            GameDetailUI2.i(this.jXr).dC(this.jXr);
            GameDetailUI2.i(this.jXr).aTT();
            if (z) {
                GameDetailUI2.m(this.jXr).a(GameDetailUI2.j(this.jXr), GameDetailUI2.k(this.jXr), GameDetailUI2.l(this.jXr), GameDetailUI2.i(this.jXr));
            }
        }
    }
}
