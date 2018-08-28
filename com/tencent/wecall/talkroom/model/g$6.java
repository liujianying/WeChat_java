package com.tencent.wecall.talkroom.model;

import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wecall.talkroom.model.g.a;

class g$6 implements Runnable {
    final /* synthetic */ MultiTalkGroup ltO;
    final /* synthetic */ g vyO;

    g$6(g gVar, MultiTalkGroup multiTalkGroup) {
        this.vyO = gVar;
        this.ltO = multiTalkGroup;
    }

    public final void run() {
        synchronized (this.vyO.cWy) {
            for (a p : this.vyO.cWy) {
                p.p(this.ltO);
            }
        }
    }
}
