package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.b;
import com.tencent.mm.sdk.platformtools.x;

class a$c implements Runnable {
    volatile boolean lhj = false;
    final /* synthetic */ a nGD;
    b nGG;
    int nda;

    public a$c(a aVar) {
        this.nGD = aVar;
        x.i("MicroMsg.SightPlayController", "make sure drawJob alive");
    }

    public final void run() {
        if (this.lhj) {
            x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", new Object[]{Integer.valueOf(this.nGD.hashCode()), Integer.valueOf(hashCode())});
            return;
        }
        this.nGD.E(a.B(this.nGD));
        if (a.r(this.nGD) == 0) {
            o.d(this.nGG, 0);
            return;
        }
        long currentTimeMillis = ((long) this.nGD.ncn) - (System.currentTimeMillis() - a.r(this.nGD));
        if (currentTimeMillis > 0) {
            o.d(this.nGG, currentTimeMillis);
        } else {
            o.d(this.nGG, 0);
        }
    }
}
