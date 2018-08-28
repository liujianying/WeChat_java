package com.tencent.mm.plugin.appbrand.ui;

import android.support.v4.app.Fragment;

class AppBrandLauncherUI$2 implements Runnable {
    final /* synthetic */ AppBrandLauncherUI guG;

    AppBrandLauncherUI$2(AppBrandLauncherUI appBrandLauncherUI) {
        this.guG = appBrandLauncherUI;
    }

    public final void run() {
        if (!this.guG.tlP && !this.guG.isFinishing()) {
            Fragment R = AppBrandLauncherUI.a(this.guG).R(AppBrandLauncherUI.bB());
            if (R != null && (R instanceof AppBrandLauncherUI$a)) {
                ((AppBrandLauncherUI$a) R).anp();
            }
        }
    }
}
