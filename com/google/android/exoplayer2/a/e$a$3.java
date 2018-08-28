package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a.e.a;

class e$a$3 implements Runnable {
    final /* synthetic */ a afE;
    final /* synthetic */ Format afI;

    e$a$3(a aVar, Format format) {
        this.afE = aVar;
        this.afI = format;
    }

    public final void run() {
        this.afE.afC.d(this.afI);
    }
}
