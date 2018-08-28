package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.u.b.b;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import org.json.JSONObject;

public final class h extends a {
    public h() {
        super("onTapCallback", TbsListener$ErrorCode.TEST_THROWABLE_ISNOT_NULL);
    }

    protected final void a(com.tencent.mm.u.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        u.b Da = aVar.Da();
        b bVar = new b();
        bVar.id = Da.getString("__page_view_id", "");
        bVar.cca = jSONObject.optString("eventId", "");
        bVar.fwf = jSONObject.optBoolean("hasHandler");
        bVar.fwg = jSONObject.optBoolean("res");
        XIPCInvoker.a(Da.getString("__process_name", ad.getProcessName()), bVar, a.class, new 1(this, aVar2));
    }
}
