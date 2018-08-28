package com.tencent.mm.plugin.freewifi.e;

import android.net.Uri;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends e implements a {
    protected String bJT;
    private int jkT;
    protected String jkW;
    protected String jkX;
    protected String jkY;
    private Uri jkZ;
    private String jla;
    protected String sign;

    static /* synthetic */ void a(i iVar, String str) {
        iVar.jkT++;
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        a aVar;
        if (iVar.jkT > 3) {
            x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.E(iVar.intent), Integer.valueOf(m.F(iVar.intent))});
            freeWifiFrontPageUI = iVar.jkG;
            dVar = d.jnj;
            aVar = new a();
            aVar.jmI = m.a(iVar.jkI, b.jiJ, 33);
            freeWifiFrontPageUI.a(dVar, aVar);
            return;
        }
        x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.E(iVar.intent), Integer.valueOf(m.F(iVar.intent)), str});
        if (m.isEmpty(str)) {
            freeWifiFrontPageUI = iVar.jkG;
            dVar = d.jnj;
            aVar = new a();
            aVar.jmI = m.a(iVar.jkI, b.jiJ, 34);
            freeWifiFrontPageUI.a(dVar, aVar);
            return;
        }
        2 2 = new 2(iVar);
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.aOj();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), 2);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.aOj();
        com.tencent.mm.plugin.freewifi.a.a.a(str, 2);
    }

    public i(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        this.jkT = 0;
        this.jla = this.intent.getStringExtra("free_wifi_schema_uri");
        this.jkZ = Uri.parse(this.jla);
        this.appId = this.jkZ.getQueryParameter("appId");
        this.jkW = this.jkZ.getQueryParameter("shopId");
        this.jkX = this.jkZ.getQueryParameter("authUrl");
        this.jkY = this.jkZ.getQueryParameter("extend");
        this.bJT = this.jkZ.getQueryParameter("timestamp");
        this.sign = this.jkZ.getQueryParameter("sign");
        x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=Data retrieved. schemaUri=%s, appid=%s, shopId=%s, authUrl=%s, extend=%s, timestamp=%s, sign=%s", new Object[]{m.E(this.intent), Integer.valueOf(m.F(this.intent)), this.jkZ, this.appId, this.jkW, this.jkX, this.jkY, this.bJT, this.sign});
    }

    public final void connect() {
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        a aVar;
        if (m.isEmpty(this.ssid)) {
            x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", new Object[]{m.E(this.intent), Integer.valueOf(m.F(this.intent))});
            freeWifiFrontPageUI = this.jkG;
            dVar = d.jnj;
            aVar = new a();
            aVar.jmI = m.a(this.jkI, b.jiJ, 32);
            freeWifiFrontPageUI.a(dVar, aVar);
        } else if (m.isEmpty(this.jkX)) {
            x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", new Object[]{m.E(this.intent), Integer.valueOf(m.F(this.intent))});
            freeWifiFrontPageUI = this.jkG;
            dVar = d.jnj;
            aVar = new a();
            aVar.jmI = m.a(this.jkI, b.jiJ, 32);
            freeWifiFrontPageUI.a(dVar, aVar);
        } else {
            StringBuilder stringBuilder = new StringBuilder(this.jkX);
            if (this.jkX.indexOf("?") == -1) {
                stringBuilder.append("?extend=").append(this.jkY);
            } else {
                stringBuilder.append("&extend=").append(this.jkY);
            }
            j.aON().aOv().post(new 1(this, stringBuilder.toString()));
        }
    }

    protected final void aPk() {
        j.aON().aOv().post(new 3(this));
    }
}
