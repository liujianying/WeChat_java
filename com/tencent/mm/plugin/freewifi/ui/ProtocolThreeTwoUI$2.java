package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeTwoUI$2 implements Runnable {
    final /* synthetic */ ProtocolThreeTwoUI joB;

    ProtocolThreeTwoUI$2(ProtocolThreeTwoUI protocolThreeTwoUI) {
        this.joB = protocolThreeTwoUI;
    }

    public final void run() {
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[]{m.E(this.joB.getIntent()), Integer.valueOf(m.F(this.joB.getIntent())), this.joB.jkH, d.aOx(), d.aOz(), Integer.valueOf(d.aOy())});
        new a(this.joB.jkH, r2, r3, r4, this.joB.bxk, m.E(this.joB.getIntent())).b(new 1(this));
    }
}
