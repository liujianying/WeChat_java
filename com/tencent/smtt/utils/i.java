package com.tencent.smtt.utils;

import com.tencent.smtt.utils.d.a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

final class i extends Thread {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    i(String str, a aVar) {
        this.a = str;
        this.b = aVar;
    }

    public final void run() {
        Throwable e;
        InputStream inputStream;
        OutputStream d;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://soft.tbs.imtt.qq.com/17421/tbs_res_imtt_tbs_DebugPlugin_DebugPlugin.tbs").openConnection();
            int contentLength = httpURLConnection.getContentLength();
            httpURLConnection.setConnectTimeout(Downloads.MIN_RETYR_AFTER);
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            try {
                d = j.d(new File(this.a));
                try {
                    byte[] bArr = new byte[8192];
                    int i = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        i += read;
                        d.write(bArr, 0, read);
                        this.b.a((i * 100) / contentLength);
                    }
                    this.b.a();
                    try {
                        inputStream.close();
                    } catch (Exception e2) {
                    }
                    d.close();
                } catch (Exception e3) {
                    e = e3;
                    try {
                        this.b.a(e);
                        try {
                            inputStream.close();
                        } catch (Exception e4) {
                        }
                        try {
                            d.close();
                        } catch (Exception e5) {
                        }
                    } catch (Throwable th) {
                        e = th;
                        try {
                            inputStream.close();
                        } catch (Exception e6) {
                        }
                        try {
                            d.close();
                        } catch (Exception e7) {
                        }
                        throw e;
                    }
                }
            } catch (Exception e8) {
                e = e8;
                d = null;
                this.b.a(e);
                inputStream.close();
                d.close();
            } catch (Throwable th2) {
                e = th2;
                d = null;
                inputStream.close();
                d.close();
                throw e;
            }
        } catch (Exception e9) {
            e = e9;
            d = null;
            inputStream = null;
        } catch (Throwable th3) {
            e = th3;
            d = null;
            inputStream = null;
            inputStream.close();
            d.close();
            throw e;
        }
    }
}
