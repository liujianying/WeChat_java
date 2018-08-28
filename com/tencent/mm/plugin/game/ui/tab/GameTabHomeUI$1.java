package com.tencent.mm.plugin.game.ui.tab;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameTabHomeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GameTabHomeUI kcY;

    GameTabHomeUI$1(GameTabHomeUI gameTabHomeUI) {
        this.kcY = gameTabHomeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        GameTabHomeUI.a(this.kcY);
        return true;
    }
}
