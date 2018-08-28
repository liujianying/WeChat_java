package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.a;
import com.tencent.mm.plugin.nfc.b.c;
import java.util.HashMap;
import java.util.Map;

class d$1 implements a {
    final /* synthetic */ d fWC;

    d$1(d dVar) {
        this.fWC = dVar;
    }

    public final void M(int i, String str) {
        Map hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(i));
        if (i == 0) {
            d dVar = this.fWC;
            dVar.fcq = d.c(dVar.fcy);
            if (dVar.fcq == null) {
                dVar.tp(dVar.f("fail: unknown error", null));
                return;
            }
            Intent intent = new Intent();
            dVar.fcq.geJ = new d$2(dVar);
            d.b(dVar.fcq, "nfc", "com.tencent.mm.plugin.hce.ui.HCETransparentUI", intent, 1);
            return;
        }
        c.aa(this.fWC.fcy.mAppId, i, -1);
        this.fWC.tp(this.fWC.f("fail: " + str, hashMap));
    }
}
