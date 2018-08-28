package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONObject;

abstract class d implements f {
    e fQc = this;

    abstract a a(l lVar, String str, JSONObject jSONObject);

    d() {
    }

    static {
        e$a.init();
    }

    public final a b(l lVar, JSONObject jSONObject) {
        String q = q(jSONObject);
        if (bi.oW(q)) {
            return new a("fail invalid path", new Object[0]);
        }
        if (lVar.fdO.mFinished) {
            return new a("fail:interrupted", new Object[0]);
        }
        a a = a(lVar, q, jSONObject);
        m.a(lVar, a.values, this.fQc);
        return a;
    }

    protected String q(JSONObject jSONObject) {
        String optString = jSONObject.optString("filePath", null);
        if (bi.oW(optString)) {
            optString = jSONObject.optString("dirPath", null);
        }
        if (bi.oW(optString)) {
            return jSONObject.optString("path", null);
        }
        return optString;
    }
}
