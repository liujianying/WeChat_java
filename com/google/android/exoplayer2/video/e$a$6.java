package com.google.android.exoplayer2.video;

import android.view.Surface;
import com.google.android.exoplayer2.video.e.a;

class e$a$6 implements Runnable {
    final /* synthetic */ a aEa;
    final /* synthetic */ Surface aEh;

    e$a$6(a aVar, Surface surface) {
        this.aEa = aVar;
        this.aEh = surface;
    }

    public final void run() {
        this.aEa.aDZ.b(this.aEh);
    }
}
