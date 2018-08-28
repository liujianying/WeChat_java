package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.c.a;
import com.tencent.mm.plugin.freewifi.e.f.1;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.x;

class f$1$1 implements a {
    final /* synthetic */ 1 jkM;

    f$1$1(1 1) {
        this.jkM = 1;
    }

    public final void onSuccess() {
        x.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", new Object[]{m.E(this.jkM.jkL.intent), Integer.valueOf(m.F(this.jkM.jkL.intent))});
        k.a aOa = k.aOa();
        aOa.ssid = this.jkM.jkL.ssid;
        aOa.bssid = m.BT("MicroMsg.FreeWifi.ProtocolFour");
        aOa.bIR = m.BU("MicroMsg.FreeWifi.ProtocolFour");
        aOa.bIQ = this.jkM.jkL.bIQ;
        aOa.jic = this.jkM.jkL.appId;
        aOa.jid = m.E(this.jkM.jkL.intent);
        aOa.jie = m.G(this.jkM.jkL.intent);
        aOa.jif = b.jiq.jiQ;
        aOa.jig = b.jiq.name;
        aOa.result = 0;
        aOa.bVU = m.H(this.jkM.jkL.intent);
        aOa.aOc().aOb();
        m.a(this.jkM.jkL.intent, this.jkM.jkL.bIQ, this.jkM.jkL.jkI, this.jkM.jkL.bxk, this.jkM.jkL.jkG, "MicroMsg.FreeWifi.ProtocolFour");
    }

    public final void pT(int i) {
        x.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", new Object[]{m.E(this.jkM.jkL.intent), Integer.valueOf(m.F(this.jkM.jkL.intent)), this.jkM.jkL.ssid, Integer.valueOf(i)});
        k.a aOa = k.aOa();
        aOa.ssid = this.jkM.jkL.ssid;
        aOa.bssid = m.BT("MicroMsg.FreeWifi.ProtocolFour");
        aOa.bIR = m.BU("MicroMsg.FreeWifi.ProtocolFour");
        aOa.bIQ = this.jkM.jkL.bIQ;
        aOa.jic = this.jkM.jkL.appId;
        aOa.jid = m.E(this.jkM.jkL.intent);
        aOa.jie = m.G(this.jkM.jkL.intent);
        aOa.jif = b.jiq.jiQ;
        aOa.jig = b.jiq.name;
        aOa.result = i;
        aOa.bVU = m.H(this.jkM.jkL.intent);
        aOa.aOc().aOb();
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        FreeWifiFrontPageUI.a aVar;
        if (i == -16) {
            this.jkM.jkL.intent.setClass(this.jkM.jkL.jkG.mController.tml, FreeWifiCopyPwdUI.class);
            this.jkM.jkL.jkG.finish();
            this.jkM.jkL.jkG.startActivity(this.jkM.jkL.intent);
        } else if (i == -14 || i == -18) {
            freeWifiFrontPageUI = this.jkM.jkL.jkG;
            dVar = d.jnj;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.glH = R.l.free_wifi_connect_fail_tips_wrong_password;
            aVar.jmI = m.a(this.jkM.jkL.jkI, b.jiq, i);
            freeWifiFrontPageUI.a(dVar, aVar);
        } else {
            freeWifiFrontPageUI = this.jkM.jkL.jkG;
            dVar = d.jnj;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.glH = R.l.free_wifi_connect_fail_tips;
            aVar.jmI = m.a(this.jkM.jkL.jkI, b.jiq, i);
            freeWifiFrontPageUI.a(dVar, aVar);
        }
    }
}
