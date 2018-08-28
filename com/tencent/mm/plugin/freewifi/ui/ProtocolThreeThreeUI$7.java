package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class ProtocolThreeThreeUI$7 implements a {
    final /* synthetic */ ProtocolThreeThreeUI joy;

    ProtocolThreeThreeUI$7(ProtocolThreeThreeUI protocolThreeThreeUI) {
        this.joy = protocolThreeThreeUI;
    }

    public final void g(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.E(this.joy.getIntent()), Integer.valueOf(m.F(this.joy.getIntent())), Integer.valueOf(responseCode)});
        if (responseCode == 200) {
            ProtocolThreeThreeUI.c(this.joy);
        } else if (responseCode == 302) {
            ProtocolThreeThreeUI.a(this.joy, httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.E(this.joy.getIntent()), Integer.valueOf(m.F(this.joy.getIntent()))});
            d.a(this.joy.ssid, 3, this.joy.getIntent());
        }
    }

    public final void j(Exception exception) {
        x.e("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s", new Object[]{m.E(this.joy.getIntent()), Integer.valueOf(m.F(this.joy.getIntent())), exception.getMessage()});
    }
}
