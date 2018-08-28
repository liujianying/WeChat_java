package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.c;

class b$c$1 implements Runnable {
    final /* synthetic */ c nGS;

    b$c$1(c cVar) {
        this.nGS = cVar;
    }

    public final void run() {
        if (this.nGS.nCX == 1) {
            this.nGS.nGR.bAn();
            this.nGS.gxh.postDelayed(this.nGS.nDb, 100);
        }
    }
}
