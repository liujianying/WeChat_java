package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.a.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public final class i {

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.i$2 */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ a qTs;

        AnonymousClass2(a aVar) {
            this.qTs = aVar;
        }

        public final void run() {
            this.qTs.boB();
        }
    }

    public static void a(final a aVar) {
        au.Em().H(new Runnable() {
            public final void run() {
                try {
                    a aVar = aVar;
                    x.i("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount]");
                    au.HU();
                    String str = (String) c.DT().get(-1535680990, "");
                    au.HU();
                    long longValue = new o(bi.f((Integer) c.DT().get(9, null))).longValue();
                    if (bi.oW(str) || longValue == 0) {
                        au.HU();
                        c.DT().a(a.sPF, Integer.valueOf(-1));
                        x.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadEmailCountAndSet: authkey or uin is null]");
                        ah.A(new AnonymousClass2(aVar));
                        return;
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://qqmail.weixin.qq.com/cgi-bin/getunreadmailcount?f=xml&appname=qqmail_weixin&charset=utf-8&clientip=0").openConnection();
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setReadTimeout(20000);
                    httpURLConnection.setRequestProperty("Cookie", String.format("skey=%s;uin=o%d;", new Object[]{str, Long.valueOf(longValue)}));
                    if (httpURLConnection.getResponseCode() >= 300) {
                        httpURLConnection.disconnect();
                        x.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount http 300]");
                        ah.A(new 3(aVar));
                        return;
                    }
                    Map z = bl.z(bi.convertStreamToString(httpURLConnection.getInputStream()), "Response");
                    int i = (z == null || bi.getInt((String) z.get(".Response.error.code"), -1) != 0) ? -1 : bi.getInt((String) z.get(".Response.result.UnreadCount"), -1);
                    if (i < 0) {
                        ah.A(new 4(aVar));
                        return;
                    }
                    au.HU();
                    c.DT().a(a.sPF, Integer.valueOf(i));
                    ah.A(new 5(aVar, i));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.QQMailUnreadHelper", e, "", new Object[0]);
                    x.e("MicroMsg.QQMailUnreadHelper", "getUnreadCountAsync exception");
                }
            }
        });
    }
}
