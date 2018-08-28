package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ui.chatting.b.b.m;

class ae$4 implements Runnable {
    final /* synthetic */ m tRN;
    final /* synthetic */ ae tRO;
    final /* synthetic */ String tRS;

    ae$4(ae aeVar, m mVar, String str) {
        this.tRO = aeVar;
        this.tRN = mVar;
        this.tRS = str;
    }

    public final void run() {
        this.tRN.cvb().o(this.tRS, -1, false);
    }
}
