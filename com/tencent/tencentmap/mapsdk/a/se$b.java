package com.tencent.tencentmap.mapsdk.a;

import android.os.AsyncTask;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

class se$b extends AsyncTask<String, Void, Boolean> {
    private WeakReference<se$a> a;
    private /* synthetic */ se b;

    public se$b(se seVar, se$a se_a) {
        this.b = seVar;
        this.a = new WeakReference(se_a);
    }

    private Boolean a(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strArr[0] + "&frontier=" + sy.a().b("")).openConnection();
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                if (httpURLConnection.getResponseCode() == 200) {
                    String headerField = httpURLConnection.getHeaderField("Content-Encoding");
                    boolean z = headerField != null && headerField.length() > 0 && headerField.toLowerCase().contains("gzip");
                    return Boolean.valueOf(se.a(this.b, new String(rv.a(z ? new GZIPInputStream(httpURLConnection.getInputStream()) : httpURLConnection.getInputStream()))));
                }
            } catch (Throwable th) {
            }
        }
        return Boolean.valueOf(false);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Boolean bool = (Boolean) obj;
        super.onPostExecute(bool);
        if (this.a != null && this.a.get() != null) {
            ((se$a) this.a.get()).b(bool.booleanValue());
        }
    }
}
