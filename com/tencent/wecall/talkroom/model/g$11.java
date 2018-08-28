package com.tencent.wecall.talkroom.model;

import java.util.List;

class g$11 implements Runnable {
    final /* synthetic */ g vyO;
    final /* synthetic */ List vyQ;

    g$11(g gVar, List list) {
        this.vyO = gVar;
        this.vyQ = list;
    }

    public final void run() {
        synchronized (this.vyO.cWy) {
            for (g$a bB : this.vyO.cWy) {
                bB.bB(this.vyQ);
            }
        }
    }
}
