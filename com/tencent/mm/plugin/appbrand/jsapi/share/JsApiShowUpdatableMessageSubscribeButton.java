package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiShowUpdatableMessageSubscribeButton extends a {
    public static final int CTRL_INDEX = 465;
    public static final String NAME = "showUpdatableMessageSubscribeButton";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiShowUpdatableMessageSubscribeButton", "data is null, err");
            lVar.E(i, f("fail:invalid data", null));
            return;
        }
        String optString = jSONObject.optString("shareKey");
        if (bi.oW(optString)) {
            x.e("MicroMsg.JsApiShowUpdatableMessageSubscribeButton", "shareKey is null, err");
            lVar.E(i, f("fail:invalid data", null));
            return;
        }
        ShowUpdatableMessageSubscribeButtonTask showUpdatableMessageSubscribeButtonTask = new ShowUpdatableMessageSubscribeButtonTask();
        showUpdatableMessageSubscribeButtonTask.dzR = optString;
        AppBrandMainProcessService.a(showUpdatableMessageSubscribeButtonTask);
        lVar.E(i, f("ok", null));
    }
}
