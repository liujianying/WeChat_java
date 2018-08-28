package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements d$a {
    final /* synthetic */ f nIA;
    final /* synthetic */ p nIz;

    f$1(f fVar, p pVar) {
        this.nIA = fVar;
        this.nIz = pVar;
    }

    public final void bzS() {
    }

    public final void bxo() {
        x.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.nIz.nAL + "is error");
        f.a(this.nIA, this.nIz.nAL);
    }

    public final void MX(String str) {
        f.a(this.nIA, this.nIz.nAL);
    }
}
