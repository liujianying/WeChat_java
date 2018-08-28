package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.nfc.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

class d$4 extends TimerTask {
    final /* synthetic */ d fWC;

    d$4(d dVar) {
        this.fWC = dVar;
    }

    public final void run() {
        boolean z;
        d dVar = this.fWC;
        synchronized (dVar.mLock) {
            z = dVar.fWB;
            if (!z) {
                dVar.fWB = true;
            }
        }
        if (z) {
            x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has finished, return");
            return;
        }
        x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCEService overtime, expect time limit: %d seconds", new Object[]{Integer.valueOf(10)});
        HCEEventLogic.a(null);
        if (dVar.fcy != null) {
            c.aa(dVar.fcy.mAppId, 13007, -2);
        }
        Map hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(13007));
        dVar.tp(dVar.f("fail: start HCEService failed", hashMap));
    }
}
