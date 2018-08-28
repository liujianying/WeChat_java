package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements a {
    final /* synthetic */ a jhD;
    final /* synthetic */ a jhE;

    a$1(a aVar, a aVar2) {
        this.jhE = aVar;
        this.jhD = aVar2;
    }

    public final void onSuccess() {
        x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "sessionKey=%s, step=%d, desc=Connect ssid succeeded. ", new Object[]{m.E(this.jhE.activity.getIntent()), Integer.valueOf(m.F(this.jhE.activity.getIntent()))});
        this.jhD.onSuccess();
    }

    public final void pT(int i) {
        x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "sessionKey=%s, step=%d, desc=Connect ssid failed. errorcode=%d", new Object[]{m.E(this.jhE.activity.getIntent()), Integer.valueOf(m.F(this.jhE.activity.getIntent())), Integer.valueOf(i)});
        this.jhD.pT(i);
    }
}
