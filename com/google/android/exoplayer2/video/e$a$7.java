package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.video.e.a;

class e$a$7 implements Runnable {
    final /* synthetic */ a aEa;
    final /* synthetic */ d afM;

    e$a$7(a aVar, d dVar) {
        this.aEa = aVar;
        this.afM = dVar;
    }

    public final void run() {
        this.afM.jC();
        this.aEa.aDZ.b(this.afM);
    }
}
