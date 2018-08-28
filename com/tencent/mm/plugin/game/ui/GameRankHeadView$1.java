package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.m.b;

class GameRankHeadView$1 implements b {
    final /* synthetic */ GameRankHeadView kbw;

    GameRankHeadView$1(GameRankHeadView gameRankHeadView) {
        this.kbw = gameRankHeadView;
    }

    public final void f(int i, String str, boolean z) {
        if (GameRankHeadView.a(this.kbw) != null) {
            GameRankHeadView.b(this.kbw).dC(this.kbw.getContext());
            GameRankHeadView.b(this.kbw).aTT();
            if (z) {
                GameRankHeadView.c(this.kbw);
            }
        }
    }
}
