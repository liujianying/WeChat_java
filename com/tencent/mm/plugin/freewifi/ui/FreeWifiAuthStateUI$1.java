package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class FreeWifiAuthStateUI$1 implements b {
    final /* synthetic */ FreeWifiAuthStateUI jmh;

    FreeWifiAuthStateUI$1(FreeWifiAuthStateUI freeWifiAuthStateUI) {
        this.jmh = freeWifiAuthStateUI;
    }

    public final void bp(String str, int i) {
        x.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", new Object[]{str, this.jmh.jkH, d.aOx()});
        if (!bi.oW(str)) {
            String str2 = str;
            new a(this.jmh.jkH, this.jmh.ssid, r3, this.jmh.jlY, str2, "", i, m.E(this.jmh.getIntent())).b(new 1(this));
        }
    }
}
