package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.page.p;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class bb extends a {
    public static final int CTRL_INDEX = 66;
    public static final String NAME = "reportSubmitForm";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        ReportSubmitFormTask reportSubmitFormTask = new ReportSubmitFormTask(pVar.fdO.fcu);
        reportSubmitFormTask.type = 1;
        reportSubmitFormTask.fKK = System.currentTimeMillis();
        reportSubmitFormTask.bVs = pVar.ahc();
        AppBrandMainProcessService.a(reportSubmitFormTask);
        Map hashMap = new HashMap();
        hashMap.put("formId", reportSubmitFormTask.fKK);
        k qv = k.qv(pVar.mAppId);
        if (qv != null) {
            qv.fdG = reportSubmitFormTask.fKK;
        }
        pVar.E(i, f("ok", hashMap));
    }
}
