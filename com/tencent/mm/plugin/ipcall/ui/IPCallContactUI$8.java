package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.a.a;

class IPCallContactUI$8 implements Runnable {
    final /* synthetic */ IPCallContactUI kuK;

    IPCallContactUI$8(IPCallContactUI iPCallContactUI) {
        this.kuK = iPCallContactUI;
    }

    public final void run() {
        a.aXa().a(IPCallContactUI.g(this.kuK), false);
    }
}
