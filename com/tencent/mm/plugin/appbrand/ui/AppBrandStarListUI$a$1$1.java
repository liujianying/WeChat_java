package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a.1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a.c;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Collection;
import java.util.List;

class AppBrandStarListUI$a$1$1 implements Runnable {
    final /* synthetic */ List gvV;
    final /* synthetic */ 1 gvW;

    AppBrandStarListUI$a$1$1(1 1, List list) {
        this.gvW = 1;
        this.gvV = list;
    }

    public final void run() {
        if (this.gvW.gvU.getActivity() != null) {
            if (bi.cX(this.gvV)) {
                AppBrandStarListUI.a((AppBrandStarListUI) this.gvW.gvU.getActivity());
                return;
            }
            a aVar = this.gvW.gvU;
            Collection collection = this.gvV;
            aVar.gvR.clear();
            aVar.gvR.addAll(collection);
            aVar.a(c.gwg);
            aVar.anz();
        }
    }
}
