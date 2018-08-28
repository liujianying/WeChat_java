package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import com.tencent.mm.sdk.platformtools.x;

class VideoTextureView$1 extends Thread {
    final /* synthetic */ MediaPlayer hUb;
    final /* synthetic */ VideoTextureView qUl;

    VideoTextureView$1(VideoTextureView videoTextureView, MediaPlayer mediaPlayer) {
        this.qUl = videoTextureView;
        this.hUb = mediaPlayer;
    }

    public final void run() {
        try {
            if (this.hUb != null) {
                x.i("MicroMsg.VideoTextureView", "%d another thread to release player[%s]", new Object[]{Integer.valueOf(this.qUl.hashCode()), this.hUb});
                this.hUb.stop();
                this.hUb.release();
            }
        } catch (Exception e) {
        }
    }
}
