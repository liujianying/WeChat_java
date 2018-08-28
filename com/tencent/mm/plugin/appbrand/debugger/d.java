package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.protocal.c.cbg;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class d extends n {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "remoteDebugInfo";

    public final String a(c cVar, JSONObject jSONObject) {
        if (!(cVar.getRuntime().fcy instanceof n)) {
            return f("fail:not debug", null);
        }
        n nVar = (n) cVar.getRuntime().fcy;
        String jSONObject2 = jSONObject.toString();
        x.d("MicroMsg.RemoteDebugService", "RemoteDebugInfo");
        cbg cbg = new cbg();
        cbg.sxz = nVar.fdO.fcz.getCurrentPage().getCurrentPageView().hashCode();
        cbg.sxy = jSONObject2;
        nVar.ftC.a(p.a(cbg, nVar.ftb, "domEvent"));
        return f("ok", null);
    }
}
