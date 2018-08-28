package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.c;
import org.json.JSONObject;

public final class JsApiGetSetting extends a {
    public static final int CTRL_INDEX = 236;
    public static final String NAME = "getSetting";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        GetSettingTask getSettingTask = new GetSettingTask();
        getSettingTask.mAppId = lVar.mAppId;
        getSettingTask.fFw = i;
        getSettingTask.fcy = lVar;
        c.br(getSettingTask);
        AppBrandMainProcessService.a(getSettingTask);
    }
}
