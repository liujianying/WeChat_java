package com.tencent.mm.plugin.freewifi;

import android.content.Intent;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;

class m$2 implements Runnable {
    final /* synthetic */ String jiT;
    final /* synthetic */ String jiV;
    final /* synthetic */ int jiW;
    final /* synthetic */ a jiX;
    final /* synthetic */ int jij;
    final /* synthetic */ Intent val$intent;

    m$2(String str, String str2, Intent intent, int i, int i2, a aVar) {
        this.jiT = str;
        this.jiV = str2;
        this.val$intent = intent;
        this.jij = i;
        this.jiW = i2;
        this.jiX = aVar;
    }

    public final void run() {
        k.a aOa = k.aOa();
        aOa.ssid = m.BS(this.jiT);
        aOa.bssid = m.BT(this.jiT);
        aOa.bIR = m.BU(this.jiT);
        aOa.bIQ = this.jiV;
        aOa.jid = m.E(this.val$intent);
        aOa.jie = this.jij;
        aOa.jif = b.jir.jiQ;
        aOa.jig = b.jir.name;
        aOa.bVU = m.H(this.val$intent);
        aOa.result = 0;
        aOa.aOc().aOb();
        String BT = m.BT(this.jiT);
        String BS = m.BS(this.jiT);
        int aOy = d.aOy();
        x.i(this.jiT, "NetStatusUtil.getNetType(MMApplicationContext.getContext()) = " + ao.getNetType(ad.getContext()));
        x.i(this.jiT, "sessionKey=%s, step=%d, method=getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[]{m.E(this.val$intent), Integer.valueOf(m.F(this.val$intent)), this.jiV, BT, BS, Integer.valueOf(aOy)});
        new com.tencent.mm.plugin.freewifi.d.a(this.jiV, BT, BS, aOy, this.jiW, m.E(this.val$intent)).b(new 1(this));
    }
}
