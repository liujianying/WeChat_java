package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import org.json.JSONObject;

final class ar extends d {
    ar() {
    }

    final a a(l lVar, String str, JSONObject jSONObject) {
        e eVar;
        String optString = jSONObject.optString("encoding");
        x.i("MicroMsg.AppBrand.UnitReadFile", "call, path %s, encoding %s", new Object[]{str, optString});
        if (bi.oW(optString)) {
            eVar = null;
        } else {
            e eVar2 = (e) e.a.fQd.get(optString.toLowerCase());
            if (eVar2 == null) {
                return new a("fail invalid encoding", new Object[0]);
            }
            eVar = eVar2;
        }
        h hVar = new h();
        j a = lVar.fdO.fcw.a(str, hVar);
        if (a == j.fkI) {
            Object obj;
            if (eVar == null) {
                obj = (Comparable) hVar.value;
            } else {
                String obj2 = eVar.i((ByteBuffer) hVar.value);
            }
            if (!(obj2 instanceof ByteBuffer)) {
                com.tencent.mm.plugin.appbrand.l.a.j((ByteBuffer) hVar.value);
            }
            return new a("ok", new Object[0]).t("data", obj2);
        }
        switch (1.fQo[a.ordinal()]) {
            case 1:
                return new a("fail no such file \"%s\"", new Object[]{str});
            case 2:
                return new a("fail permission denied, open \"%s\"", new Object[]{str});
            case 3:
                return new a("fail \"%s\" is not a regular file", new Object[]{str});
            default:
                return new a("fail " + a.name(), new Object[0]);
        }
    }
}
