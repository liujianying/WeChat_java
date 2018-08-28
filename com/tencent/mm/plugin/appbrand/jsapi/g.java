package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import java.util.Map;
import org.json.JSONObject;

public abstract class g {
    protected l fFa;
    protected p fFb;
    protected JSONObject fFc;
    private int fFd;
    private e fFe;

    public g(e eVar, l lVar, p pVar, JSONObject jSONObject, int i) {
        if (eVar == null || lVar == null || jSONObject == null) {
            throw new IllegalArgumentException("JsApiAsyncRequest");
        }
        this.fFe = eVar;
        this.fFa = lVar;
        this.fFb = pVar;
        this.fFd = i;
        this.fFc = jSONObject;
    }

    public final l ahK() {
        return this.fFa;
    }

    public final JSONObject ahL() {
        return this.fFc;
    }

    public final void w(Map<String, ? extends Object> map) {
        this.fFa.E(this.fFd, this.fFe.f("ok", map));
    }

    public final void g(String str, Map<String, ? extends Object> map) {
        this.fFa.E(this.fFd, this.fFe.f(str, map));
    }
}
