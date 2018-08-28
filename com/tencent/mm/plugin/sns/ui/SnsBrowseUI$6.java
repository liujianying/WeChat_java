package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.Gallery;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;

class SnsBrowseUI$6 implements b {
    final /* synthetic */ SnsBrowseUI nTH;
    final /* synthetic */ Gallery nTL;

    SnsBrowseUI$6(SnsBrowseUI snsBrowseUI, Gallery gallery) {
        this.nTH = snsBrowseUI;
        this.nTL = gallery;
    }

    public final void O(float f, float f2) {
        if ((SnsBrowseUI.f(this.nTH) == 0 || SnsBrowseUI.g(this.nTH) == 0) && this.nTH.nTu != null) {
            SnsBrowseUI.b(this.nTH, this.nTH.nTu.getHeight());
            SnsBrowseUI.a(this.nTH, this.nTH.nTu.getWidth());
        }
        if (SnsBrowseUI.f(this.nTH) != 0) {
            float f3 = 1.0f - (f2 / ((float) SnsBrowseUI.f(this.nTH)));
            if (f3 > 1.0f) {
                f3 = 1.0f;
            }
            SnsBrowseUI.a(this.nTH, f3);
            View selectedView = ((MMGestureGallery) this.nTL).getSelectedView();
            if (selectedView instanceof MultiTouchImageView) {
                selectedView.setPivotX((float) (SnsBrowseUI.g(this.nTH) / 2));
                selectedView.setPivotY((float) (SnsBrowseUI.f(this.nTH) / 2));
                selectedView.setScaleX(f3);
                selectedView.setScaleY(f3);
                selectedView.setTranslationX(f);
                selectedView.setTranslationY(f2);
                SnsBrowseUI.d(this.nTH).setAlpha(f3);
            }
        }
    }

    public final void P(float f, float f2) {
        SnsBrowseUI.e(this.nTH, (int) f);
        SnsBrowseUI.f(this.nTH, (int) f2);
    }
}
