package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.page.p$d;
import com.tencent.mm.sdk.platformtools.x;

class a$3 implements p$d {
    final /* synthetic */ AppBrandVideoView gbm;
    final /* synthetic */ a gbn;

    a$3(a aVar, AppBrandVideoView appBrandVideoView) {
        this.gbn = aVar;
        this.gbm = appBrandVideoView;
    }

    public final void agK() {
        AppBrandVideoView appBrandVideoView = this.gbm;
        x.i("MicroMsg.AppBrandVideoView", "onUIPause");
        appBrandVideoView.gak.SL();
    }
}
