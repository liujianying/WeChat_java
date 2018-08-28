package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ab$2 implements a {
    final /* synthetic */ ab nGb;

    ab$2(ab abVar) {
        this.nGb = abVar;
    }

    public final void bzS() {
    }

    public final void bxo() {
        ab.a(this.nGb, null);
        ab.a(this.nGb).countDown();
    }

    public final void MX(String str) {
        try {
            ab.a(this.nGb, MMBitmapFactory.decodeFile(str));
            ab.a(this.nGb).countDown();
        } catch (Throwable e) {
            x.e("AdlandingRadarChartComp", "%s" + bi.i(e));
        }
    }
}
