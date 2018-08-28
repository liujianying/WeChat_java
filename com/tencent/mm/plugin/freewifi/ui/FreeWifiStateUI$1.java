package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class FreeWifiStateUI$1 implements a {
    final /* synthetic */ FreeWifiStateUI jnZ;

    FreeWifiStateUI$1(FreeWifiStateUI freeWifiStateUI) {
        this.jnZ = freeWifiStateUI;
    }

    public final boolean vD() {
        if (!bi.oW(this.jnZ.ssid)) {
            FreeWifiStateUI.a(this.jnZ, this.jnZ.aPq());
            x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[]{this.jnZ.ssid, Integer.valueOf(FreeWifiStateUI.a(this.jnZ))});
            FreeWifiStateUI.b(this.jnZ).SO();
            k.a aOa = k.aOa();
            aOa.ssid = this.jnZ.ssid;
            aOa.bIQ = this.jnZ.bIQ;
            aOa.jid = m.E(this.jnZ.getIntent());
            aOa.jie = m.G(this.jnZ.getIntent());
            aOa.jif = b.jiq.jiQ;
            aOa.jig = b.jiq.name;
            aOa.result = -16;
            aOa.bVU = m.H(this.jnZ.getIntent());
            aOa.jic = this.jnZ.bPS;
            aOa.jih = this.jnZ.bPg;
            aOa.aOc().aOb();
            if (FreeWifiStateUI.a(this.jnZ) != 2) {
                this.jnZ.aPu();
                this.jnZ.aPs();
                d.a(this.jnZ.ssid, 3, this.jnZ.getIntent());
            }
        }
        return false;
    }
}
