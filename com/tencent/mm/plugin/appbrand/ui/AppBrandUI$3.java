package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.c;

class AppBrandUI$3 implements c {
    final /* synthetic */ AppBrandUI gwE;

    AppBrandUI$3(AppBrandUI appBrandUI) {
        this.gwE = appBrandUI;
    }

    public final void finish() {
        this.gwE.mController.tml.finish();
    }

    public final void b(AppBrandRemoteTaskController appBrandRemoteTaskController) {
        AppBrandUI.a(this.gwE, appBrandRemoteTaskController);
    }
}
