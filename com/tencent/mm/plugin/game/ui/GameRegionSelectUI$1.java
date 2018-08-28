package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameRegionSelectUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GameRegionSelectUI kbC;

    GameRegionSelectUI$1(GameRegionSelectUI gameRegionSelectUI) {
        this.kbC = gameRegionSelectUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kbC.setResult(0);
        this.kbC.YC();
        this.kbC.finish();
        return true;
    }
}
