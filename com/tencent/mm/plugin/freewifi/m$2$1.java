package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.m.2;
import com.tencent.mm.sdk.platformtools.x;

class m$2$1 implements e {
    final /* synthetic */ 2 jiY;

    m$2$1(2 2) {
        this.jiY = 2;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i(this.jiY.jiT, "sessionKey=%s, step=%d, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.E(this.jiY.val$intent), Integer.valueOf(m.F(this.jiY.val$intent)), Integer.valueOf(i), Integer.valueOf(i2), str});
        a aOa = k.aOa();
        aOa.ssid = m.BS(this.jiY.jiT);
        aOa.bssid = m.BT(this.jiY.jiT);
        aOa.bIR = m.BU(this.jiY.jiT);
        aOa.bIQ = this.jiY.jiV;
        aOa.jid = m.E(this.jiY.val$intent);
        aOa.jie = m.G(this.jiY.val$intent);
        aOa.jif = k$b.GetBackPage33Return.jiQ;
        aOa.jig = k$b.GetBackPage33Return.name;
        aOa.bVU = m.H(this.jiY.val$intent);
        aOa.result = i2;
        aOa.hKX = str;
        aOa.aOc().b(this.jiY.val$intent, true).aOb();
        this.jiY.jiX.j(i, i2, str, lVar);
    }
}
