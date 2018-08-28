package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class y extends a {
    public static final int CTRL_INDEX = 101;
    public static final String NAME = "getAppConfig";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            lVar.E(i, f("fail", null));
            x.e("MicroMsg.JsApiGetAppConfig", "data is null");
            return;
        }
        String str = lVar.mAppId;
        int optInt = jSONObject.optInt("type", 0);
        x.i("MicroMsg.JsApiGetAppConfig", "getAppConfig app_id:%s,type:%d", new Object[]{str, Integer.valueOf(optInt)});
        if (optInt <= 0) {
            lVar.E(i, f("fail", null));
            x.e("MicroMsg.JsApiGetAppConfig", "type %d is invalid", new Object[]{Integer.valueOf(optInt)});
            return;
        }
        JsApiGetAppConfigTask jsApiGetAppConfigTask = new JsApiGetAppConfigTask();
        jsApiGetAppConfigTask.appId = str;
        jsApiGetAppConfigTask.type = optInt;
        jsApiGetAppConfigTask.scene = lVar.fdO.aan();
        jsApiGetAppConfigTask.fFC = new 1(this, optInt, jsApiGetAppConfigTask, lVar, i);
        jsApiGetAppConfigTask.ahA();
        AppBrandMainProcessService.a(jsApiGetAppConfigTask);
    }
}
