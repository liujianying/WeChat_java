package com.tencent.mm.ui.conversation;

import com.tencent.mm.g.a.ge;
import com.tencent.mm.sdk.b.a;

class m$8 implements Runnable {
    final /* synthetic */ m urw;

    m$8(m mVar) {
        this.urw = mVar;
    }

    public final void run() {
        ge geVar = new ge();
        geVar.bPq.data = "MAIN_UI_EVENT_UPDATE_VIEW";
        a.sFg.m(geVar);
    }
}
