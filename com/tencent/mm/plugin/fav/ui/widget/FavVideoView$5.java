package com.tencent.mm.plugin.fav.ui.widget;

class FavVideoView$5 implements Runnable {
    final /* synthetic */ FavVideoView jfS;

    public FavVideoView$5(FavVideoView favVideoView) {
        this.jfS = favVideoView;
    }

    public final void run() {
        if (!(FavVideoView.d(this.jfS) == null || FavVideoView.d(this.jfS).getVisibility() == 0)) {
            FavVideoView.d(this.jfS).setVisibility(0);
        }
        if (FavVideoView.e(this.jfS) != null && FavVideoView.e(this.jfS).getVisibility() != 8) {
            FavVideoView.e(this.jfS).setVisibility(8);
        }
    }
}
