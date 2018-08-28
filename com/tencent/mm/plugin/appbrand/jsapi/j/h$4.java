package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.d.a;
import java.util.HashMap;
import java.util.Map;

class h$4 implements a<String> {
    final /* synthetic */ h fXq;
    final /* synthetic */ com.tencent.mm.plugin.appbrand.widget.picker.a fXt;
    final /* synthetic */ AppBrandOptionsPicker fXu;

    h$4(h hVar, com.tencent.mm.plugin.appbrand.widget.picker.a aVar, AppBrandOptionsPicker appBrandOptionsPicker) {
        this.fXq = hVar;
        this.fXt = aVar;
        this.fXu = appBrandOptionsPicker;
    }

    public final /* synthetic */ void f(boolean z, Object obj) {
        this.fXt.hide();
        if (z) {
            Map hashMap = new HashMap(2);
            hashMap.put("value", this.fXu.aqr());
            hashMap.put("index", Integer.valueOf(this.fXu.getValue()));
            this.fXq.h("ok", hashMap);
            return;
        }
        this.fXq.h("cancel", null);
    }
}
