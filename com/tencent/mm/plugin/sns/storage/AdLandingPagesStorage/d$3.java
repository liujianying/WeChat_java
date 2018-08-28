package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.d;
import com.tencent.mm.sdk.platformtools.ah;

class d$3 implements d {
    final /* synthetic */ String iRk;
    final /* synthetic */ d$a nIk;
    final /* synthetic */ String nny;

    d$3(d$a d_a, String str, String str2) {
        this.nIk = d_a;
        this.nny = str;
        this.iRk = str2;
    }

    public final void bxo() {
        if (this.nIk != null) {
            ah.A(new 1(this));
        }
    }

    public final void bxp() {
        if (this.nIk != null) {
            ah.A(new Runnable() {
                public final void run() {
                    d$3.this.nIk.MX(d$3.this.nny + d$3.this.iRk);
                }
            });
        }
    }
}
