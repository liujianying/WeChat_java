package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class FreeWifiActivateAuthStateUI$2 implements b {
    final /* synthetic */ FreeWifiActivateAuthStateUI jlP;

    FreeWifiActivateAuthStateUI$2(FreeWifiActivateAuthStateUI freeWifiActivateAuthStateUI) {
        this.jlP = freeWifiActivateAuthStateUI;
    }

    public final void bp(String str, int i) {
        x.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", new Object[]{str, this.jlP.jkH, d.aOx()});
        if (!bi.oW(str)) {
            String str2 = str;
            new a(this.jlP.jkH, this.jlP.ssid, r3, this.jlP.jlY, str2, "", i, m.E(this.jlP.getIntent())).b(new 1(this));
        }
    }
}
