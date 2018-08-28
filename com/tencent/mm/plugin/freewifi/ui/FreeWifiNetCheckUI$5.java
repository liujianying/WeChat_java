package com.tencent.mm.plugin.freewifi.ui;

import android.net.wifi.ScanResult;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.h.a;
import com.tencent.mm.protocal.c.bij;
import com.tencent.mm.protocal.c.cr;
import java.util.LinkedList;
import java.util.List;

class FreeWifiNetCheckUI$5 implements a {
    final /* synthetic */ String jku;
    final /* synthetic */ FreeWifiNetCheckUI jnK;

    FreeWifiNetCheckUI$5(FreeWifiNetCheckUI freeWifiNetCheckUI, String str) {
        this.jnK = freeWifiNetCheckUI;
        this.jku = str;
    }

    public final void bh(List<ScanResult> list) {
        if (list == null || list.size() == 0) {
            this.jnK.finish();
            FreeWifiNetCheckUI.c(this.jnK);
            return;
        }
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
        k.a aOa = k.aOa();
        aOa.jid = m.E(FreeWifiNetCheckUI.b(this.jnK));
        aOa.jif = b.jix.jiQ;
        aOa.jig = b.jix.name;
        aOa.bVU = 9;
        aOa.aOc().aOb();
        new com.tencent.mm.plugin.freewifi.d.k(this.jku, bij, 9, m.E(this.jnK.getIntent())).b(new 1(this));
    }
}
