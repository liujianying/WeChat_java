package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class au$1 implements a {
    final /* synthetic */ l fGs;
    final /* synthetic */ int fGt;
    final /* synthetic */ au fGu;

    au$1(au auVar, l lVar, int i) {
        this.fGu = auVar;
        this.fGs = lVar;
        this.fGt = i;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == 1) {
            String stringExtra;
            Object jSONArray;
            String str = "";
            if (intent != null) {
                stringExtra = intent.getStringExtra("key_app_authorize_state");
            } else {
                stringExtra = str;
            }
            try {
                jSONArray = new JSONArray(stringExtra);
            } catch (JSONException e) {
                jSONArray = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errMsg", this.fGu.getName() + ":ok");
                jSONObject.put("authSetting", jSONArray);
            } catch (Throwable e2) {
                x.e("MicroMsg.JsApiOpenSetting", "set json error!");
                x.printErrStackTrace("MicroMsg.JsApiOpenSetting", e2, "", new Object[0]);
            }
            this.fGs.E(this.fGt, jSONObject.toString());
        }
    }
}
