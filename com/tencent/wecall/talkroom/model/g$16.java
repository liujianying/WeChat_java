package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$16 implements Runnable {
    final /* synthetic */ g vyO;

    g$16(g gVar) {
        this.vyO = gVar;
    }

    public final void run() {
        synchronized (this.vyO.cWy) {
            for (a bgu : this.vyO.cWy) {
                bgu.bgu();
            }
        }
    }
}
