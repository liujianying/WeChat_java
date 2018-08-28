package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;

class f$2 implements Runnable {
    final /* synthetic */ String nHz;
    final /* synthetic */ f nIA;
    final /* synthetic */ s nIB;

    f$2(f fVar, String str, s sVar) {
        this.nIA = fVar;
        this.nHz = str;
        this.nIB = sVar;
    }

    public final void run() {
        f.a(this.nIA, this.nHz, this.nIB);
    }
}
