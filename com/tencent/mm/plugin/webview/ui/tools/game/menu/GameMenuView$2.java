package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.m;

class GameMenuView$2 implements OnClickListener {
    final /* synthetic */ GameMenuView qgT;

    GameMenuView$2(GameMenuView gameMenuView) {
        this.qgT = gameMenuView;
    }

    public final void onClick(View view) {
        if (GameMenuView.b(this.qgT) != null) {
            GameMenuView.b(this.qgT).g((m) view.getTag());
        }
        if (GameMenuView.c(this.qgT) != null) {
            GameMenuView.c(this.qgT).onDismiss();
        }
    }
}
