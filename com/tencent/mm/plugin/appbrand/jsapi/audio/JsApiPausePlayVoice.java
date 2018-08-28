package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

public final class JsApiPausePlayVoice extends a {
    public static final int CTRL_INDEX = 34;
    public static final String NAME = "pauseVoice";
    private PausePlayVoice fIO;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        this.fIO = new PausePlayVoice((byte) 0);
        AppBrandMainProcessService.a(this.fIO);
        lVar.E(i, f("ok", null));
    }
}
