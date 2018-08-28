package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.plugin.appbrand.page.p$f;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements p$f {
    final /* synthetic */ AppBrandLivePusherView fRN;
    final /* synthetic */ c fRO;

    c$1(c cVar, AppBrandLivePusherView appBrandLivePusherView) {
        this.fRO = cVar;
        this.fRN = appBrandLivePusherView;
    }

    public final void agL() {
        j ajf = this.fRN.fRF.ajf();
        x.i("MicroMsg.AppBrandLivePusherView", "onForeground code:%d info:%s", new Object[]{Integer.valueOf(ajf.errorCode), ajf.fRT});
    }
}
