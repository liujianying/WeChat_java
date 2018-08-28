package com.tencent.mm.plugin.appbrand.report.a;

import android.content.Intent;
import android.util.Pair;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class e {
    public static void a(g gVar, JSONObject jSONObject) {
        try {
            b(gVar, jSONObject);
            jSONObject.put("referpagepath", a.d(gVar.fct.fqA));
            jSONObject.put("clickTimestamp", bi.VF());
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillWxConfigLaunchInfo ex = %s", new Object[]{e});
        }
    }

    public static void b(g gVar, JSONObject jSONObject) {
        jSONObject.put("scene_note", gVar.fcE.bGG);
        jSONObject.put("sessionId", gVar.fct.fdE);
        jSONObject.put("usedState", gVar.fcE.gqK);
        jSONObject.put("prescene", gVar.fcE.cbB);
        jSONObject.put("prescene_note", gVar.fcE.cbC);
    }

    public static Pair<Integer, String> h(p pVar) {
        Object obj;
        int i = 1;
        switch (1.fjK[com.tencent.mm.plugin.appbrand.e.qn(pVar.mAppId).ordinal()]) {
            case 1:
                i = pVar.gnC.iD() ? 4 : 3;
                obj = null;
                break;
            case 2:
                if (pVar.gnC.iD()) {
                    i = 5;
                }
                obj = null;
                break;
            case 3:
                i = 6;
                obj = null;
                break;
            case 4:
                i = 9;
                String obj2 = k.qu(pVar.mAppId).fdL + ":" + com.tencent.mm.compatible.util.p.encode(bi.oV(k.qu(pVar.mAppId).fdM));
                break;
            default:
                Intent intent = pVar.fdO.fcz.getReporter().gqU;
                if (intent == null) {
                    i = 7;
                    obj2 = null;
                    break;
                }
                String str;
                if (intent.getComponent() == null) {
                    x.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "onBackground, intent %s, get null cmp name", new Object[]{intent});
                    str = "";
                } else {
                    str = intent.getComponent().getClassName();
                }
                if (!str.contains("WebViewUI")) {
                    obj2 = bi.aG(intent.getStringExtra("appbrand_report_key_target_activity"), str);
                    i = 8;
                    break;
                }
                i = 10;
                obj2 = intent.getStringExtra("appbrand_report_key_target_url");
                break;
        }
        return Pair.create(Integer.valueOf(i), obj2);
    }
}
