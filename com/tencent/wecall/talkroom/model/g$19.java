package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;
import java.util.List;

class g$19 implements Runnable {
    final /* synthetic */ g vyO;
    final /* synthetic */ List vyT;

    g$19(g gVar, List list) {
        this.vyO = gVar;
        this.vyT = list;
    }

    public final void run() {
        synchronized (this.vyO.cWy) {
            for (a em : this.vyO.cWy) {
                em.em(this.vyT);
            }
        }
    }
}
