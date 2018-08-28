package com.tencent.mm.booter.notification.a;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.x;

class f$3 implements OnCompletionListener {
    final /* synthetic */ f cZm;
    final /* synthetic */ AudioManager cZp;

    f$3(f fVar, AudioManager audioManager) {
        this.cZm = fVar;
        this.cZp = audioManager;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        x.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound finish, player: %s", new Object[]{this.cZm.cZj});
        this.cZp.setMode(0);
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        if (this.cZm.cZj != null) {
            this.cZm.cZj.release();
        }
    }
}
