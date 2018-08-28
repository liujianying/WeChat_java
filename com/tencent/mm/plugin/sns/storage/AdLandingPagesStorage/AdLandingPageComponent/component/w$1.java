package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.BitmapFactory;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class w$1 implements a {
    final /* synthetic */ w nFz;

    w$1(w wVar) {
        this.nFz = wVar;
    }

    public final void bzS() {
        this.nFz.startLoading();
    }

    public final void bxo() {
        this.nFz.eVR.setVisibility(8);
    }

    public final void MX(String str) {
        try {
            this.nFz.I(BitmapFactory.decodeFile(str));
        } catch (Throwable e) {
            x.e("AdLandingPagePureImageComponet", "%s" + bi.i(e));
        }
    }
}
