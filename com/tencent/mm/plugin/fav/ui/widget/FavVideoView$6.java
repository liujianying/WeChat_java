package com.tencent.mm.plugin.fav.ui.widget;

class FavVideoView$6 implements Runnable {
    final /* synthetic */ FavVideoView jfS;

    FavVideoView$6(FavVideoView favVideoView) {
        this.jfS = favVideoView;
    }

    public final void run() {
        if (!(FavVideoView.d(this.jfS) == null || FavVideoView.d(this.jfS).getVisibility() == 8)) {
            FavVideoView.d(this.jfS).setVisibility(8);
        }
        if (FavVideoView.e(this.jfS) != null && FavVideoView.e(this.jfS).getVisibility() != 8) {
            FavVideoView.e(this.jfS).setVisibility(8);
        }
    }
}
