package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.m;
import org.json.JSONObject;

abstract class c<T extends d> extends n {
    private final T fPZ;

    public c(T t) {
        this.fPZ = t;
        this.fPZ.fQc = this;
    }

    public final String a(l lVar, JSONObject jSONObject) {
        f$a b = this.fPZ.b(lVar, jSONObject);
        m.a(lVar, b.values, this);
        return f(b.Yy, b.values);
    }
}
