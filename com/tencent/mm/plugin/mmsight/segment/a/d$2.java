package com.tencent.mm.plugin.mmsight.segment.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mm.plugin.mmsight.segment.a.a.c;

class d$2 implements OnSeekCompleteListener {
    final /* synthetic */ d lnP;
    final /* synthetic */ c lnQ;

    d$2(d dVar, c cVar) {
        this.lnP = dVar;
        this.lnQ = cVar;
    }

    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        this.lnQ.bH(mediaPlayer);
    }
}
