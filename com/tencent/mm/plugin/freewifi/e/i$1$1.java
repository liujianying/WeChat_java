package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.e.i.1;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class i$1$1 implements a {
    final /* synthetic */ 1 jlc;

    i$1$1(1 1) {
        this.jlc = 1;
    }

    public final void g(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.E(this.jlc.jlb.intent), Integer.valueOf(m.F(this.jlc.jlb.intent)), Integer.valueOf(responseCode)});
        if (responseCode == 200) {
            this.jlc.jlb.aPk();
        } else if (responseCode == 302) {
            i.a(this.jlc.jlb, httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.E(this.jlc.jlb.intent), Integer.valueOf(m.F(this.jlc.jlb.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = this.jlc.jlb.jkG;
            d dVar = d.jnj;
            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
            aVar.jmI = m.a(this.jlc.jlb.jkI, b.jiJ, 32);
            freeWifiFrontPageUI.a(dVar, aVar);
        }
    }

    public final void j(Exception exception) {
        x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[]{m.E(this.jlc.jlb.intent), Integer.valueOf(m.F(this.jlc.jlb.intent)), exception.getMessage(), m.h(exception)});
        FreeWifiFrontPageUI freeWifiFrontPageUI = this.jlc.jlb.jkG;
        d dVar = d.jnj;
        FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
        aVar.jmI = m.a(this.jlc.jlb.jkI, b.jiJ, m.i(exception));
        freeWifiFrontPageUI.a(dVar, aVar);
    }
}
