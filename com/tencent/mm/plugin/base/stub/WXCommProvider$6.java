package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.model.au;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.x;

class WXCommProvider$6 extends bd<Boolean> {
    final /* synthetic */ WXCommProvider hdU;

    WXCommProvider$6(WXCommProvider wXCommProvider, Boolean bool) {
        this.hdU = wXCommProvider;
        super(4000, bool);
    }

    private Boolean ame() {
        try {
            x.i("MicroMsg.WXCommProvider", "checkIsLogin run");
            if (!au.HX()) {
                return Boolean.valueOf(false);
            }
            x.i("MicroMsg.WXCommProvider", "checkIsLogin doScene");
            return Boolean.valueOf(au.DF().a(new bg(new 1(this)), 0));
        } catch (Exception e) {
            x.e("MicroMsg.WXCommProvider", "exception in NetSceneLocalProxy.");
            cf(Boolean.valueOf(false));
            return Boolean.valueOf(false);
        }
    }
}
