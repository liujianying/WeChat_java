package com.tencent.mm.plugin.game.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class GameSearchUI$3 implements OnScrollListener {
    final /* synthetic */ GameSearchUI kcH;

    GameSearchUI$3(GameSearchUI gameSearchUI) {
        this.kcH = gameSearchUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && GameSearchUI.b(this.kcH).kbN) {
            if (GameSearchUI.c(this.kcH) != null) {
                GameSearchUI.c(this.kcH).setVisibility(0);
            }
            GameSearchUI.a(this.kcH, GameSearchUI.d(this.kcH));
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
