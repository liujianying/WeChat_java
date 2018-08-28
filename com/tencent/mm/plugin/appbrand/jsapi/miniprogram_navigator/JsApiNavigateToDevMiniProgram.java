package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONObject;

public final class JsApiNavigateToDevMiniProgram extends a {
    private static final int CTRL_INDEX = 351;
    private static final String NAME = "navigateToDevMiniProgram";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("downloadURL");
        String optString3 = jSONObject.optString("checkSumMd5");
        a a = a.a(jSONObject.optString("envVersion"), a.fVx);
        String optString4 = jSONObject.optString("relativeURL");
        JSONObject optJSONObject = jSONObject.optJSONObject("extraData");
        String optString5 = jSONObject.optString("extoptions");
        if (bi.oW(optString)) {
            lVar.E(i, f("fail invalid appId", null));
        } else if (a.fVx == a && (bi.oW(optString2) || bi.oW(optString3))) {
            lVar.E(i, f("fail invalid downloadURL & checkSumMd5", null));
        } else {
            if (a.fVx == a) {
                DevPkgInfo devPkgInfo = new DevPkgInfo();
                devPkgInfo.appId = optString;
                devPkgInfo.cbv = optString2;
                devPkgInfo.cbw = optString3;
                devPkgInfo.fVN = optString5;
                XIPCInvoker.a("com.tencent.mm", devPkgInfo, a.class);
            }
            e.a(lVar, optString, a.fmv, optString4, null, optJSONObject, null, new 1(this, lVar, i));
        }
    }
}
