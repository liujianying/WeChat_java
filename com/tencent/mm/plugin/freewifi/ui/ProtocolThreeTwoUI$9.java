package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.a$a;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeTwoUI$9 implements a$a {
    final /* synthetic */ ProtocolThreeTwoUI joB;

    ProtocolThreeTwoUI$9(ProtocolThreeTwoUI protocolThreeTwoUI) {
        this.joB = protocolThreeTwoUI;
    }

    public final void onSuccess() {
        a aOa = k.aOa();
        aOa.ssid = this.joB.ssid;
        aOa.bssid = m.BT("MicroMsg.FreeWifi.Protocol32UI");
        aOa.bIR = m.BU("MicroMsg.FreeWifi.Protocol32UI");
        aOa.bIQ = ProtocolThreeTwoUI.e(this.joB);
        aOa.jic = this.joB.bPS;
        aOa.jid = m.E(ProtocolThreeTwoUI.d(this.joB));
        aOa.jie = m.G(ProtocolThreeTwoUI.d(this.joB));
        aOa.jif = b.jiq.jiQ;
        aOa.jig = b.jiq.name;
        aOa.result = 0;
        aOa.bVU = m.H(ProtocolThreeTwoUI.d(this.joB));
        aOa.jih = this.joB.bPg;
        aOa.aOc().aOb();
        String aNX = h.b.aNY().aNX();
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid succeeded and then tries to access blackUrl. ssid=%s, blackUrl = %s", new Object[]{m.E(this.joB.getIntent()), Integer.valueOf(m.F(this.joB.getIntent())), this.joB.ssid, aNX});
        1 1 = new 1(this, aNX);
        com.tencent.mm.plugin.freewifi.a.a.aOj();
        com.tencent.mm.plugin.freewifi.a.a.a(aNX, 1);
    }

    public final void pT(int i) {
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", new Object[]{m.E(this.joB.getIntent()), Integer.valueOf(m.F(this.joB.getIntent())), this.joB.ssid, Integer.valueOf(i)});
        d.a(this.joB.ssid, 3, this.joB.getIntent());
        a aOa = k.aOa();
        aOa.ssid = this.joB.ssid;
        aOa.bssid = m.BT("MicroMsg.FreeWifi.Protocol32UI");
        aOa.bIR = m.BU("MicroMsg.FreeWifi.Protocol32UI");
        aOa.bIQ = ProtocolThreeTwoUI.e(this.joB);
        aOa.jic = this.joB.bPS;
        aOa.jid = m.E(ProtocolThreeTwoUI.d(this.joB));
        aOa.jie = m.G(ProtocolThreeTwoUI.d(this.joB));
        aOa.jif = b.jiq.jiQ;
        aOa.jig = b.jiq.name;
        aOa.result = i;
        aOa.bVU = m.H(ProtocolThreeTwoUI.d(this.joB));
        aOa.jih = this.joB.bPg;
        aOa.aOc().aOb();
    }
}
