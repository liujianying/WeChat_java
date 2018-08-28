package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.g.a.ie;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class WXCommProvider$3 implements Runnable {
    final /* synthetic */ WXCommProvider hdU;
    final /* synthetic */ ie hdV;

    WXCommProvider$3(WXCommProvider wXCommProvider, ie ieVar) {
        this.hdU = wXCommProvider;
        this.hdV = ieVar;
    }

    public final void run() {
        if (!a.sFg.m(this.hdV)) {
            x.e("MicroMsg.WXCommProvider", "handle scan result failed again");
        }
    }
}
