package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ImageFolderMgrView$1 implements AnimationListener {
    final /* synthetic */ ImageFolderMgrView jDn;

    ImageFolderMgrView$1(ImageFolderMgrView imageFolderMgrView) {
        this.jDn = imageFolderMgrView;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        ImageFolderMgrView.a(this.jDn).setVisibility(8);
        ImageFolderMgrView.a(this.jDn, false);
        ImageFolderMgrView.b(this.jDn);
    }
}
