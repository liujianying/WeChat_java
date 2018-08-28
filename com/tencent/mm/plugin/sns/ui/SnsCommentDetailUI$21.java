package com.tencent.mm.plugin.sns.ui;

import android.graphics.BitmapFactory;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.b;

class SnsCommentDetailUI$21 implements a {
    final /* synthetic */ SnsCommentDetailUI nUO;
    final /* synthetic */ PhotosContent nUS;
    final /* synthetic */ b nUT;
    final /* synthetic */ TagImageView nUU;

    SnsCommentDetailUI$21(SnsCommentDetailUI snsCommentDetailUI, PhotosContent photosContent, b bVar, TagImageView tagImageView) {
        this.nUO = snsCommentDetailUI;
        this.nUS = photosContent;
        this.nUT = bVar;
        this.nUU = tagImageView;
    }

    public final void bzS() {
    }

    public final void bxo() {
    }

    public final void MX(String str) {
        MaskImageView maskImageView = (MaskImageView) this.nUS.findViewById(f.media_icon);
        if (maskImageView != null) {
            maskImageView.setVisibility(0);
            maskImageView.setImageBitmap(BitmapFactory.decodeFile(str));
            float a = e.a((double) this.nUT.nzl, 1, this.nUT.nzh, this.nUT.nzi);
            float a2 = e.a((double) this.nUT.nzm, 1, this.nUT.nzh, this.nUT.nzi);
            float a3 = e.a((double) this.nUT.nzn, 1, this.nUT.nzh, this.nUT.nzi);
            float a4 = e.a((double) this.nUT.nzo, 1, this.nUT.nzh, this.nUT.nzi);
            LayoutParams layoutParams = new FrameLayout.LayoutParams((int) a, (int) a2);
            layoutParams.setMargins((int) ((((float) this.nUU.getRight()) - a3) - a), (int) ((((float) this.nUU.getBottom()) - a4) - a2), 0, 0);
            maskImageView.setLayoutParams(layoutParams);
        }
    }
}
