package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.an;

class GameDownloadGuidanceUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ GameDownloadGuidanceUI jXC;

    GameDownloadGuidanceUI$4(GameDownloadGuidanceUI gameDownloadGuidanceUI) {
        this.jXC = gameDownloadGuidanceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        an.a(this.jXC.mController.tml, 10, 1008, 1, c.an(this.jXC.mController.tml, GameDownloadGuidanceUI.c(this.jXC)), this.jXC.jNv, null);
        return true;
    }
}
