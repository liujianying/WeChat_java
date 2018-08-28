package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.net.HttpURLConnection;
import java.net.URL;

class sg$1 extends Thread {
    private /* synthetic */ String a;
    private /* synthetic */ String b;
    private /* synthetic */ sg c;

    sg$1(sg sgVar, String str, String str2) {
        this.c = sgVar;
        this.a = str;
        this.b = str2;
    }

    public final void run() {
        Throwable th;
        HttpURLConnection httpURLConnection;
        super.run();
        HttpURLConnection httpURLConnection2;
        try {
            httpURLConnection2 = (HttpURLConnection) new URL(this.a).openConnection();
            try {
                httpURLConnection2.setConnectTimeout(3000);
                if (httpURLConnection2.getResponseCode() == 200) {
                    Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection2.getInputStream());
                    if (decodeStream != null) {
                        sg.c().put(this.b, decodeStream);
                    }
                    if (sg.a(this.c).get() != null) {
                        ((sl) sg.a(this.c).get()).b(decodeStream);
                    }
                    sg.a(this.c, this.b, decodeStream);
                }
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
