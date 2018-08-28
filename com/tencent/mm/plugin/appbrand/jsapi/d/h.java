package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.c.f;
import org.json.JSONObject;

public final class h extends g {
    private static final int CTRL_INDEX = 111;
    private static final String NAME = "updateTextArea";

    protected final /* synthetic */ boolean a(f fVar, JSONObject jSONObject, p pVar, int i) {
        com.tencent.mm.plugin.appbrand.widget.input.c.h hVar = (com.tencent.mm.plugin.appbrand.widget.input.c.h) fVar;
        boolean a = super.a(hVar, jSONObject, pVar, i);
        hVar.gLS = Boolean.valueOf(true);
        hVar.gLY = Boolean.valueOf(false);
        Object opt = jSONObject.opt("confirm");
        hVar.gLT = opt == null ? null : com.tencent.mm.plugin.appbrand.r.h.bs(opt);
        return a;
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        super.a(pVar, jSONObject, i);
    }
}
