package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public abstract class c extends d {
    public final void a(l lVar, JSONObject jSONObject, int i) {
        super.a(lVar, jSONObject, i);
        p d = d(lVar);
        if (d == null) {
            x.w("MicroMsg.BaseUpdateViewJsApi", "invoke JsApi updateView failed, current page view is null.");
            lVar.E(i, f("fail:page is null", null));
            return;
        }
        a(lVar, i, d, jSONObject);
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        super.a(pVar, jSONObject, i);
        a(pVar, i, pVar, jSONObject);
    }

    private void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, int i, p pVar, JSONObject jSONObject) {
        ah.A(new 1(this, pVar, cVar, i, jSONObject));
    }

    public boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        return true;
    }

    public boolean a(p pVar, int i, View view, JSONObject jSONObject, f fVar) {
        return true;
    }

    public boolean aii() {
        return false;
    }

    public boolean aik() {
        return false;
    }
}
