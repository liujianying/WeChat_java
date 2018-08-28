package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

abstract class b<T extends d> extends a {
    private static final ThreadPoolExecutor fQa = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());
    private final T fPZ;

    public b(T t) {
        this.fPZ = t;
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        fQa.submit(new 1(this, lVar, jSONObject, i));
    }
}
