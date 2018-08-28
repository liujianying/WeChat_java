package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.8;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeOneUI$8$1 implements e {
    final /* synthetic */ 8 jox;

    ProtocolThreeOneUI$8$1(8 8) {
        this.jox = 8;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.E(this.jox.jov.getIntent()), Integer.valueOf(m.F(this.jox.jov.getIntent())), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0 && (lVar instanceof a)) {
            ep aOY = ((a) lVar).aOY();
            if (aOY != null) {
                x.i("MicroMsg.FreeWifi.Protocol31UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{aOY.rbW, aOY.hcS, aOY.hbL, Integer.valueOf(aOY.rfa), aOY.rfb, aOY.eJK});
                this.jox.jov.bPS = aOY.rbW;
                this.jox.jov.jkJ = aOY.hcS;
                this.jox.jov.bPg = aOY.hbL;
                this.jox.jov.jnW = aOY.rfa;
                this.jox.jov.jnX = aOY.rfb;
                this.jox.jov.signature = aOY.eJK;
                this.jox.jov.jnY = aOY.rfc;
                x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPage] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{m.E(this.jox.jov.getIntent()), Integer.valueOf(m.F(this.jox.jov.getIntent())), this.jox.jov.bPS, this.jox.jov.jkJ, this.jox.jov.bPg, Integer.valueOf(this.jox.jov.jnW), this.jox.jov.jnX, this.jox.jov.signature, this.jox.jov.jnY});
            }
            d.a(this.jox.jov.ssid, 2, this.jox.jov.getIntent());
            x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", new Object[]{m.E(this.jox.jov.getIntent()), Integer.valueOf(m.F(this.jox.jov.getIntent())), Integer.valueOf(2)});
        }
    }
}
