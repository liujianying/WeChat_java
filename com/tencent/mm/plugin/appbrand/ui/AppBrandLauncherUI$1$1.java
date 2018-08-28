package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.1;

class AppBrandLauncherUI$1$1 implements Runnable {
    final /* synthetic */ 1 guH;

    AppBrandLauncherUI$1$1(1 1) {
        this.guH = 1;
    }

    public final void run() {
        if (!this.guH.guG.isFinishing() && !this.guH.guG.tlP) {
            this.guH.guG.db(true);
        }
    }
}
