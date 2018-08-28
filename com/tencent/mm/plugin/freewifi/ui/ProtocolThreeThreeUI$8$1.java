package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.8;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeThreeUI$8$1 implements e {
    final /* synthetic */ 8 joA;

    ProtocolThreeThreeUI$8$1(8 8) {
        this.joA = 8;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.E(this.joA.joy.getIntent()), Integer.valueOf(m.F(this.joA.joy.getIntent())), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            ep aOY = ((f) lVar).aOY();
            if (aOY != null) {
                x.i("MicroMsg.FreeWifi.Protocol33UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{aOY.rbW, aOY.hcS, aOY.hbL, Integer.valueOf(aOY.rfa), aOY.rfb, aOY.eJK});
                this.joA.joy.jkJ = aOY.hcS;
                this.joA.joy.bPg = aOY.hbL;
                this.joA.joy.jnW = aOY.rfa;
                this.joA.joy.jnX = aOY.rfb;
                this.joA.joy.signature = aOY.eJK;
                this.joA.joy.jnY = aOY.rfc;
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPageFor33] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{m.E(this.joA.joy.getIntent()), Integer.valueOf(m.F(this.joA.joy.getIntent())), this.joA.joy.appId, this.joA.joy.jkJ, this.joA.joy.bPg, Integer.valueOf(this.joA.joy.jnW), this.joA.joy.jnX, this.joA.joy.signature, this.joA.joy.jnY});
            }
            d.a(this.joA.joy.ssid, 2, this.joA.joy.getIntent());
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", new Object[]{m.E(this.joA.joy.getIntent()), Integer.valueOf(m.F(this.joA.joy.getIntent())), Integer.valueOf(2)});
        } else if (i2 == -30032) {
            Intent intent = new Intent();
            intent.putExtra("free_wifi_error_ui_error_msg", this.joA.joy.getString(R.l.free_wifi_errmsg_33_invalid_sign_warnning));
            intent.setClass(this.joA.joy, FreeWifiErrorUI.class);
            this.joA.joy.finish();
            this.joA.joy.startActivity(intent);
        } else {
            d.a(this.joA.joy.ssid, 3, this.joA.joy.getIntent());
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=NetSceneGetBackPageFor33 returns unkown errcode. errCode=%d", new Object[]{m.E(this.joA.joy.getIntent()), Integer.valueOf(m.F(this.joA.joy.getIntent())), Integer.valueOf(i2)});
        }
    }
}
