package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class VideoSurfaceView$3 implements OnCompletionListener {
    final /* synthetic */ VideoSurfaceView qUd;

    VideoSurfaceView$3(VideoSurfaceView videoSurfaceView) {
        this.qUd = videoSurfaceView;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (VideoSurfaceView.e(this.qUd) != null) {
            VideoSurfaceView.e(this.qUd).ck(VideoSurfaceView.g(this.qUd).getCurrentPosition(), VideoSurfaceView.g(this.qUd).getDuration());
            VideoSurfaceView.e(this.qUd).wd();
        }
    }
}
