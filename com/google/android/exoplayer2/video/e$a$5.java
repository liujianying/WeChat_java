package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.video.e.a;

class e$a$5 implements Runnable {
    final /* synthetic */ a aEa;
    final /* synthetic */ int aEd;
    final /* synthetic */ int aEe;
    final /* synthetic */ int aEf;
    final /* synthetic */ float aEg;

    e$a$5(a aVar, int i, int i2, int i3, float f) {
        this.aEa = aVar;
        this.aEd = i;
        this.aEe = i2;
        this.aEf = i3;
        this.aEg = f;
    }

    public final void run() {
        this.aEa.aDZ.b(this.aEd, this.aEe, this.aEf, this.aEg);
    }
}
