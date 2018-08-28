package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameCenterUI5$1 implements OnMenuItemClickListener {
    final /* synthetic */ GameCenterUI5 jVE;

    GameCenterUI5$1(GameCenterUI5 gameCenterUI5) {
        this.jVE = gameCenterUI5;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jVE.finish();
        return true;
    }
}
