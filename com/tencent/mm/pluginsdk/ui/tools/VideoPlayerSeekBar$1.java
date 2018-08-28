package com.tencent.mm.pluginsdk.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.x;

class VideoPlayerSeekBar$1 implements OnTouchListener {
    final /* synthetic */ VideoPlayerSeekBar qTx;

    VideoPlayerSeekBar$1(VideoPlayerSeekBar videoPlayerSeekBar) {
        this.qTx = videoPlayerSeekBar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            x.i("MicroMsg.VideoPlayerSeekBar", "ontouch down");
            VideoPlayerSeekBar.a(this.qTx);
            VideoPlayerSeekBar.a(this.qTx, motionEvent.getX());
            if (VideoPlayerSeekBar.b(this.qTx) != null) {
                VideoPlayerSeekBar.c(this.qTx).ajO();
            }
        } else if (motionEvent.getAction() == 2) {
            float x = motionEvent.getX();
            LayoutParams layoutParams = (LayoutParams) VideoPlayerSeekBar.d(this.qTx).getLayoutParams();
            int a = VideoPlayerSeekBar.a(this.qTx, ((int) (x - VideoPlayerSeekBar.e(this.qTx))) + layoutParams.leftMargin, VideoPlayerSeekBar.f(this.qTx));
            layoutParams.leftMargin = a;
            VideoPlayerSeekBar.g(this.qTx).setLayoutParams(layoutParams);
            int i = VideoPlayerSeekBar.f(this.qTx).value;
            if (VideoPlayerSeekBar.h(this.qTx) > 0) {
                layoutParams = (LayoutParams) VideoPlayerSeekBar.i(this.qTx).getLayoutParams();
                layoutParams.width = a;
                VideoPlayerSeekBar.j(this.qTx).setLayoutParams(layoutParams);
            }
            VideoPlayerSeekBar.k(this.qTx).setText(VideoPlayerSeekBar.kT(i / 60) + ":" + VideoPlayerSeekBar.kT(i % 60));
            VideoPlayerSeekBar.l(this.qTx);
        } else {
            int m = VideoPlayerSeekBar.m(this.qTx);
            if (VideoPlayerSeekBar.n(this.qTx)) {
                m = VideoPlayerSeekBar.a(this.qTx, VideoPlayerSeekBar.f(this.qTx).value);
            }
            if (VideoPlayerSeekBar.o(this.qTx) != null) {
                x.i("MicroMsg.VideoPlayerSeekBar", "current time : " + m);
                VideoPlayerSeekBar.p(this.qTx).kV(m);
            }
            VideoPlayerSeekBar.q(this.qTx);
        }
        return true;
    }
}
