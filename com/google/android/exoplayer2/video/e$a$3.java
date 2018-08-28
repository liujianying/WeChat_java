package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.video.e.a;

class e$a$3 implements Runnable {
    final /* synthetic */ a aEa;
    final /* synthetic */ Format afI;

    e$a$3(a aVar, Format format) {
        this.aEa = aVar;
        this.afI = format;
    }

    public final void run() {
        this.aEa.aDZ.c(this.afI);
    }
}
