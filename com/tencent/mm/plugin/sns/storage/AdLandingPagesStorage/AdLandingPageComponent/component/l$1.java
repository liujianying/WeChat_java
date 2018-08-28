package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.x;

class l$1 implements a {
    final /* synthetic */ l nDI;

    l$1(l lVar) {
        this.nDI = lVar;
    }

    public final void bzS() {
    }

    public final void bxo() {
    }

    @TargetApi(16)
    public final void MX(String str) {
        try {
            Drawable createFromPath = Drawable.createFromPath(str);
            this.nDI.nDG.setBackground(createFromPath);
            if (createFromPath != null && this.nDI.bAa().height > 0.0f && createFromPath.getIntrinsicHeight() > 0) {
                this.nDI.nDG.setLayoutParams(new LayoutParams((int) ((this.nDI.bAa().height * ((float) createFromPath.getIntrinsicWidth())) / ((float) createFromPath.getIntrinsicHeight())), (int) this.nDI.bAa().height));
            }
        } catch (Exception e) {
            x.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the backgroundCoverUrl is set error ,because " + e.toString());
        }
    }
}
