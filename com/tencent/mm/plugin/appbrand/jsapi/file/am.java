package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

final class am extends ax {
    am() {
    }

    final a a(l lVar, String str, JSONObject jSONObject) {
        try {
            jSONObject.put("append", true);
            return super.a(lVar, str, jSONObject);
        } catch (Exception e) {
            b.e("MicroMsg.AppBrand.UnitAppendFile", "call with path(%s), put append fail ex = %s", str, e);
            return new a("fail " + j.ERR_OP_FAIL.name(), new Object[0]);
        }
    }
}
