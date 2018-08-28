package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic.HCEMMToAppBrandMessageEvent;
import com.tencent.mm.sdk.platformtools.x;

class HCEEventLogic$a$1 implements a {
    HCEEventLogic$a$1() {
    }

    public final void bj(Object obj) {
        if (obj instanceof HCEMMToAppBrandMessageEvent) {
            HCEMMToAppBrandMessageEvent hCEMMToAppBrandMessageEvent = (HCEMMToAppBrandMessageEvent) obj;
            x.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic HCEMMToAppBrandMessageEvent onCustomDataNotify eventType: %d, appId: %s", Integer.valueOf(HCEMMToAppBrandMessageEvent.a(hCEMMToAppBrandMessageEvent)), HCEMMToAppBrandMessageEvent.b(hCEMMToAppBrandMessageEvent));
            switch (HCEMMToAppBrandMessageEvent.a(hCEMMToAppBrandMessageEvent)) {
                case 12:
                    if (HCEMMToAppBrandMessageEvent.c(hCEMMToAppBrandMessageEvent) != null) {
                        HCEEventLogic.l(HCEMMToAppBrandMessageEvent.b(hCEMMToAppBrandMessageEvent), HCEMMToAppBrandMessageEvent.c(hCEMMToAppBrandMessageEvent).getInt("errCode"), HCEMMToAppBrandMessageEvent.c(hCEMMToAppBrandMessageEvent).getString("errMsg"));
                        return;
                    }
                    return;
                case 31:
                case 41:
                    g pY = com.tencent.mm.plugin.appbrand.a.pY(HCEMMToAppBrandMessageEvent.b(hCEMMToAppBrandMessageEvent));
                    if (pY != null) {
                        a.a(pY.mAppId, HCEMMToAppBrandMessageEvent.a(hCEMMToAppBrandMessageEvent), HCEMMToAppBrandMessageEvent.c(hCEMMToAppBrandMessageEvent));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
