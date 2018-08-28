package com.tencent.mm.plugin.sight.decode.ui;

class VideoPlayView$8 implements Runnable {
    final /* synthetic */ VideoPlayView neq;

    VideoPlayView$8(VideoPlayView videoPlayView) {
        this.neq = videoPlayView;
    }

    public final void run() {
        if (!VideoPlayView.a(this.neq).isPlaying()) {
            ((AdVideoPlayerLoadingBar) VideoPlayView.c(this.neq)).ajV();
        }
    }
}
