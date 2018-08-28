package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements y {
    final /* synthetic */ AppBrandLivePlayerView fRH;
    final /* synthetic */ b fRI;

    b$1(b bVar, AppBrandLivePlayerView appBrandLivePlayerView) {
        this.fRI = bVar;
        this.fRH = appBrandLivePlayerView;
    }

    public final void ajd() {
        AppBrandLivePlayerView appBrandLivePlayerView = this.fRH;
        x.i("MicroMsg.AppBrandLivePlayerView", "onExitFullScreen");
        appBrandLivePlayerView.cP(false);
    }
}
