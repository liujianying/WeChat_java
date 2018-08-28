package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.x;

class f$8 implements a {
    final /* synthetic */ f nIA;
    final /* synthetic */ w nIE;

    f$8(f fVar, w wVar) {
        this.nIA = fVar;
        this.nIE = wVar;
    }

    public final void bzS() {
    }

    public final void bxo() {
        x.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.nIE.nBz + "is error");
        f.a(this.nIA, this.nIE.nAP);
    }

    public final void MX(String str) {
        f.a(this.nIA, this.nIE.nBz);
    }
}
