package com.tencent.mm.plugin.appbrand.game.d.a;

import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.l;
import java.util.HashMap;
import java.util.Map;

final class b extends h {
    static final int CTRL_INDEX = -2;
    static final String NAME = "onKeyboardConfirm";

    b() {
    }

    final void a(String str, l lVar) {
        Map hashMap = new HashMap(2);
        hashMap.put("errMsg", "ok");
        hashMap.put("value", str);
        x(hashMap).a(lVar).ahM();
    }
}
