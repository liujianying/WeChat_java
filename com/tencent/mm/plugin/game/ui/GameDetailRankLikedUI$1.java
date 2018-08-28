package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameDetailRankLikedUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GameDetailRankLikedUI jWk;

    GameDetailRankLikedUI$1(GameDetailRankLikedUI gameDetailRankLikedUI) {
        this.jWk = gameDetailRankLikedUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jWk.finish();
        return true;
    }
}
