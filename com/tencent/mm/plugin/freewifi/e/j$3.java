package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.a.a$a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.net.HttpURLConnection;

class j$3 implements Runnable {
    final /* synthetic */ j jlf;
    final /* synthetic */ String val$url;

    j$3(j jVar, String str) {
        this.jlf = jVar;
        this.val$url = str;
    }

    public final void run() {
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.E(this.jlf.intent), Integer.valueOf(m.F(this.jlf.intent)), this.val$url});
        a.aOj();
        a.a(this.val$url, new a$a() {
            public final void g(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.E(j$3.this.jlf.intent), Integer.valueOf(m.F(j$3.this.jlf.intent)), Integer.valueOf(responseCode)});
                if (responseCode == 200) {
                    j.a(j$3.this.jlf, 0, "");
                    m.a(j$3.this.jlf.intent, j$3.this.jlf.bIQ, j$3.this.jlf.jkI, j$3.this.jlf.bxk, j$3.this.jlf.jkG, "MicroMsg.FreeWifi.Protocol32");
                } else if (responseCode == TbsListener$ErrorCode.ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY) {
                    j.a(j$3.this.jlf, httpURLConnection.getHeaderField("Location"));
                } else {
                    x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fs to connect wifi. ", new Object[]{m.E(j$3.this.jlf.intent), Integer.valueOf(m.F(j$3.this.jlf.intent))});
                    FreeWifiFrontPageUI freeWifiFrontPageUI = j$3.this.jlf.jkG;
                    d dVar = d.jnj;
                    FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                    aVar.jmI = m.a(j$3.this.jlf.jkI, b.jiH, 32);
                    freeWifiFrontPageUI.a(dVar, aVar);
                    j.a(j$3.this.jlf, 32, "INVALID_HTTP_RESP_CODE");
                }
            }

            public final void j(Exception exception) {
                x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[]{m.E(j$3.this.jlf.intent), Integer.valueOf(m.F(j$3.this.jlf.intent)), exception.getMessage(), m.h(exception)});
                FreeWifiFrontPageUI freeWifiFrontPageUI = j$3.this.jlf.jkG;
                d dVar = d.jnj;
                FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                aVar.jmI = m.a(j$3.this.jlf.jkI, b.jiH, m.i(exception));
                freeWifiFrontPageUI.a(dVar, aVar);
                j.a(j$3.this.jlf, m.i(exception), m.g(exception));
            }
        });
    }
}
