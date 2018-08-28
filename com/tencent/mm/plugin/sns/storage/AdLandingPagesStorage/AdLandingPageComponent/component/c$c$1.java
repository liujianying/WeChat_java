package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c.c;
import com.tencent.mm.sdk.platformtools.x;

class c$c$1 implements Runnable {
    final /* synthetic */ c nDc;

    c$c$1(c cVar) {
        this.nDc = cVar;
    }

    public final void run() {
        if (this.nDc.nCX == 1) {
            c cVar = this.nDc;
            x.d("AdLandingCarouselComp", "onDraggin first visible " + cVar.nCT.nCQ.fi() + ", last visible " + cVar.nCT.nCQ.fj());
            c.a(cVar.nCT);
            this.nDc.gxh.postDelayed(this.nDc.nDb, 100);
        }
    }
}
