package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.u.b.b;
import org.json.JSONObject;

public final class l extends a {
    public l(int i) {
        super("setWidgetSize", i);
    }

    protected final void a(com.tencent.mm.u.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        u.b Da = aVar.Da();
        com.tencent.mm.plugin.appbrand.dynamic.widget.a.a aVar3 = new com.tencent.mm.plugin.appbrand.dynamic.widget.a.a();
        aVar3.id = Da.getString("__page_view_id", "");
        aVar3.width = jSONObject.optInt("width", Da.getInt("__page_view_width", 0));
        aVar3.height = jSONObject.optInt("height", Da.getInt("__page_view_height", 0));
        XIPCInvoker.a(Da.getString("__process_name", ad.getProcessName()), aVar3, a.class, new 1(this, aVar2));
    }
}
