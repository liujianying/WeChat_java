package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.x;

class g$2 implements OnErrorListener {
    final /* synthetic */ g hTZ;

    g$2(g gVar) {
        this.hTZ = gVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.e("MicroMsg.F2fRcvVoiceListener", "prefix play error");
        g.d(this.hTZ);
        g.h(this.hTZ);
        g.e(this.hTZ);
        if (g.f(this.hTZ).isEmpty()) {
            g.aBK();
        } else {
            g.g(this.hTZ);
        }
        return false;
    }
}
