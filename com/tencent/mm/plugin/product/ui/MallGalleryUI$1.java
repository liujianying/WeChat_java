package com.tencent.mm.plugin.product.ui;

import android.support.v4.view.ViewPager.e;
import com.tencent.mm.sdk.platformtools.x;

class MallGalleryUI$1 implements e {
    final /* synthetic */ MallGalleryUI lSt;

    MallGalleryUI$1(MallGalleryUI mallGalleryUI) {
        this.lSt = mallGalleryUI;
    }

    public final void O(int i) {
        x.d("MicroMsg.MallGalleryUI", "Page Selected postion: %d", new Object[]{Integer.valueOf(i)});
        MallGalleryUI.a(this.lSt, i);
        if (MallGalleryUI.a(this.lSt)) {
            this.lSt.mController.hideTitleView();
            MallGalleryUI.b(this.lSt);
        }
    }

    public final synchronized void a(int i, float f, int i2) {
    }

    public final void N(int i) {
    }
}
