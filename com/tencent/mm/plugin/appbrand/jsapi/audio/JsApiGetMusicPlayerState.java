package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

public class JsApiGetMusicPlayerState extends a {
    public static final int CTRL_INDEX = 46;
    public static final String NAME = "getMusicPlayerState";
    private GetMusicPlayerState fIc;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        this.fIc = new GetMusicPlayerState(this, lVar, i);
        this.fIc.fId = lVar.mAppId;
        AppBrandMainProcessService.a(this.fIc);
    }
}
