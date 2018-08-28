package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$3 implements Runnable {
    final /* synthetic */ g vyO;

    g$3(g gVar) {
        this.vyO = gVar;
    }

    public final void run() {
        synchronized (this.vyO.cWy) {
            for (a St : this.vyO.cWy) {
                St.St();
            }
        }
    }
}
