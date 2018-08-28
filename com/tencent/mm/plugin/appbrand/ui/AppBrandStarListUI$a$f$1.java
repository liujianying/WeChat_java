package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a.f;

class AppBrandStarListUI$a$f$1 implements Runnable {
    final /* synthetic */ String dhF;
    final /* synthetic */ int fmg;
    final /* synthetic */ f gwn;
    final /* synthetic */ int hW;

    AppBrandStarListUI$a$f$1(f fVar, String str, int i, int i2) {
        this.gwn = fVar;
        this.dhF = str;
        this.fmg = i;
        this.hW = i2;
    }

    public final void run() {
        e.abh().g(this.dhF, this.fmg, true);
        if (this.gwn.gvU.getActivity() != null) {
            this.gwn.gvU.getActivity().runOnUiThread(new 1(this));
        }
        a.b(this.gwn.gwi.appId, this.gwn.gwi.fig + 1, 4, 2, "");
    }
}
