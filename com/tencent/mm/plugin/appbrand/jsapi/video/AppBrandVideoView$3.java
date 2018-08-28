package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.media.ThumbnailUtils;
import com.tencent.mm.sdk.platformtools.ah;

class AppBrandVideoView$3 implements Runnable {
    final /* synthetic */ AppBrandVideoView gaM;
    final /* synthetic */ String gaN;

    AppBrandVideoView$3(AppBrandVideoView appBrandVideoView, String str) {
        this.gaM = appBrandVideoView;
        this.gaN = str;
    }

    public final void run() {
        ah.A(new 1(this, ThumbnailUtils.createVideoThumbnail(this.gaN, 1)));
    }
}
