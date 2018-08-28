package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.r.m;
import org.json.JSONObject;

public class a extends e {
    public void a(c cVar, JSONObject jSONObject, int i) {
        if (cVar instanceof l) {
            if (m.a((l) cVar, jSONObject, this)) {
                a((l) cVar, jSONObject, i);
            } else {
                cVar.E(i, f(this.fEX, null));
            }
        } else if (cVar instanceof p) {
            a((p) cVar, jSONObject, i);
        }
    }

    public void a(l lVar, JSONObject jSONObject, int i) {
    }

    public void a(p pVar, JSONObject jSONObject, int i) {
    }
}
