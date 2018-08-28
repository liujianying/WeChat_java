package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameOverSeaCenterUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GameOverSeaCenterUI kbp;

    GameOverSeaCenterUI$1(GameOverSeaCenterUI gameOverSeaCenterUI) {
        this.kbp = gameOverSeaCenterUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kbp.finish();
        return true;
    }
}
