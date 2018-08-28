package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.a.a$a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.9.1;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.net.HttpURLConnection;

class ProtocolThreeTwoUI$9$1$1 implements a$a {
    final /* synthetic */ 1 joE;

    ProtocolThreeTwoUI$9$1$1(1 1) {
        this.joE = 1;
    }

    public final void g(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=it still cannot get authurl and extend (now http returns 200), so it fails to connect wifi. ", new Object[]{m.E(this.joE.joD.joB.getIntent()), Integer.valueOf(m.F(this.joE.joD.joB.getIntent()))});
            d.a(this.joE.joD.joB.ssid, 3, this.joE.joD.joB.getIntent());
            ProtocolThreeTwoUI.a(this.joE.joD.joB, 35, "CANNOT_GET_AUTHURL_AFTER_BLACK_URL");
        } else if (responseCode == TbsListener$ErrorCode.ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY) {
            1.a(this.joE, httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.E(this.joE.joD.joB.getIntent()), Integer.valueOf(m.F(this.joE.joD.joB.getIntent()))});
            d.a(this.joE.joD.joB.ssid, 3, this.joE.joD.joB.getIntent());
            ProtocolThreeTwoUI.a(this.joE.joD.joB, 32, "INVALID_HTTP_RESP_CODE");
        }
    }

    public final void j(Exception exception) {
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[]{m.E(this.joE.joD.joB.getIntent()), Integer.valueOf(m.F(this.joE.joD.joB.getIntent())), exception.getMessage()});
        d.a(this.joE.joD.joB.ssid, 3, this.joE.joD.joB.getIntent());
        ProtocolThreeTwoUI.a(this.joE.joD.joB, 101, m.g(exception));
    }
}
