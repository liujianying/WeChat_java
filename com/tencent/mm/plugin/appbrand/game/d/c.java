package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.mm.plugin.appbrand.game.d.a.d;
import com.tencent.mm.plugin.appbrand.game.d.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.ak;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.l.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashSet;
import java.util.Map;

public final class c {
    private static final String[] fCn = new String[]{"scrollWebviewTo"};

    public static Map<String, e> agz() {
        Map<String, e> ahN = i.ahN();
        ahN.putAll(i.ahO());
        Object<e> hashSet = new HashSet();
        hashSet.add(new JsApiOperateWXData());
        hashSet.add(new com.tencent.mm.plugin.appbrand.game.d.a.e());
        hashSet.add(new f());
        hashSet.add(new d());
        hashSet.add(new ak());
        hashSet.add(new b());
        hashSet.add(new com.tencent.mm.plugin.appbrand.jsapi.l.c());
        hashSet.add(new b());
        hashSet.add(new com.tencent.mm.plugin.appbrand.jsapi.l.d());
        hashSet.add(new a());
        hashSet.add(new com.tencent.mm.plugin.appbrand.jsapi.video.d());
        hashSet.add(new com.tencent.mm.plugin.appbrand.jsapi.video.c());
        hashSet.add(new com.tencent.mm.plugin.appbrand.jsapi.video.b());
        hashSet.add(new a());
        hashSet.add(new com.tencent.mm.plugin.appbrand.jsapi.g.a());
        for (e eVar : hashSet) {
            if (!(eVar == null || bi.oW(eVar.getName()))) {
                ahN.put(eVar.getName(), eVar);
            }
        }
        for (Object remove : fCn) {
            ahN.remove(remove);
        }
        return ahN;
    }
}
