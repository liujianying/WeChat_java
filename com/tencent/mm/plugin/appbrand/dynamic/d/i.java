package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.u.b.b;
import org.json.JSONObject;

public final class i extends a {
    public i() {
        super("openApp", 326);
    }

    protected final void a(com.tencent.mm.u.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        u.b Da = aVar.Da();
        b bVar = new b();
        bVar.id = Da.getString("__page_view_id", "");
        bVar.url = jSONObject.optString("url", "");
        XIPCInvoker.a(Da.getString("__process_name", ad.getProcessName()), bVar, a.class, new 1(this, aVar2));
    }
}
