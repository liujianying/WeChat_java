package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x.10;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.x;

class x$10$1 implements a {
    final /* synthetic */ 10 nFN;

    x$10$1(10 10) {
        this.nFN = 10;
    }

    public final void bzS() {
    }

    public final void bxo() {
        x.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "video download fail");
        x.a(this.nFN.nFL, true);
    }

    public final void MX(String str) {
        x.v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "video view height " + this.nFN.nFL.contentView.getHeight() + ", player height " + x.a(this.nFN.nFL).getHeight());
        x.a(this.nFN.nFL, false);
        x.a(this.nFN.nFL, str);
        if (this.nFN.nFL.nEG.bPb) {
            x.a(this.nFN.nFL).BK(str);
            x.m(this.nFN.nFL);
        }
    }
}
