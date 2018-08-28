package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$10 implements Runnable {
    final /* synthetic */ g vyO;

    g$10(g gVar) {
        this.vyO = gVar;
    }

    public final void run() {
        synchronized (this.vyO.cWy) {
            for (a cHM : this.vyO.cWy) {
                cHM.cHM();
            }
        }
    }
}
