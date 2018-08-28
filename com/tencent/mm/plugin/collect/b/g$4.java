package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.x;

class g$4 implements OnCompletionListener {
    final /* synthetic */ g hTZ;

    g$4(g gVar) {
        this.hTZ = gVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        x.i("MicroMsg.F2fRcvVoiceListener", "no need to play money this time");
        g.e(this.hTZ);
        g.d(this.hTZ);
        g.h(this.hTZ);
        if (g.f(this.hTZ).isEmpty()) {
            g.aBK();
        } else {
            g.g(this.hTZ);
        }
    }
}
