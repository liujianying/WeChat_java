package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 277;
    public static final String NAME = "startSoterAuthentication";

    static /* synthetic */ void a(b bVar, l lVar, int i, Bundle bundle, String str) {
        int i2;
        int i3 = -1;
        String str2 = "not returned";
        Object obj = "";
        Object obj2 = "";
        if (bundle != null) {
            i3 = bundle.getInt("err_code");
            str2 = bundle.getString("err_msg");
            obj = bundle.getString("result_json");
            obj2 = bundle.getString("result_json_signature");
            i2 = bundle.getByte("use_mode");
        } else {
            i2 = 0;
        }
        JSONArray kA = a.kA(i2);
        Object obj3 = "";
        if (kA.length() > 0) {
            try {
                obj3 = kA.getString(0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiStartSoterAuthentication", e, "hy: json error in callback", new Object[0]);
            }
        }
        Map hashMap = new HashMap(5);
        hashMap.put("authMode", obj3);
        hashMap.put("errCode", Integer.valueOf(i3));
        hashMap.put("resultJSON", obj);
        hashMap.put("resultJSONSignature", obj2);
        if ("fail".equals(str)) {
            str = str + " " + str2;
        }
        lVar.E(i, bVar.f(str, hashMap));
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiStartSoterAuthentication", "hy: JsApiStartSoterAuthentication");
        super.a(lVar, jSONObject, i);
        Context c = c(lVar);
        if (c == null) {
            x.e("MicroMsg.JsApiStartSoterAuthentication", "JsApiStartSoterAuthentication context is null, appId is %s", lVar.mAppId);
            lVar.E(i, f("fail", null));
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("requestAuthModes");
        String optString = jSONObject.optString("challenge");
        String optString2 = jSONObject.optString("authContent");
        Intent intent = new Intent();
        intent.putExtra("auth_mode", a.g(optJSONArray));
        intent.putExtra("challenge", optString);
        intent.putExtra("auth_content", optString2);
        intent.putExtra("key_soter_fp_mp_scene", 0);
        c.geJ = new 1(this, lVar, i);
        d.b(c, "soter_mp", ".ui.SoterAuthenticationUI", intent, 1000);
    }
}
