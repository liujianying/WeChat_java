package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class i$1 extends b {
    final /* synthetic */ String bAj;
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ i fIF;

    i$1(i iVar, String str, l lVar, int i) {
        this.fIF = iVar;
        this.bAj = str;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void a(c cVar) {
        x.i("MicroMsg.Record.JsApiOperateRecorder", "onPause, appId:%s", new Object[]{this.bAj});
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operationType", "pause");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e, "", new Object[0]);
        }
        if (i.a(this.fIF) == null) {
            i.a(this.fIF, new i.b(this.fIF, this.fCl, this.doP));
        }
        i.a(this.fIF).fII = jSONObject.toString();
        i.a(this.fIF).appId = this.bAj;
        i.a(this.fIF).action = -1;
        i.a(this.fIF).ahT();
    }

    public final void onDestroy() {
        x.i("MicroMsg.Record.JsApiOperateRecorder", "onDestroy, appId:%s", new Object[]{this.bAj});
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operationType", "stop");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e, "", new Object[0]);
        }
        if (i.a(this.fIF) == null) {
            i.a(this.fIF, new i.b(this.fIF, this.fCl, this.doP));
        }
        i.a(this.fIF).fII = jSONObject.toString();
        i.a(this.fIF).appId = this.bAj;
        i.a(this.fIF).action = -1;
        i.a(this.fIF).ahU();
        e.b(this.bAj, this);
        i.ahY().remove(this.bAj);
    }
}
