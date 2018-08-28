package com.tencent.mm.ui.chatting.gallery;

class ImageGalleryGridUI$3 implements Runnable {
    final /* synthetic */ ImageGalleryGridUI tUJ;

    ImageGalleryGridUI$3(ImageGalleryGridUI imageGalleryGridUI) {
        this.tUJ = imageGalleryGridUI;
    }

    public final void run() {
        if (ImageGalleryGridUI.a(this.tUJ) != null && ImageGalleryGridUI.a(this.tUJ).getVisibility() != 0) {
            ImageGalleryGridUI.a(this.tUJ).setVisibility(0);
        }
    }
}
