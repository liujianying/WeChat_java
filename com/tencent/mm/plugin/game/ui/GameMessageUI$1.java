package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameMessageUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GameMessageUI kbc;

    GameMessageUI$1(GameMessageUI gameMessageUI) {
        this.kbc = gameMessageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        GameMessageUI.a(this.kbc);
        return true;
    }
}
