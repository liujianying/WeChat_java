package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler.a;

class c$2 implements a {
    final /* synthetic */ AppBrandInputInvokeHandler fQH;
    final /* synthetic */ c fQI;

    c$2(c cVar, AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
        this.fQI = cVar;
        this.fQH = appBrandInputInvokeHandler;
    }

    public final void cO(boolean z) {
        if (z) {
            p kK = c.kK(this.fQH.getInputId());
            if (kK != null && kK.isRunning()) {
            }
        }
    }
}
