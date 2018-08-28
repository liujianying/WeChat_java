package com.tencent.mm.plugin.freewifi.e;

import android.net.Uri;
import com.tencent.mm.plugin.freewifi.a.a$a;
import com.tencent.mm.plugin.freewifi.e.j.2;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

class j$2$1 implements a$a {
    int jlg = 0;
    private final int jlh = 3;
    private int jli = 0;
    private a$a jlj = new 1(this);
    final /* synthetic */ String jlk;
    final /* synthetic */ 2 jll;

    j$2$1(2 2, String str) {
        this.jll = 2;
        this.jlk = str;
    }

    public final void g(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackurl returns 200 directly, so we believe that the device is already authenticated. Authentication ended.", new Object[]{m.E(this.jll.jlf.intent), Integer.valueOf(m.F(this.jll.jlf.intent))});
            j.a(this.jll.jlf, 0, "");
            m.a(this.jll.jlf.intent, this.jll.jlf.bIQ, this.jll.jlf.jkI, this.jll.jlf.bxk, this.jll.jlf.jkG, "MicroMsg.FreeWifi.Protocol32");
        } else if (responseCode == TbsListener$ErrorCode.ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY) {
            Cd(httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.E(this.jll.jlf.intent), Integer.valueOf(m.F(this.jll.jlf.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = this.jll.jlf.jkG;
            d dVar = d.jnj;
            a aVar = new a();
            aVar.jmI = m.a(this.jll.jlf.jkI, b.jiI, 32);
            freeWifiFrontPageUI.a(dVar, aVar);
            j.b(this.jll.jlf, 32, "INVALID_HTTP_RESP_CODE");
        }
    }

    public final void j(Exception exception) {
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        a aVar;
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[]{m.E(this.jll.jlf.intent), Integer.valueOf(m.F(this.jll.jlf.intent)), exception.getMessage(), m.h(exception)});
        if (exception instanceof UnknownHostException) {
            j.b(this.jll.jlf, 102, m.g(exception));
            x.i("MicroMsg.FreeWifi.Protocol32", "countBlackHttpRequest=" + this.jlg);
            int i = this.jlg + 1;
            this.jlg = i;
            if (i <= 3) {
                try {
                    Thread.sleep(3000);
                    com.tencent.mm.plugin.freewifi.a.a.aOj();
                    com.tencent.mm.plugin.freewifi.a.a.a(this.jlk, this);
                    return;
                } catch (InterruptedException e) {
                    x.e("MicroMsg.FreeWifi.Protocol32", "InterruptedException e stacktrace=%s", new Object[]{m.h(exception)});
                    j.b(this.jll.jlf, 103, m.g(exception));
                    freeWifiFrontPageUI = this.jll.jlf.jkG;
                    dVar = d.jnj;
                    aVar = new a();
                    aVar.jmI = m.a(this.jll.jlf.jkI, b.jiI, 103);
                    freeWifiFrontPageUI.a(dVar, aVar);
                    return;
                }
            }
            freeWifiFrontPageUI = this.jll.jlf.jkG;
            dVar = d.jnj;
            aVar = new a();
            aVar.jmI = m.a(this.jll.jlf.jkI, b.jiI, m.i(exception));
            freeWifiFrontPageUI.a(dVar, aVar);
            j.b(this.jll.jlf, m.i(exception), m.g(exception));
            return;
        }
        freeWifiFrontPageUI = this.jll.jlf.jkG;
        dVar = d.jnj;
        aVar = new a();
        aVar.jmI = m.a(this.jll.jlf.jkI, b.jiI, m.i(exception));
        freeWifiFrontPageUI.a(dVar, aVar);
        j.b(this.jll.jlf, m.i(exception), m.g(exception));
    }

    private void Cd(String str) {
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("authUrl");
        String BR = m.BR(parse.getQueryParameter("extend"));
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackUrl returns 302 and now trying to  get authurl and extend from location. location=%s, authUrl=%s, extend=%s", new Object[]{m.E(this.jll.jlf.intent), Integer.valueOf(m.F(this.jll.jlf.intent)), str, queryParameter, BR});
        if (m.isEmpty(queryParameter)) {
            this.jli++;
            if (this.jli < 3) {
                com.tencent.mm.plugin.freewifi.a.a.aOj();
                com.tencent.mm.plugin.freewifi.a.a.a(str, this.jlj);
                return;
            }
            x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.E(this.jll.jlf.intent), Integer.valueOf(m.F(this.jll.jlf.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = this.jll.jlf.jkG;
            d dVar = d.jnj;
            a aVar = new a();
            aVar.jmI = m.a(this.jll.jlf.jkI, b.jiI, 36);
            freeWifiFrontPageUI.a(dVar, aVar);
            j.a(this.jll.jlf, 36, "BLACK_302_TIMES_EXCESS");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(queryParameter);
        if (queryParameter.indexOf("?") != -1) {
            stringBuilder.append("&extend=").append(BR);
        } else {
            stringBuilder.append("?extend=").append(BR);
        }
        stringBuilder.append("&openId=").append(m.BR(this.jll.jlf.openId)).append("&tid=").append(m.BR(this.jll.jlf.jle)).append("&timestamp=").append(this.jll.jlf.bJT).append("&sign=").append(this.jll.jlf.sign);
        j.aON().aOv().post(new j$3(this.jll.jlf, stringBuilder.toString()));
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. http authentication url = %s", new Object[]{m.E(this.jll.jlf.intent), Integer.valueOf(m.F(this.jll.jlf.intent)), stringBuilder.toString()});
    }
}
