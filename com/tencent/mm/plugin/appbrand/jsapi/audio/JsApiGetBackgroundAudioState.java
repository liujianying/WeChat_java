package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

public class JsApiGetBackgroundAudioState extends a {
    public static final int CTRL_INDEX = 159;
    public static final String NAME = "getBackgroundAudioState";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String str = lVar.mAppId;
        MainProcessTask getBackgroundAudioStateTask = new GetBackgroundAudioStateTask(this, lVar, i);
        getBackgroundAudioStateTask.appId = str;
        AppBrandMainProcessService.a(getBackgroundAudioStateTask);
    }
}
