package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 459;
    private static final String NAME = "sendDataToH5";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (jSONObject.has("webviewId")) {
            String str = lVar.mAppId;
            int optInt = jSONObject.optInt("webviewId");
            String optString = jSONObject.optString("data");
            SendDataToH5FromMiniProgramEvent sendDataToH5FromMiniProgramEvent = new SendDataToH5FromMiniProgramEvent();
            sendDataToH5FromMiniProgramEvent.fQq = str;
            sendDataToH5FromMiniProgramEvent.data = optString;
            sendDataToH5FromMiniProgramEvent.fQr = optInt;
            if (ad.cie()) {
                com.tencent.mm.sdk.b.a.sFg.m(sendDataToH5FromMiniProgramEvent);
            } else {
                XIPCInvoker.a("com.tencent.mm:tools", sendDataToH5FromMiniProgramEvent, a.class, null);
            }
            lVar.E(i, f("ok", null));
            return;
        }
        lVar.E(i, f("fail:invalid data", null));
        x.e("MicroMsg.AppBrand.JsApiSendDataToH5", "invoke with nil webviewId");
    }
}
