package com.tencent.mm.plugin.fav.ui.widget;

class FavVideoView$2 implements Runnable {
    final /* synthetic */ FavVideoView jfS;

    FavVideoView$2(FavVideoView favVideoView) {
        this.jfS = favVideoView;
    }

    public final void run() {
        if (FavVideoView.a(this.jfS) != null) {
            this.jfS.BK(FavVideoView.c(this.jfS));
        }
    }
}
