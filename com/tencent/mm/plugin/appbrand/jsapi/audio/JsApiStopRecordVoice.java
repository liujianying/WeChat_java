package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONObject;

public final class JsApiStopRecordVoice extends a {
    public static final int CTRL_INDEX = 32;
    public static final String NAME = "stopRecord";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        h(lVar);
        lVar.E(i, f("ok", null));
    }

    static void h(l lVar) {
        if (!bi.oW(JsApiStartRecordVoice.fJc)) {
            com.tencent.mm.plugin.appbrand.page.a.t(lVar.fdO).ln(k.qu(lVar.mAppId).fdJ);
            AppBrandMainProcessService.a(new StopRecordVoice((byte) 0));
            JsApiStartRecordVoice.fJc = null;
        }
    }
}
