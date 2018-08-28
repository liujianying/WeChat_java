package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import android.view.View.OnClickListener;

class AppBrandVideoView$10 implements OnClickListener {
    final /* synthetic */ AppBrandVideoView gaM;

    AppBrandVideoView$10(AppBrandVideoView appBrandVideoView) {
        this.gaM = appBrandVideoView;
    }

    public final void onClick(View view) {
        if (AppBrandVideoView.b(this.gaM).isPlaying()) {
            this.gaM.pause();
        } else {
            this.gaM.start();
        }
    }
}
