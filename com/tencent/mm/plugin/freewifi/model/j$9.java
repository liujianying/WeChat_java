package com.tencent.mm.plugin.freewifi.model;

import android.net.wifi.ScanResult;
import com.tencent.mm.g.a.ok;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.h.a;
import com.tencent.mm.protocal.c.bij;
import com.tencent.mm.protocal.c.cr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

class j$9 extends c<ok> {
    final /* synthetic */ j jkt;

    j$9(j jVar) {
        this.jkt = jVar;
        this.sFo = ok.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ok okVar = (ok) bVar;
        int networkType = d.getNetworkType();
        if (!(networkType == 0 || networkType == -1)) {
            x.i("MicroMsg.FreeWifi.SubCoreFreeWifi", "networkType is " + networkType + ", start to scan and report near field wifi, to get a pushed message for connecting wifi.");
            final String str = okVar.bZm.userName;
            h.b.aOH().a(new a() {
                public final void bh(List<ScanResult> list) {
                    if (list != null && list.size() != 0) {
                        bij bij = new bij();
                        bij.siZ = new LinkedList();
                        for (ScanResult scanResult : list) {
                            if (scanResult != null) {
                                cr crVar = new cr();
                                crVar.mac = scanResult.BSSID;
                                crVar.rcO = scanResult.level;
                                crVar.ssid = scanResult.SSID;
                                bij.siZ.add(crVar);
                            }
                        }
                        String aOe = m.aOe();
                        k.a aOa = k.aOa();
                        aOa.jid = aOe;
                        aOa.jif = k.b.jix.jiQ;
                        aOa.jig = k.b.jix.name;
                        aOa.bVU = 8;
                        aOa.aOc().aOb();
                        new com.tencent.mm.plugin.freewifi.d.k(str, bij, 8, aOe).b(null);
                    }
                }
            });
        }
        return false;
    }
}
