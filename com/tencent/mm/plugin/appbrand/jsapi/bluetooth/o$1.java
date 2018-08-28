package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.j;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class o$1 implements b {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ o fLq;

    o$1(o oVar, l lVar, int i) {
        this.fLq = oVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void a(j jVar) {
        x.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "[onScanResult]result:%s", new Object[]{jVar});
        Map hashMap;
        switch (o$3.fLf[jVar.ordinal()]) {
            case 1:
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(0));
                hashMap.put("isDiscovering", Boolean.valueOf(true));
                this.fCl.E(this.doP, this.fLq.f("ok", hashMap));
                c.kB(12);
                return;
            default:
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(jVar.errCode));
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                this.fCl.E(this.doP, this.fLq.f(jVar.Yy, hashMap));
                c.kB(13);
                return;
        }
    }
}
