package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class d$5 implements a {
    final /* synthetic */ String ewx;
    final /* synthetic */ String nHz;
    final /* synthetic */ d.a nIk;
    final /* synthetic */ String val$url;

    d$5(d.a aVar, String str, String str2, String str3) {
        this.nIk = aVar;
        this.val$url = str;
        this.nHz = str2;
        this.ewx = str3;
    }

    public final void bzS() {
        ah.A(new 1(this));
    }

    public final void bxo() {
        x.e("AdLandingPagesDownloadResourceHelper", " download error sight for " + this.val$url + " for adid:" + this.nHz);
        ah.A(new 2(this));
    }

    public final void bxp() {
        x.i("AdLandingPagesDownloadResourceHelper", " download success sight for " + this.val$url + " for adid:" + this.nHz);
        ah.A(new 3(this));
    }
}
