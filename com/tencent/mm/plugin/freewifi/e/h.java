package com.tencent.mm.plugin.freewifi.e;

import android.net.Uri;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends e implements a {
    private String jkS = this.intent.getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
    private int jkT = 0;

    static /* synthetic */ void a(h hVar, String str) {
        hVar.jkT++;
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        a aVar;
        if (hVar.jkT > 3) {
            x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.E(hVar.intent), Integer.valueOf(m.F(hVar.intent))});
            freeWifiFrontPageUI = hVar.jkG;
            dVar = d.jnj;
            aVar = new a();
            aVar.jmI = m.a(hVar.jkI, b.jiG, 33);
            freeWifiFrontPageUI.a(dVar, aVar);
            hVar.ai(33, "AUTH_302_TIMES_EXCESS");
            return;
        }
        x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.E(hVar.intent), Integer.valueOf(m.F(hVar.intent)), str});
        if (m.isEmpty(str)) {
            freeWifiFrontPageUI = hVar.jkG;
            dVar = d.jnj;
            aVar = new a();
            aVar.jmI = m.a(hVar.jkI, b.jiG, 34);
            freeWifiFrontPageUI.a(dVar, aVar);
            hVar.ai(34, "EMPTY_AUTH_LOCATION");
            return;
        }
        2 2 = new 2(hVar);
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.aOj();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), 2);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.aOj();
        com.tencent.mm.plugin.freewifi.a.a.a(str, 2);
    }

    public h(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, desc=Data retrieved. authUrlWithParams=%s", new Object[]{m.E(this.intent), Integer.valueOf(m.F(this.intent)), this.jkS});
    }

    public final void connect() {
        x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.connect, desc=it starts connecting wifi by protocol 3.1. authUrlWithParams=%s", new Object[]{m.E(this.intent), Integer.valueOf(m.F(this.intent)), this.jkS});
        final String str = this.jkS;
        j.aON().aOv().post(new Runnable() {
            public final void run() {
                x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.E(h.this.intent), Integer.valueOf(m.F(h.this.intent)), str});
                com.tencent.mm.plugin.freewifi.a.a.aOj();
                com.tencent.mm.plugin.freewifi.a.a.a(str, new 1(this));
            }
        });
    }

    private void ai(int i, String str) {
        k.a aOa = k.aOa();
        aOa.ssid = this.ssid;
        aOa.bssid = m.BT("MicroMsg.FreeWifi.ProtocolThreeOne");
        aOa.bIR = m.BU("MicroMsg.FreeWifi.ProtocolThreeOne");
        aOa.bIQ = this.bIQ;
        aOa.jic = this.appId;
        aOa.jid = m.E(this.intent);
        aOa.jie = 31;
        aOa.jif = b.jiG.jiQ;
        aOa.jig = b.jiG.name;
        aOa.result = i;
        aOa.hKX = str;
        aOa.bVU = m.H(this.intent);
        aOa.aOc().b(this.intent, i != 0).aOb();
    }
}
