package com.tencent.mm.plugin.game.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class GameLibraryUI$8 implements OnScrollListener {
    final /* synthetic */ GameLibraryUI jZN;

    GameLibraryUI$8(GameLibraryUI gameLibraryUI) {
        this.jZN = gameLibraryUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && GameLibraryUI.j(this.jZN) && !GameLibraryUI.k(this.jZN)) {
            GameLibraryUI.l(this.jZN).setVisibility(0);
            GameLibraryUI.h(this.jZN);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
