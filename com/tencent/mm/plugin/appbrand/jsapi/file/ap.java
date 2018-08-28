package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

final class ap extends d {
    ap() {
    }

    final a a(l lVar, String str, JSONObject jSONObject) {
        j rg = lVar.fdO.fcw.rg(str);
        switch (1.fQo[rg.ordinal()]) {
            case 1:
                return new a("fail no such file or directory \"%s\"", new Object[]{str});
            case 2:
                return new a("fail permission denied, open \"%s\"", new Object[]{str});
            case 3:
                return new a("fail file already exists \"%s\"", new Object[]{str});
            case 4:
                return new a("ok", new Object[0]);
            default:
                return new a("fail " + rg.name(), new Object[0]);
        }
    }
}
