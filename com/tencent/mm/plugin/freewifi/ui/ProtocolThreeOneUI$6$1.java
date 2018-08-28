package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.6;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class ProtocolThreeOneUI$6$1 implements a {
    final /* synthetic */ 6 jow;

    ProtocolThreeOneUI$6$1(6 6) {
        this.jow = 6;
    }

    public final void g(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.E(this.jow.jov.getIntent()), Integer.valueOf(m.F(this.jow.jov.getIntent())), Integer.valueOf(responseCode)});
        if (!ProtocolThreeOneUI.d(this.jow.jov)) {
            if (responseCode == 200) {
                ProtocolThreeOneUI.e(this.jow.jov);
            } else if (responseCode == 302) {
                ProtocolThreeOneUI.a(this.jow.jov, httpURLConnection.getHeaderField("Location"));
            } else {
                x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.E(this.jow.jov.getIntent()), Integer.valueOf(m.F(this.jow.jov.getIntent()))});
                d.a(this.jow.jov.ssid, 3, this.jow.jov.getIntent());
                ProtocolThreeOneUI.a(this.jow.jov, 32, "INVALID_HTTP_RESP_CODE");
            }
        }
    }

    public final void j(Exception exception) {
        x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[]{m.E(this.jow.jov.getIntent()), Integer.valueOf(m.F(this.jow.jov.getIntent())), exception.getMessage()});
        d.a(this.jow.jov.ssid, 3, this.jow.jov.getIntent());
        ProtocolThreeOneUI.a(this.jow.jov, s$l.AppCompatTheme_buttonStyleSmall, m.g(exception));
    }
}
