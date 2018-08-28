package com.tencent.tencentmap.mapsdk.a;

import com.tencent.mm.plugin.appbrand.jsapi.f.m;
import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

class rk$1 extends Thread {
    private /* synthetic */ rk a;

    rk$1(rk rkVar) {
        this.a = rkVar;
    }

    public final void run() {
        rk.a(this.a, true);
        String str = "https://apikey.map.qq.com/mkey/index.php/mkey/check?";
        int i = 0;
        while (i < 2) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str + rk.a(this.a).toString()).openConnection();
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                if (httpURLConnection.getResponseCode() == m.CTRL_INDEX) {
                    String headerField = httpURLConnection.getHeaderField("Content-Encoding");
                    boolean z = headerField != null && headerField.length() > 0 && headerField.toLowerCase().contains("gzip");
                    rk.a(this.a, new String(rv.a(z ? new BufferedInputStream(new GZIPInputStream(httpURLConnection.getInputStream())) : new BufferedInputStream(httpURLConnection.getInputStream()))));
                    break;
                }
                continue;
                i++;
            } catch (Exception e) {
            }
        }
        rk.a(this.a, false);
    }
}
