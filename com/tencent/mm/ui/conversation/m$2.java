package com.tencent.mm.ui.conversation;

class m$2 implements Runnable {
    final /* synthetic */ m urw;

    m$2(m mVar) {
        this.urw = mVar;
    }

    public final void run() {
        if (!this.urw.bOb.isFinishing()) {
            this.urw.uqX.setSelection(0);
        }
    }
}
