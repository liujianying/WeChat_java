package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler.b;
import java.util.HashMap;
import java.util.Map;

class c$1 implements b {
    final /* synthetic */ AppBrandInputInvokeHandler fQH;
    final /* synthetic */ c fQI;

    c$1(c cVar, AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
        this.fQI = cVar;
        this.fQH = appBrandInputInvokeHandler;
    }

    public final void bM(int i, int i2) {
        int inputId = this.fQH.getInputId();
        p kK = c.kK(inputId);
        if (kK != null && kK.isRunning()) {
            c$a c_a = new c$a();
            Map hashMap = new HashMap();
            hashMap.put("height", Integer.valueOf(f.lO(i2)));
            hashMap.put("lineCount", Integer.valueOf(i));
            hashMap.put("inputId", Integer.valueOf(inputId));
            c_a.aC(kK.mAppId, 0).x(hashMap).h(new int[]{kK.hashCode()});
        }
    }
}
