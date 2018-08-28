package com.tencent.mm.ui.chatting.gallery;

class ImageGalleryGridUI$1 implements Runnable {
    final /* synthetic */ ImageGalleryGridUI tUJ;

    ImageGalleryGridUI$1(ImageGalleryGridUI imageGalleryGridUI) {
        this.tUJ = imageGalleryGridUI;
    }

    public final void run() {
        if (ImageGalleryGridUI.a(this.tUJ) != null && ImageGalleryGridUI.a(this.tUJ).getVisibility() != 4) {
            ImageGalleryGridUI.a(this.tUJ).setVisibility(4);
        }
    }
}
