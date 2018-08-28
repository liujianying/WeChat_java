package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class aw extends a {
    public static final int CTRL_INDEX = 430;
    public static final String NAME = "pageNotFoundCallback";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiPageNotFoundCallback", "data is null, do nothing");
            lVar.E(i, f("fail", null));
            return;
        }
        x.i("MicroMsg.JsApiPageNotFoundCallback", "pageNotFoundCallback data:%s", new Object[]{jSONObject});
        Boolean valueOf = Boolean.valueOf(jSONObject.optBoolean("hasHandler"));
        int optInt = jSONObject.optInt("webviewId", -1);
        p d = d(lVar);
        if (valueOf.booleanValue()) {
            if (d != null) {
                ah.M(d.gnF);
                if (d.hashCode() != optInt) {
                    x.e("MicroMsg.JsApiPageNotFoundCallback", "appBrandPageView.getComponentId():%d, webviewId:%d, err", new Object[]{Integer.valueOf(d.hashCode()), Integer.valueOf(optInt)});
                }
            } else {
                x.e("MicroMsg.JsApiPageNotFoundCallback", "appBrandPageView is null");
            }
            x.i("MicroMsg.JsApiPageNotFoundCallback", "already handler, ignore");
            lVar.E(i, f("ok", null));
            return;
        }
        if (d != null && d.hashCode() == optInt) {
            ah.A(new 1(this, d));
        }
        x.e("MicroMsg.JsApiPageNotFoundCallback", "currentPageView is null, return");
        lVar.E(i, f("ok", null));
    }
}
