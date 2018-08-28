package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.mm.bc.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import java.util.HashMap;
import java.util.Map;

final class d extends h {
    static final int CTRL_INDEX = 473;
    static final String NAME = "onDeviceOrientationChange";

    d() {
    }

    final void a(a aVar) {
        String replace = aVar.name().replace("_", "");
        Map hashMap = new HashMap(2);
        hashMap.put("errMsg", "ok");
        hashMap.put("value", replace);
        x(hashMap).ahM();
    }
}
