package com.tencent.mm.plugin.game.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class GameCategoryUI$4 implements OnScrollListener {
    final /* synthetic */ GameCategoryUI jUT;

    GameCategoryUI$4(GameCategoryUI gameCategoryUI) {
        this.jUT = gameCategoryUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && GameCategoryUI.d(this.jUT) && !GameCategoryUI.e(this.jUT)) {
            GameCategoryUI.f(this.jUT).setVisibility(0);
            GameCategoryUI.g(this.jUT);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
