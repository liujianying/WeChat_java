package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeOneUI$8 implements Runnable {
    final /* synthetic */ ProtocolThreeOneUI jov;

    ProtocolThreeOneUI$8(ProtocolThreeOneUI protocolThreeOneUI) {
        this.jov = protocolThreeOneUI;
    }

    public final void run() {
        x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[]{m.E(this.jov.getIntent()), Integer.valueOf(m.F(this.jov.getIntent())), this.jov.jkH, d.aOx(), d.aOz(), Integer.valueOf(d.aOy())});
        new a(this.jov.jkH, r2, r3, r4, this.jov.bxk, m.E(this.jov.getIntent())).b(new 1(this));
    }
}
