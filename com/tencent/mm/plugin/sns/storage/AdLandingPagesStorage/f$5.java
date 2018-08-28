package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.x;

class f$5 implements a {
    final /* synthetic */ f nIA;
    final /* synthetic */ q nID;

    f$5(f fVar, q qVar) {
        this.nIA = fVar;
        this.nID = qVar;
    }

    public final void bzS() {
    }

    public final void bxo() {
        x.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.nID.nAN + "is error");
        f.a(this.nIA, this.nID.nAN);
    }

    public final void MX(String str) {
        f.a(this.nIA, this.nID.nAN);
    }
}
