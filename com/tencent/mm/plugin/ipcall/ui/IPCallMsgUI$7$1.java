package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.7;
import com.tencent.mm.sdk.platformtools.x;

class IPCallMsgUI$7$1 implements Runnable {
    final /* synthetic */ 7 kwB;

    IPCallMsgUI$7$1(7 7) {
        this.kwB = 7;
    }

    public final void run() {
        synchronized (this.kwB.kwA.kwx) {
            x.v("MicroMsg.IPCallMsgUI", "comment notify");
            this.kwB.kwA.kwx.a(null, null);
        }
    }
}
