package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;

class ImageGalleryGridUI$8 implements Runnable {
    final /* synthetic */ ImageGalleryGridUI tUJ;

    ImageGalleryGridUI$8(ImageGalleryGridUI imageGalleryGridUI) {
        this.tUJ = imageGalleryGridUI;
    }

    @TargetApi(12)
    public final void run() {
        if (this.tUJ.tUC != null) {
            this.tUJ.tUC.setVisibility(8);
            this.tUJ.tUC = null;
        }
    }
}
