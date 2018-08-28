package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.c.cgu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 108;
    public static final String NAME = "reportRealtimeAction";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        try {
            a(lVar.fdO, null, jSONObject);
            lVar.E(i, f("ok", null));
        } catch (Exception e) {
            x.e("MicroMsg.JsApiReportRealtimeAction", "report by service(%s), e = %s", new Object[]{lVar.mAppId, e});
        }
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        try {
            a(pVar.fdO, pVar, jSONObject);
            pVar.E(i, f("ok", null));
        } catch (Exception e) {
            x.e("MicroMsg.JsApiReportRealtimeAction", "report by page(%s), e = %s", new Object[]{pVar.mAppId, e});
        }
    }

    private static void a(g gVar, p pVar, JSONObject jSONObject) {
        com.tencent.mm.plugin.appbrand.report.a.g.a g;
        int i;
        String optString = jSONObject.optString("actionData");
        cgu cgu = new cgu();
        cgu.hcE = 2;
        cgu.jQb = gVar.mAppId;
        cgu.mEb = 0;
        cgu.ixe = (int) bi.VE();
        cgu.mEc = 0;
        cgu.sAT = optString;
        cgu.sAU = gVar.fcu.frm.fih + 1;
        cgu.sAW = com.tencent.mm.plugin.appbrand.report.a.cH(ad.getContext());
        cgu.sAV = j.g(gVar).fdE;
        AppBrandStatObject appBrandStatObject = gVar.fcE;
        cgu.pPq = appBrandStatObject.scene;
        cgu.sAY = appBrandStatObject.bGG;
        cgu.cbB = appBrandStatObject.cbB;
        cgu.cbC = appBrandStatObject.cbC;
        cgu.sAX = appBrandStatObject.gqK;
        com.tencent.mm.plugin.appbrand.report.a.g gVar2 = gVar.fcz.getReporter().gqZ;
        if (pVar != null) {
            g = gVar2.g(pVar);
        } else {
            g = gVar2.amJ();
        }
        cgu.sAS = g.path;
        cgu.grK = g.grt == null ? null : g.grt.path;
        if (gVar2.vr(g.path)) {
            i = 1;
        } else {
            i = 0;
        }
        cgu.grP = i;
        x.i("MicroMsg.JsApiReportRealtimeAction", "report(%s), path %s, appState %d, sessionId %s, scene %d, sceneNote %s, preScene %d, preSceneNote %s, usedState %d, referPath %s, isEntrance %d", new Object[]{gVar.mAppId, cgu.sAS, Integer.valueOf(cgu.sAU), cgu.sAV, Integer.valueOf(cgu.pPq), cgu.sAY, Integer.valueOf(cgu.cbB), cgu.cbC, Integer.valueOf(cgu.sAX), cgu.grK, Integer.valueOf(cgu.grP)});
        AppBrandIDKeyBatchReport.a(cgu);
    }
}
