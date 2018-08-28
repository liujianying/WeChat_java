package com.tencent.mm.plugin.webview.fts.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.fts.c.c;
import com.tencent.mm.plugin.webview.fts.ui.a.b;
import com.tencent.mm.sdk.platformtools.x;

class FtsWebVideoView$12 implements b {
    final /* synthetic */ FtsWebVideoView pQA;

    FtsWebVideoView$12(FtsWebVideoView ftsWebVideoView) {
        this.pQA = ftsWebVideoView;
    }

    public final void ajJ() {
        x.d("MicroMsg.FtsWebVideoView", "onSingleTap");
        if (FtsWebVideoView.e(this.pQA)) {
            FtsWebVideoView.c(this.pQA).jR(FtsWebVideoView.f(this.pQA));
        }
    }

    public final void ajK() {
        x.d("MicroMsg.FtsWebVideoView", "onDoubleTap");
    }

    public final void ajL() {
        if (FtsWebVideoView.d(this.pQA).ajG()) {
            x.i("MicroMsg.FtsWebVideoView", "onStartDragProgress isLive: no seek");
            return;
        }
        FtsWebVideoView.g(this.pQA).setVisibility(0);
        FtsWebVideoView.c(this.pQA).bTz();
    }

    public final int e(int i, float f) {
        int i2 = 0;
        if (FtsWebVideoView.d(this.pQA).ajG()) {
            x.i("MicroMsg.FtsWebVideoView", "onDragProgress isLive: no seek");
        } else {
            x.i("MicroMsg.FtsWebVideoView", "onDragProgress:" + i + "/" + f);
            float measuredWidth = f / ((float) this.pQA.getMeasuredWidth());
            int videoDurationSec = FtsWebVideoView.d(this.pQA).getVideoDurationSec();
            int currentPosition = ((int) (measuredWidth * ((float) videoDurationSec))) + getCurrentPosition();
            if (currentPosition >= 0) {
                if (currentPosition > videoDurationSec) {
                    i2 = videoDurationSec;
                } else {
                    i2 = currentPosition;
                }
            }
            FtsWebVideoView.g(this.pQA).setText(c.bx(((long) i2) * 1000) + "/" + c.bx(((long) videoDurationSec) * 1000));
        }
        return i2;
    }

    public final void f(int i, float f) {
        FtsWebVideoView.c(this.pQA).bTA();
        FtsWebVideoView.g(this.pQA).setVisibility(8);
        int currPosSec = FtsWebVideoView.d(this.pQA).getCurrPosSec();
        x.i("MicroMsg.FtsWebVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(currPosSec), Float.valueOf(f)});
        if (FtsWebVideoView.d(this.pQA).ajG()) {
            x.i("MicroMsg.FtsWebVideoView", "onEndDragProgress isLive: no seek");
            return;
        }
        this.pQA.C(i, false);
        FtsWebVideoView.c(this.pQA).bTA();
        if (FtsWebVideoView.h(this.pQA) != null) {
            FtsWebVideoView.h(this.pQA).bTU();
        }
    }

    public final boolean bHY() {
        if (FtsWebVideoView.i(this.pQA)) {
            return false;
        }
        return true;
    }

    public final int getCurrentPosition() {
        return FtsWebVideoView.d(this.pQA).getCurrPosSec();
    }

    public final void aa(float f) {
        x.d("MicroMsg.FtsWebVideoView", "onAdjustVolume:" + f);
        FtsWebVideoView.j(this.pQA).setPercent(f);
        FtsWebVideoView.k(this.pQA).setText(R.l.fts_web_video_volume);
        FtsWebVideoView.l(this.pQA).setImageResource(R.k.fts_web_video_volume_icon);
        FtsWebVideoView.m(this.pQA).setVisibility(0);
    }

    public final void ab(float f) {
        x.d("MicroMsg.FtsWebVideoView", "onAdjustBrightness:" + f);
        FtsWebVideoView.j(this.pQA).setPercent(f);
        FtsWebVideoView.k(this.pQA).setText(R.l.fts_web_video_brightness);
        FtsWebVideoView.l(this.pQA).setImageResource(R.k.fts_web_video_brightness_icon);
        FtsWebVideoView.m(this.pQA).setVisibility(0);
    }

    public final void ajM() {
        FtsWebVideoView.m(this.pQA).setVisibility(8);
    }

    public final void ajN() {
        FtsWebVideoView.m(this.pQA).setVisibility(8);
    }
}
