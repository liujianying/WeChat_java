package com.tencent.mm.booter.notification.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class f$6 implements OnErrorListener {
    final /* synthetic */ f cZm;

    f$6(f fVar) {
        this.cZm = fVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound error, player: %s", new Object[]{this.cZm.cZj});
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        if (this.cZm.cZj != null) {
            this.cZm.cZj.release();
        }
        return false;
    }
}
