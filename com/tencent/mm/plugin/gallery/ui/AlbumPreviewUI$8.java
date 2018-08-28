package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class AlbumPreviewUI$8 implements AnimationListener {
    final /* synthetic */ AlbumPreviewUI jCE;
    private Runnable jCJ = new 1(this);

    AlbumPreviewUI$8(AlbumPreviewUI albumPreviewUI) {
        this.jCE = albumPreviewUI;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        AlbumPreviewUI.G(this.jCE).setVisibility(0);
        AlbumPreviewUI.G(this.jCE).postDelayed(this.jCJ, 4000);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
