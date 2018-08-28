package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.4;
import com.tencent.mm.sdk.platformtools.x;

class b$4$1 implements Runnable {
    final /* synthetic */ 4 nHC;

    b$4$1(4 4) {
        this.nHC = 4;
    }

    public final void run() {
        if (b.j(this.nHC.nHy)) {
            this.nHC.nHy.bAv();
            return;
        }
        x.d("ContentFragment", "onAnimationEnd show nextBtn");
        b.a(this.nHC.nHy).nHJ.setAlpha(1.0f);
        b.a(this.nHC.nHy, b.a(this.nHC.nHy));
    }
}
