package com.tencent.mm.ui.chatting.gallery;

import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.6;

class ImageGalleryGridUI$6$1 implements Runnable {
    final /* synthetic */ 6 tUL;

    ImageGalleryGridUI$6$1(6 6) {
        this.tUL = 6;
    }

    public final void run() {
        ImageGalleryGridUI.b(this.tUL.tUJ).startAnimation(AnimationUtils.loadAnimation(this.tUL.tUJ.mController.tml, R.a.fast_faded_out));
        ImageGalleryGridUI.b(this.tUL.tUJ).setVisibility(8);
    }
}
