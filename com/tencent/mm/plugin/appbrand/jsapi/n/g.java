package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ah;
import org.json.JSONObject;

public final class g extends a {
    private static final int CTRL_INDEX = 470;
    private static final String NAME = "showStatusBar";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        p d = d(lVar);
        if (d == null) {
            lVar.E(i, f("fail no page available", null));
        } else {
            a(d.gnE, (c) lVar, i);
        }
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        a(pVar.gnE, (c) pVar, i);
    }

    final void a(com.tencent.mm.plugin.appbrand.page.a.c cVar, c cVar2, int i) {
        if (ah.isMainThread()) {
            cVar.ahh();
            cVar2.E(i, f("ok", null));
            return;
        }
        ah.A(new 1(this, cVar, cVar2, i));
    }
}
