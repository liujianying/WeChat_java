package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoViewControlBar.b;

class AppBrandVideoView$2 implements b {
    final /* synthetic */ AppBrandVideoView gaM;

    AppBrandVideoView$2(AppBrandVideoView appBrandVideoView) {
        this.gaM = appBrandVideoView;
    }

    public final int ajH() {
        return AppBrandVideoView.b(this.gaM).getCacheTimeSec();
    }

    public final int ajI() {
        return AppBrandVideoView.b(this.gaM).getVideoDurationSec();
    }
}
