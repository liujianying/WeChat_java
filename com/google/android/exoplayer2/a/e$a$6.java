package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.e.a;

class e$a$6 implements Runnable {
    final /* synthetic */ a afE;
    final /* synthetic */ int afN;

    e$a$6(a aVar, int i) {
        this.afE = aVar;
        this.afN = i;
    }

    public final void run() {
        this.afE.afC.cb(this.afN);
    }
}
