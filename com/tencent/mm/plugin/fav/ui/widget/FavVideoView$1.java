package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;

class FavVideoView$1 implements Runnable {
    final /* synthetic */ boolean hEu;
    final /* synthetic */ FavVideoView jfS;

    FavVideoView$1(FavVideoView favVideoView, boolean z) {
        this.jfS = favVideoView;
        this.hEu = z;
    }

    public final void run() {
        x.i("MicroMsg.FavVideoView", "VideoPlay: switch video model isVideoPlay %b ", new Object[]{Boolean.valueOf(this.hEu)});
        View view = (View) FavVideoView.a(this.jfS);
        if (this.hEu) {
            view.setVisibility(0);
            FavVideoView.b(this.jfS).setVisibility(8);
            return;
        }
        view.setVisibility(8);
        FavVideoView.b(this.jfS).setVisibility(0);
    }
}
