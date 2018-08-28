package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.b.b.a;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.page.h.1;
import java.util.HashMap;
import java.util.Map;

class g$1 implements a {
    final /* synthetic */ g fdd;

    g$1(g gVar) {
        this.fdd = gVar;
    }

    public final void a(com.tencent.mm.plugin.appbrand.b.a aVar) {
        Object obj;
        g gVar = this.fdd;
        Map hashMap = new HashMap();
        switch (1.fjn[aVar.ordinal()]) {
            case 1:
                obj = "background";
                break;
            case 2:
                obj = "active";
                break;
            case 3:
                obj = "suspend";
                break;
            default:
                return;
        }
        hashMap.put("status", obj);
        new h().x(hashMap).a(gVar.fcy).ahM();
    }
}
