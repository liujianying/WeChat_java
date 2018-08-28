package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.e.a;
import com.google.android.exoplayer2.b.d;

class e$a$5 implements Runnable {
    final /* synthetic */ a afE;
    final /* synthetic */ d afM;

    e$a$5(a aVar, d dVar) {
        this.afE = aVar;
        this.afM = dVar;
    }

    public final void run() {
        this.afM.jC();
        this.afE.afC.d(this.afM);
    }
}
