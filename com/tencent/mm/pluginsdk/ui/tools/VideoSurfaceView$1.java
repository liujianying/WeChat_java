package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import com.tencent.mm.sdk.platformtools.x;

class VideoSurfaceView$1 implements OnVideoSizeChangedListener {
    final /* synthetic */ VideoSurfaceView qUd;

    VideoSurfaceView$1(VideoSurfaceView videoSurfaceView) {
        this.qUd = videoSurfaceView;
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        VideoSurfaceView.a(this.qUd, mediaPlayer.getVideoWidth());
        VideoSurfaceView.b(this.qUd, mediaPlayer.getVideoHeight());
        x.v("MicroMsg.VideoSurfaceView", "on size change size:( " + VideoSurfaceView.a(this.qUd) + " , " + VideoSurfaceView.b(this.qUd) + " )");
        VideoSurfaceView.c(this.qUd);
    }
}
