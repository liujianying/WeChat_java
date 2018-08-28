package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$1 implements Runnable {
    final /* synthetic */ int vyN;
    final /* synthetic */ g vyO;

    g$1(g gVar, int i) {
        this.vyO = gVar;
        this.vyN = i;
    }

    public final void run() {
        synchronized (this.vyO.cWy) {
            for (a th : this.vyO.cWy) {
                th.th(this.vyN);
            }
        }
    }
}
