package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.de;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class e$19 extends c<de> {
    final /* synthetic */ e iup;

    e$19(e eVar) {
        this.iup = eVar;
        this.sFo = de.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        de deVar = (de) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceGetCurrentSSIDEvent: opCode = %b", new Object[]{Boolean.valueOf(deVar.bKM.bKD)});
        if (deVar.bKM.bKD) {
            String ssid = ao.getWifiInfo(ad.getContext()).getSSID();
            if (!bi.oW(ssid)) {
                deVar.bKN.bKE = true;
                deVar.bKN.bKO = ssid.replaceAll("\"", "");
                return true;
            }
        }
        deVar.bKN.bKE = false;
        deVar.bKN.bKO = null;
        return true;
    }
}
