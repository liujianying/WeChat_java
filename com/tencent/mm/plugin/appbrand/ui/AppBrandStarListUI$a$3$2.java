package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.widget.RecyclerView.t;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a.3;

class AppBrandStarListUI$a$3$2 implements Runnable {
    final /* synthetic */ t gvZ;
    final /* synthetic */ 3 gwa;

    AppBrandStarListUI$a$3$2(3 3, t tVar) {
        this.gwa = 3;
        this.gvZ = tVar;
    }

    public final void run() {
        this.gwa.gvY.remove(this.gvZ);
        3.a(this.gwa, this.gvZ);
    }
}
