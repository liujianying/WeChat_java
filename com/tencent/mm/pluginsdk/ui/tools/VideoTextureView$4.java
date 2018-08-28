package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mm.sdk.platformtools.x;

class VideoTextureView$4 implements OnSeekCompleteListener {
    final /* synthetic */ VideoTextureView qUl;

    VideoTextureView$4(VideoTextureView videoTextureView) {
        this.qUl = videoTextureView;
    }

    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        int currentPosition = mediaPlayer != null ? mediaPlayer.getCurrentPosition() : -1;
        x.i("MicroMsg.VideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", new Object[]{Integer.valueOf(currentPosition), Boolean.valueOf(VideoTextureView.g(this.qUl)), Boolean.valueOf(VideoTextureView.j(this.qUl))});
        if (!VideoTextureView.g(this.qUl)) {
            this.qUl.pause();
        } else if (!VideoTextureView.j(this.qUl)) {
            this.qUl.start();
        } else {
            return;
        }
        if (VideoTextureView.k(this.qUl) != null) {
            VideoTextureView.k(this.qUl).bR(VideoTextureView.g(this.qUl));
        }
        VideoTextureView.a(this.qUl, 0);
    }
}
