package com.tencent.mm.booter.notification.a;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class f$4 implements OnErrorListener {
    final /* synthetic */ f cZm;
    final /* synthetic */ AudioManager cZp;

    f$4(f fVar, AudioManager audioManager) {
        this.cZm = fVar;
        this.cZp = audioManager;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound error, player: %s", new Object[]{this.cZm.cZj});
        this.cZp.setMode(0);
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        if (this.cZm.cZj != null) {
            this.cZm.cZj.release();
        }
        return false;
    }
}
