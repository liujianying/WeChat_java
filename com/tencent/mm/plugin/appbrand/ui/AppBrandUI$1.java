package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.b.d;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.g;

class AppBrandUI$1 extends d {
    final /* synthetic */ AppBrandUI gwE;

    AppBrandUI$1(AppBrandUI appBrandUI, Activity activity) {
        this.gwE = appBrandUI;
        super(activity);
    }

    protected final void acz() {
        g aaA = AppBrandUI.a(this.gwE).aaA();
        if (aaA != null) {
            e.a(aaA.mAppId, c.fcj);
        }
    }
}
