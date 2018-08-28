package com.tencent.mm.plugin.appbrand.game.d.a;

import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.l;
import java.util.HashMap;
import java.util.Map;

final class c extends h {
    static final int CTRL_INDEX = 78;
    static final String NAME = "onKeyboardInput";

    c() {
    }

    final void a(String str, l lVar) {
        Map hashMap = new HashMap(2);
        hashMap.put("errMsg", "ok");
        hashMap.put("value", str);
        x(hashMap).a(lVar).ahM();
    }
}
