package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.a.a$a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.net.HttpURLConnection;

class ProtocolThreeTwoUI$11 implements a$a {
    final /* synthetic */ ProtocolThreeTwoUI joB;

    ProtocolThreeTwoUI$11(ProtocolThreeTwoUI protocolThreeTwoUI) {
        this.joB = protocolThreeTwoUI;
    }

    public final void g(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.E(this.joB.getIntent()), Integer.valueOf(m.F(this.joB.getIntent())), Integer.valueOf(responseCode)});
        if (responseCode == 200) {
            ProtocolThreeTwoUI.f(this.joB);
        } else if (responseCode == TbsListener$ErrorCode.ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY) {
            ProtocolThreeTwoUI.b(this.joB, httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.E(this.joB.getIntent()), Integer.valueOf(m.F(this.joB.getIntent()))});
            d.a(this.joB.ssid, 3, this.joB.getIntent());
            ProtocolThreeTwoUI.a(this.joB, 32, "INVALID_HTTP_RESP_CODE");
        }
    }

    public final void j(Exception exception) {
        x.e("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s", new Object[]{m.E(this.joB.getIntent()), Integer.valueOf(m.F(this.joB.getIntent())), exception.getMessage()});
        ProtocolThreeTwoUI.a(this.joB, 101, m.g(exception));
    }
}
