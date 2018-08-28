package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.protocal.c.aja;
import com.tencent.mm.protocal.c.ajb;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 204;
    public static final String NAME = "getUserAutoFillData";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData data is invalid");
            pVar.E(i, f("fail:data is invalid", null));
            return;
        }
        LinkedList linkedList = new LinkedList();
        JSONArray optJSONArray = jSONObject.optJSONArray("fields");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                linkedList.add(optJSONArray.optString(i2));
            }
        }
        if (linkedList.size() == 0) {
            x.e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData fields is empty");
            pVar.E(i, f("fail:fields is empty", null));
            return;
        }
        x.i("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData appId:%s, data:%s", new Object[]{pVar.mAppId, jSONObject.toString()});
        b.a aVar = new b.a();
        aVar.dIG = new aja();
        aVar.dIH = new ajb();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
        aVar.dIF = 1191;
        aVar.dII = 0;
        aVar.dIJ = 0;
        b KT = aVar.KT();
        aja aja = (aja) KT.dID.dIL;
        aja.rLL = linkedList;
        aja.bPS = r3;
        aja.rLK = false;
        aja.source = 1;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(KT, new 1(this, pVar, i));
    }
}
