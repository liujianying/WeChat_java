package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ImageFolderMgrView$2 implements AnimationListener {
    final /* synthetic */ ImageFolderMgrView jDn;

    ImageFolderMgrView$2(ImageFolderMgrView imageFolderMgrView) {
        this.jDn = imageFolderMgrView;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        ImageFolderMgrView.a(this.jDn, true);
        ImageFolderMgrView.b(this.jDn);
    }
}
