package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class VideoTextureView$7 implements OnCompletionListener {
    final /* synthetic */ VideoTextureView qUl;

    VideoTextureView$7(VideoTextureView videoTextureView) {
        this.qUl = videoTextureView;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        x.i("MicroMsg.VideoTextureView", "video on completion");
        VideoTextureView.b(this.qUl, bi.VE());
        if (VideoTextureView.d(this.qUl) != null) {
            VideoTextureView.d(this.qUl).wd();
        }
    }
}
