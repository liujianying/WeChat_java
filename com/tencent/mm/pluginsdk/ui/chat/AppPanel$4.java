package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.sdk.platformtools.x;

class AppPanel$4 implements Runnable {
    final /* synthetic */ AppPanel qKH;

    AppPanel$4(AppPanel appPanel) {
        this.qKH = appPanel;
    }

    public final void run() {
        g.NE();
        x.i("MicroMsg.AppPanel", "preMakeConnection ret:%d", new Object[]{Integer.valueOf(0)});
        AppPanel.ceg();
    }
}
