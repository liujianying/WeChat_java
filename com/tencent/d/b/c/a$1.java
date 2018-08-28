package com.tencent.d.b.c;

import com.tencent.d.a.c.c;

class a$1 implements Runnable {
    final /* synthetic */ boolean vlS;
    final /* synthetic */ a vlT;

    a$1(a aVar, boolean z) {
        this.vlT = aVar;
        this.vlS = z;
    }

    public final void run() {
        c.v("Soter.SoterFingerprintCanceller", "soter: enter worker thread. perform cancel", new Object[0]);
        this.vlT.vlR.cancel();
        if (this.vlS) {
            a.cFT();
        }
    }
}
