package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiMakeVoIPCall extends a {
    public static final int CTRL_INDEX = 154;
    public static final String NAME = "makeVoIPCall";
    private int fFw;
    private l fcy;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        this.fcy = lVar;
        this.fFw = i;
        String optString = jSONObject.optString("context");
        String optString2 = jSONObject.optString("avatarUrl");
        boolean optBoolean = jSONObject.optBoolean("showOther");
        boolean optBoolean2 = jSONObject.optBoolean("allowBackCamera");
        String optString3 = jSONObject.optString("toUserName");
        String oV = bi.oV(jSONObject.optString("scene"));
        String oV2 = bi.oV(jSONObject.optString("type"));
        AppBrandSysConfig appBrandSysConfig = lVar.fdO.fcu;
        if (bi.oW(optString3) && appBrandSysConfig != null) {
            optString3 = appBrandSysConfig.bGy;
        }
        if (bi.oW(lVar.mAppId) || bi.oW(optString3)) {
            x.e("MicroMsg.JsApiMakeVoIPCall", "appId or toUserName invalid!");
            lVar.E(i, f("fail", null));
            return;
        }
        x.d("MicroMsg.JsApiMakeVoIPCall", "allowBackCamera: %s, showOther: %s, avatarUrl: %s, context: %s, toUserName: %s", new Object[]{Boolean.valueOf(optBoolean2), Boolean.valueOf(optBoolean), optString2, optString, optString3});
        StartVoIPCall startVoIPCall = new StartVoIPCall(this, lVar, i);
        startVoIPCall.ahA();
        AppBrandMainProcessService.a(startVoIPCall);
        Intent intent = new Intent();
        intent.putExtra("voipCSBizId", optString3);
        intent.putExtra("voipCSAppId", lVar.mAppId);
        intent.putExtra("voipCSAllowBackCamera", optBoolean2 ? "1" : "0");
        intent.putExtra("voipCSShowOther", optBoolean ? "1" : "0");
        intent.putExtra("voipCSAvatarUrl", optString2);
        intent.putExtra("voipCSContext", optString);
        intent.putExtra("voipCSScene", oV);
        intent.putExtra("voipCSType", oV2);
        intent.putExtra("launch_from_appbrand", true);
        intent.setClassName(lVar.getContext(), lVar.getContext().getPackageName() + ".plugin.voip_cs.ui.VoipCSMainUI");
        AppBrandProcessProxyUI.m(lVar.getContext(), intent);
    }
}
