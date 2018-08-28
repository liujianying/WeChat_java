package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseVideo extends a {
    public static final int CTRL_INDEX = 36;
    public static final String NAME = "chooseVideo";
    private static volatile boolean fUO = false;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        int i2 = 0;
        if (fUO) {
            lVar.E(i, f("cancel", null));
            return;
        }
        MMActivity c = c(lVar);
        if (c == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        ChooseRequest chooseRequest = new ChooseRequest();
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        x.i("MicroMsg.JsApiChooseVideo", "doChooseVideo sourceType = %s, maxDuration = %s", new Object[]{optJSONArray, jSONObject.optString("maxDuration")});
        if (optJSONArray == null || optJSONArray.length() == 0) {
            chooseRequest.fUg = true;
            chooseRequest.fUh = true;
        } else {
            chooseRequest.fUg = optJSONArray.toString().contains("camera");
            chooseRequest.fUh = optJSONArray.toString().contains("album");
        }
        chooseRequest.fUQ = jSONObject.optBoolean("compressed", true);
        if (chooseRequest.fUg) {
            com.tencent.mm.plugin.appbrand.a.a(lVar.mAppId, new 3(this, lVar, jSONObject, i));
            MMActivity c2 = c(lVar);
            if (c2 == null) {
                lVar.E(i, f("fail", null));
            } else {
                i2 = com.tencent.mm.pluginsdk.permission.a.a(c2, "android.permission.CAMERA", 115, "", "");
                if (i2 != 0) {
                    com.tencent.mm.plugin.appbrand.a.pZ(lVar.mAppId);
                }
            }
            if (i2 == 0) {
                return;
            }
        }
        fUO = true;
        e.a(lVar.mAppId, new 1(this, lVar));
        chooseRequest.maxDuration = bi.getInt(r4, 60);
        chooseRequest.appId = lVar.mAppId;
        com.tencent.mm.plugin.appbrand.ipc.a.b(c, chooseRequest, new 2(this, lVar, i));
    }
}
