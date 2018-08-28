package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMViewPager.b;

class ImageGalleryUI$18 implements b {
    final /* synthetic */ ImageGalleryUI tWn;

    ImageGalleryUI$18(ImageGalleryUI imageGalleryUI) {
        this.tWn = imageGalleryUI;
    }

    public final void O(float f, float f2) {
        float f3 = 1.0f;
        float height = 1.0f - (f2 / ((float) this.tWn.jDB.getHeight()));
        if (height <= 1.0f) {
            f3 = height;
        }
        ImageGalleryUI.a(this.tWn, f3);
        x.d("MicroMsg.ImageGalleryUI", "alvinluo onGalleryScale tx: %f, ty: %f, scale: %f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)});
        ImageGalleryUI.a(this.tWn, ImageGalleryUI.a(this.tWn, ImageGalleryUI.f(this.tWn), this.tWn.jDB));
        if (ImageGalleryUI.s(this.tWn) != null) {
            if (f == 0.0f && f2 == 0.0f) {
                ImageGalleryUI.t(this.tWn);
            } else {
                ImageGalleryUI.n(this.tWn);
            }
            ImageGalleryUI.s(this.tWn).setPivotX((float) (this.tWn.jDB.getWidth() / 2));
            ImageGalleryUI.s(this.tWn).setPivotY((float) (this.tWn.jDB.getHeight() / 2));
            ImageGalleryUI.s(this.tWn).setScaleX(f3);
            ImageGalleryUI.s(this.tWn).setScaleY(f3);
            ImageGalleryUI.s(this.tWn).setTranslationX(f);
            ImageGalleryUI.s(this.tWn).setTranslationY(f2);
            ImageGalleryUI.p(this.tWn).setAlpha(f3);
            return;
        }
        x.d("MicroMsg.ImageGalleryUI", "runDragAnimation contentView is null !!");
    }

    public final void P(float f, float f2) {
        ImageGalleryUI.c(this.tWn, (int) f);
        ImageGalleryUI.d(this.tWn, (int) f2);
    }
}
