package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.game.model.an;

class GameDetailUI2$13 implements OnMenuItemClickListener {
    final /* synthetic */ GameDetailUI2 jXr;

    GameDetailUI2$13(GameDetailUI2 gameDetailUI2) {
        this.jXr = gameDetailUI2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        GameDetailUI2.a(this.jXr, GameDetailUI2.e(this.jXr));
        an.a(this.jXr.mController.tml, 12, 1207, 1, 2, GameDetailUI2.f(this.jXr), GameDetailUI2.g(this.jXr), null);
        return false;
    }
}
