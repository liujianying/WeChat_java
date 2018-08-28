package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.a.a$a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.net.HttpURLConnection;

class i$2 implements a$a {
    final /* synthetic */ i jlb;

    i$2(i iVar) {
        this.jlb = iVar;
    }

    public final void g(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.E(this.jlb.intent), Integer.valueOf(m.F(this.jlb.intent)), Integer.valueOf(responseCode)});
        if (responseCode == 200) {
            this.jlb.aPk();
        } else if (responseCode == TbsListener$ErrorCode.ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY) {
            i.a(this.jlb, httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.E(this.jlb.intent), Integer.valueOf(m.F(this.jlb.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = this.jlb.jkG;
            d dVar = d.jnj;
            a aVar = new a();
            aVar.jmI = m.a(this.jlb.jkI, b.jiJ, 32);
            freeWifiFrontPageUI.a(dVar, aVar);
        }
    }

    public final void j(Exception exception) {
        x.e("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", new Object[]{m.E(this.jlb.intent), Integer.valueOf(m.F(this.jlb.intent)), exception.getMessage(), m.h(exception)});
        FreeWifiFrontPageUI freeWifiFrontPageUI = this.jlb.jkG;
        d dVar = d.jnj;
        a aVar = new a();
        aVar.jmI = m.a(this.jlb.jkI, b.jiJ, m.i(exception));
        freeWifiFrontPageUI.a(dVar, aVar);
    }
}
