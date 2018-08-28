package com.tencent.mm.plugin.freewifi.model;

import com.tencent.mm.g.a.bh;
import com.tencent.mm.g.a.bh.a;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

class j$8 extends c<bh> {
    final /* synthetic */ j jkt;

    j$8(j jVar) {
        this.jkt = jVar;
        this.sFo = bh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bh bhVar = (bh) bVar;
        x.d("MicroMsg.FreeWifi.SubCoreFreeWifi", "receive CheckWechatFreeWifiEvent");
        if (d.getNetworkType() != 0) {
            x.d("MicroMsg.FreeWifi.SubCoreFreeWifi", "not wifi");
        } else {
            j.aOJ();
            bhVar.bIN.bIP = h.b.aNY().aNW();
            bhVar.bIN.bIO = h.b.aNY().aNV();
            String aOz = d.aOz();
            String aOx = d.aOx();
            if (!(bi.oW(aOz) || bi.oW(aOx))) {
                com.tencent.mm.plugin.freewifi.g.c Cg = j.aOK().Cg(aOz);
                if (Cg != null) {
                    bhVar.bIN.bIQ = Cg.field_url;
                }
                bhVar.bIN.ssid = aOz;
                bhVar.bIN.bssid = m.BT("MicroMsg.FreeWifi.FreeWifiManager");
                bhVar.bIN.bIR = m.BU("MicroMsg.FreeWifi.FreeWifiManager");
                if (Cg != null && aOz.equalsIgnoreCase(Cg.field_ssid) && aOx.equalsIgnoreCase(Cg.field_mac)) {
                    a aVar = bhVar.bIN;
                    if (Cg == null) {
                        x.e("MicroMsg.FreeWifi.FreeWifiManager", "filterLang, freewifi info is null");
                        aOz = null;
                    } else {
                        aOz = w.chP();
                        aOz = aOz.equals("zh_CN") ? Cg.field_showWordCn : (aOz.equals("zh_TW") || aOz.equals("zh_HK")) ? Cg.field_showWordTw : Cg.field_showWordEn;
                    }
                    aVar.bIS = aOz;
                    if (!(m.isEmpty(bhVar.bIN.bIS) || i$a.jhY.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 0) == 1)) {
                        i$a.jhY.bo("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 1);
                    }
                    if (Cg.field_expiredTime - bi.VE() < 0) {
                        j.aOP().aOs();
                    }
                }
            }
        }
        return false;
    }
}
