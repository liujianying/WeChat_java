package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.model.bg.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.base.stub.WXCommProvider.6;
import com.tencent.mm.sdk.platformtools.x;

class WXCommProvider$6$1 implements a {
    final /* synthetic */ 6 hea;

    WXCommProvider$6$1(6 6) {
        this.hea = 6;
    }

    public final void a(e eVar) {
        x.i("MicroMsg.WXCommProvider", "checkIsLogin onSceneEnd() hasLogin:%s", new Object[]{Boolean.valueOf(WXCommProvider.hdT)});
        this.hea.cf(Boolean.valueOf(true));
    }
}
