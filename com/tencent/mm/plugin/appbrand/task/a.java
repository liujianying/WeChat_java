package com.tencent.mm.plugin.appbrand.task;

import com.tencent.mm.plugin.appbrand.ui.AppBrandEmbedUI;

final class a extends f {
    final long gtc;
    private String gtd;

    a(long j) {
        super(AppBrandEmbedUI.class, null);
        this.gtc = j;
    }

    final void a(String str, int i, AppBrandRemoteTaskController appBrandRemoteTaskController) {
        if (this.gtS.keySet().isEmpty()) {
            this.gtd = str;
        }
        super.a(str, i, appBrandRemoteTaskController);
    }

    final void vu(String str) {
        if (this.gtd.equals(str)) {
            this.gtS.clear();
            this.gtT.clear();
            return;
        }
        super.vu(str);
    }
}
