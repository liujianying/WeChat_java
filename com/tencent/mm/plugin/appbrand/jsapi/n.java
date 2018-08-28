package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

public class n extends e {
    public Thread fFo;

    public String a(c cVar, JSONObject jSONObject) {
        if (cVar instanceof l) {
            this.fFo = Thread.currentThread();
            return a((l) cVar, jSONObject);
        } else if (cVar instanceof p) {
            return a((p) cVar);
        } else {
            return "";
        }
    }

    public String a(l lVar, JSONObject jSONObject) {
        return "";
    }

    public String a(p pVar) {
        return "";
    }
}
