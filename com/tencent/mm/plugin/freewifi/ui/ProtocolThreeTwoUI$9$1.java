package com.tencent.mm.plugin.freewifi.ui;

import android.net.Uri;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.9;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

class ProtocolThreeTwoUI$9$1 implements a {
    int jlg = 0;
    private final int jlh = 3;
    private int jli = 0;
    private a jlj = new 1(this);
    final /* synthetic */ String jlk;
    final /* synthetic */ 9 joD;

    ProtocolThreeTwoUI$9$1(9 9, String str) {
        this.joD = 9;
        this.jlk = str;
    }

    public final void g(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == HardCoderJNI.sHCDBDELAY_WRITE) {
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackurl returns 200 directly, so we believe that the device is already authenticated. Authentication ended.", m.E(this.joD.joB.getIntent()), Integer.valueOf(m.F(this.joD.joB.getIntent())));
            ProtocolThreeTwoUI.f(this.joD.joB);
        } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
            Cd(httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.E(this.joD.joB.getIntent()), Integer.valueOf(m.F(this.joD.joB.getIntent())));
            d.a(this.joD.joB.ssid, 3, this.joD.joB.getIntent());
            ProtocolThreeTwoUI.a(this.joD.joB, 32, "INVALID_HTTP_RESP_CODE");
        }
    }

    public final void j(Exception exception) {
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", m.E(this.joD.joB.getIntent()), Integer.valueOf(m.F(this.joD.joB.getIntent())), exception.getMessage());
        if (exception instanceof UnknownHostException) {
            ProtocolThreeTwoUI.a(this.joD.joB, 102, m.g(exception));
            int i = this.jlg + 1;
            this.jlg = i;
            if (i <= 3) {
                try {
                    Thread.sleep(3000);
                    com.tencent.mm.plugin.freewifi.a.a.aOj();
                    com.tencent.mm.plugin.freewifi.a.a.a(this.jlk, this);
                    return;
                } catch (InterruptedException e) {
                    return;
                }
            }
            d.a(this.joD.joB.ssid, 3, this.joD.joB.getIntent());
            ProtocolThreeTwoUI.a(this.joD.joB, 101, m.g(exception));
            return;
        }
        d.a(this.joD.joB.ssid, 3, this.joD.joB.getIntent());
        ProtocolThreeTwoUI.a(this.joD.joB, 101, m.g(exception));
    }

    private void Cd(String str) {
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("authUrl");
        String BR = m.BR(parse.getQueryParameter("extend"));
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackUrl returns 302 and now trying to  get authurl and extend from location. location=%s, authUrl=%s, extend=%s", m.E(this.joD.joB.getIntent()), Integer.valueOf(m.F(this.joD.joB.getIntent())), str, queryParameter, BR);
        if (m.isEmpty(queryParameter)) {
            this.jli++;
            if (this.jli < 3) {
                com.tencent.mm.plugin.freewifi.a.a.aOj();
                com.tencent.mm.plugin.freewifi.a.a.a(str, this.jlj);
                return;
            }
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Connection fail. Too many 302, exceeding 3 times", m.E(this.joD.joB.getIntent()), Integer.valueOf(m.F(this.joD.joB.getIntent())));
            d.a(this.joD.joB.ssid, 3, this.joD.joB.getIntent());
            ProtocolThreeTwoUI.a(this.joD.joB, 36, "BLACK_302_TIMES_EXCESS");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(queryParameter);
        if (queryParameter.indexOf("?") != -1) {
            stringBuilder.append("&extend=").append(BR);
        } else {
            stringBuilder.append("?extend=").append(BR);
        }
        stringBuilder.append("&openId=").append(m.BR(ProtocolThreeTwoUI.j(this.joD.joB))).append("&tid=").append(m.BR(ProtocolThreeTwoUI.i(this.joD.joB))).append("&timestamp=").append(ProtocolThreeTwoUI.h(this.joD.joB)).append("&sign=").append(ProtocolThreeTwoUI.g(this.joD.joB));
        ProtocolThreeTwoUI.a(this.joD.joB, stringBuilder.toString());
    }
}
