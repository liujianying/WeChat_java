package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

final class ao extends d {
    ao() {
    }

    final a a(l lVar, String str, JSONObject jSONObject) {
        boolean z = true;
        j rf = lVar.fdO.fcw.rf(str);
        switch (1.fQo[rf.ordinal()]) {
            case 1:
                return new a("fail no such file or directory \"%s\"", new Object[]{str});
            case 2:
            case 3:
                a aVar = new a("ok", new Object[0]);
                String str2 = "result";
                if (rf != j.OK) {
                    z = false;
                }
                return aVar.t(str2, Boolean.valueOf(z));
            default:
                return new a("fail " + rf.name(), new Object[0]);
        }
    }
}
