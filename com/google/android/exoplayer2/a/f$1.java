package com.google.android.exoplayer2.a;

import android.media.AudioTrack;

class f$1 extends Thread {
    final /* synthetic */ AudioTrack agP;
    final /* synthetic */ f agQ;

    f$1(f fVar, AudioTrack audioTrack) {
        this.agQ = fVar;
        this.agP = audioTrack;
    }

    public final void run() {
        try {
            this.agP.flush();
            this.agP.release();
        } finally {
            f.a(this.agQ).open();
        }
    }
}
