package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_INDEX = 57;
    public static final String NAME = "requestPayment";

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            cVar.E(i, f("fail", null));
            return;
        }
        MMActivity mMActivity = cVar.getRuntime().fcq;
        if (mMActivity == null) {
            cVar.E(i, f("fail", null));
            return;
        }
        try {
            jSONObject.put("appId", cVar.getAppId());
            PString pString = new PString();
            if (!a.fWH.a(mMActivity, cVar.getRuntime().fcE, jSONObject, new b.a() {
                public final void a(int i, String str, Map<String, Object> map) {
                    switch (i) {
                        case 1:
                            cVar.E(i, e.this.f("ok", null));
                            return;
                        case 2:
                            cVar.E(i, e.this.f("fail:" + str, null));
                            return;
                        case 3:
                            cVar.E(i, e.this.f("cancel", null));
                            return;
                        default:
                            return;
                    }
                }
            }, pString)) {
                cVar.E(i, f("fail", null));
            } else if (jSONObject.optBoolean("grantMessageQuota", true)) {
                p d = cVar instanceof p ? (p) cVar : a.d((l) cVar);
                String str = pString.value;
                if (d != null) {
                    ReportSubmitFormTask reportSubmitFormTask = new ReportSubmitFormTask(d.fdO.fcu);
                    reportSubmitFormTask.type = 0;
                    reportSubmitFormTask.fKK = str.replace("prepay_id=", "");
                    reportSubmitFormTask.bVs = d.getURL();
                    AppBrandMainProcessService.a(reportSubmitFormTask);
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.JsApiRequestPayment", e.getMessage());
            cVar.E(i, f("fail", null));
        }
    }
}
