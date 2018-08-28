package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class u extends n {
    public static final int CTRL_INDEX = 401;
    public static final String NAME = "canvasToTempFilePathSync";

    public final String a(l lVar, JSONObject jSONObject) {
        p d = d(lVar);
        if (d == null) {
            x.w("MicroMsg.JsApiCanvasToTempFilePathSync", "invoke JsApi insertView failed, current page view is null.");
            return f("fail", null);
        }
        x.i("MicroMsg.JsApiCanvasToTempFilePathSync", "call toTempFilePathForGame.");
        a a = com.tencent.mm.plugin.appbrand.jsapi.b.a.a(d, jSONObject, true);
        return f(a.Yy, a.values);
    }
}
