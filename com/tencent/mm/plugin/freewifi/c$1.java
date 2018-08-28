package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.sdk.platformtools.x;

class c$1 implements c$a {
    final /* synthetic */ c$a jhH;
    final /* synthetic */ c jhI;

    public c$1(c cVar, c$a c_a) {
        this.jhI = cVar;
        this.jhH = c_a;
    }

    public final void onSuccess() {
        x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=Connect ssid succeeded. ", new Object[]{m.E(this.jhI.activity.getIntent()), Integer.valueOf(m.F(this.jhI.activity.getIntent()))});
        this.jhH.onSuccess();
    }

    public final void pT(int i) {
        x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=Connect ssid failed. errorcode=%d", new Object[]{m.E(this.jhI.activity.getIntent()), Integer.valueOf(m.F(this.jhI.activity.getIntent())), Integer.valueOf(i)});
        this.jhH.pT(i);
    }
}
