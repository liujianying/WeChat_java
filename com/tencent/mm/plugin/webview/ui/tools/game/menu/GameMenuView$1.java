package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.database.DataSetObserver;

class GameMenuView$1 extends DataSetObserver {
    final /* synthetic */ GameMenuView qgT;

    GameMenuView$1(GameMenuView gameMenuView) {
        this.qgT = gameMenuView;
    }

    public final void onInvalidated() {
        GameMenuView.a(this.qgT);
    }

    public final void onChanged() {
        GameMenuView.a(this.qgT);
    }
}
