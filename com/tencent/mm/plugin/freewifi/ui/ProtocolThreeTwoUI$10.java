package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class ProtocolThreeTwoUI$10 implements Runnable {
    final /* synthetic */ ProtocolThreeTwoUI joB;
    final /* synthetic */ String val$url;

    ProtocolThreeTwoUI$10(ProtocolThreeTwoUI protocolThreeTwoUI, String str) {
        this.joB = protocolThreeTwoUI;
        this.val$url = str;
    }

    public final void run() {
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.E(this.joB.getIntent()), Integer.valueOf(m.F(this.joB.getIntent())), this.val$url});
        a.aOj();
        a.a(this.val$url, new a.a() {
            public final void g(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.E(ProtocolThreeTwoUI$10.this.joB.getIntent()), Integer.valueOf(m.F(ProtocolThreeTwoUI$10.this.joB.getIntent())), Integer.valueOf(responseCode)});
                if (responseCode == 200) {
                    ProtocolThreeTwoUI.f(ProtocolThreeTwoUI$10.this.joB);
                } else if (responseCode == 302) {
                    ProtocolThreeTwoUI.b(ProtocolThreeTwoUI$10.this.joB, httpURLConnection.getHeaderField("Location"));
                } else {
                    x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fs to connect wifi. ", new Object[]{m.E(ProtocolThreeTwoUI$10.this.joB.getIntent()), Integer.valueOf(m.F(ProtocolThreeTwoUI$10.this.joB.getIntent()))});
                    d.a(ProtocolThreeTwoUI$10.this.joB.ssid, 3, ProtocolThreeTwoUI$10.this.joB.getIntent());
                    ProtocolThreeTwoUI.a(ProtocolThreeTwoUI$10.this.joB, 32, "INVALID_HTTP_RESP_CODE");
                }
            }

            public final void j(Exception exception) {
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[]{m.E(ProtocolThreeTwoUI$10.this.joB.getIntent()), Integer.valueOf(m.F(ProtocolThreeTwoUI$10.this.joB.getIntent())), exception.getMessage()});
                d.a(ProtocolThreeTwoUI$10.this.joB.ssid, 3, ProtocolThreeTwoUI$10.this.joB.getIntent());
                ProtocolThreeTwoUI.a(ProtocolThreeTwoUI$10.this.joB, s$l.AppCompatTheme_buttonStyleSmall, m.g(exception));
            }
        });
    }
}
