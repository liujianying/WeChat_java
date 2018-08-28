package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.i;
import com.tencent.mm.plugin.appbrand.jsapi.f.i.a;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class i$4 implements i {
    final /* synthetic */ p fIY;
    final /* synthetic */ int fKG;
    final /* synthetic */ i fSE;

    i$4(i iVar, int i, p pVar) {
        this.fSE = iVar;
        this.fKG = i;
        this.fIY = pVar;
    }

    public final void a(e eVar) {
        a aVar = new a((byte) 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mapId", this.fKG);
            jSONObject.put("data", eVar.data);
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[]{e});
        }
        h a = aVar.a(this.fIY);
        a.mData = jSONObject.toString();
        a.ahM();
    }
}
