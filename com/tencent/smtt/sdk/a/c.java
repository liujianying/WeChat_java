package com.tencent.smtt.sdk.a;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.n;
import com.tencent.smtt.utils.s;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

final class c extends Thread {
    final /* synthetic */ Context a;
    final /* synthetic */ ThirdAppInfoNew b;

    c(String str, Context context, ThirdAppInfoNew thirdAppInfoNew) {
        this.a = context;
        this.b = thirdAppInfoNew;
        super(str);
    }

    public final void run() {
        if (VERSION.SDK_INT >= 8) {
            if (b.a == null) {
                try {
                    b.a = "65dRa93L".getBytes("utf-8");
                } catch (UnsupportedEncodingException e) {
                    b.a = null;
                    TbsLog.e("sdkreport", "Post failed -- get POST_DATA_KEY failed!");
                }
            }
            if (b.a == null) {
                TbsLog.e("sdkreport", "Post failed -- POST_DATA_KEY is null!");
                return;
            }
            String string = TbsDownloadConfig.getInstance(this.a).mPreferences.getString("tbs_deskey_token", "");
            String str = "";
            String str2 = "";
            if (TextUtils.isEmpty(string)) {
                string = str2;
            } else {
                str = string.substring(0, string.indexOf("&"));
                string = string.substring(string.indexOf("&") + 1, string.length());
            }
            boolean z = TextUtils.isEmpty(str) || str.length() != 96 || TextUtils.isEmpty(string) || string.length() != 24;
            try {
                JSONObject b;
                s a = s.a();
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(z ? a.b() + n.a().b() : a.f() + str).openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(20000);
                if (VERSION.SDK_INT > 13) {
                    httpURLConnection.setRequestProperty("Connection", "close");
                }
                try {
                    b = b.b(this.b, this.a);
                } catch (Exception e2) {
                    b = null;
                }
                if (b == null) {
                    TbsLog.e("sdkreport", "post -- jsonData is null!");
                    return;
                }
                try {
                    byte[] bytes = b.toString().getBytes("utf-8");
                    byte[] a2 = z ? n.a().a(bytes) : n.a(bytes, string);
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    httpURLConnection.setRequestProperty("Content-Length", String.valueOf(a2.length));
                    try {
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(a2);
                        outputStream.flush();
                        if (httpURLConnection.getResponseCode() != 200) {
                            TbsLog.e("sdkreport", "Post failed -- not 200");
                        }
                    } catch (Throwable th) {
                        TbsLog.e("sdkreport", "Post failed -- exceptions:" + th.getMessage());
                    }
                } catch (Throwable th2) {
                }
            } catch (IOException e3) {
                TbsLog.e("sdkreport", "Post failed -- IOException:" + e3);
            } catch (AssertionError e4) {
                TbsLog.e("sdkreport", "Post failed -- AssertionError:" + e4);
            } catch (NoClassDefFoundError e5) {
                TbsLog.e("sdkreport", "Post failed -- NoClassDefFoundError:" + e5);
            }
        }
    }
}
