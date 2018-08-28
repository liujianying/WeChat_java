package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.j;
import com.tencent.mm.plugin.appbrand.l;
import java.util.HashMap;
import java.util.Map;

class q$1 implements b {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ q fLs;

    q$1(q qVar, l lVar, int i) {
        this.fLs = qVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void a(j jVar) {
        Map hashMap;
        switch (q$2.fLf[jVar.ordinal()]) {
            case 1:
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(0));
                this.fCl.E(this.doP, this.fLs.f("ok", hashMap));
                c.kB(58);
                return;
            default:
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(jVar.errCode));
                this.fCl.E(this.doP, this.fLs.f(jVar.Yy, hashMap));
                c.kB(58);
                return;
        }
    }
}
