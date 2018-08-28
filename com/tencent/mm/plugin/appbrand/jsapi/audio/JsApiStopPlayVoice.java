package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiStopPlayVoice extends a {
    public static final int CTRL_INDEX = 35;
    public static final String NAME = "stopVoice";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("localId");
        x.i("MicroMsg.JsApiStopPlayVoice", "doStopVoice, appId : %s, localId : %s", new Object[]{lVar.mAppId, optString});
        AppBrandMainProcessService.a(new StopPlayVoice((byte) 0));
        lVar.E(i, f("ok", null));
        JsApiStartPlayVoice.fIW = null;
    }

    public static void ahZ() {
        if (!bi.oW(JsApiStartPlayVoice.fIW)) {
            AppBrandMainProcessService.a(new StopPlayVoice((byte) 0));
            JsApiStartPlayVoice.fIW = null;
        }
    }
}
