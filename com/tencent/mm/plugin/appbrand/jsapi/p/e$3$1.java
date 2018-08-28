package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.mm.plugin.appbrand.jsapi.p.e.3;
import com.tencent.mm.pluginsdk.ui.tools.s.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class e$3$1 implements b {
    final /* synthetic */ 3 gdg;

    e$3$1(3 3) {
        this.gdg = 3;
    }

    public final void uf(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "share image to friend fail, imgPath is null");
        } else {
            e.c(this.gdg.gdb, str);
        }
    }
}
