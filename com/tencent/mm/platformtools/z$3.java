package com.tencent.mm.platformtools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.x;

class z$3 implements OnCompletionListener {
    z$3() {
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        try {
            mediaPlayer.release();
        } catch (Throwable e) {
            x.printErrStackTrace("MiroMsg.NotificationUtil", e, "", new Object[0]);
        }
    }
}
