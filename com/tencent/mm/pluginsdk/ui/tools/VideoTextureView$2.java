package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import com.tencent.mm.sdk.platformtools.x;

class VideoTextureView$2 implements OnVideoSizeChangedListener {
    final /* synthetic */ VideoTextureView qUl;

    VideoTextureView$2(VideoTextureView videoTextureView) {
        this.qUl = videoTextureView;
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            if (mediaPlayer != VideoTextureView.a(this.qUl)) {
                x.w("MicroMsg.VideoTextureView", "another player on video size changed, return now.[%s, %s]", new Object[]{mediaPlayer, VideoTextureView.a(this.qUl)});
                return;
            }
            VideoTextureView.a(this.qUl, mediaPlayer.getVideoWidth());
            VideoTextureView.b(this.qUl, mediaPlayer.getVideoHeight());
            x.i("MicroMsg.VideoTextureView", "on size change size:( " + VideoTextureView.b(this.qUl) + " , " + VideoTextureView.c(this.qUl) + " )");
            if (VideoTextureView.d(this.qUl) != null) {
                VideoTextureView.d(this.qUl).cl(VideoTextureView.b(this.qUl), VideoTextureView.c(this.qUl));
            }
            VideoTextureView.e(this.qUl);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoTextureView", e, "on video size changed error[%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }
}
