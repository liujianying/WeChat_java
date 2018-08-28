package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 431;
    public static final String NAME = "requestMallPayment";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        MMActivity c = c(lVar);
        if (c == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        try {
            jSONObject.put("appId", lVar.mAppId);
            jSONObject.put("pay_for_wallet_type", 3);
            PString pString = new PString();
            if (a.fWH.a(c, lVar.fdO.fcE, jSONObject, new 1(this, lVar, i), pString)) {
                p d = d(lVar);
                String str = pString.value;
                if (d != null) {
                    ReportSubmitFormTask reportSubmitFormTask = new ReportSubmitFormTask(d.fdO.fcu);
                    reportSubmitFormTask.type = 0;
                    reportSubmitFormTask.fKK = str.replace("prepay_id=", "");
                    reportSubmitFormTask.bVs = d.getURL();
                    AppBrandMainProcessService.a(reportSubmitFormTask);
                    return;
                }
                return;
            }
            lVar.E(i, f("fail", null));
        } catch (Exception e) {
            x.e("MicroMsg.JsApiRequestMallPayment", e.getMessage());
            lVar.E(i, f("fail", null));
        }
    }
}
