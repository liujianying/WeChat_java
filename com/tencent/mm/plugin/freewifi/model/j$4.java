package com.tencent.mm.plugin.freewifi.model;

import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.e.1;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.x;

class j$4 implements a {
    final /* synthetic */ j jkt;

    j$4(j jVar) {
        this.jkt = jVar;
    }

    public final void a(d.a aVar) {
        e aOQ = j.aOQ();
        by byVar = aVar.dIN;
        if (1 != i.a.aNZ().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0)) {
            i.a.aNZ().bo("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 1);
        }
        if (byVar == null || byVar.rcl == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
            return;
        }
        String a = ab.a(byVar.rcl);
        x.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", Long.valueOf(byVar.rcq), a);
        if (m.isEmpty(a)) {
            x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
            return;
        }
        com.tencent.mm.plugin.freewifi.c.a BW = com.tencent.mm.plugin.freewifi.c.a.BW(a);
        if (BW == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
            return;
        }
        new com.tencent.mm.plugin.freewifi.d.d(m.BS("MicroMsg.FreeWifi.FreeWifiMessageService"), m.BT("MicroMsg.FreeWifi.FreeWifiMessageService"), m.BU("MicroMsg.FreeWifi.FreeWifiMessageService"), BW.jjx, BW.jju, BW.jjy, BW.ssid, BW.bssid).b(new 1(aOQ, byVar));
    }
}
