package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa.1.1.1;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.sdk.platformtools.bi;

class aa$1$1$1$1 implements ImageGetter {
    final /* synthetic */ 1 nFV;

    aa$1$1$1$1(1 1) {
        this.nFV = 1;
    }

    public final Drawable getDrawable(String str) {
        String eH = d.eH("adId", str);
        if (bi.oW(eH) || !FileOp.cn(eH)) {
            return null;
        }
        Drawable createFromPath = Drawable.createFromPath(eH);
        if (createFromPath != null) {
            createFromPath.setBounds(0, 0, createFromPath.getIntrinsicHeight() != 0 ? (createFromPath.getIntrinsicWidth() * ((int) aa.a(this.nFV.nFU.nFT.nFS).duz)) / createFromPath.getIntrinsicHeight() : createFromPath.getIntrinsicWidth(), createFromPath.getIntrinsicHeight() != 0 ? (int) aa.a(this.nFV.nFU.nFT.nFS).duz : createFromPath.getIntrinsicHeight());
        }
        return createFromPath;
    }
}
