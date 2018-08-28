package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.plugin.collect.b.g.a;
import com.tencent.mm.plugin.collect.b.g.b;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements OnCompletionListener {
    final /* synthetic */ b hTY;
    final /* synthetic */ g hTZ;

    g$1(g gVar, b bVar) {
        this.hTZ = gVar;
        this.hTY = bVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        x.i("MicroMsg.F2fRcvVoiceListener", "start play money");
        if (g.a(this.hTZ) != null && g.b(this.hTZ) && g.c(this.hTZ) == null) {
            g.a(this.hTZ, a.a(this.hTY.fileName, new 1(this), new 2(this)));
        } else {
            x.i("MicroMsg.F2fRcvVoiceListener", "has played");
        }
        g.h(this.hTZ);
    }
}
