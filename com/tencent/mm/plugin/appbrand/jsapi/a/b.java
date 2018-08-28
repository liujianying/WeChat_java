package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.protocal.c.sb;
import com.tencent.mm.protocal.c.sc;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 206;
    public static final String NAME = "deleteUserAutoFillData";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData data is invalid");
            pVar.E(i, f("fail:data is invalid", null));
            return;
        }
        Object optString = jSONObject.optString("groupKey");
        int optInt = jSONObject.optInt("groupId", 0);
        if (TextUtils.isEmpty(optString)) {
            x.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData groupKey is invalid");
            pVar.E(i, f("fail:groupKey is invalid", null));
            return;
        }
        x.i("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData appId:%s, groupId:%d, groupKey:%s", new Object[]{pVar.mAppId, Integer.valueOf(optInt), optString});
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new sb();
        aVar.dIH = new sc();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo";
        aVar.dIF = 1194;
        aVar.dII = 0;
        aVar.dIJ = 0;
        com.tencent.mm.ab.b KT = aVar.KT();
        sb sbVar = (sb) KT.dID.dIL;
        sbVar.rvy = optString;
        sbVar.bPS = r3;
        sbVar.group_id = optInt;
        sbVar.source = 1;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(KT, new 1(this, pVar, i));
    }
}
