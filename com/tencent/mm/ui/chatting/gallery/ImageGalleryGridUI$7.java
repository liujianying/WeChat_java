package com.tencent.mm.ui.chatting.gallery;

import android.animation.TimeInterpolator;
import android.os.Build.VERSION;
import android.view.View;

class ImageGalleryGridUI$7 implements Runnable {
    final /* synthetic */ ImageGalleryGridUI tUJ;
    final /* synthetic */ View tUM;
    final /* synthetic */ TimeInterpolator tUN;

    ImageGalleryGridUI$7(ImageGalleryGridUI imageGalleryGridUI, View view, TimeInterpolator timeInterpolator) {
        this.tUJ = imageGalleryGridUI;
        this.tUM = view;
        this.tUN = timeInterpolator;
    }

    public final void run() {
        if (VERSION.SDK_INT >= 16) {
            this.tUM.animate().setDuration(500).alpha(0.0f).withEndAction(this.tUJ.tUB).withLayer().setInterpolator(this.tUN);
        } else if (this.tUJ.handler != null) {
            this.tUM.animate().setDuration(500).alpha(0.0f).setInterpolator(this.tUN);
            this.tUJ.handler.postDelayed(this.tUJ.tUB, 500);
        }
    }
}
