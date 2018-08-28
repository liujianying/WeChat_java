package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.ah;
import org.json.JSONObject;

public final class i extends a {
    private static final int CTRL_INDEX = 332;
    public static final String NAME = "operateCamera";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            lVar.E(i, f("fail:data is null or nil", null));
        } else {
            ah.A(new 1(this, jSONObject, lVar, i));
        }
    }
}
