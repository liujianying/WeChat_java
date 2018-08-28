package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.ui.base.h;

class GameMessageUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ GameMessageUI kbc;

    GameMessageUI$2(GameMessageUI gameMessageUI) {
        this.kbc = gameMessageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        GameMessageUI.a(this.kbc, new 1(this));
        GameMessageUI.b(this.kbc, new 2(this));
        h.a(this.kbc.mController.tml, i.game_clear_message, 0, GameMessageUI.c(this.kbc), GameMessageUI.d(this.kbc));
        return false;
    }
}
