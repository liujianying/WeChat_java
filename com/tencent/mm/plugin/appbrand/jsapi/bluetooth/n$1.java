package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.j;
import com.tencent.mm.plugin.appbrand.l;
import java.util.HashMap;
import java.util.Map;

class n$1 implements b {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ n fLp;

    n$1(n nVar, l lVar, int i) {
        this.fLp = nVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void a(j jVar) {
        Map hashMap;
        switch (n$2.fLf[jVar.ordinal()]) {
            case 1:
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(0));
                this.fCl.E(this.doP, this.fLp.f("ok", hashMap));
                c.kB(42);
                return;
            default:
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(jVar.errCode));
                this.fCl.E(this.doP, this.fLp.f(jVar.Yy, hashMap));
                c.kB(43);
                return;
        }
    }
}
