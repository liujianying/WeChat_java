package com.tencent.mm.plugin.fav.ui.detail;

import android.view.ViewTreeObserver.OnPreDrawListener;

class FavoriteVideoPlayUI$4 implements OnPreDrawListener {
    final /* synthetic */ FavoriteVideoPlayUI jdN;

    FavoriteVideoPlayUI$4(FavoriteVideoPlayUI favoriteVideoPlayUI) {
        this.jdN = favoriteVideoPlayUI;
    }

    public final boolean onPreDraw() {
        FavoriteVideoPlayUI.e(this.jdN).getViewTreeObserver().removeOnPreDrawListener(this);
        FavoriteVideoPlayUI.g(this.jdN).a(FavoriteVideoPlayUI.e(this.jdN), FavoriteVideoPlayUI.f(this.jdN), new 1(this));
        return true;
    }
}
