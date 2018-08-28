package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.17;
import com.tencent.mm.ui.tools.f.b;

class ImageGalleryUI$17$1 implements b {
    final /* synthetic */ 17 tWp;

    ImageGalleryUI$17$1(17 17) {
        this.tWp = 17;
    }

    public final void onAnimationStart() {
        if (this.tWp.tWn.tVY != null) {
            this.tWp.tWn.tVY.k(Boolean.valueOf(true));
        }
    }

    public final void onAnimationEnd() {
        ImageGalleryUI.q(this.tWp.tWn).post(new Runnable() {
            public final void run() {
                if (ImageGalleryUI$17$1.this.tWp.tWn.tVY != null) {
                    ImageGalleryUI$17$1.this.tWp.tWn.tVY.k(Boolean.valueOf(false));
                }
            }
        });
    }
}
