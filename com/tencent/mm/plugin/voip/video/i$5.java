package com.tencent.mm.plugin.voip.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class i$5 implements OnCompletionListener {
    final /* synthetic */ i oVi;

    i$5(i iVar) {
        this.oVi = iVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.release();
        if (System.currentTimeMillis() - this.oVi.oVg > 5000) {
            this.oVi.oVe = 8;
        }
    }
}
