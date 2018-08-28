package com.tencent.mm.modelvideo;

import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.x;

class m$3 implements Runnable {
    final /* synthetic */ m emY;

    m$3(m mVar) {
        this.emY = mVar;
    }

    public final void run() {
        x.d("MicroMsg.SightMassSendService", "Try Run service runningFlag:" + m.f(this.emY) + " sending:" + m.g(this.emY));
        if (!m.f(this.emY)) {
            m.l(this.emY);
            m.m(this.emY).dgA = SystemClock.elapsedRealtime();
            m.c(this.emY);
        }
        m.n(this.emY);
        m.o(this.emY).J(10, 10);
    }

    public final String toString() {
        return super.toString() + "|run";
    }
}
