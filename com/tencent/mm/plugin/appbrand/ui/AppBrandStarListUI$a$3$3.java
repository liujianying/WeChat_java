package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.widget.RecyclerView.t;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a.3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a.f;

class AppBrandStarListUI$a$3$3 implements Runnable {
    final /* synthetic */ t gvZ;
    final /* synthetic */ 3 gwa;
    final /* synthetic */ f gwb;

    AppBrandStarListUI$a$3$3(3 3, f fVar, t tVar) {
        this.gwa = 3;
        this.gwb = fVar;
        this.gvZ = tVar;
    }

    public final void run() {
        this.gwb.gwm.setVisibility(8);
        this.gwa.gvX.remove(this.gvZ);
        3.a(this.gwa, this.gvZ);
    }
}
