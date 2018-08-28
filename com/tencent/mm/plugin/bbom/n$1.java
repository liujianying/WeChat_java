package com.tencent.mm.plugin.bbom;

import com.tencent.mm.model.au;
import com.tencent.mm.ui.MMAppMgr;

class n$1 implements Runnable {
    final /* synthetic */ n hey;

    n$1(n nVar) {
        this.hey = nVar;
    }

    public final void run() {
        au.hold();
        MMAppMgr.lE(true);
    }
}
