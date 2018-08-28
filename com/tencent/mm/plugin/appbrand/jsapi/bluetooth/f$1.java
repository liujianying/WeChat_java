package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.f.2;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class f$1 implements b {
    final /* synthetic */ String bAj;
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ f fLg;

    f$1(f fVar, String str, l lVar, int i) {
        this.fLg = fVar;
        this.bAj = str;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void a(j jVar) {
        x.i("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection result:%s", new Object[]{this.bAj, jVar});
        Map hashMap;
        switch (2.fLf[jVar.ordinal()]) {
            case 1:
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(0));
                this.fCl.E(this.doP, this.fLg.f("ok", hashMap));
                c.kB(26);
                return;
            default:
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(jVar.errCode));
                this.fCl.E(this.doP, this.fLg.f(jVar.Yy, hashMap));
                c.kB(27);
                return;
        }
    }
}
