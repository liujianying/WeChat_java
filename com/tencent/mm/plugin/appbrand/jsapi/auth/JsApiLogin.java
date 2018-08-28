package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import org.json.JSONObject;

public final class JsApiLogin extends c {
    public static final int CTRL_INDEX = 52;
    public static final String NAME = "login";

    public final /* bridge */ /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        super.a(cVar, jSONObject, i);
    }

    public final void a(c cVar, JSONObject jSONObject, int i, b bVar) {
        LoginTask loginTask = new LoginTask();
        loginTask.appId = cVar.getAppId();
        loginTask.fJv = NAME;
        AppBrandSysConfig appBrandSysConfig = cVar.getRuntime().fcu;
        if (appBrandSysConfig != null) {
            loginTask.fmv = appBrandSysConfig.frm.fih;
        }
        AppBrandStatObject qb = a.qb(cVar.getAppId());
        if (qb != null) {
            loginTask.fGJ = qb.scene;
        }
        String jSONObject2 = jSONObject.toString();
        loginTask.fJr = this;
        loginTask.fJs = cVar;
        loginTask.data = jSONObject2;
        loginTask.fFd = i;
        loginTask.fJt = bVar;
        loginTask.fJz = new Bundle();
        loginTask.ahA();
        AppBrandMainProcessService.a(loginTask);
    }
}
