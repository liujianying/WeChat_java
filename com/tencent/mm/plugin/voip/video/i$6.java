package com.tencent.mm.plugin.voip.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class i$6 implements OnErrorListener {
    final /* synthetic */ i oVi;

    i$6(i iVar) {
        this.oVi = iVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.oVi.oVe = 5;
            x.w("MicroMsg.RingPlayer", "RingPlayer playSound :onError", new Object[]{mediaPlayer, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        return false;
    }
}
