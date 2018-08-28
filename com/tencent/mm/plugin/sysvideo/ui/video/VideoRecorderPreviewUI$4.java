package com.tencent.mm.plugin.sysvideo.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.video.VideoView;

class VideoRecorderPreviewUI$4 implements OnPreparedListener {
    final /* synthetic */ VideoRecorderPreviewUI ouS;

    VideoRecorderPreviewUI$4(VideoRecorderPreviewUI videoRecorderPreviewUI) {
        this.ouS = videoRecorderPreviewUI;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        x.d("MicroMsg.VideoRecorderPreviewUI", g.Ab() + " onPrepared");
        x.d("MicroMsg.VideoRecorderPreviewUI", g.Ab() + " onPrepared");
        VideoView a = VideoRecorderPreviewUI.a(this.ouS);
        if (a.ngO == null || !a.qTW) {
            a.qTX = true;
        } else {
            a.ngO.start();
            a.qTX = false;
        }
        VideoRecorderPreviewUI.b(this.ouS).sendEmptyMessageDelayed(0, 3000);
    }
}
