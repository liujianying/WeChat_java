package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.e.j.2.1;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class j$2$1$1 implements a {
    final /* synthetic */ 1 jlm;

    j$2$1$1(1 1) {
        this.jlm = 1;
    }

    public final void g(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        FreeWifiFrontPageUI.a aVar;
        if (responseCode == 200) {
            x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=it still cannot get authurl and extend (now http returns 200), so it fails to connect wifi. ", new Object[]{m.E(this.jlm.jll.jlf.intent), Integer.valueOf(m.F(this.jlm.jll.jlf.intent))});
            freeWifiFrontPageUI = this.jlm.jll.jlf.jkG;
            dVar = d.jnj;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.jmI = m.a(this.jlm.jll.jlf.jkI, b.jiI, 35);
            freeWifiFrontPageUI.a(dVar, aVar);
            j.a(this.jlm.jll.jlf, 35, "CANNOT_GET_AUTHURL_AFTER_BLACK_URL");
        } else if (responseCode == 302) {
            1.a(this.jlm, httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.E(this.jlm.jll.jlf.intent), Integer.valueOf(m.F(this.jlm.jll.jlf.intent))});
            freeWifiFrontPageUI = this.jlm.jll.jlf.jkG;
            dVar = d.jnj;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.jmI = m.a(this.jlm.jll.jlf.jkI, b.jiI, 32);
            freeWifiFrontPageUI.a(dVar, aVar);
            j.a(this.jlm.jll.jlf, 32, "INVALID_HTTP_RESP_CODE");
        }
    }

    public final void j(Exception exception) {
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s,stacktrace=%s", new Object[]{m.E(this.jlm.jll.jlf.intent), Integer.valueOf(m.F(this.jlm.jll.jlf.intent)), exception.getMessage(), m.h(exception)});
        FreeWifiFrontPageUI freeWifiFrontPageUI = this.jlm.jll.jlf.jkG;
        d dVar = d.jnj;
        FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
        aVar.jmI = m.a(this.jlm.jll.jlf.jkI, b.jiI, m.i(exception));
        freeWifiFrontPageUI.a(dVar, aVar);
        j.a(this.jlm.jll.jlf, m.i(exception), m.g(exception));
    }
}
