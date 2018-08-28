package com.tencent.mm.plugin.topstory.ui.video;

import android.annotation.SuppressLint;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.topstory.ui.b.f;
import com.tencent.mm.plugin.topstory.ui.b.g;
import com.tencent.mm.plugin.websearch.ui.b;
import com.tencent.mm.sdk.platformtools.x;

class n$b implements d {
    final /* synthetic */ n oBM;
    private float oBS;

    n$b(n nVar) {
        this.oBM = nVar;
        this.oBS = (float) a.fl(nVar.getContext());
    }

    public final void ajJ() {
        x.d("MicroMsg.TopStory.TopStoryVideoViewContainer", "onSingleTap");
        if (n.r(this.oBM)) {
            n.f(this.oBM).jR(n.i(this.oBM));
        }
        if (n.c(this.oBM) != null) {
            n.c(this.oBM).bHL();
            n.c(this.oBM).bHK();
        }
    }

    public final void ajK() {
        x.d("MicroMsg.TopStory.TopStoryVideoViewContainer", "onDoubleTap");
    }

    public final void ajL() {
        n.s(this.oBM).setVisibility(0);
        n.f(this.oBM).bTz();
    }

    public final int e(int i, float f) {
        x.d("MicroMsg.TopStory.TopStoryVideoViewContainer", "onDragProgress:" + i + "/" + f);
        float f2 = f / this.oBS;
        int videoDurationSec = n.b(this.oBM).bHS().getVideoDurationSec();
        int currentPosition = ((int) (f2 * ((float) videoDurationSec))) + getCurrentPosition();
        if (currentPosition < 0) {
            currentPosition = 0;
        } else if (currentPosition > videoDurationSec) {
            currentPosition = videoDurationSec;
        }
        n.s(this.oBM).setText(b.bx(((long) currentPosition) * 1000) + "/" + b.bx(((long) videoDurationSec) * 1000));
        return currentPosition;
    }

    public final void f(int i, float f) {
        n.f(this.oBM).bTA();
        n.s(this.oBM).setVisibility(8);
        int currPosSec = n.b(this.oBM).bHS().getCurrPosSec();
        this.oBM.seekTo(i);
        n.f(this.oBM).bTA();
        x.d("MicroMsg.TopStory.TopStoryVideoViewContainer", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(currPosSec), Float.valueOf(f)});
    }

    public final boolean bHY() {
        if (n.t(this.oBM)) {
            return false;
        }
        return true;
    }

    public final int getCurrentPosition() {
        return n.b(this.oBM).bHS().getCurrPosSec();
    }

    @SuppressLint({"ResourceType"})
    public final void aa(float f) {
        n.u(this.oBM).setPercent(f);
        n.v(this.oBM).setText(g.fts_web_video_volume);
        n.w(this.oBM).setImageResource(f.fts_web_video_volume_icon);
        n.x(this.oBM).setVisibility(0);
        x.d("MicroMsg.TopStory.TopStoryVideoViewContainer", "onAdjustVolume:" + f);
    }

    @SuppressLint({"ResourceType"})
    public final void ab(float f) {
        n.u(this.oBM).setPercent(f);
        n.v(this.oBM).setText(g.fts_web_video_brightness);
        n.w(this.oBM).setImageResource(f.fts_web_video_brightness_icon);
        n.x(this.oBM).setVisibility(0);
        x.d("MicroMsg.TopStory.TopStoryVideoViewContainer", "onAdjustBrightness:" + f);
    }

    public final void ajM() {
        n.x(this.oBM).setVisibility(8);
        com.tencent.mm.plugin.websearch.api.a.a.kB(23);
    }

    public final void ajN() {
        n.x(this.oBM).setVisibility(8);
        com.tencent.mm.plugin.websearch.api.a.a.kB(24);
    }
}
