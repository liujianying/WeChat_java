package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

final class al extends d {
    al() {
    }

    final a a(l lVar, String str, JSONObject jSONObject) {
        String str2;
        if (lVar.fdO.fcw.ra(str) == j.fkI) {
            str2 = "ok";
        } else {
            str2 = String.format("fail no such file or directory \"%s\"", new Object[]{str});
        }
        return new a(str2, new Object[0]);
    }
}
