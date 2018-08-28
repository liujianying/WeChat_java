package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.tencentmap.mapsdk.a.kz.b;
import java.io.Closeable;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

class kz$a extends AsyncTask<Context, Void, Boolean> {
    final /* synthetic */ kz a;

    private kz$a(kz kzVar) {
        this.a = kzVar;
    }

    /* renamed from: a */
    protected Boolean doInBackground(Context... contextArr) {
        Throwable th;
        HttpsURLConnection httpsURLConnection;
        int i;
        int i2 = 0;
        int a = kv.a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://confinfo.map.qq.com/confinfo?");
        stringBuilder.append("apiKey=");
        if (contextArr != null && contextArr.length > 0) {
            stringBuilder.append(kz.a(this.a, contextArr[0].getApplicationContext()));
        }
        Closeable inputStream;
        boolean z;
        try {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(stringBuilder.toString()).openConnection();
            try {
                httpsURLConnection2.setConnectTimeout(3000);
                httpsURLConnection2.connect();
                inputStream = httpsURLConnection2.getInputStream();
                try {
                    byte[] a2 = q.a(inputStream);
                    if (a2 == null || a2.length == 0) {
                        Boolean valueOf = Boolean.valueOf(false);
                        if (httpsURLConnection2 != null) {
                            httpsURLConnection2.disconnect();
                        }
                        if (inputStream != null) {
                            q.a(inputStream);
                        }
                        if (a != kv.a()) {
                            i2 = 1;
                        }
                        if (!(i2 == 0 || kz.a(this.a) == null)) {
                            kv.a(kz.a(this.a), a);
                            ll.a(kz.a(this.a)).a(1);
                        }
                        return valueOf;
                    }
                    int a3 = kz.a(this.a, new String(a2), a);
                    if (httpsURLConnection2 != null) {
                        httpsURLConnection2.disconnect();
                    }
                    if (inputStream != null) {
                        q.a(inputStream);
                    }
                    z = a3 != kv.a();
                    if (z && kz.a(this.a) != null) {
                        kv.a(kz.a(this.a), a3);
                        ll.a(kz.a(this.a)).a(1);
                    }
                    return Boolean.valueOf(z);
                } catch (Throwable th2) {
                    th = th2;
                    httpsURLConnection = httpsURLConnection2;
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    if (inputStream != null) {
                        q.a(inputStream);
                    }
                    if (a == kv.a()) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    kv.a(kz.a(this.a), a);
                    ll.a(kz.a(this.a)).a(1);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                httpsURLConnection = httpsURLConnection2;
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                if (inputStream != null) {
                    q.a(inputStream);
                }
                if (a == kv.a()) {
                    i = 1;
                } else {
                    i = 0;
                }
                kv.a(kz.a(this.a), a);
                ll.a(kz.a(this.a)).a(1);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            httpsURLConnection = null;
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
            if (inputStream != null) {
                q.a(inputStream);
            }
            if (a == kv.a()) {
                i = 0;
            } else {
                i = 1;
            }
            kv.a(kz.a(this.a), a);
            ll.a(kz.a(this.a)).a(1);
            throw th;
        }
    }

    /* renamed from: a */
    protected void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (kz.b(this.a) != null && kz.b(this.a).get() != null) {
            ((b) kz.b(this.a).get()).a(bool.booleanValue());
        }
    }
}
