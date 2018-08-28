package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

abstract class c extends a {
    protected abstract void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i, b bVar);

    c() {
    }

    public void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        final a r = a.r(cVar.getRuntime());
        final com.tencent.mm.plugin.appbrand.jsapi.c cVar2 = cVar;
        final JSONObject jSONObject2 = jSONObject;
        final int i2 = i;
        AnonymousClass1 anonymousClass1 = new a.a() {
            public final void Yz() {
                x.i("MicroMsg.AppBrand.BaseAuthJsApi", "about to call AuthInvoke, api[%s]", new Object[]{c.this.getName()});
                if (cVar2.isRunning()) {
                    c.this.a(cVar2, jSONObject2, i2, r);
                    return;
                }
                x.e("MicroMsg.AppBrand.BaseAuthJsApi", "doAuth but component not running, api = %s", new Object[]{c.this.getName()});
                r.Dd(2);
            }

            public final String toString() {
                return hashCode() + "|" + c.this.getName();
            }
        };
        if (!r.aic()) {
            synchronized (r.gBF) {
                r.gBF.offer(anonymousClass1);
            }
            r.Dd(1);
        }
    }

    final void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, int i, String str) {
        cVar.E(i, f(str, null));
    }
}
