package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameCategoryUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GameCategoryUI jUT;

    GameCategoryUI$1(GameCategoryUI gameCategoryUI) {
        this.jUT = gameCategoryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jUT.finish();
        return true;
    }
}
