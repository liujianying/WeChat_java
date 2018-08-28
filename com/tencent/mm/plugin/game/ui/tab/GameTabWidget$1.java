package com.tencent.mm.plugin.game.ui.tab;

import android.database.DataSetObserver;

class GameTabWidget$1 extends DataSetObserver {
    final /* synthetic */ GameTabWidget kdc;

    GameTabWidget$1(GameTabWidget gameTabWidget) {
        this.kdc = gameTabWidget;
    }

    public final void onInvalidated() {
        GameTabWidget.a(this.kdc);
    }

    public final void onChanged() {
        GameTabWidget.a(this.kdc);
    }
}
