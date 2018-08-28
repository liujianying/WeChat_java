package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

final class at extends d {
    at() {
    }

    final a a(l lVar, String str, JSONObject jSONObject) {
        j rh = lVar.fdO.fcw.rh(str);
        switch (1.fQo[rh.ordinal()]) {
            case 1:
            case 2:
                return new a("fail no such file or directory \"%s\"", new Object[]{str});
            case 3:
                return new a("fail directory not empty", new Object[0]);
            case 4:
                return new a("fail permission denied, open \"%s\"", new Object[]{str});
            case 5:
                return new a("ok", new Object[0]);
            default:
                return new a("fail " + rh.name(), new Object[0]);
        }
    }
}
