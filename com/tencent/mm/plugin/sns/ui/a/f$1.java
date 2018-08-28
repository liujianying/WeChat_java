package com.tencent.mm.plugin.sns.ui.a;

import android.graphics.BitmapFactory;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d$a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;

class f$1 implements d$a {
    final /* synthetic */ PhotosContent nUS;
    final /* synthetic */ b nUT;
    final /* synthetic */ TagImageView nUU;
    final /* synthetic */ f oke;

    f$1(f fVar, PhotosContent photosContent, b bVar, TagImageView tagImageView) {
        this.oke = fVar;
        this.nUS = photosContent;
        this.nUT = bVar;
        this.nUU = tagImageView;
    }

    public final void bzS() {
    }

    public final void bxo() {
    }

    public final void MX(String str) {
        this.oke.okd = (MaskImageView) this.nUS.findViewById(f.media_icon);
        if (this.oke.okd != null) {
            this.oke.okd.setVisibility(0);
            this.oke.okd.setImageBitmap(BitmapFactory.decodeFile(str));
            float a = e.a((double) this.nUT.nzl, 1, this.nUT.nzh, this.nUT.nzi);
            float a2 = e.a((double) this.nUT.nzm, 1, this.nUT.nzh, this.nUT.nzi);
            float a3 = e.a((double) this.nUT.nzn, 1, this.nUT.nzh, this.nUT.nzi);
            float a4 = e.a((double) this.nUT.nzo, 1, this.nUT.nzh, this.nUT.nzi);
            LayoutParams layoutParams = new FrameLayout.LayoutParams((int) a, (int) a2);
            layoutParams.setMargins((int) ((((float) this.nUU.getRight()) - a3) - a), (int) ((((float) this.nUU.getBottom()) - a4) - a2), 0, 0);
            this.oke.okd.setLayoutParams(layoutParams);
        }
    }
}
