package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.19;

class ImageGalleryUI$19$1 implements Runnable {
    final /* synthetic */ 19 tWr;

    ImageGalleryUI$19$1(19 19) {
        this.tWr = 19;
    }

    public final void run() {
        if (ImageGalleryUI.l(this.tWr.tWn) != null) {
            ImageGalleryUI.l(this.tWr.tWn).crm();
        }
        if (ImageGalleryUI.m(this.tWr.tWn) != null) {
            ImageGalleryUI.m(this.tWr.tWn).crm();
        }
    }
}
