package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$d;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class h$2 implements a {
    final /* synthetic */ h jkU;

    h$2(h hVar) {
        this.jkU = hVar;
    }

    public final void g(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.E(this.jkU.intent), Integer.valueOf(m.F(this.jkU.intent)), Integer.valueOf(responseCode)});
        if (responseCode == 200) {
            h.a(this.jkU, 0, "");
            m.a(this.jkU.intent, this.jkU.bIQ, this.jkU.jkI, this.jkU.bxk, this.jkU.jkG, "MicroMsg.FreeWifi.ProtocolThreeOne");
        } else if (responseCode == 302) {
            h.a(this.jkU, httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.E(this.jkU.intent), Integer.valueOf(m.F(this.jkU.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = this.jkU.jkG;
            FreeWifiFrontPageUI$d freeWifiFrontPageUI$d = FreeWifiFrontPageUI$d.FAIL;
            FreeWifiFrontPageUI$a freeWifiFrontPageUI$a = new FreeWifiFrontPageUI$a();
            freeWifiFrontPageUI$a.jmI = m.a(this.jkU.jkI, b.jiG, 32);
            freeWifiFrontPageUI.a(freeWifiFrontPageUI$d, freeWifiFrontPageUI$a);
            h.a(this.jkU, 32, "INVALID_HTTP_RESP_CODE");
        }
    }

    public final void j(Exception exception) {
        x.e("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", new Object[]{m.E(this.jkU.intent), Integer.valueOf(m.F(this.jkU.intent)), exception.getMessage(), m.h(exception)});
        FreeWifiFrontPageUI freeWifiFrontPageUI = this.jkU.jkG;
        FreeWifiFrontPageUI$d freeWifiFrontPageUI$d = FreeWifiFrontPageUI$d.FAIL;
        FreeWifiFrontPageUI$a freeWifiFrontPageUI$a = new FreeWifiFrontPageUI$a();
        freeWifiFrontPageUI$a.jmI = m.a(this.jkU.jkI, b.jiG, m.i(exception));
        freeWifiFrontPageUI.a(freeWifiFrontPageUI$d, freeWifiFrontPageUI$a);
        h.a(this.jkU, m.i(exception), m.g(exception));
    }
}
