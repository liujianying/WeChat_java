package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.BitmapFactory;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d$a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class u$1 implements d$a {
    final /* synthetic */ u nFu;

    u$1(u uVar) {
        this.nFu = uVar;
    }

    public final void bzS() {
        this.nFu.startLoading();
    }

    public final void bxo() {
        this.nFu.eVR.setVisibility(8);
    }

    public final void MX(String str) {
        try {
            this.nFu.setImage(BitmapFactory.decodeFile(str));
        } catch (Throwable e) {
            x.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "%s" + bi.i(e));
        }
    }
}
