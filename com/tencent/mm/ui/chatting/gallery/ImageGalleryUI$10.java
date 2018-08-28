package com.tencent.mm.ui.chatting.gallery;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ImageGalleryUI$10 implements AnimationListener {
    final /* synthetic */ ImageGalleryUI tWn;

    ImageGalleryUI$10(ImageGalleryUI imageGalleryUI) {
        this.tWn = imageGalleryUI;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (ImageGalleryUI.J(ImageGalleryUI.I(this.tWn)).getVisibility() == 0) {
            this.tWn.cxh();
            ImageGalleryUI.K(ImageGalleryUI.I(this.tWn)).setVisibility(8);
            ImageGalleryUI.D(this.tWn);
            ImageGalleryUI.E(this.tWn);
        }
    }
}
