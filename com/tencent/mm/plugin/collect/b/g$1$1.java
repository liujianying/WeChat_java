package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.plugin.collect.b.g.1;
import com.tencent.mm.sdk.platformtools.x;

class g$1$1 implements OnCompletionListener {
    final /* synthetic */ 1 hUa;

    g$1$1(1 1) {
        this.hUa = 1;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        x.i("MicroMsg.F2fRcvVoiceListener", "play done");
        g.d(this.hUa.hTZ);
        g.a(this.hUa.hTZ, null);
        g.e(this.hUa.hTZ);
        if (g.f(this.hUa.hTZ).isEmpty()) {
            g.aBK();
        } else {
            g.g(this.hUa.hTZ);
        }
    }
}
