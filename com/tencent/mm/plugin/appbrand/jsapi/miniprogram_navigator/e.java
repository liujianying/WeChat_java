package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.Intent;
import com.tencent.mm.model.gdpr.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandEmbedUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

final class e {
    private static final int fVP = (e.class.hashCode() & 65535);

    e() {
    }

    static /* synthetic */ void c(g gVar, AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        Intent intent = new Intent(gVar.fcq, AppBrandEmbedUI.class);
        intent.putExtra("key_appbrand_init_config", appBrandInitConfig);
        intent.putExtra("key_appbrand_stat_object", appBrandStatObject);
        gVar.fcq.geJ = new 3(gVar, appBrandInitConfig);
        gVar.fcq.startActivityForResult(intent, fVP);
    }

    static void a(c cVar, String str, int i, String str2, a aVar, JSONObject jSONObject, JSONObject jSONObject2, b bVar) {
        p pVar;
        String ahc;
        String str3 = "MicroMsg.MiniProgramNavigator";
        String str4 = "navigateTo fromAppID(%s) targetAppID(%s) sourceType:%d";
        Object[] objArr = new Object[3];
        objArr[0] = cVar.getAppId();
        objArr[1] = str;
        objArr[2] = Integer.valueOf(aVar != null ? aVar.bJt : 0);
        x.i(str3, str4, objArr);
        str3 = "";
        if (cVar instanceof p) {
            pVar = (p) cVar;
        } else {
            n nVar = cVar.getRuntime().fcz;
            pVar = (nVar == null || nVar.getCurrentPage() == null) ? null : nVar.getCurrentPage().getCurrentPageView();
        }
        if (pVar != null) {
            ahc = pVar.ahc();
        } else {
            ahc = str3;
        }
        str4 = cVar.getAppId() + ":" + cVar.getRuntime().fct.fdE + ":" + (cVar.getRuntime().fct.bGM + 1000);
        AppBrandStatObject appBrandStatObject = cVar.getRuntime().fcE;
        AppBrandStatObject appBrandStatObject2 = new AppBrandStatObject();
        int i2 = (aVar == null || aVar.scene == 0) ? 1037 : aVar.scene;
        appBrandStatObject2.scene = i2;
        appBrandStatObject2.cbA = appBrandStatObject.cbA;
        if (aVar == null || aVar.scene == 0 || bi.oW(aVar.bGG)) {
            str3 = str4;
        } else {
            str3 = String.format("%s:%s", new Object[]{str4, aVar.bGG});
        }
        appBrandStatObject2.bGG = str3;
        appBrandStatObject2.cbB = aVar != null ? aVar.cbB : 0;
        appBrandStatObject2.cbC = aVar != null ? aVar.cbC : null;
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        appBrandLaunchReferrer.appId = cVar.getAppId();
        appBrandLaunchReferrer.fqF = jSONObject == null ? "{}" : jSONObject.toString();
        appBrandLaunchReferrer.fqG = jSONObject2 == null ? "{}" : jSONObject2.toString();
        appBrandLaunchReferrer.fqE = 1;
        appBrandLaunchReferrer.url = ahc;
        appBrandLaunchReferrer.bJt = aVar != null ? aVar.bJt : 0;
        appBrandLaunchReferrer.fqH = aVar != null ? aVar.fqH : null;
        k.qv(cVar.getAppId()).fdL = str;
        k.qv(cVar.getAppId()).fdM = str2;
        AppBrandPreInitTask appBrandPreInitTask = new AppBrandPreInitTask(str, i, appBrandStatObject2, new 1(bVar, str2, appBrandLaunchReferrer, cVar, str, i, appBrandStatObject2));
        if (com.tencent.mm.model.gdpr.c.Jm()) {
            com.tencent.mm.model.gdpr.c.a(cVar.getContext(), a.dEb, str, new 2(appBrandPreInitTask, cVar));
        } else {
            appBrandPreInitTask.akA();
        }
    }
}
