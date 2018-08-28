package com.tencent.mm.ui.conversation;

import com.tencent.mm.g.a.ge;
import com.tencent.mm.sdk.b.a;

class i$12 implements Runnable {
    final /* synthetic */ i uqR;

    i$12(i iVar) {
        this.uqR = iVar;
    }

    public final void run() {
        ge geVar = new ge();
        geVar.bPq.data = "MAIN_UI_EVENT_INIT_FINALLY";
        a.sFg.m(geVar);
    }
}
