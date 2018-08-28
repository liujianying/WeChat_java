package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements b$a {
    final /* synthetic */ String ewx;
    final /* synthetic */ String nHz;
    final /* synthetic */ a nIk;
    final /* synthetic */ String nIl;

    d$1(a aVar, String str, String str2, String str3) {
        this.nIk = aVar;
        this.nIl = str;
        this.nHz = str2;
        this.ewx = str3;
    }

    public final void bzS() {
        ah.A(new 1(this));
    }

    public final void bxo() {
        x.e("AdLandingPagesDownloadResourceHelper", " download error img for " + this.nIl + " for adid:" + this.nHz);
        ah.A(new 2(this));
    }

    public final void bxp() {
        x.i("AdLandingPagesDownloadResourceHelper", " download success img for " + this.nIl + " for adid:" + this.nHz);
        ah.A(new 3(this));
    }
}
