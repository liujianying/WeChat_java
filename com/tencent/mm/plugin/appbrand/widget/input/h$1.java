package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.r.c;

class h$1 implements e {
    final /* synthetic */ int fQL;
    final /* synthetic */ h gGK;

    public h$1(h hVar, int i) {
        this.gGK = hVar;
        this.fQL = i;
    }

    public final void onDestroy() {
        c.runOnUiThread(new 1(this));
    }
}
