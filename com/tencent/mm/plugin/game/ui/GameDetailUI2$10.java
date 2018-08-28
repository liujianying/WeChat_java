package com.tencent.mm.plugin.game.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class GameDetailUI2$10 implements OnGlobalLayoutListener {
    final /* synthetic */ GameDetailUI2 jXr;

    GameDetailUI2$10(GameDetailUI2 gameDetailUI2) {
        this.jXr = gameDetailUI2;
    }

    public final void onGlobalLayout() {
        if (GameDetailUI2.b(this.jXr).getLineCount() > 3) {
            GameDetailUI2.c(this.jXr).setVisibility(0);
        } else {
            GameDetailUI2.c(this.jXr).setVisibility(8);
        }
    }
}
