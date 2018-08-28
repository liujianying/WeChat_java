package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class ProtocolThreeThreeUI$6 implements Runnable {
    final /* synthetic */ ProtocolThreeThreeUI joy;
    final /* synthetic */ String val$url;

    ProtocolThreeThreeUI$6(ProtocolThreeThreeUI protocolThreeThreeUI, String str) {
        this.joy = protocolThreeThreeUI;
        this.val$url = str;
    }

    public final void run() {
        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.E(this.joy.getIntent()), Integer.valueOf(m.F(this.joy.getIntent())), this.val$url});
        a.aOj();
        a.a(this.val$url, new a.a() {
            public final void g(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.E(ProtocolThreeThreeUI$6.this.joy.getIntent()), Integer.valueOf(m.F(ProtocolThreeThreeUI$6.this.joy.getIntent())), Integer.valueOf(responseCode)});
                if (responseCode == 200) {
                    ProtocolThreeThreeUI.c(ProtocolThreeThreeUI$6.this.joy);
                } else if (responseCode == 302) {
                    ProtocolThreeThreeUI.a(ProtocolThreeThreeUI$6.this.joy, httpURLConnection.getHeaderField("Location"));
                } else {
                    x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.E(ProtocolThreeThreeUI$6.this.joy.getIntent()), Integer.valueOf(m.F(ProtocolThreeThreeUI$6.this.joy.getIntent()))});
                    d.a(ProtocolThreeThreeUI$6.this.joy.ssid, 3, ProtocolThreeThreeUI$6.this.joy.getIntent());
                }
            }

            public final void j(Exception exception) {
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[]{m.E(ProtocolThreeThreeUI$6.this.joy.getIntent()), Integer.valueOf(m.F(ProtocolThreeThreeUI$6.this.joy.getIntent())), exception.getMessage()});
                d.a(ProtocolThreeThreeUI$6.this.joy.ssid, 3, ProtocolThreeThreeUI$6.this.joy.getIntent());
            }
        });
    }
}
