package com.tencent.mm.plugin.voip.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class i$1 implements OnCompletionListener {
    final /* synthetic */ i oVi;

    i$1(i iVar) {
        this.oVi = iVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (System.currentTimeMillis() - this.oVi.oVf > 70000) {
            this.oVi.oVe = 4;
        }
    }
}
