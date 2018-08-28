package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.map.lib.gl.model.GLIcon;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

public class kq$a implements jg {
    private final WeakReference<kq> a;
    private byte[] b = null;

    public kq$a(kq kqVar) {
        this.a = new WeakReference(kqVar);
    }

    public byte[] a(String str) {
        Closeable closeable;
        Throwable th;
        HttpURLConnection httpURLConnection;
        if (this.a == null || this.a.get() == null) {
            return null;
        }
        if (!kq.a((kq) this.a.get()).a(str)) {
            return null;
        }
        if (str != null) {
            str = str.replace("/mvd_map", jy.b()).replace("/mobile_newmap", jy.b());
        }
        String a = jy.a(str);
        int i = (a.contains("styleid") && a.contains("scene") && a.contains("version")) ? 1 : 0;
        if (i == 0) {
            String str2;
            if (a.endsWith(".jpg") || a.startsWith("http://closedroadvector.map.qq.com") || a.startsWith("http://p0.map.gtimg.com/scenic/")) {
                str2 = a;
            } else {
                str2 = a + kh.c(kq.b((kq) this.a.get()));
            }
            try {
                po a2 = pn.a().a(str2, "androidsdk");
                if (a2 == null) {
                    return null;
                }
                if (!a.contains("qt=rtt")) {
                    kq.a((kq) this.a.get()).b(a);
                }
                if (a.startsWith("http://p0.map.gtimg.com/scenic/") && a2.a != null && a2.a.length == 0) {
                    if (this.b == null) {
                        Bitmap createBitmap = Bitmap.createBitmap(GLIcon.TOP, GLIcon.TOP, Config.ARGB_8888);
                        new Canvas(createBitmap).drawARGB(0, 255, 255, 255);
                        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        createBitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        this.b = byteArrayOutputStream.toByteArray();
                    }
                    a2.a = this.b;
                }
                return a2.a;
            } catch (Exception e) {
                return null;
            }
        }
        HttpURLConnection httpURLConnection2;
        Closeable inputStream;
        try {
            httpURLConnection2 = (HttpURLConnection) new URL(a).openConnection();
            try {
                httpURLConnection2.addRequestProperty("User-Agent", "androidsdk");
                httpURLConnection2.setConnectTimeout(10000);
                if (httpURLConnection2.getResponseCode() == 200) {
                    inputStream = httpURLConnection2.getInputStream();
                    try {
                        byte[] a3 = q.a(inputStream);
                        if (!a.contains("qt=rtt")) {
                            kq.a((kq) this.a.get()).b(a);
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        if (inputStream != null) {
                            q.a(inputStream);
                        }
                        return a3;
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (inputStream != null) {
                            q.a(inputStream);
                        }
                        throw th;
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                httpURLConnection = httpURLConnection2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (inputStream != null) {
                    q.a(inputStream);
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (inputStream != null) {
                q.a(inputStream);
            }
            throw th;
        }
    }
}
