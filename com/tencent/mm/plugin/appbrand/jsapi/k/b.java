package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 107;
    private static final String NAME = "showActionSheet";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        p d = e.d(lVar);
        if (d == null) {
            x.w("MicroMsg.JsApiShowActionSheet", "invoke JsApi JsApiShowActionSheet failed, current page view is null.");
            lVar.E(i, f("fail", null));
            return;
        }
        m.o(d);
        String optString = jSONObject.optString("itemList");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(optString);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < jSONArray.length()) {
                    arrayList.add((String) jSONArray.get(i3));
                    i2 = i3 + 1;
                } else {
                    ah.A(new 1(this, lVar, jSONObject, arrayList, i));
                    return;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.JsApiShowActionSheet", e.getMessage());
            lVar.E(i, f("fail", null));
        }
    }
}
