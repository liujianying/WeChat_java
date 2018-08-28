package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.b.e;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.h;

final class i extends e {
    private h gwx;

    i(Activity activity, h hVar) {
        super(activity);
        this.gwx = hVar;
    }

    protected final void acA() {
        g aaA = this.gwx.aaA();
        if (aaA != null) {
            aaA.fcL.fjj.jG(10);
        }
    }
}
