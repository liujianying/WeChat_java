package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiCheckIsSupportFaceDetect extends a {
    public static final int CTRL_INDEX = 214;
    public static final String NAME = "checkIsSupportFacialRecognition";
    private GetIsSupportFaceTask fKN = null;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiCheckIsSupportFaceDetect", "hy: subapp start do check is support face detect");
        this.fKN = new GetIsSupportFaceTask(lVar, i, this);
        c.br(this.fKN);
        AppBrandMainProcessService.a(this.fKN);
    }
}
