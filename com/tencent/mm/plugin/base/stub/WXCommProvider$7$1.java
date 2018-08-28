package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.model.bg.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.base.stub.WXCommProvider.7;
import com.tencent.mm.sdk.platformtools.x;

class WXCommProvider$7$1 implements a {
    final /* synthetic */ 7 hec;

    WXCommProvider$7$1(7 7) {
        this.hec = 7;
    }

    public final void a(e eVar) {
        x.i("MicroMsg.WXCommProvider", "checkIsLogin() onSceneEnd()");
        this.hec.heb.countDown();
    }
}
