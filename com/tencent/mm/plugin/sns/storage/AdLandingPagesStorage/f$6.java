package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.x;

class f$6 implements a {
    final /* synthetic */ f nIA;
    final /* synthetic */ q nID;

    f$6(f fVar, q qVar) {
        this.nIA = fVar;
        this.nID = qVar;
    }

    public final void bzS() {
    }

    public final void bxo() {
        x.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.nID.nAO + "is error");
        f.a(this.nIA, this.nID.nAO);
    }

    public final void MX(String str) {
        f.a(this.nIA, this.nID.nAO);
    }
}
