package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeOneUI$1 implements a {
    final /* synthetic */ ProtocolThreeOneUI jov;

    ProtocolThreeOneUI$1(ProtocolThreeOneUI protocolThreeOneUI) {
        this.jov = protocolThreeOneUI;
    }

    public final boolean vD() {
        if (!bi.oW(this.jov.ssid)) {
            ProtocolThreeOneUI.a(this.jov, this.jov.aPq());
            if (ProtocolThreeOneUI.a(this.jov) != 2) {
                ProtocolThreeOneUI.b(this.jov);
                x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[]{m.E(this.jov.getIntent()), Integer.valueOf(m.F(this.jov.getIntent())), d.pZ(ProtocolThreeOneUI.a(this.jov))});
                d.a(this.jov.ssid, 3, this.jov.getIntent());
                ProtocolThreeOneUI.a(this.jov, 31, "AUTH_TIMEOUT");
            }
        }
        return false;
    }
}
