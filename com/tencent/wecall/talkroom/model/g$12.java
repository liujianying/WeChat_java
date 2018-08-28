package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$12 implements Runnable {
    final /* synthetic */ g vyO;

    g$12(g gVar) {
        this.vyO = gVar;
    }

    public final void run() {
        synchronized (this.vyO.cWy) {
            for (a cHN : this.vyO.cWy) {
                cHN.cHN();
            }
        }
    }
}
