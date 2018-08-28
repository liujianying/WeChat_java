package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.ui.a.2.1.1;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

class a$2$1$1$1 implements Runnable {
    final /* synthetic */ String jiV;
    final /* synthetic */ String jjh;
    final /* synthetic */ String jji;
    final /* synthetic */ String jmq;
    final /* synthetic */ String jmr;
    final /* synthetic */ 1 jms;

    a$2$1$1$1(1 1, String str, String str2, String str3, String str4, String str5) {
        this.jms = 1;
        this.jmq = str;
        this.jjh = str2;
        this.jji = str3;
        this.jmr = str4;
        this.jiV = str5;
    }

    public final void run() {
        Exception e;
        Throwable th;
        x.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=it tries to ping. pingUrl= %s", new Object[]{this.jmq});
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(this.jmq);
            long currentTimeMillis = System.currentTimeMillis();
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(5000);
                    httpURLConnection2.setReadTimeout(5000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setRequestProperty("Pragma", "no-cache");
                    httpURLConnection2.setRequestProperty("Cache-Control", "no-cache");
                    int responseCode = httpURLConnection2.getResponseCode();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    h.mEJ.h(12907, new Object[]{this.jjh, this.jji, this.jmr, this.jiV, "", Long.valueOf(currentTimeMillis2), Integer.valueOf(responseCode), "", "", ""});
                    x.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=ping ended. http response code = %d, cost=%d ms", new Object[]{Integer.valueOf(responseCode), Long.valueOf(currentTimeMillis2)});
                    if (200 == responseCode) {
                        ah.A(new 1(this));
                    } else if (302 == responseCode) {
                        x.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=http response 302 location = %s", new Object[]{httpURLConnection2.getHeaderField("Location")});
                    }
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                } catch (Throwable th2) {
                    th = th2;
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
        } catch (Exception e3) {
            e = e3;
            try {
                Writer stringWriter = new StringWriter();
                e.printStackTrace(new PrintWriter(stringWriter));
                String stringWriter2 = stringWriter.toString();
                x.i("MicroMsg.FreeWifi.FreeWifiBanner", "ping encounter exception. " + stringWriter2);
                if (stringWriter2 == null) {
                    stringWriter2 = "";
                }
                h hVar = h.mEJ;
                Object[] objArr = new Object[10];
                objArr[0] = this.jjh;
                objArr[1] = this.jji;
                objArr[2] = this.jmr;
                objArr[3] = this.jiV;
                objArr[4] = "";
                objArr[5] = Integer.valueOf(0);
                objArr[6] = Integer.valueOf(0);
                objArr[7] = "";
                objArr[8] = "";
                if (stringWriter2.length() > 1024) {
                    stringWriter2 = stringWriter2.substring(0, 1024);
                }
                objArr[9] = stringWriter2;
                hVar.h(12907, objArr);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th3) {
                th = th3;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }
}
