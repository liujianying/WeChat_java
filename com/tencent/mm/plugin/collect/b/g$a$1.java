package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class g$a$1 implements OnErrorListener {
    final /* synthetic */ MediaPlayer hUb;
    final /* synthetic */ OnErrorListener hUc;

    g$a$1(MediaPlayer mediaPlayer, OnErrorListener onErrorListener) {
        this.hUb = mediaPlayer;
        this.hUc = onErrorListener;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.i("MicroMsg.F2fRcvVoiceListener", "onError, what: %d, extra: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
            } catch (Exception e) {
            }
        }
        if (this.hUb != null) {
            this.hUb.release();
        }
        if (this.hUc != null) {
            this.hUc.onError(mediaPlayer, i, i2);
        }
        return false;
    }
}
