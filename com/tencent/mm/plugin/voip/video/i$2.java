package com.tencent.mm.plugin.voip.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class i$2 implements OnErrorListener {
    final /* synthetic */ i oVi;

    i$2(i iVar) {
        this.oVi = iVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.oVi.oVe = 1;
        x.w("MicroMsg.RingPlayer", "RingPlayer startPlayCustomRing MediaPlayer onError, what: " + i + ":extra:" + i2);
        return false;
    }
}
