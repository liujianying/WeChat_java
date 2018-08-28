package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.mm.plugin.appbrand.jsapi.m.a.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.g.a;
import java.util.HashMap;
import java.util.Map;

class a$b$1 implements a {
    final /* synthetic */ l fCl;
    final /* synthetic */ b fYd;

    a$b$1(b bVar, l lVar) {
        this.fYd = bVar;
        this.fCl = lVar;
    }

    public final boolean i(Object... objArr) {
        float[] fArr = (float[]) objArr[0];
        Map hashMap = new HashMap();
        hashMap.put("x", Float.valueOf((-fArr[0]) / 10.0f));
        hashMap.put("y", Float.valueOf((-fArr[1]) / 10.0f));
        hashMap.put("z", Float.valueOf((-fArr[2]) / 10.0f));
        this.fYd.fYc.x(hashMap);
        return f.ajz().a(this.fYd.fYc, this.fCl);
    }
}
