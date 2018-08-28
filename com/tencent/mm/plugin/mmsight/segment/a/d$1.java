package com.tencent.mm.plugin.mmsight.segment.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mm.plugin.mmsight.segment.a.a.b;

class d$1 implements OnPreparedListener {
    final /* synthetic */ b lnO;
    final /* synthetic */ d lnP;

    d$1(d dVar, b bVar) {
        this.lnP = dVar;
        this.lnO = bVar;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        this.lnO.bG(mediaPlayer);
    }
}
