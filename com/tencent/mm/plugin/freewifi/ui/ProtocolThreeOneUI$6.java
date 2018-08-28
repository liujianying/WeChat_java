package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeOneUI$6 implements Runnable {
    final /* synthetic */ ProtocolThreeOneUI jov;
    final /* synthetic */ String val$url;

    ProtocolThreeOneUI$6(ProtocolThreeOneUI protocolThreeOneUI, String str) {
        this.jov = protocolThreeOneUI;
        this.val$url = str;
    }

    public final void run() {
        x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.E(this.jov.getIntent()), Integer.valueOf(m.F(this.jov.getIntent())), this.val$url});
        a.aOj();
        a.a(this.val$url, new 1(this));
    }
}
