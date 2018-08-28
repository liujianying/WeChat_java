package com.tencent.mm.plugin.voip.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.model.au;

class i$7 implements OnCompletionListener {
    final /* synthetic */ i oVi;

    public i$7(i iVar) {
        this.oVi = iVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.release();
        if (System.currentTimeMillis() - this.oVi.oVg > 5000) {
            this.oVi.oVe = 8;
            au.HV().setMode(0);
        }
    }
}
