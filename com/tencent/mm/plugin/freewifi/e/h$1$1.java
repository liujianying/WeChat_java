package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.e.h.1;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class h$1$1 implements a {
    final /* synthetic */ 1 jkV;

    h$1$1(1 1) {
        this.jkV = 1;
    }

    public final void g(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.E(this.jkV.jkU.intent), Integer.valueOf(m.F(this.jkV.jkU.intent)), Integer.valueOf(responseCode)});
        if (responseCode == com.tencent.mm.plugin.appbrand.jsapi.f.m.CTRL_INDEX) {
            h.a(this.jkV.jkU, 0, "");
            m.a(this.jkV.jkU.intent, this.jkV.jkU.bIQ, this.jkV.jkU.jkI, this.jkV.jkU.bxk, this.jkV.jkU.jkG, "MicroMsg.FreeWifi.ProtocolThreeOne");
        } else if (responseCode == 302) {
            h.a(this.jkV.jkU, httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.E(this.jkV.jkU.intent), Integer.valueOf(m.F(this.jkV.jkU.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = this.jkV.jkU.jkG;
            d dVar = d.jnj;
            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
            aVar.jmI = m.a(this.jkV.jkU.jkI, b.jiG, 32);
            freeWifiFrontPageUI.a(dVar, aVar);
            h.a(this.jkV.jkU, 32, "INVALID_HTTP_RESP_CODE");
        }
    }

    public final void j(Exception exception) {
        x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stackTrace=%s", new Object[]{m.E(this.jkV.jkU.intent), Integer.valueOf(m.F(this.jkV.jkU.intent)), exception.getMessage(), m.h(exception)});
        FreeWifiFrontPageUI freeWifiFrontPageUI = this.jkV.jkU.jkG;
        d dVar = d.jnj;
        FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
        aVar.jmI = m.a(this.jkV.jkU.jkI, b.jiG, m.i(exception));
        freeWifiFrontPageUI.a(dVar, aVar);
        h.a(this.jkV.jkU, m.i(exception), m.g(exception));
    }
}
