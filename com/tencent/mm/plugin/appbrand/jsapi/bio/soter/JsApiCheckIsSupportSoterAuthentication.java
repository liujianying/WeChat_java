package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiCheckIsSupportSoterAuthentication extends a {
    public static final int CTRL_INDEX = 276;
    public static final String NAME = "checkIsSupportSoterAuthentication";
    private GetIsSupportSoterTask fKV = null;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
        this.fKV = new GetIsSupportSoterTask(lVar, i, this);
        c.br(this.fKV);
        AppBrandMainProcessService.a(this.fKV);
    }
}
