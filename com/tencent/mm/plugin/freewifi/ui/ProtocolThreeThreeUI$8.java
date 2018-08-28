package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeThreeUI$8 implements Runnable {
    final /* synthetic */ ProtocolThreeThreeUI joy;

    ProtocolThreeThreeUI$8(ProtocolThreeThreeUI protocolThreeThreeUI) {
        this.joy = protocolThreeThreeUI;
    }

    public final void run() {
        String aOx = d.aOx();
        String aOz = d.aOz();
        int aOy = d.aOy();
        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[]{m.E(this.joy.getIntent()), Integer.valueOf(m.F(this.joy.getIntent())), "", aOx, aOz, Integer.valueOf(aOy)});
        new f(this.joy.ssid, this.joy.bssid, this.joy.appId, this.joy.jkW, this.joy.jkX, this.joy.jkY, this.joy.bJT, this.joy.sign).b(new 1(this));
    }
}
