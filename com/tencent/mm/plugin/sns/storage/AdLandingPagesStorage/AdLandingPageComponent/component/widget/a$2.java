package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements Runnable {
    final /* synthetic */ a nGD;
    final /* synthetic */ double ncU;

    a$2(a aVar, double d) {
        this.nGD = aVar;
        this.ncU = d;
    }

    public final void run() {
        x.i("MicroMsg.SightPlayController", "SeekToFrame   %f  %s", new Object[]{Double.valueOf(this.ncU), bi.cjd().toString()});
        a.a(this.nGD, this.ncU);
    }
}
