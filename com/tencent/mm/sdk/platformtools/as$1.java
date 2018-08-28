package com.tencent.mm.sdk.platformtools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

class as$1 implements OnErrorListener {
    final /* synthetic */ MediaPlayer hUb;

    as$1(MediaPlayer mediaPlayer) {
        this.hUb = mediaPlayer;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.i("MicroMsg.PlaySound", "onError, what: %d, extra: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
            } catch (Exception e) {
            }
        }
        if (this.hUb != null) {
            this.hUb.release();
        }
        return false;
    }
}
