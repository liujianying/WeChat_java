package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.appusage.i.b;

class AppBrandLauncherUI$1 implements b {
    final /* synthetic */ AppBrandLauncherUI guG;

    AppBrandLauncherUI$1(AppBrandLauncherUI appBrandLauncherUI) {
        this.guG = appBrandLauncherUI;
    }

    public final void acW() {
        i.b(this);
        if (!i.acU()) {
            this.guG.runOnUiThread(new 1(this));
        }
    }
}
