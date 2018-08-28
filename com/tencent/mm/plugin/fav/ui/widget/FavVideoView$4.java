package com.tencent.mm.plugin.fav.ui.widget;

import com.tencent.mm.sdk.platformtools.x;

class FavVideoView$4 implements Runnable {
    final /* synthetic */ int dPF;
    final /* synthetic */ int dVx;
    final /* synthetic */ FavVideoView jfS;

    FavVideoView$4(FavVideoView favVideoView, int i, int i2) {
        this.jfS = favVideoView;
        this.dPF = i;
        this.dVx = i2;
    }

    public final void run() {
        if (!(FavVideoView.d(this.jfS) == null || FavVideoView.d(this.jfS).getVisibility() == 8)) {
            FavVideoView.d(this.jfS).setVisibility(8);
        }
        if (FavVideoView.e(this.jfS) != null) {
            if (FavVideoView.e(this.jfS).getVisibility() != 0) {
                FavVideoView.e(this.jfS).setVisibility(0);
            }
            x.i("MicroMsg.FavVideoView", "download video update progress offset:%d  total: %d", new Object[]{Integer.valueOf(this.dPF), Integer.valueOf(this.dVx)});
            if (FavVideoView.e(this.jfS).getMax() != this.dVx && this.dVx > 0) {
                FavVideoView.e(this.jfS).setMax(this.dVx);
            }
            FavVideoView.e(this.jfS).setProgress(this.dPF);
        }
    }
}
