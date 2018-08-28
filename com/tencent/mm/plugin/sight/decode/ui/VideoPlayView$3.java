package com.tencent.mm.plugin.sight.decode.ui;

import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.ui.MMActivity;

class VideoPlayView$3 implements Runnable {
    final /* synthetic */ VideoPlayView neq;

    VideoPlayView$3(VideoPlayView videoPlayView) {
        this.neq = videoPlayView;
    }

    public final void run() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (this.neq.getContext() instanceof MMActivity) {
            ((MMActivity) this.neq.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            if (VideoPlayView.a(this.neq) instanceof VideoSightView) {
                ((VideoSightView) VideoPlayView.a(this.neq)).setDrawableWidth(displayMetrics.widthPixels);
            }
        }
        ((View) VideoPlayView.a(this.neq)).requestLayout();
        ((View) VideoPlayView.a(this.neq)).postInvalidate();
    }
}
