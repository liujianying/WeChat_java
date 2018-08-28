package com.tencent.mm.plugin.subapp.ui.gallery;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.MMGestureGallery.c;

class GestureGalleryUI$4 implements c {
    final /* synthetic */ GestureGalleryUI osu;
    final /* synthetic */ int osv;

    GestureGalleryUI$4(GestureGalleryUI gestureGalleryUI, int i) {
        this.osu = gestureGalleryUI;
        this.osv = i;
    }

    public final void aMl() {
        if (1 == this.osv) {
            GestureGalleryUI.a(this.osu);
        } else if (2 == this.osv) {
            h.a(this.osu, null, this.osu.mController.tml.getResources().getStringArray(R.c.shake_tran_img_alert), "", false, new 1(this));
        }
    }
}
