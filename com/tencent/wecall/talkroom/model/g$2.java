package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$2 implements Runnable {
    final /* synthetic */ int bFr;
    final /* synthetic */ g vyO;

    g$2(g gVar, int i) {
        this.vyO = gVar;
        this.bFr = i;
    }

    public final void run() {
        synchronized (this.vyO.cWy) {
            for (a Ip : this.vyO.cWy) {
                Ip.Ip(this.bFr);
            }
        }
    }
}
