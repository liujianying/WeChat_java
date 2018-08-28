package com.tencent.mm.ui.chatting.gallery;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ImageGalleryUI$9 implements AnimationListener {
    final /* synthetic */ ImageGalleryUI tWn;

    ImageGalleryUI$9(ImageGalleryUI imageGalleryUI) {
        this.tWn = imageGalleryUI;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        ImageGalleryUI.G(this.tWn);
        ImageGalleryUI.H(this.tWn);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
