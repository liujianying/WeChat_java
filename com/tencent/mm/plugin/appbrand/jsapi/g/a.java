package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.k.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.h.a {
    public static final int CTRL_INDEX = 467;
    public static final String NAME = "createLoadSubPackageTask";
    String fEl = "";
    String fVW = "";
    long mTotalSize = -1;

    protected final String ajr() {
        if (bi.oW(this.fEl)) {
            StringBuilder stringBuilder = new StringBuilder();
            b.alr();
            this.fEl = stringBuilder.append(b.alq()).toString();
        }
        return this.fEl;
    }

    protected final String ajs() {
        return "loadTaskId";
    }

    public final void a(l lVar, JSONObject jSONObject, String str) {
        this.fVW = jSONObject.optString("moduleName");
        if (bi.oW(this.fVW)) {
            x.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: null or nil moduleName");
            j(lVar);
            return;
        }
        g gVar = lVar.fdO;
        if (gVar == null || gVar.mFinished) {
            x.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: runtime is not in valid state!");
            j(lVar);
            return;
        }
        com.tencent.mm.plugin.appbrand.i.a aVar = gVar.fcM;
        if (aVar == null) {
            x.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: modularizingHelper null!");
            j(lVar);
        } else if (aVar.alp()) {
            aVar.a(this.fVW, false, new 1(this, lVar), new 2(this, lVar));
        } else {
            x.w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: not support modularizing but still called JsApiCreateLoadSubPackageTask");
            a.a(lVar, this.fEl, "fail", this.fVW, 0, -1, -1);
        }
    }

    private void j(l lVar) {
        a.a(lVar, this.fEl, "fail", this.fVW, 0, -1, -1);
    }
}
