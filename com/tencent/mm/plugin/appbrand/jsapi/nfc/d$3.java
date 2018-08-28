package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic.b;
import com.tencent.mm.plugin.nfc.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class d$3 implements b {
    final /* synthetic */ d fWC;

    d$3(d dVar) {
        this.fWC = dVar;
    }

    public final void m(String str, int i, String str2) {
        boolean z;
        d dVar = this.fWC;
        synchronized (dVar.mLock) {
            z = dVar.fWB;
            if (!z) {
                dVar.fWB = true;
            }
        }
        if (z) {
            x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEFinish has finished, return");
            return;
        }
        Map hashMap = new HashMap();
        int currentTimeMillis = (int) (System.currentTimeMillis() - dVar.mStartTime);
        if (dVar.bno != null) {
            x.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE timer cancel");
            dVar.bno.cancel();
        }
        if (str == null || str.equals(dVar.fcy.mAppId)) {
            x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo HCE start HCEService callback onRefreshed errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str2});
            if (i == 0) {
                HCEEventLogic.tT(dVar.fcy.mAppId);
                hashMap.put("errCode", Integer.valueOf(0));
                dVar.tp(dVar.f("ok", hashMap));
            } else {
                hashMap.put("errCode", Integer.valueOf(i));
                dVar.tp(dVar.f("fail: " + str2, hashMap));
            }
            c.aa(dVar.fcy.mAppId, i, currentTimeMillis);
            HCEEventLogic.a(null);
            return;
        }
        x.e("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCESevice callback appId invalid, appId: %s", new Object[]{str});
        hashMap.put("errCode", Integer.valueOf(13010));
        c.aa(dVar.fcy.mAppId, 13010, currentTimeMillis);
        dVar.tp(dVar.f("fail: unknown error", hashMap));
        HCEEventLogic.a(null);
    }
}
