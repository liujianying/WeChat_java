package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 152;
    public static final String NAME = "getContactMessageCount";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        String str = "";
        AppBrandSysConfig appBrandSysConfig = pVar.fdO.fcu;
        if (appBrandSysConfig != null) {
            str = appBrandSysConfig.bGy;
        }
        if (bi.oW(str)) {
            x.e("MicroMsg.JsApiGetAppConfig", "getContactMessageCount username is empty!!!");
        }
        JsApiGetContactMessageCountTask jsApiGetContactMessageCountTask = new JsApiGetContactMessageCountTask();
        jsApiGetContactMessageCountTask.username = str;
        jsApiGetContactMessageCountTask.fFC = new 1(this, jsApiGetContactMessageCountTask, pVar, i);
        jsApiGetContactMessageCountTask.ahA();
        AppBrandMainProcessService.a(jsApiGetContactMessageCountTask);
    }
}
