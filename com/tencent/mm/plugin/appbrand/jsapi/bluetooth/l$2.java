package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.j;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

class l$2 implements b {
    final /* synthetic */ String bAj;
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ l fLj;

    l$2(l lVar, String str, l lVar2, int i) {
        this.fLj = lVar;
        this.bAj = str;
        this.fCl = lVar2;
        this.doP = i;
    }

    public final void a(j jVar) {
        x.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged result:%s", new Object[]{this.bAj, jVar});
        switch (l$3.fLf[jVar.ordinal()]) {
            case 1:
                new HashMap().put("errCode", Integer.valueOf(0));
                this.fCl.E(this.doP, this.fLj.f("ok", null));
                c.kB(42);
                return;
            default:
                new HashMap().put("errCode", Integer.valueOf(jVar.errCode));
                this.fCl.E(this.doP, this.fLj.f(jVar.Yy, null));
                c.kB(43);
                return;
        }
    }
}
