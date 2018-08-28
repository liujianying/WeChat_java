package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker$a;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.e;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

class g$1 extends c {
    final /* synthetic */ g fXm;

    g$1(g gVar) {
        this.fXm = gVar;
    }

    static /* synthetic */ e a(g$1 g_1, Class cls) {
        a dq = super.dq(false);
        return (dq == null || !cls.isInstance(dq.getPicker())) ? null : dq.getPicker();
    }

    final void u(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("column", -1);
        JSONArray optJSONArray = jSONObject.optJSONArray("array");
        if (optInt < 0 || optJSONArray == null || optJSONArray.length() < 0) {
            h("fail:invalid data", null);
            return;
        }
        try {
            String[] strArr = new String[optJSONArray.length()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = optJSONArray.getString(i);
            }
            c.runOnUiThread(new 1(this, optInt, new AppBrandMultiOptionsPicker$a(strArr, jSONObject.optInt("current", 0))));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.JsApiUpdateMultiPickerView", e, "opt params", new Object[0]);
            h("fail:invalid data", null);
        }
    }
}
