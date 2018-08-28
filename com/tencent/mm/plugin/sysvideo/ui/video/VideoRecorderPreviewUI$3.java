package com.tencent.mm.plugin.sysvideo.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class VideoRecorderPreviewUI$3 implements OnErrorListener {
    final /* synthetic */ VideoRecorderPreviewUI ouS;

    VideoRecorderPreviewUI$3(VideoRecorderPreviewUI videoRecorderPreviewUI) {
        this.ouS = videoRecorderPreviewUI;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        VideoRecorderPreviewUI.a(this.ouS).stopPlayback();
        h.i(this.ouS, R.l.video_play_faile, R.l.video_play_err);
        return false;
    }
}
