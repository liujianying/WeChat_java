package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.an;

class GameOverSeaCenterUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ GameOverSeaCenterUI kbp;

    GameOverSeaCenterUI$5(GameOverSeaCenterUI gameOverSeaCenterUI) {
        this.kbp = gameOverSeaCenterUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        an.a(this.kbp.mController.tml, 10, 1008, 1, c.an(this.kbp.mController.tml, GameOverSeaCenterUI.d(this.kbp)), this.kbp.jNv, null);
        return true;
    }
}
