package com.tencent.mm.plugin.sight.decode.ui;

class VideoPlayView$7 implements Runnable {
    final /* synthetic */ VideoPlayView neq;

    VideoPlayView$7(VideoPlayView videoPlayView) {
        this.neq = videoPlayView;
    }

    public final void run() {
        if (VideoPlayView.c(this.neq) != null) {
            VideoPlayView.c(this.neq).setIsPlay(false);
        }
    }
}
