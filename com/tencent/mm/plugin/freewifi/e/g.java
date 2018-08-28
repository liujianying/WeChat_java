package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;
import java.net.URL;

public final class g extends e implements a {
    private a jkN;
    private int jkO = 5;

    static /* synthetic */ void a(g gVar) {
        gVar.jkN = new a(gVar.ssid, gVar.jkG);
        gVar.jkN.a(new a.a() {
            public final void onSuccess() {
                x.i("MicroMsg.FreeWifi.ProtocolOne", "sessionKey=%s, step=%d, desc=Network. ", new Object[]{m.E(g.this.intent), Integer.valueOf(m.F(g.this.intent))});
                g.b(g.this);
            }

            public final void pT(int i) {
                g.this.aPj();
            }
        });
    }

    static /* synthetic */ void b(g gVar) {
        int i = gVar.jkO;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            x.i("MicroMsg.FreeWifi.ProtocolOne", "now retry count = %d", new Object[]{Integer.valueOf(i2)});
            String AH = com.tencent.mm.k.g.AU().AH();
            x.i("MicroMsg.FreeWifi.ProtocolOne", "get check url from cinfig : %s", new Object[]{AH});
            if (bi.oW(AH)) {
                x.i("MicroMsg.FreeWifi.ProtocolOne", "get check url from config failed, use the default url : %s", new Object[]{"http://10.1.0.6/redirect"});
                AH = "http://10.1.0.6/redirect";
            }
            String Cc = Cc(AH);
            x.i("MicroMsg.FreeWifi.ProtocolOne", "get location from url : %s, %s", new Object[]{AH, Cc});
            if (bi.oW(Cc)) {
                x.e("MicroMsg.FreeWifi.ProtocolOne", "get location from url failed : %s, %s", new Object[]{AH, Cc});
                try {
                    Thread.sleep(500);
                    i = i2;
                } catch (Exception e) {
                    i = i2;
                }
            } else {
                String cQ = cQ(Cc, "auth=");
                x.i("MicroMsg.FreeWifi.ProtocolOne", "get apauthmessage from location : %s, %s", new Object[]{cQ, Cc});
                if (bi.oW(cQ)) {
                    x.e("MicroMsg.FreeWifi.ProtocolOne", "get apauth message from location failed : %s", new Object[]{Cc});
                } else {
                    x.i("MicroMsg.FreeWifi.ProtocolOne", "get ap auth data : %s, url : %s, mac : %s", new Object[]{cQ, gVar.jkH, d.aOx()});
                    if (bi.oW(cQ)) {
                        gVar.aPj();
                        return;
                    } else {
                        new com.tencent.mm.plugin.freewifi.d.a(gVar.jkH, gVar.ssid, r3, "", cQ, "", gVar.bxk, m.E(gVar.intent)).b(new 3(gVar));
                        return;
                    }
                }
            }
        }
        gVar.aPj();
    }

    public g(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
    }

    public final void connect() {
        j.aON().aOv().post(new 1(this));
    }

    private void aPj() {
        this.jkG.a(FreeWifiFrontPageUI$d.FAIL, FreeWifiFrontPageUI$a.jnf);
    }

    static String cQ(String str, String str2) {
        if (bi.oW(str)) {
            x.e("MicroMsg.FreeWifi.ProtocolOne", "null or nil header");
            return null;
        }
        String[] split;
        String[] split2 = str.split("\\?");
        if (str2.length() > 0) {
            split = split2[1].split("&");
        } else {
            split = split2;
        }
        if (split == null || split.length <= 0) {
            return null;
        }
        for (String str3 : split) {
            if (str3.startsWith(str2)) {
                return str3.substring(str2.length());
            }
        }
        return null;
    }

    static String Cc(String str) {
        Exception e;
        HttpURLConnection httpURLConnection;
        Throwable th;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(30000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection2.getResponseCode();
                    x.i("MicroMsg.FreeWifi.ProtocolOne", "code : %d, location : %s", new Object[]{Integer.valueOf(responseCode), httpURLConnection2.getHeaderField("Location")});
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return r1;
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                    try {
                        x.e("MicroMsg.FreeWifi.ProtocolOne", "get recirect location failed : %s", new Object[]{e.getMessage()});
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return null;
        } catch (Exception e3) {
            e = e3;
            httpURLConnection = null;
            x.e("MicroMsg.FreeWifi.ProtocolOne", "get recirect location failed : %s", new Object[]{e.getMessage()});
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        } catch (Throwable th22) {
            th = th22;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}
