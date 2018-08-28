package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class d$6 implements a {
    final /* synthetic */ String nHz;
    final /* synthetic */ String nIl;
    final /* synthetic */ b nIp;

    d$6(b bVar, String str, String str2) {
        this.nIp = bVar;
        this.nIl = str;
        this.nHz = str2;
    }

    public final void cg(final String str, final int i) {
        ah.A(new Runnable() {
            public final void run() {
            }
        });
    }

    public final void MY(String str) {
        x.e("AdLandingPagesDownloadResourceHelper", " download error video for " + this.nIl + " for adid:" + this.nHz);
        ah.A(new 2(this, str));
    }

    public final void MZ(String str) {
        x.i("AdLandingPagesDownloadResourceHelper", " download success video for " + this.nIl + " for adid:" + this.nHz);
        ah.A(new 3(this, str));
    }
}
