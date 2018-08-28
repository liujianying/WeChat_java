package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

class VideoSurfaceView$2 implements OnPreparedListener {
    final /* synthetic */ VideoSurfaceView qUd;

    VideoSurfaceView$2(VideoSurfaceView videoSurfaceView) {
        this.qUd = videoSurfaceView;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        VideoSurfaceView.d(this.qUd);
        if (VideoSurfaceView.e(this.qUd) != null) {
            VideoSurfaceView.e(this.qUd).iy();
        }
        VideoSurfaceView.a(this.qUd, mediaPlayer.getVideoWidth());
        VideoSurfaceView.b(this.qUd, mediaPlayer.getVideoHeight());
        VideoSurfaceView.c(this.qUd);
        if (VideoSurfaceView.a(this.qUd) == 0 || VideoSurfaceView.b(this.qUd) == 0) {
            if (VideoSurfaceView.f(this.qUd)) {
                VideoSurfaceView.g(this.qUd).start();
                VideoSurfaceView.h(this.qUd);
            }
        } else if (VideoSurfaceView.f(this.qUd)) {
            VideoSurfaceView.g(this.qUd).start();
            VideoSurfaceView.h(this.qUd);
        }
    }
}
