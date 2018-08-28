package com.tencent.mm.plugin.sight.decode.ui;

import android.view.View;
import android.view.View.OnClickListener;

class VideoPlayView$6 implements OnClickListener {
    final /* synthetic */ VideoPlayView neq;

    public VideoPlayView$6(VideoPlayView videoPlayView) {
        this.neq = videoPlayView;
    }

    public final void onClick(View view) {
        VideoPlayView.l(this.neq).removeCallbacks(VideoPlayView.n(this.neq));
        VideoPlayView.l(this.neq).postDelayed(VideoPlayView.n(this.neq), 3000);
        if (VideoPlayView.a(this.neq).isPlaying()) {
            VideoPlayView.o(this.neq);
            if (VideoPlayView.c(this.neq) != null) {
                VideoPlayView.c(this.neq).setIsPlay(false);
                return;
            }
            return;
        }
        VideoPlayView.a(this.neq, false);
        VideoPlayView.a(this.neq).x(VideoPlayView.g(this.neq));
        if (VideoPlayView.c(this.neq) != null) {
            VideoPlayView.c(this.neq).setIsPlay(true);
        }
    }
}
