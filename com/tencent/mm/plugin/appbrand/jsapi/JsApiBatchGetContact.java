package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsApiBatchGetContact extends a {
    public static final int CTRL_INDEX = 410;
    public static final String NAME = "batchGetContact";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiBatchGetContact", NAME);
        if (jSONObject == null) {
            lVar.E(i, f("fail:data is null or nil", null));
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("appIds");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            x.w("MicroMsg.JsApiBatchGetContact", "appIds is empty");
            lVar.E(i, f("fail:appIds is empty", null));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            arrayList.add(optJSONArray.optString(i2));
        }
        JsApiBatchGetContactTask jsApiBatchGetContactTask = new JsApiBatchGetContactTask(this, lVar, i, arrayList);
        jsApiBatchGetContactTask.ahA();
        AppBrandMainProcessService.a(jsApiBatchGetContactTask);
    }
}
