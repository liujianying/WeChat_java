package com.tencent.wecall.talkroom.model;

import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wecall.talkroom.model.g.a;

class g$21 implements Runnable {
    final /* synthetic */ int esz;
    final /* synthetic */ MultiTalkGroup ltO;
    final /* synthetic */ g vyO;

    g$21(g gVar, int i, MultiTalkGroup multiTalkGroup) {
        this.vyO = gVar;
        this.esz = i;
        this.ltO = multiTalkGroup;
    }

    public final void run() {
        synchronized (this.vyO.cWy) {
            for (a a : this.vyO.cWy) {
                a.a(this.esz, this.ltO);
            }
        }
    }
}
