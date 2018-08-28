package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.text.TextUtils;
import com.tencent.mm.model.u$b;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.h.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class b extends a {
    public b(int i) {
        super(com.tencent.mm.plugin.appbrand.jsapi.b.b.NAME, i);
    }

    protected final void a(com.tencent.mm.u.c.a aVar, JSONObject jSONObject, com.tencent.mm.u.b.b.a<JSONObject> aVar2) {
        c.aZ(d.j(jSONObject), "before_jsapi_invoke");
        u$b Da = aVar.Da();
        String string = Da.getString("__page_view_id", null);
        String string2 = Da.getString("__process_name", ad.getProcessName());
        if (com.tencent.mm.plugin.appbrand.dynamic.d.aeQ().su(string) == null) {
            x.w("MicroMsg.JsApiFunc_DrawCanvas", "get view by viewId(%s) return null.", new Object[]{string});
            aVar2.aA(a(false, "got 'null' when get view by the given viewId", null));
            return;
        }
        long j;
        synchronized (Da) {
            long longValue;
            long currentTimeMillis = System.currentTimeMillis();
            CharSequence sF = sF("lastTime");
            if (!TextUtils.isEmpty(sF)) {
                Object obj = Da.dAZ.get(sF);
                if (obj instanceof Long) {
                    longValue = ((Long) obj).longValue();
                    j = currentTimeMillis - longValue;
                }
            }
            longValue = 0;
            j = currentTimeMillis - longValue;
        }
        a aVar3 = (a) Da.get(sF("DrawCanvasRunnable"), null);
        if (aVar3 == null) {
            aVar3 = new a((byte) 0);
            Da.p(sF("DrawCanvasRunnable"), aVar3);
        }
        aVar3.process = string2;
        aVar3.fvT = string;
        aVar3.fvU = jSONObject;
        aVar3.fvV = this;
        aVar3.fvW = aVar2;
        aVar3.fvX = Da;
        com.tencent.mm.plugin.appbrand.dynamic.b.aeO().removeCallbacks(aVar3);
        if (j < 16) {
            x.v("MicroMsg.JsApiFunc_DrawCanvas", "postDelayed(%s)", new Object[]{Long.valueOf(j)});
            com.tencent.mm.plugin.appbrand.dynamic.b.aeO().postDelayed(aVar3, j);
            return;
        }
        aVar3.run();
    }

    final String sF(String str) {
        return this.name + "#" + str;
    }
}
