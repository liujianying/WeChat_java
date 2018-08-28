package com.tencent.mm.ui.chatting.gallery;

class ImageGalleryUI$8 implements Runnable {
    final /* synthetic */ int eKj;
    final /* synthetic */ ImageGalleryUI tWn;

    ImageGalleryUI$8(ImageGalleryUI imageGalleryUI, int i) {
        this.tWn = imageGalleryUI;
        this.eKj = i;
    }

    public final void run() {
        if (ImageGalleryUI.f(this.tWn) != null) {
            b f = ImageGalleryUI.f(this.tWn);
            f.tTE.pause(this.eKj);
        }
    }
}
