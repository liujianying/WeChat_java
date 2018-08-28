package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.sdk.platformtools.x;

class FreewifiWeChatNoAuthStateUI$1 implements e {
    final /* synthetic */ FreewifiWeChatNoAuthStateUI jot;

    FreewifiWeChatNoAuthStateUI$1(FreewifiWeChatNoAuthStateUI freewifiWeChatNoAuthStateUI) {
        this.jot = freewifiWeChatNoAuthStateUI;
    }

    public final void a(int i, int i2, String str, l lVar) {
        au.DF().b(640, this);
        x.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap ok");
            ep aOY = ((a) lVar).aOY();
            if (aOY != null) {
                x.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{aOY.rbW, aOY.hcS, aOY.hbL, Integer.valueOf(aOY.rfa), aOY.rfb, aOY.eJK});
                this.jot.bPS = aOY.rbW;
                this.jot.jkJ = aOY.hcS;
                this.jot.bPg = aOY.hbL;
                this.jot.jnW = aOY.rfa;
                this.jot.jnX = aOY.rfb;
                this.jot.signature = aOY.eJK;
                this.jot.jnY = aOY.rfc;
            }
            d.a(this.jot.ssid, 2, this.jot.getIntent());
            return;
        }
        x.e("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", new Object[]{Integer.valueOf(FreewifiWeChatNoAuthStateUI.a(this.jot)), FreewifiWeChatNoAuthStateUI.b(this.jot), FreewifiWeChatNoAuthStateUI.c(this.jot)});
        d.a(this.jot.ssid, -2014, this.jot.getIntent());
        d.Ca(FreewifiWeChatNoAuthStateUI.c(this.jot));
    }
}
