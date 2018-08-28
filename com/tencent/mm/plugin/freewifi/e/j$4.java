package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class j$4 implements a {
    final /* synthetic */ j jlf;

    j$4(j jVar) {
        this.jlf = jVar;
    }

    public final void g(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.E(this.jlf.intent), Integer.valueOf(m.F(this.jlf.intent)), Integer.valueOf(responseCode)});
        if (responseCode == com.tencent.mm.plugin.appbrand.jsapi.f.m.CTRL_INDEX) {
            j.a(this.jlf, 0, "");
            m.a(this.jlf.intent, this.jlf.bIQ, this.jlf.jkI, this.jlf.bxk, this.jlf.jkG, "MicroMsg.FreeWifi.Protocol32");
        } else if (responseCode == 302) {
            j.a(this.jlf, httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.E(this.jlf.intent), Integer.valueOf(m.F(this.jlf.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = this.jlf.jkG;
            d dVar = d.jnj;
            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
            aVar.jmI = m.a(this.jlf.jkI, b.jiH, 32);
            freeWifiFrontPageUI.a(dVar, aVar);
            j.a(this.jlf, 32, "INVALID_HTTP_RESP_CODE");
        }
    }

    public final void j(Exception exception) {
        x.e("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", new Object[]{m.E(this.jlf.intent), Integer.valueOf(m.F(this.jlf.intent)), exception.getMessage(), m.h(exception)});
        FreeWifiFrontPageUI freeWifiFrontPageUI = this.jlf.jkG;
        d dVar = d.jnj;
        FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
        aVar.jmI = m.a(this.jlf.jkI, b.jiH, m.i(exception));
        freeWifiFrontPageUI.a(dVar, aVar);
        j.a(this.jlf, m.i(exception), m.g(exception));
    }
}
