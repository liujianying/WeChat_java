package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class c$1 implements Runnable {
    final /* synthetic */ long cXh;
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JsApiGetStorageTask fZn;
    final /* synthetic */ c fZo;

    c$1(c cVar, JsApiGetStorageTask jsApiGetStorageTask, l lVar, int i, long j) {
        this.fZo = cVar;
        this.fZn = jsApiGetStorageTask;
        this.fCl = lVar;
        this.doP = i;
        this.cXh = j;
    }

    public final void run() {
        String str = this.fZn.value == null ? "fail" : "ok";
        Map hashMap = new HashMap();
        hashMap.put("data", this.fZn.value == null ? "" : this.fZn.value);
        hashMap.put("dataType", this.fZn.type == null ? "" : this.fZn.type);
        this.fCl.E(this.doP, this.fZo.f(str, hashMap));
        this.fZn.ahB();
        x.i("MicroMsg.JsApiGetStorage", "getStorage: %s, time: %d", new Object[]{this.fZn.aAL, Long.valueOf(System.currentTimeMillis() - this.cXh)});
    }
}
