package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.x;

class f$3 implements a {
    final /* synthetic */ f nIA;
    final /* synthetic */ o nIC;

    f$3(f fVar, o oVar) {
        this.nIA = fVar;
        this.nIC = oVar;
    }

    public final void bzS() {
    }

    public final void bxo() {
        x.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.nIC.nAL + "is error");
        f.a(this.nIA, this.nIC.nAL);
    }

    public final void MX(String str) {
        f.a(this.nIA, this.nIC.nAL);
    }
}
