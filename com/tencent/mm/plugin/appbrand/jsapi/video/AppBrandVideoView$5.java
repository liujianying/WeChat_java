package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.jsapi.video.f.b;
import com.tencent.mm.plugin.appbrand.s.i;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandVideoView$5 implements b {
    final /* synthetic */ AppBrandVideoView gaM;

    AppBrandVideoView$5(AppBrandVideoView appBrandVideoView) {
        this.gaM = appBrandVideoView;
    }

    public final void ajJ() {
        x.d("MicroMsg.AppBrandVideoView", "onSingleTap");
        if (AppBrandVideoView.f(this.gaM)) {
            AppBrandVideoView.g(this.gaM).ajS();
        }
    }

    public final void ajK() {
        x.d("MicroMsg.AppBrandVideoView", "onDoubleTap");
    }

    public final void ajL() {
        if (AppBrandVideoView.h(this.gaM)) {
            AppBrandVideoView.i(this.gaM).setVisibility(0);
        }
    }

    public final int e(int i, float f) {
        int i2 = 0;
        if (AppBrandVideoView.h(this.gaM)) {
            x.i("MicroMsg.AppBrandVideoView", "onDragProgress:" + i + "/" + f);
            float measuredWidth = f / ((float) this.gaM.getMeasuredWidth());
            int videoDurationSec = AppBrandVideoView.b(this.gaM).getVideoDurationSec();
            int currentPosition = ((int) (measuredWidth * ((float) videoDurationSec))) + getCurrentPosition();
            if (currentPosition >= 0) {
                if (currentPosition > videoDurationSec) {
                    i2 = videoDurationSec;
                } else {
                    i2 = currentPosition;
                }
            }
            AppBrandVideoView.i(this.gaM).setText(g.bx(((long) i2) * 1000) + "/" + g.bx(((long) videoDurationSec) * 1000));
        }
        return i2;
    }

    public final void f(int i, float f) {
        AppBrandVideoView.i(this.gaM).setVisibility(8);
        int currPosSec = AppBrandVideoView.b(this.gaM).getCurrPosSec();
        x.i("MicroMsg.AppBrandVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(currPosSec), Float.valueOf(f)});
        if (AppBrandVideoView.h(this.gaM)) {
            this.gaM.C(i, false);
        }
    }

    public final int getCurrentPosition() {
        return AppBrandVideoView.b(this.gaM).getCurrPosSec();
    }

    public final void aa(float f) {
        x.d("MicroMsg.AppBrandVideoView", "onAdjustVolume:" + f);
        AppBrandVideoView.j(this.gaM).setPercent(f);
        AppBrandVideoView.k(this.gaM).setText(j.app_brand_video_volume);
        AppBrandVideoView.l(this.gaM).setImageResource(i.app_brand_video_volume_icon);
        AppBrandVideoView.m(this.gaM).setVisibility(0);
    }

    public final void ab(float f) {
        x.d("MicroMsg.AppBrandVideoView", "onAdjustBrightness:" + f);
        AppBrandVideoView.j(this.gaM).setPercent(f);
        AppBrandVideoView.k(this.gaM).setText(j.app_brand_video_brightness);
        AppBrandVideoView.l(this.gaM).setImageResource(i.app_brand_video_brightness_icon);
        AppBrandVideoView.m(this.gaM).setVisibility(0);
    }

    public final void ajM() {
        AppBrandVideoView.m(this.gaM).setVisibility(8);
    }

    public final void ajN() {
        AppBrandVideoView.m(this.gaM).setVisibility(8);
    }
}
