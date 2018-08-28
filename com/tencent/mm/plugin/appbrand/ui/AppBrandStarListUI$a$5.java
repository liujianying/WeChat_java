package com.tencent.mm.plugin.appbrand.ui;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a;

class AppBrandStarListUI$a$5 implements OnGlobalLayoutListener {
    final /* synthetic */ a gvU;
    int gwc = 0;
    final /* synthetic */ ViewTreeObserver gwd;

    AppBrandStarListUI$a$5(a aVar, ViewTreeObserver viewTreeObserver) {
        this.gvU = aVar;
        this.gwd = viewTreeObserver;
    }

    public final void onGlobalLayout() {
        int i = this.gwc + 1;
        this.gwc = i;
        if (i >= 2) {
            this.gwd.removeOnGlobalLayoutListener(this);
            a.b(this.gvU);
        }
    }
}
