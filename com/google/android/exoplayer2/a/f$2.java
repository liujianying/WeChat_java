package com.google.android.exoplayer2.a;

import android.media.AudioTrack;

class f$2 extends Thread {
    final /* synthetic */ AudioTrack agP;
    final /* synthetic */ f agQ;

    f$2(f fVar, AudioTrack audioTrack) {
        this.agQ = fVar;
        this.agP = audioTrack;
    }

    public final void run() {
        this.agP.release();
    }
}
