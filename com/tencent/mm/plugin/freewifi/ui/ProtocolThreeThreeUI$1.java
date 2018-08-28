package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeThreeUI$1 implements a {
    final /* synthetic */ ProtocolThreeThreeUI joy;

    ProtocolThreeThreeUI$1(ProtocolThreeThreeUI protocolThreeThreeUI) {
        this.joy = protocolThreeThreeUI;
    }

    public final boolean vD() {
        if (!bi.oW(this.joy.ssid)) {
            ProtocolThreeThreeUI.a(this.joy, this.joy.aPq());
            if (ProtocolThreeThreeUI.a(this.joy) != 2) {
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[]{m.E(this.joy.getIntent()), Integer.valueOf(m.F(this.joy.getIntent())), d.pZ(ProtocolThreeThreeUI.a(this.joy))});
                d.a(this.joy.ssid, 3, this.joy.getIntent());
            }
        }
        return false;
    }
}
