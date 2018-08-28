package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a.f.1;
import com.tencent.mm.sdk.platformtools.bi;

class AppBrandStarListUI$a$f$1$1 implements Runnable {
    final /* synthetic */ 1 gwo;

    AppBrandStarListUI$a$f$1$1(1 1) {
        this.gwo = 1;
    }

    public final void run() {
        a.f(this.gwo.gwn.gvU).remove(this.gwo.hW);
        if (a.c(this.gwo.gwn.gvU) != null) {
            a.c(this.gwo.gwn.gvU).bn(this.gwo.hW);
            a.a(this.gwo.gwn.gvU);
            if (bi.cX(a.f(this.gwo.gwn.gvU))) {
                AppBrandStarListUI.a((AppBrandStarListUI) this.gwo.gwn.gvU.getActivity());
            }
        }
    }
}
