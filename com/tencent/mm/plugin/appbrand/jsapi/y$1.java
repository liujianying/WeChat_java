package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class y$1 implements Runnable {
    final /* synthetic */ int bpX;
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JsApiGetAppConfigTask fFN;
    final /* synthetic */ y fFO;

    y$1(y yVar, int i, JsApiGetAppConfigTask jsApiGetAppConfigTask, l lVar, int i2) {
        this.fFO = yVar;
        this.bpX = i;
        this.fFN = jsApiGetAppConfigTask;
        this.fCl = lVar;
        this.doP = i2;
    }

    public final void run() {
        Map hashMap = new HashMap();
        hashMap.put("type", this.bpX);
        hashMap.put("data", this.fFN.value);
        x.i("MicroMsg.JsApiGetAppConfig", "getAppConfig type:%d,data:\n%s", new Object[]{Integer.valueOf(this.bpX), this.fFN.value});
        if (bi.oW(this.fFN.value)) {
            this.fCl.E(this.doP, this.fFO.f("fail", null));
        } else {
            this.fCl.E(this.doP, this.fFO.f("ok", hashMap));
        }
        this.fFN.ahB();
    }
}
