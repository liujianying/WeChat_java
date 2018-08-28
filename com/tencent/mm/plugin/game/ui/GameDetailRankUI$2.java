package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameDetailRankUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ GameDetailRankUI jWr;

    GameDetailRankUI$2(GameDetailRankUI gameDetailRankUI) {
        this.jWr = gameDetailRankUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jWr.finish();
        return true;
    }
}
