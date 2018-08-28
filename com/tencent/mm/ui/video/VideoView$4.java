package com.tencent.mm.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class VideoView$4 implements OnErrorListener {
    final /* synthetic */ VideoView uFz;

    VideoView$4(VideoView videoView) {
        this.uFz = videoView;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.d("MicroMsg.VideoView", "Error: " + i + "," + i2);
        if (VideoView.m(this.uFz) == null || !VideoView.m(this.uFz).onError(VideoView.e(this.uFz), i, i2)) {
            this.uFz.getWindowToken();
        }
        return true;
    }
}
