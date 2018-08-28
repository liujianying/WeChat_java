package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.text.Html;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa.1.1;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class aa$1$1$1 implements a {
    final /* synthetic */ 1 nFU;

    aa$1$1$1(1 1) {
        this.nFU = 1;
    }

    public final void bzS() {
    }

    public final void bxo() {
    }

    public final void MX(String str) {
        try {
            ah.A(new 2(this, Html.fromHtml(this.nFU.nFT.nFR, new 1(this), null)));
        } catch (Exception e) {
            x.e("MicroMsg.Sns.AdLandingPageTextComponent", "the backgroundCoverUrl is set error ,because " + e.toString());
        }
    }
}
