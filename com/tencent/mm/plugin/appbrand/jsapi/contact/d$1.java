package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class d$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ p fJO;
    final /* synthetic */ JsApiGetContactMessageCountTask fPB;
    final /* synthetic */ d fPC;

    d$1(d dVar, JsApiGetContactMessageCountTask jsApiGetContactMessageCountTask, p pVar, int i) {
        this.fPC = dVar;
        this.fPB = jsApiGetContactMessageCountTask;
        this.fJO = pVar;
        this.doP = i;
    }

    public final void run() {
        Map hashMap = new HashMap();
        hashMap.put("count", this.fPB.bGz);
        x.i("MicroMsg.JsApiGetAppConfig", "JsApiGetContactMessageCountTask unreadCount:%d", new Object[]{Integer.valueOf(this.fPB.bGz)});
        if (this.fPB.bGz == -1) {
            this.fJO.E(this.doP, this.fPC.f("fail", null));
        } else {
            this.fJO.E(this.doP, this.fPC.f("ok", hashMap));
        }
        this.fPB.ahB();
    }
}
