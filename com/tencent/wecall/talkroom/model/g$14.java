package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$14 implements Runnable {
    final /* synthetic */ boolean iIq;
    final /* synthetic */ g vyO;

    g$14(g gVar, boolean z) {
        this.vyO = gVar;
        this.iIq = z;
    }

    public final void run() {
        synchronized (this.vyO.cWy) {
            for (a gD : this.vyO.cWy) {
                gD.gD(this.iIq);
            }
        }
    }
}
