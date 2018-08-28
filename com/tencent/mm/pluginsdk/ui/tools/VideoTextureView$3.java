package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mm.sdk.platformtools.x;

class VideoTextureView$3 implements OnPreparedListener {
    final /* synthetic */ VideoTextureView qUl;

    VideoTextureView$3(VideoTextureView videoTextureView) {
        this.qUl = videoTextureView;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        if (mediaPlayer == VideoTextureView.a(this.qUl) || mediaPlayer == null) {
            int videoHeight;
            VideoTextureView.f(this.qUl);
            VideoTextureView.a(this.qUl, mediaPlayer != null ? mediaPlayer.getVideoWidth() : 0);
            VideoTextureView videoTextureView = this.qUl;
            if (mediaPlayer != null) {
                videoHeight = mediaPlayer.getVideoHeight();
            } else {
                videoHeight = 0;
            }
            VideoTextureView.b(videoTextureView, videoHeight);
            x.i("MicroMsg.VideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", new Object[]{Integer.valueOf(VideoTextureView.b(this.qUl)), Integer.valueOf(VideoTextureView.c(this.qUl)), Boolean.valueOf(VideoTextureView.g(this.qUl))});
            VideoTextureView.e(this.qUl);
            if (VideoTextureView.b(this.qUl) == 0 || VideoTextureView.c(this.qUl) == 0) {
                if (VideoTextureView.g(this.qUl)) {
                    VideoTextureView.a(this.qUl).start();
                    VideoTextureView.i(this.qUl);
                    VideoTextureView.a(this.qUl).setLooping(VideoTextureView.h(this.qUl));
                }
            } else if (VideoTextureView.g(this.qUl)) {
                VideoTextureView.a(this.qUl).start();
                VideoTextureView.a(this.qUl).setLooping(VideoTextureView.h(this.qUl));
                VideoTextureView.i(this.qUl);
            }
            if (VideoTextureView.d(this.qUl) != null) {
                VideoTextureView.d(this.qUl).iy();
                return;
            }
            return;
        }
        x.w("MicroMsg.VideoTextureView", "another player callback, release now.[%s, %s]", new Object[]{mediaPlayer, VideoTextureView.a(this.qUl)});
        VideoTextureView.a(this.qUl, mediaPlayer);
    }
}
