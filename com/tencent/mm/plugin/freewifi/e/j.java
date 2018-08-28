package com.tencent.mm.plugin.freewifi.e;

import android.net.Uri;
import com.tencent.mm.plugin.freewifi.a;
import com.tencent.mm.plugin.freewifi.a$a;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends e implements a {
    String bJT = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
    private a jkN;
    private int jkT = 0;
    String jle = this.intent.getStringExtra("free_wifi_tid");
    String openId = this.intent.getStringExtra("free_wifi_openid");
    String sign = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");

    static /* synthetic */ void a(j jVar) {
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connectSsid, desc=it starts to connect ssid. ssid=%s", new Object[]{m.E(jVar.intent), Integer.valueOf(m.F(jVar.intent)), jVar.ssid});
        jVar.jkN.a(new a$a() {
            public final void onSuccess() {
                k.a aOa = k.aOa();
                aOa.ssid = j.this.ssid;
                aOa.bssid = m.BT("MicroMsg.FreeWifi.Protocol32");
                aOa.bIR = m.BU("MicroMsg.FreeWifi.Protocol32");
                aOa.bIQ = j.this.bIQ;
                aOa.jic = j.this.appId;
                aOa.jid = m.E(j.this.intent);
                aOa.jie = m.G(j.this.intent);
                aOa.jif = b.jiq.jiQ;
                aOa.jig = b.jiq.name;
                aOa.result = 0;
                aOa.bVU = m.H(j.this.intent);
                aOa.aOc().aOb();
                String aNX = h.b.aNY().aNX();
                x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid succeeded and then tries to access blackUrl. ssid=%s, blackUrl = %s", new Object[]{m.E(j.this.intent), Integer.valueOf(m.F(j.this.intent)), j.this.ssid, aNX});
                1 1 = new 1(this, aNX);
                com.tencent.mm.plugin.freewifi.a.a.aOj();
                com.tencent.mm.plugin.freewifi.a.a.a(aNX, 1);
            }

            public final void pT(int i) {
                x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", new Object[]{m.E(j.this.intent), Integer.valueOf(m.F(j.this.intent)), j.this.ssid, Integer.valueOf(i)});
                FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.jkG;
                d dVar = d.jnj;
                FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                aVar.jmI = m.a(j.this.jkI, b.jiq, i);
                freeWifiFrontPageUI.a(dVar, aVar);
                k.a aOa = k.aOa();
                aOa.ssid = j.this.ssid;
                aOa.bssid = m.BT("MicroMsg.FreeWifi.Protocol32");
                aOa.bIR = m.BU("MicroMsg.FreeWifi.Protocol32");
                aOa.bIQ = j.this.bIQ;
                aOa.jic = j.this.appId;
                aOa.jid = m.E(j.this.intent);
                aOa.jie = m.G(j.this.intent);
                aOa.jig = b.jiq.name;
                aOa.jif = b.jiq.jiQ;
                aOa.result = i;
                aOa.bVU = m.H(j.this.intent);
                aOa.aOc().aOb();
            }
        });
    }

    static /* synthetic */ void a(j jVar, String str) {
        jVar.jkT++;
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        FreeWifiFrontPageUI.a aVar;
        if (jVar.jkT > 3) {
            x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.E(jVar.intent), Integer.valueOf(m.F(jVar.intent))});
            freeWifiFrontPageUI = jVar.jkG;
            dVar = d.jnj;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.jmI = m.a(jVar.jkI, b.jiH, 33);
            freeWifiFrontPageUI.a(dVar, aVar);
            jVar.aj(33, "AUTH_302_TIMES_EXCESS");
            return;
        }
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.E(jVar.intent), Integer.valueOf(m.F(jVar.intent)), str});
        if (m.isEmpty(str)) {
            freeWifiFrontPageUI = jVar.jkG;
            dVar = d.jnj;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.jmI = m.a(jVar.jkI, b.jiH, 34);
            freeWifiFrontPageUI.a(dVar, aVar);
            jVar.aj(34, "EMPTY_AUTH_LOCATION");
            return;
        }
        4 4 = new 4(jVar);
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.aOj();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), 4);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.aOj();
        com.tencent.mm.plugin.freewifi.a.a.a(str, 4);
    }

    static /* synthetic */ void b(j jVar, int i, String str) {
        k.a aOa = k.aOa();
        aOa.ssid = jVar.ssid;
        aOa.bssid = m.BT("MicroMsg.FreeWifi.Protocol32");
        aOa.bIR = m.BU("MicroMsg.FreeWifi.Protocol32");
        aOa.bIQ = jVar.bIQ;
        aOa.jic = jVar.appId;
        aOa.jid = m.E(jVar.intent);
        aOa.jie = 32;
        aOa.jif = b.jiH.jiQ;
        aOa.jig = b.jiH.name;
        aOa.result = i;
        aOa.hKX = str;
        aOa.bVU = m.H(jVar.intent);
        aOa.aOc().aOb();
    }

    public j(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. openId=%s, tid=%s, timestamp=%s, sign=%s", new Object[]{m.E(this.intent), Integer.valueOf(m.F(this.intent)), this.openId, this.jle, this.bJT, this.sign});
    }

    public final void connect() {
        this.jkN = new a(this.ssid, this.jkG);
        com.tencent.mm.plugin.freewifi.model.j.aON().aOv().post(new Runnable() {
            public final void run() {
                j.a(j.this);
            }
        });
    }

    private void aj(int i, String str) {
        k.a aOa = k.aOa();
        aOa.ssid = this.ssid;
        aOa.bssid = m.BT("MicroMsg.FreeWifi.Protocol32");
        aOa.bIR = m.BU("MicroMsg.FreeWifi.Protocol32");
        aOa.bIQ = this.bIQ;
        aOa.jic = this.appId;
        aOa.jid = m.E(this.intent);
        aOa.jie = 32;
        aOa.jif = b.jiH.jiQ;
        aOa.jig = b.jiH.name;
        aOa.result = i;
        aOa.hKX = str;
        aOa.bVU = m.H(this.intent);
        aOa.aOc().aOb();
    }
}
