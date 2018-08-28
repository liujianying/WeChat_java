package com.tencent.mm.ui;

import com.tencent.mm.ui.MMAppMgr.Receiver;

class MMAppMgr$Receiver$2 implements Runnable {
    final /* synthetic */ Receiver tnt;

    MMAppMgr$Receiver$2(Receiver receiver) {
        this.tnt = receiver;
    }

    public final void run() {
        MMAppMgr.cqu();
    }
}
