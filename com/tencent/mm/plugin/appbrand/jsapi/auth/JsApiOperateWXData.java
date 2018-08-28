package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiOperateWXData extends c {
    public static final int CTRL_INDEX = 79;
    public static final String NAME = "operateWXData";

    public final void a(c cVar, JSONObject jSONObject, int i, b bVar) {
        try {
            String string = jSONObject.getString("data");
            OperateWXDataTask operateWXDataTask = new OperateWXDataTask();
            operateWXDataTask.appId = cVar.getAppId();
            operateWXDataTask.fJv = NAME;
            AppBrandSysConfig appBrandSysConfig = cVar.getRuntime().fcu;
            if (appBrandSysConfig != null) {
                operateWXDataTask.fmv = appBrandSysConfig.frm.fih;
            }
            operateWXDataTask.fJr = this;
            operateWXDataTask.fJs = cVar;
            operateWXDataTask.fJG = string;
            operateWXDataTask.fFd = i;
            operateWXDataTask.fJt = bVar;
            operateWXDataTask.fJz = new Bundle();
            AppBrandStatObject qb = a.qb(operateWXDataTask.appId);
            if (qb != null) {
                operateWXDataTask.fGJ = qb.scene;
            }
            operateWXDataTask.ahA();
            AppBrandMainProcessService.a(operateWXDataTask);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiOperateWXData", "Exception %s", new Object[]{e.getMessage()});
            cVar.E(i, f("fail", null));
        }
    }
}
