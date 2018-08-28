package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z.8;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.b;
import com.tencent.mm.sdk.platformtools.x;

class z$8$1 implements b {
    final /* synthetic */ 8 nFQ;

    z$8$1(8 8) {
        this.nFQ = 8;
    }

    public final void MY(String str) {
        x.e("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "video download fail %s", new Object[]{str});
        this.nFQ.nFO.nET = true;
    }

    public final void MZ(String str) {
        x.v("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "video view height " + this.nFQ.nFO.contentView.getHeight() + ", player height " + this.nFQ.nFO.nFA.getHeight());
        this.nFQ.nFO.nET = false;
        this.nFQ.nFO.fOr = str;
        if (this.nFQ.nFO.nEG.bPb) {
            this.nFQ.nFO.nFA.BK(str);
            this.nFQ.nFO.nFI = true;
        }
    }
}
