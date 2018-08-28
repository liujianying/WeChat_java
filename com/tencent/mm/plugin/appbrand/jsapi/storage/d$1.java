package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.l;
import java.util.HashMap;
import java.util.Map;

class d$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JsApiGetStorageInfoTask fZp;
    final /* synthetic */ d fZq;

    d$1(d dVar, JsApiGetStorageInfoTask jsApiGetStorageInfoTask, l lVar, int i) {
        this.fZq = dVar;
        this.fZp = jsApiGetStorageInfoTask;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void run() {
        Map hashMap = new HashMap();
        hashMap.put("keys", this.fZp.fZr);
        hashMap.put("currentSize", Integer.valueOf(this.fZp.size));
        hashMap.put("limitSize", Integer.valueOf(this.fZp.limit));
        this.fCl.E(this.doP, this.fZq.f("ok", hashMap));
    }
}
