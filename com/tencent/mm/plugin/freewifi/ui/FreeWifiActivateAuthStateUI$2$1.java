package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateAuthStateUI.2;
import com.tencent.mm.sdk.platformtools.x;

class FreeWifiActivateAuthStateUI$2$1 implements e {
    final /* synthetic */ 2 jlQ;

    FreeWifiActivateAuthStateUI$2$1(2 2) {
        this.jlQ = 2;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.jlQ.jlP.jma = false;
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "authUrl : %s", new Object[]{((a) lVar).aOS()});
            j.aOP().a(this.jlQ.jlP.ssid, r0, this.jlQ.jlP.getIntent());
        } else if (i2 == -2014) {
            d.a(this.jlQ.jlP.ssid, -2014, this.jlQ.jlP.getIntent());
        } else {
            d.a(this.jlQ.jlP.ssid, 3, this.jlQ.jlP.getIntent());
        }
    }
}
