package com.tencent.mm.plugin.sysvideo.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class VideoRecorderPreviewUI$6 implements OnCompletionListener {
    final /* synthetic */ VideoRecorderPreviewUI ouS;

    VideoRecorderPreviewUI$6(VideoRecorderPreviewUI videoRecorderPreviewUI) {
        this.ouS = videoRecorderPreviewUI;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        this.ouS.finish();
        this.ouS.overridePendingTransition(0, 0);
    }
}
