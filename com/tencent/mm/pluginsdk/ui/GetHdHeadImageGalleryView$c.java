package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.ui.tools.MMGestureGallery$f;

class GetHdHeadImageGalleryView$c implements MMGestureGallery$f {
    final /* synthetic */ GetHdHeadImageGalleryView qFk;

    private GetHdHeadImageGalleryView$c(GetHdHeadImageGalleryView getHdHeadImageGalleryView) {
        this.qFk = getHdHeadImageGalleryView;
    }

    /* synthetic */ GetHdHeadImageGalleryView$c(GetHdHeadImageGalleryView getHdHeadImageGalleryView, byte b) {
        this(getHdHeadImageGalleryView);
    }

    public final void ayI() {
        if (GetHdHeadImageGalleryView.a(this.qFk) != null) {
            GetHdHeadImageGalleryView.a(this.qFk).dismiss();
        }
    }
}
