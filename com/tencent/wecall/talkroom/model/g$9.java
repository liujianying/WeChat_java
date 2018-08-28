package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$9 implements Runnable {
    final /* synthetic */ int fyo;
    final /* synthetic */ g vyO;

    g$9(g gVar, int i) {
        this.vyO = gVar;
        this.fyo = i;
    }

    public final void run() {
        synchronized (this.vyO.cWy) {
            for (a onStateChanged : this.vyO.cWy) {
                onStateChanged.onStateChanged(this.fyo);
            }
        }
    }
}
