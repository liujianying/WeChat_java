package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

class FreewifiActivateWeChatNoAuthStateUI$1 implements e {
    final /* synthetic */ FreewifiActivateWeChatNoAuthStateUI jos;

    FreewifiActivateWeChatNoAuthStateUI$1(FreewifiActivateWeChatNoAuthStateUI freewifiActivateWeChatNoAuthStateUI) {
        this.jos = freewifiActivateWeChatNoAuthStateUI;
    }

    public final void a(int i, int i2, String str, l lVar) {
        au.DF().b(640, this);
        x.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap ok");
            d.a(this.jos.ssid, 2, this.jos.getIntent());
            return;
        }
        x.e("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", new Object[]{Integer.valueOf(FreewifiActivateWeChatNoAuthStateUI.a(this.jos)), FreewifiActivateWeChatNoAuthStateUI.b(this.jos), FreewifiActivateWeChatNoAuthStateUI.c(this.jos)});
        this.jos.ph(-2014);
        d.Ca(FreewifiActivateWeChatNoAuthStateUI.c(this.jos));
    }
}
