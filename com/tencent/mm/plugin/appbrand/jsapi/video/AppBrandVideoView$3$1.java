package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.3;

class AppBrandVideoView$3$1 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ 3 gaO;

    AppBrandVideoView$3$1(3 3, Bitmap bitmap) {
        this.gaO = 3;
        this.abc = bitmap;
    }

    public final void run() {
        if (this.abc != null && !this.abc.isRecycled()) {
            AppBrandVideoView.a(this.gaO.gaM).setImageBitmap(this.abc);
        }
    }
}
