package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$15 implements Runnable {
    final /* synthetic */ g vyO;
    final /* synthetic */ int vyR;

    g$15(g gVar, int i) {
        this.vyO = gVar;
        this.vyR = i;
    }

    public final void run() {
        synchronized (this.vyO.cWy) {
            for (a Iq : this.vyO.cWy) {
                Iq.Iq(this.vyR);
            }
        }
    }
}
