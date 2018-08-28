package com.tencent.wecall.talkroom.model;

class g$13 implements Runnable {
    final /* synthetic */ int bFr;
    final /* synthetic */ g vyO;
    final /* synthetic */ String vyp;

    g$13(g gVar, String str, int i) {
        this.vyO = gVar;
        this.vyp = str;
        this.bFr = i;
    }

    public final void run() {
        synchronized (this.vyO.cWy) {
            for (g$a dF : this.vyO.cWy) {
                dF.dF(this.vyp, this.bFr);
            }
        }
    }
}
