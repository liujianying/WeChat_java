package com.tencent.mm.booter.notification.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.x;

class f$5 implements OnCompletionListener {
    final /* synthetic */ f cZm;

    f$5(f fVar) {
        this.cZm = fVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        x.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound finish, player: %s", new Object[]{this.cZm.cZj});
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        if (this.cZm.cZj != null) {
            this.cZm.cZj.release();
        }
    }
}
