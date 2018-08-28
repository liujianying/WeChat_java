package com.tencent.tencentmap.mapsdk.a;

import java.net.HttpURLConnection;
import java.net.URL;

class sl$1 extends Thread {
    private /* synthetic */ sl a;

    sl$1(sl slVar) {
        this.a = slVar;
    }

    public final void run() {
        Throwable th;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        try {
            String str = Integer.toString(sl.c) + "," + Integer.toString(sl.d);
            String str2 = Integer.toString(sl.a) + "," + Integer.toString(sl.b);
            String str3 = Integer.toString(sl.e) + "," + Integer.toString(0);
            String str4 = Integer.toString(sl.f) + "," + Integer.toString(0);
            StringBuilder stringBuilder = new StringBuilder("https://pr.map.qq.com/pingd?");
            String str5 = (sl.a(this.a) == null || sl.a(this.a).c() == null) ? "" : sl.a(this.a).c() + "&";
            httpURLConnection2 = (HttpURLConnection) new URL(stringBuilder.append(str5).append("appid=sdk&logid=ditu&miss=").append(str).append("&hit=").append(str2).append("&keep=").append(str3).append("&change=").append(str4).toString()).openConnection();
            try {
                httpURLConnection2.setRequestMethod("GET");
                httpURLConnection2.connect();
                if (httpURLConnection2.getResponseCode() == 200) {
                    httpURLConnection2.getInputStream();
                    sl.c = 0;
                    sl.d = 0;
                    sl.a = 0;
                    sl.b = 0;
                    sl.e = 0;
                    sl.f = 0;
                    sl.g = 0;
                    sl.b = 0;
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Exception e) {
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnection2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Exception e2) {
            httpURLConnection2 = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}
