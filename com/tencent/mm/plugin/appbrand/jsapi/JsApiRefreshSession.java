package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import org.json.JSONObject;

public final class JsApiRefreshSession extends a {
    private static final int CTRL_INDEX = 118;
    private static final String NAME = "refreshSession";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        RefreshSessionTask refreshSessionTask = new RefreshSessionTask();
        AppBrandSysConfig appBrandSysConfig = lVar.fdO.fcu;
        if (appBrandSysConfig != null) {
            RefreshSessionTask.a(refreshSessionTask, appBrandSysConfig.frm.fih);
        }
        String str = lVar.mAppId;
        refreshSessionTask.fFe = this;
        refreshSessionTask.fFa = lVar;
        refreshSessionTask.fFd = i;
        refreshSessionTask.appId = str;
        AppBrandStatObject qb = a.qb(str);
        if (qb != null) {
            refreshSessionTask.fGJ = qb.scene;
        }
        refreshSessionTask.ahA();
        AppBrandMainProcessService.a(refreshSessionTask);
    }
}
