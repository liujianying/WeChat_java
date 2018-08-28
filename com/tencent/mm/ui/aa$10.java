package com.tencent.mm.ui;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class aa$10 implements Runnable {
    final /* synthetic */ aa toC;

    aa$10(aa aaVar) {
        this.toC = aaVar;
    }

    public final void run() {
        if (this.toC.tox) {
            x.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "remove setTagRunnable");
            ah.M(this.toC.toy);
        }
    }
}
