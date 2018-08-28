package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.b;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

public final class d extends a {
    private static final int CTRL_INDEX = 238;
    private static final String NAME = "setNavigationBarRightButton";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        boolean optBoolean = jSONObject.optBoolean("hide", false);
        jSONObject.optString("text", "");
        jSONObject.optString("iconPath", "");
        String str = "fail";
        switch (1.fZD[b.a(cVar instanceof p ? (p) cVar : a.d((l) cVar), optBoolean) - 1]) {
            case 1:
                str = "ok";
                break;
            case 2:
                str = "fail no page available";
                break;
            case 3:
                str = "fail iconPath not found";
                break;
            case 4:
                str = "fail invalid text length";
                break;
        }
        cVar.E(i, f(str, null));
    }
}
