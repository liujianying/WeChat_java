package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;
import java.util.ArrayList;
import java.util.List;

class g$8 implements Runnable {
    final /* synthetic */ g vyO;
    final /* synthetic */ boolean vyP;
    final /* synthetic */ String vyp;

    g$8(g gVar, String str, boolean z) {
        this.vyO = gVar;
        this.vyp = str;
        this.vyP = z;
    }

    public final void run() {
        synchronized (this.vyO.cWy) {
            List<a> arrayList = new ArrayList(this.vyO.cWy);
        }
        for (a bF : arrayList) {
            bF.bF(this.vyp, this.vyP);
        }
    }
}
