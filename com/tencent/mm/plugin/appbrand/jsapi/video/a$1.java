package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements y {
    final /* synthetic */ AppBrandVideoView gbm;
    final /* synthetic */ a gbn;

    a$1(a aVar, AppBrandVideoView appBrandVideoView) {
        this.gbn = aVar;
        this.gbm = appBrandVideoView;
    }

    public final void ajd() {
        AppBrandVideoView appBrandVideoView = this.gbm;
        x.i("MicroMsg.AppBrandVideoView", "onExitFullScreen");
        if (appBrandVideoView.gan.gaY) {
            appBrandVideoView.gan.ajc();
        }
        appBrandVideoView.cV(false);
    }
}
