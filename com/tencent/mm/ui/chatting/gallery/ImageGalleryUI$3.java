package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.g.a.ak;
import com.tencent.mm.ui.widget.a.d.a;

class ImageGalleryUI$3 implements a {
    final /* synthetic */ ImageGalleryUI tWn;

    ImageGalleryUI$3(ImageGalleryUI imageGalleryUI) {
        this.tWn = imageGalleryUI;
    }

    public final void onDismiss() {
        ak akVar = new ak();
        akVar.bHM.filePath = ImageGalleryUI.b(this.tWn);
        com.tencent.mm.sdk.b.a.sFg.m(akVar);
        ImageGalleryUI.w(this.tWn);
        ImageGalleryUI.e(this.tWn);
        ImageGalleryUI.a(this.tWn, null);
        ImageGalleryUI.a(this.tWn, ImageGalleryUI.b(this.tWn, 0));
    }
}
