package com.tencent.mm.plugin.mmsight.segment.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.plugin.mmsight.segment.a.a.a;

class d$4 implements OnErrorListener {
    final /* synthetic */ d lnP;
    final /* synthetic */ a lnS;

    d$4(d dVar, a aVar) {
        this.lnP = dVar;
        this.lnS = aVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return this.lnS.cS(i, i2);
    }
}
