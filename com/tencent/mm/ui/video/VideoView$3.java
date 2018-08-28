package com.tencent.mm.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class VideoView$3 implements OnCompletionListener {
    final /* synthetic */ VideoView uFz;

    VideoView$3(VideoView videoView) {
        this.uFz = videoView;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (VideoView.l(this.uFz) != null) {
            VideoView.l(this.uFz).onCompletion(VideoView.e(this.uFz));
        }
    }
}
