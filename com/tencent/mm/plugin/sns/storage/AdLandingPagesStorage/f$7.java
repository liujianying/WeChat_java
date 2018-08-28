package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.sdk.platformtools.x;

class f$7 implements d$b {
    final /* synthetic */ f nIA;
    final /* synthetic */ w nIE;

    f$7(f fVar, w wVar) {
        this.nIA = fVar;
        this.nIE = wVar;
    }

    public final void MY(String str) {
        x.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.nIE.nAP + "is error");
        f.a(this.nIA, this.nIE.nAP);
    }

    public final void MZ(String str) {
        f.a(this.nIA, this.nIE.nAP);
    }
}
