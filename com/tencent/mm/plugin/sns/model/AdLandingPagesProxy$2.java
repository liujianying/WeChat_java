package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.n;

class AdLandingPagesProxy$2 implements Runnable {
    final /* synthetic */ String enn;
    final /* synthetic */ AdLandingPagesProxy nmu;

    AdLandingPagesProxy$2(AdLandingPagesProxy adLandingPagesProxy, String str) {
        this.nmu = adLandingPagesProxy;
        this.enn = str;
    }

    public final void run() {
        if (g.Eg().Dx()) {
            n Nk = af.byo().Nk(this.enn);
            if (Nk != null) {
                b bAF = Nk.bAF();
                if (bAF != null) {
                    AdLandingPagesProxy.LT(bAF.bzu());
                    AdLandingPagesProxy.LT(bAF.bzv());
                }
            }
        }
    }
}
