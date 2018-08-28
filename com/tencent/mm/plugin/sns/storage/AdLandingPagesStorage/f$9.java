package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.x;

class f$9 implements a {
    final /* synthetic */ f nIA;
    final /* synthetic */ String val$url;

    f$9(f fVar, String str) {
        this.nIA = fVar;
        this.val$url = str;
    }

    public final void bzS() {
    }

    public final void bxo() {
        x.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.val$url + "is error");
        f.a(this.nIA, this.val$url);
    }

    public final void MX(String str) {
        f.a(this.nIA, this.val$url);
    }
}
