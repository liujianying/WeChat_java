package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.j;
import com.tencent.mm.plugin.appbrand.l;
import java.util.HashMap;
import java.util.Map;

class l$1 implements b {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ l fLj;

    l$1(l lVar, l lVar2, int i) {
        this.fLj = lVar;
        this.fCl = lVar2;
        this.doP = i;
    }

    public final void a(j jVar) {
        Map hashMap;
        switch (l$3.fLf[jVar.ordinal()]) {
            case 1:
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(0));
                this.fCl.E(this.doP, this.fLj.f("ok", hashMap));
                c.kB(42);
                return;
            default:
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(jVar.errCode));
                this.fCl.E(this.doP, this.fLj.f(jVar.Yy, hashMap));
                c.kB(43);
                return;
        }
    }
}
