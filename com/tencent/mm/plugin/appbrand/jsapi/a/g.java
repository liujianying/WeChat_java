package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b$a;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.protocal.c.bif;
import com.tencent.mm.protocal.c.big;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = 205;
    public static final String NAME = "setUserAutoFillData";

    public final void a(final p pVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData data is invalid");
            pVar.E(i, f("fail:data is invalid", null));
            return;
        }
        String optString = jSONObject.optString("dataList");
        x.i("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData appId:%s, dataList:%s", new Object[]{pVar.mAppId, optString});
        b.a aVar = new b.a();
        aVar.dIG = new bif();
        aVar.dIH = new big();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo";
        aVar.dIF = 1180;
        aVar.dII = 0;
        aVar.dIJ = 0;
        b KT = aVar.KT();
        bif bif = (bif) KT.dID.dIL;
        bif.bPS = r2;
        bif.rLM = optString;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(KT, new b$a() {
            public final void a(int i, int i2, String str, b bVar) {
                if (i == 0 && i2 == 0 && bVar.dIE.dIL != null) {
                    x.i("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData success");
                    pVar.E(i, g.this.f("ok", null));
                    return;
                }
                x.e("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData SaveUserAutoFillInfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.dIE.dIL});
                pVar.E(i, g.this.f("fail:cgi fail", null));
            }
        });
    }
}
