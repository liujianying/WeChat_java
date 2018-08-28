package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.g.a.eu;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class WXCommProvider$2 implements a {
    final /* synthetic */ WXCommProvider hdU;

    WXCommProvider$2(WXCommProvider wXCommProvider) {
        this.hdU = wXCommProvider;
    }

    public final boolean vD() {
        if (com.tencent.mm.sdk.b.a.sFg == null || !com.tencent.mm.sdk.b.a.sFg.G(eu.class)) {
            return true;
        }
        synchronized (WXCommProvider.atB()) {
            x.i("MicroMsg.WXCommProvider", "The lock was released.");
            WXCommProvider.aqk();
            WXCommProvider.atB().notifyAll();
        }
        return false;
    }
}
