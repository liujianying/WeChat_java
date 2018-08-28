package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.an;

class GameDetailUI2$2 implements OnClickListener {
    final /* synthetic */ GameDetailUI2 jXr;

    GameDetailUI2$2(GameDetailUI2 gameDetailUI2) {
        this.jXr = gameDetailUI2;
    }

    public final void onClick(View view) {
        c.a(view, this.jXr);
        an.a(this.jXr.mController.tml, 12, 1204, 999, 7, GameDetailUI2.f(this.jXr), GameDetailUI2.g(this.jXr), null);
    }
}
