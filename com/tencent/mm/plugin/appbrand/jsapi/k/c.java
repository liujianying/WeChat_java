package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.graphics.Color;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class c extends a {
    private static final int CTRL_INDEX = 104;
    private static final String NAME = "showModal";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        p d = e.d(lVar);
        if (d == null) {
            x.w("MicroMsg.JsApiShowModal", "invoke JsApi JsApiShowModal failed, current page view is null.");
            lVar.E(i, f("fail", null));
            return;
        }
        m.o(d);
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString("confirmText", lVar.getContext().getString(j.app_ok));
        String optString3 = jSONObject.optString("cancelText", lVar.getContext().getString(j.app_cancel));
        l lVar2 = lVar;
        ah.A(new 1(this, lVar2, optString, jSONObject.optString("content"), optString2, i, Boolean.valueOf(jSONObject.optBoolean("showCancel", true)), optString3, f.aQ(jSONObject.optString("confirmColor", ""), Color.parseColor("#3CC51F")), f.aQ(jSONObject.optString("cancelColor", ""), Color.parseColor("#000000"))));
    }
}
