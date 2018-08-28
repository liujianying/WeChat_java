package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$17 implements Runnable {
    final /* synthetic */ g vyO;
    final /* synthetic */ byte[] vyS;
    final /* synthetic */ String vyp;

    g$17(g gVar, String str, byte[] bArr) {
        this.vyO = gVar;
        this.vyp = str;
        this.vyS = bArr;
    }

    public final void run() {
        synchronized (this.vyO.cWy) {
            for (a z : this.vyO.cWy) {
                z.z(this.vyp, this.vyS);
            }
        }
    }
}
