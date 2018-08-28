package com.tencent.wecall.talkroom.model;

import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wecall.talkroom.model.g.a;

class g$7 implements Runnable {
    final /* synthetic */ MultiTalkGroup ltO;
    final /* synthetic */ g vyO;

    g$7(g gVar, MultiTalkGroup multiTalkGroup) {
        this.vyO = gVar;
        this.ltO = multiTalkGroup;
    }

    public final void run() {
        synchronized (this.vyO.cWy) {
            for (a q : this.vyO.cWy) {
                q.q(this.ltO);
            }
        }
    }
}
