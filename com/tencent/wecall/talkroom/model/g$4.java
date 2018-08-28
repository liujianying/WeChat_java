package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$4 implements Runnable {
    final /* synthetic */ int bFr;
    final /* synthetic */ Object fEv;
    final /* synthetic */ g vyO;

    g$4(g gVar, int i, Object obj) {
        this.vyO = gVar;
        this.bFr = i;
        this.fEv = obj;
    }

    public final void run() {
        synchronized (this.vyO.cWy) {
            for (a h : this.vyO.cWy) {
                h.h(this.bFr, this.fEv);
            }
        }
    }
}
