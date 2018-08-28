package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public class c extends a {
    public static final int CTRL_INDEX = 63;
    public static final String NAME = "reportKeyValue";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        if (lVar.fdO.fcu == null) {
            x.e("MicroMsg.JsApiReportKeyValue", "config is Null!");
            lVar.E(i, f("fail", null));
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                int optInt = jSONObject2.optInt("key");
                String optString = jSONObject2.optString("value");
                if (optInt > 0 && !bi.oW(optString)) {
                    h.mEJ.h(optInt, new Object[]{lVar.mAppId, Integer.valueOf(r4.frm.fii), Integer.valueOf(r4.frm.fih + 1), optString});
                }
            } catch (Exception e) {
                x.e("MicroMsg.JsApiReportKeyValue", "AppBrandService parse report value failed : %s", new Object[]{e.getMessage()});
            }
        }
        lVar.E(i, f("ok", null));
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            pVar.E(i, f("fail", null));
            return;
        }
        if (pVar.fdO.fcu == null) {
            x.e("MicroMsg.JsApiReportKeyValue", "config is Null!");
            pVar.E(i, f("fail", null));
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                int optInt = jSONObject2.optInt("key");
                String optString = jSONObject2.optString("value");
                if (optInt > 0 && !bi.oW(optString)) {
                    h.mEJ.h(optInt, new Object[]{pVar.mAppId, Integer.valueOf(r4.frm.fii), Integer.valueOf(r4.frm.fih + 1), optString});
                }
            } catch (Exception e) {
                x.e("MicroMsg.JsApiReportKeyValue", "AppBrandPageView parse report value failed : %s", new Object[]{e.getMessage()});
            }
        }
        pVar.E(i, f("ok", null));
    }
}
