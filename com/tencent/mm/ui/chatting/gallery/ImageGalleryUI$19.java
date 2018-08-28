package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.f.b;

class ImageGalleryUI$19 implements b {
    final /* synthetic */ ImageGalleryUI tWn;

    ImageGalleryUI$19(ImageGalleryUI imageGalleryUI) {
        this.tWn = imageGalleryUI;
    }

    public final void onAnimationStart() {
        ImageGalleryUI.a(this.tWn, true);
        ImageGalleryUI.dw(ImageGalleryUI.u(this.tWn));
        ImageGalleryUI.dw(ImageGalleryUI.v(this.tWn));
        new ag().postDelayed(new 1(this), 20);
    }

    public final void onAnimationEnd() {
        x.i("MicroMsg.ImageGalleryUI", "runExitAnimation onAnimationEnd");
        ImageGalleryUI.q(this.tWn).post(new 2(this));
        ImageGalleryUI.a(this.tWn, false);
    }
}
