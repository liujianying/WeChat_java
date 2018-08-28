package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;

class e$11 implements Runnable {
    final /* synthetic */ e ltL;
    final /* synthetic */ MultiTalkGroup ltO;

    e$11(e eVar, MultiTalkGroup multiTalkGroup) {
        this.ltL = eVar;
        this.ltO = multiTalkGroup;
    }

    public final void run() {
        String str = this.ltO.vgm;
        if (bi.oW(str)) {
            str = this.ltO.vgn;
        }
        o.bgM().lta.HI(str);
    }
}
