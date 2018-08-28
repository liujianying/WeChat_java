package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.ReportTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 245;
    private static final String NAME = "reportPageData";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        AppBrandSysConfig appBrandSysConfig = lVar.fdO.fcu;
        AppBrandStatObject qb = com.tencent.mm.plugin.appbrand.a.qb(lVar.mAppId);
        ReportTask reportTask = new ReportTask();
        if (appBrandSysConfig != null) {
            reportTask.appId = appBrandSysConfig.appId;
            reportTask.username = appBrandSysConfig.bGy;
            reportTask.fmv = appBrandSysConfig.frm.fih;
            reportTask.cbu = appBrandSysConfig.frm.fii;
            reportTask.fKP = WxaCommLibRuntimeReader.abP().fii;
        }
        if (qb != null) {
            reportTask.scene = qb.scene;
            reportTask.cbB = qb.cbB;
        }
        p d = d(lVar);
        if (d != null) {
            reportTask.bGH = d.getURL();
        }
        reportTask.fWF = jSONObject.toString();
        AppBrandMainProcessService.a(reportTask);
        lVar.E(i, f("ok", null));
    }
}
