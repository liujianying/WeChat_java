package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.a;
import com.tencent.mm.plugin.appbrand.l;
import java.util.HashMap;
import java.util.Map;

class e$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ e fWD;

    e$1(e eVar, l lVar, int i) {
        this.fWD = eVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void M(int i, String str) {
        Map hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(i));
        if (i == 0) {
            e eVar = this.fWD;
            l lVar = this.fCl;
            int i2 = this.doP;
            HCEEventLogic.tU(lVar.mAppId);
            HCEEventLogic.a(null);
            HCEEventLogic.c(lVar.mAppId, 13, null);
            Map hashMap2 = new HashMap(2);
            hashMap2.put("errCode", Integer.valueOf(0));
            e.a(lVar, i2, eVar.f("ok", hashMap2));
            return;
        }
        e.a(this.fCl, this.doP, this.fWD.f("fail: " + str, hashMap));
    }
}
