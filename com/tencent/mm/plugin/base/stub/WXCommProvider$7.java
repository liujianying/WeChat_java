package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.model.au;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.platformtools.x;

class WXCommProvider$7 implements Runnable {
    final /* synthetic */ WXCommProvider hdU;
    final /* synthetic */ b heb;

    WXCommProvider$7(WXCommProvider wXCommProvider, b bVar) {
        this.hdU = wXCommProvider;
        this.heb = bVar;
    }

    public final void run() {
        try {
            if (au.HX()) {
                au.DF().a(new bg(new 1(this)), 0);
            }
        } catch (Exception e) {
            x.e("MicroMsg.WXCommProvider", "exception in NetSceneLocalProxy");
            this.heb.countDown();
        }
    }
}
