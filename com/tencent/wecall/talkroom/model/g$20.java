package com.tencent.wecall.talkroom.model;

import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wecall.talkroom.model.g.a;

class g$20 implements Runnable {
    final /* synthetic */ MultiTalkGroup ltO;
    final /* synthetic */ g vyO;

    g$20(g gVar, MultiTalkGroup multiTalkGroup) {
        this.vyO = gVar;
        this.ltO = multiTalkGroup;
    }

    public final void run() {
        synchronized (this.vyO.cWy) {
            for (a b : this.vyO.cWy) {
                b.b(this.ltO);
            }
        }
    }
}
