package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class b$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ b fWw;

    b$1(b bVar, l lVar, int i) {
        this.fWw = bVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void M(int i, String str) {
        x.i("MicroMsg.JsApiGetHCEState", "alvinluo checkIsSupport onResult errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        Map hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(i));
        if (i == 0) {
            this.fCl.E(this.doP, this.fWw.f("ok", hashMap));
        } else {
            this.fCl.E(this.doP, this.fWw.f("fail " + str, hashMap));
        }
    }
}
