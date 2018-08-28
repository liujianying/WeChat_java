package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

class i$3 implements Runnable {
    final /* synthetic */ i jlb;

    i$3(i iVar) {
        this.jlb = iVar;
    }

    public final void run() {
        a aOa = k.aOa();
        aOa.ssid = this.jlb.ssid;
        aOa.bssid = m.BT("MicroMsg.FreeWifi.Protocol33");
        aOa.bIR = m.BU("MicroMsg.FreeWifi.Protocol33");
        aOa.bIQ = this.jlb.bIQ;
        aOa.jid = m.E(this.jlb.intent);
        aOa.jie = this.jlb.jkI;
        aOa.jif = b.jit.jiQ;
        aOa.jig = b.jit.name;
        aOa.bVU = m.H(this.jlb.intent);
        aOa.result = 0;
        aOa.aOc().aOb();
        String aOx = d.aOx();
        String aOz = d.aOz();
        int aOy = d.aOy();
        x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[]{m.E(this.jlb.intent), Integer.valueOf(m.F(this.jlb.intent)), "", aOx, aOz, Integer.valueOf(aOy)});
        new f(this.jlb.ssid, m.BT("MicroMsg.FreeWifi.Protocol33"), this.jlb.appId, this.jlb.jkW, this.jlb.jkX, this.jlb.jkY, this.jlb.bJT, this.jlb.sign).b(new 1(this));
    }
}
