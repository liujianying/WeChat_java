package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$18 implements Runnable {
    final /* synthetic */ g vyO;

    g$18(g gVar) {
        this.vyO = gVar;
    }

    public final void run() {
        synchronized (this.vyO.cWy) {
            for (a cHO : this.vyO.cWy) {
                cHO.cHO();
            }
        }
    }
}
