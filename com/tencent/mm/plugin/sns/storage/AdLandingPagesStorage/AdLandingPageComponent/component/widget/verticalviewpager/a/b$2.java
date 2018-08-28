package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements a {
    final /* synthetic */ String fYF;
    final /* synthetic */ b nHy;

    b$2(b bVar, String str) {
        this.nHy = bVar;
        this.fYF = str;
    }

    public final void bzS() {
    }

    public final void bxo() {
        x.i("ContentFragment", "download img fail %s", new Object[]{this.fYF});
        b.c(this.nHy);
    }

    public final void MX(String str) {
        b.a(this.nHy, str, "adId", this.fYF);
    }
}
