package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.2;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeTwoUI$2$1 implements e {
    final /* synthetic */ 2 joC;

    ProtocolThreeTwoUI$2$1(2 2) {
        this.joC = 2;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.E(this.joC.joB.getIntent()), Integer.valueOf(m.F(this.joC.joB.getIntent())), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0 && (lVar instanceof a)) {
            ep aOY = ((a) lVar).aOY();
            if (aOY != null) {
                x.i("MicroMsg.FreeWifi.Protocol32UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{aOY.rbW, aOY.hcS, aOY.hbL, Integer.valueOf(aOY.rfa), aOY.rfb, aOY.eJK});
                this.joC.joB.bPS = aOY.rbW;
                this.joC.joB.jkJ = aOY.hcS;
                this.joC.joB.bPg = aOY.hbL;
                this.joC.joB.jnW = aOY.rfa;
                this.joC.joB.jnX = aOY.rfb;
                this.joC.joB.signature = aOY.eJK;
                this.joC.joB.jnY = aOY.rfc;
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPage] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{m.E(this.joC.joB.getIntent()), Integer.valueOf(m.F(this.joC.joB.getIntent())), this.joC.joB.bPS, this.joC.joB.jkJ, this.joC.joB.bPg, Integer.valueOf(this.joC.joB.jnW), this.joC.joB.jnX, this.joC.joB.signature, this.joC.joB.jnY});
            }
            d.a(this.joC.joB.ssid, 2, this.joC.joB.getIntent());
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", new Object[]{m.E(this.joC.joB.getIntent()), Integer.valueOf(m.F(this.joC.joB.getIntent())), Integer.valueOf(2)});
        }
    }
}
