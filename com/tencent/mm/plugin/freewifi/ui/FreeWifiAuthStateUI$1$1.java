package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiAuthStateUI.1;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.sdk.platformtools.x;

class FreeWifiAuthStateUI$1$1 implements e {
    final /* synthetic */ 1 jmi;

    FreeWifiAuthStateUI$1$1(1 1) {
        this.jmi = 1;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.jmi.jmh.jma = false;
        if (i == 0 && i2 == 0) {
            a aVar = (a) lVar;
            x.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "authUrl : %s", new Object[]{aVar.aOS()});
            ep aOY = aVar.aOY();
            if (aOY != null) {
                x.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{aOY.rbW, aOY.hcS, aOY.hbL, Integer.valueOf(aOY.rfa), aOY.rfb, aOY.eJK});
                this.jmi.jmh.bPS = aOY.rbW;
                this.jmi.jmh.jkJ = aOY.hcS;
                this.jmi.jmh.bPg = aOY.hbL;
                this.jmi.jmh.jnW = aOY.rfa;
                this.jmi.jmh.jnX = aOY.rfb;
                this.jmi.jmh.signature = aOY.eJK;
                this.jmi.jmh.jnY = aOY.rfc;
            }
            j.aOP().a(this.jmi.jmh.ssid, r0, this.jmi.jmh.getIntent());
        } else if (i2 == -2014) {
            d.a(this.jmi.jmh.ssid, -2014, this.jmi.jmh.getIntent());
        } else {
            d.a(this.jmi.jmh.ssid, 3, this.jmi.jmh.getIntent());
        }
    }
}
