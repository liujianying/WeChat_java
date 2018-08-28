package com.tencent.qqvideo.proxy.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqvideo.proxy.httpproxy.HttpproxyFacade;
import com.tencent.smtt.sdk.TbsReaderView$ReaderCallback;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigStorage {
    private static String Config_Version = "";
    private static final long GET_CONFIG_INTERVAL = 600000;
    private static long LastGetConfigTime = 0;
    private static final String PREFERENCE = "_httpproxy_preferences";
    public static final String PREF_DOWNPROXY_CONFIG = "DOWNPROXY_CONFIG";
    public static final String PREF_DOWNPROXY_CONFIG_VERSION = "DOWNPROXY_GUID_CONFIG_VERSION";
    private static String TAG = "TV_Httpproxy";
    private static final String TVHttpProxy_Version = "V1.0.186.0011";
    private static final String TVHttpProxy_Version_Code = "101860011";
    private static final String TVHttpProxy_channel_id = "186";
    private static final int[] connectTimeOut = new int[]{TbsReaderView$ReaderCallback.GET_BAR_ANIMATING, TbsReaderView$ReaderCallback.GET_BAR_ANIMATING, 10000};
    private static String guid = "123";
    private static final String httpsCrtFileName = "videosdkcrt/sec.video.qq.com.crt";
    private static final String ipflag = "1";
    private static final String otype = "json";
    private static final String platform = "aphone";
    private static final int[] readTimeOut = new int[]{10000, 10000, 15000};
    private static final int[] retryTimes = new int[]{3, 2};
    private static String sharedPreferencesName = null;
    private static final String url = "https://sec.video.qq.com/p/wxconf/getmfomat";
    private Thread thread = null;

    public static SharedPreferences getSharedPreferences(Context context, String str, int i) {
        return context.getSharedPreferences(str, i);
    }

    public static SharedPreferences getAppSharedPreferences(Context context) {
        if (sharedPreferencesName == null) {
            sharedPreferencesName = context.getPackageName() + PREFERENCE;
        }
        return getSharedPreferences(context, sharedPreferencesName, 0);
    }

    public static String getDownProxyConfig(Context context) {
        if (context == null) {
            return "";
        }
        Config_Version = getConfigVersionFromSharedPreference(context);
        return getAppSharedPreferences(context).getString(PREF_DOWNPROXY_CONFIG, "");
    }

    public static void setDownProxyConfig(Context context, String str) {
        getAppSharedPreferences(context).edit().putString(PREF_DOWNPROXY_CONFIG, str).commit();
    }

    public static String getHttpProxyVersion() {
        return TVHttpProxy_Version;
    }

    public static String getHttpProxyVersionCode() {
        return TVHttpProxy_Version_Code;
    }

    public static String getConfigVersion() {
        return Config_Version;
    }

    private static String getConfigVersionFromSharedPreference(Context context) {
        if (context == null) {
            return "";
        }
        return getAppSharedPreferences(context).getString(PREF_DOWNPROXY_CONFIG_VERSION, "");
    }

    private static void setConfigVersionToSharedPreference(Context context, String str) {
        if (context != null && str != null) {
            getAppSharedPreferences(context).edit().putString(PREF_DOWNPROXY_CONFIG_VERSION, str).commit();
        }
    }

    public void synGetServerConfig(Context context) {
        if (context == null) {
            HttpproxyFacade.print(6, TAG, "synGetServerConfig context is null");
            return;
        }
        try {
            this.thread = new Thread(new 1(this, context));
            if (this.thread == null) {
                HttpproxyFacade.print(6, TAG, "thread create failed");
            } else {
                this.thread.start();
            }
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "thread create exception");
        }
    }

    public void stopGetServerConfig() {
        try {
            if (this.thread != null) {
                this.thread.interrupt();
            }
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "thread create exception");
        }
    }

    private boolean needGetConfig() {
        if (LastGetConfigTime == 0) {
            LastGetConfigTime = System.currentTimeMillis();
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - LastGetConfigTime <= GET_CONFIG_INTERVAL && currentTimeMillis >= LastGetConfigTime) {
            return false;
        }
        LastGetConfigTime = System.currentTimeMillis();
        return true;
    }

    private void synGetConfig(Context context) {
        if (needGetConfig()) {
            int i = -1;
            try {
                JSONObject jSONObject = new JSONObject(fetchTextFromUrl(makeGetServerConfigUrl(context), context));
                if (jSONObject.has("httpproxy_config")) {
                    i = 0;
                    HttpproxyFacade.print(3, TAG, "get httpproxy_config:" + jSONObject.getString("httpproxy_config"));
                    setDownProxyConfig(context, jSONObject.getString("httpproxy_config"));
                }
                if (jSONObject.has("config_ver")) {
                    setConfigVersionToSharedPreference(context, jSONObject.getString("config_ver"));
                }
            } catch (Throwable th) {
                HttpproxyFacade.print(6, TAG, "get config exception");
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("error_code", i);
                jSONObject2.put("report_type", 90);
                HttpproxyFacade.jsonReport(jSONObject2.toString());
                return;
            } catch (JSONException e) {
                return;
            }
        }
        HttpproxyFacade.print(4, TAG, "last get config time:" + System.currentTimeMillis() + ",so get config just return");
    }

    private String makeGetServerConfigUrl(Context context) {
        return String.format("%s?platform=%s&appver=%s&player_channel_id=%s&otype=%s&ipflag=%s&guid=%s", new Object[]{url, platform, TVHttpProxy_Version, TVHttpProxy_channel_id, otype, "1", guid});
    }

    private SSLContext getHttpsSSLContext(Context context) {
        Throwable th;
        InputStream open;
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            open = context.getAssets().open(httpsCrtFileName);
            try {
                Certificate generateCertificate = instance.generateCertificate(open);
                KeyStore instance2 = KeyStore.getInstance(KeyStore.getDefaultType());
                instance2.load(null, null);
                instance2.setCertificateEntry("ca", generateCertificate);
                TrustManagerFactory instance3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance3.init(instance2);
                SSLContext instance4 = SSLContext.getInstance("TLS");
                instance4.init(null, instance3.getTrustManagers(), null);
                if (open == null) {
                    return instance4;
                }
                try {
                    open.close();
                    return instance4;
                } catch (IOException e) {
                    return instance4;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    HttpproxyFacade.print(6, TAG, "getHttpsSSLContext unknow exception:" + Log.getStackTraceString(th));
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e2) {
                        }
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            open = null;
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e32) {
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String fetchTextFromUrl(java.lang.String r17, android.content.Context r18) {
        /*
        r16 = this;
        r0 = r16;
        r1 = r18;
        r9 = r0.getHttpsSSLContext(r1);
        r6 = 0;
        r3 = 0;
        if (r9 != 0) goto L_0x0010;
    L_0x000c:
        r2 = "";
    L_0x000f:
        return r2;
    L_0x0010:
        r2 = 0;
        r8 = r2;
    L_0x0012:
        r2 = 2;
        if (r8 < r2) goto L_0x0019;
    L_0x0015:
        r2 = "";
        goto L_0x000f;
    L_0x0019:
        r2 = 1;
        if (r8 != r2) goto L_0x016f;
    L_0x001c:
        r2 = r16.getBkDomain(r17);
        r4 = 4;
        r5 = TAG;
        r7 = new java.lang.StringBuilder;
        r10 = "请求备份域名:";
        r7.<init>(r10);
        r7 = r7.append(r2);
        r7 = r7.toString();
        com.tencent.qqvideo.proxy.httpproxy.HttpproxyFacade.print(r4, r5, r7);
        r7 = r2;
    L_0x0037:
        r2 = 0;
        r4 = r2;
        r5 = r3;
    L_0x003a:
        r2 = retryTimes;
        r2 = r2[r8];
        if (r4 < r2) goto L_0x0045;
    L_0x0040:
        r2 = r8 + 1;
        r8 = r2;
        r3 = r5;
        goto L_0x0012;
    L_0x0045:
        r2 = 4;
        r3 = TAG;	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r10 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r11 = " 第";
        r10.<init>(r11);	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r11 = r4 + 1;
        r10 = r10.append(r11);	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r11 = " 次CGI请求:";
        r10 = r10.append(r11);	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r10 = r10.append(r7);	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r10 = r10.toString();	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        com.tencent.qqvideo.proxy.httpproxy.HttpproxyFacade.print(r2, r3, r10);	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r2 = new java.net.URL;	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r2.<init>(r7);	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r2 = r2.openConnection();	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r2 = (javax.net.ssl.HttpsURLConnection) r2;	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r3 = connectTimeOut;	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r3 = r3[r4];	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r2.setConnectTimeout(r3);	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r3 = readTimeOut;	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r3 = r3[r4];	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r2.setReadTimeout(r3);	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r3 = r9.getSocketFactory();	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r2.setSSLSocketFactory(r3);	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r3 = r2.getInputStream();	 Catch:{ IOException -> 0x0168, Throwable -> 0x0161, all -> 0x015a }
        r6 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x016c, Throwable -> 0x0165, all -> 0x015e }
        r6.<init>();	 Catch:{ IOException -> 0x016c, Throwable -> 0x0165, all -> 0x015e }
        r2 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x016c, Throwable -> 0x0165, all -> 0x015e }
        r12 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x016c, Throwable -> 0x0165, all -> 0x015e }
        r13 = "utf-8";
        r12.<init>(r3, r13);	 Catch:{ IOException -> 0x016c, Throwable -> 0x0165, all -> 0x015e }
        r2.<init>(r12);	 Catch:{ IOException -> 0x016c, Throwable -> 0x0165, all -> 0x015e }
    L_0x00a2:
        r5 = r2.readLine();	 Catch:{ IOException -> 0x00f2, Throwable -> 0x011b }
        if (r5 != 0) goto L_0x00ee;
    L_0x00a8:
        r5 = r6.toString();	 Catch:{ IOException -> 0x00f2, Throwable -> 0x011b }
        r6 = 4;
        r12 = TAG;	 Catch:{ IOException -> 0x00f2, Throwable -> 0x011b }
        r13 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00f2, Throwable -> 0x011b }
        r14 = "【connect】连接时间：";
        r13.<init>(r14);	 Catch:{ IOException -> 0x00f2, Throwable -> 0x011b }
        r14 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x00f2, Throwable -> 0x011b }
        r10 = r14 - r10;
        r10 = r13.append(r10);	 Catch:{ IOException -> 0x00f2, Throwable -> 0x011b }
        r11 = "返回数据：";
        r10 = r10.append(r11);	 Catch:{ IOException -> 0x00f2, Throwable -> 0x011b }
        r10 = r10.append(r5);	 Catch:{ IOException -> 0x00f2, Throwable -> 0x011b }
        r10 = r10.toString();	 Catch:{ IOException -> 0x00f2, Throwable -> 0x011b }
        com.tencent.qqvideo.proxy.httpproxy.HttpproxyFacade.print(r6, r12, r10);	 Catch:{ IOException -> 0x00f2, Throwable -> 0x011b }
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ IOException -> 0x00f2, Throwable -> 0x011b }
        if (r6 != 0) goto L_0x013f;
    L_0x00d9:
        r6 = r5.trim();	 Catch:{ IOException -> 0x00f2, Throwable -> 0x011b }
        r6 = r6.isEmpty();	 Catch:{ IOException -> 0x00f2, Throwable -> 0x011b }
        if (r6 != 0) goto L_0x013f;
    L_0x00e3:
        if (r3 == 0) goto L_0x00e8;
    L_0x00e5:
        r3.close();	 Catch:{ IOException -> 0x014a }
    L_0x00e8:
        r2.close();	 Catch:{ IOException -> 0x014c }
    L_0x00eb:
        r2 = r5;
        goto L_0x000f;
    L_0x00ee:
        r6.append(r5);	 Catch:{ IOException -> 0x00f2, Throwable -> 0x011b }
        goto L_0x00a2;
    L_0x00f2:
        r5 = move-exception;
    L_0x00f3:
        r5 = 6;
        r6 = TAG;	 Catch:{ all -> 0x0132 }
        r10 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0132 }
        r11 = "IO Exception";
        r10.<init>(r11);	 Catch:{ all -> 0x0132 }
        r11 = java.lang.System.err;	 Catch:{ all -> 0x0132 }
        r10 = r10.append(r11);	 Catch:{ all -> 0x0132 }
        r10 = r10.toString();	 Catch:{ all -> 0x0132 }
        com.tencent.qqvideo.proxy.httpproxy.HttpproxyFacade.print(r5, r6, r10);	 Catch:{ all -> 0x0132 }
        if (r3 == 0) goto L_0x0110;
    L_0x010d:
        r3.close();	 Catch:{ IOException -> 0x014e }
    L_0x0110:
        if (r2 == 0) goto L_0x0115;
    L_0x0112:
        r2.close();	 Catch:{ IOException -> 0x0150 }
    L_0x0115:
        r4 = r4 + 1;
        r5 = r2;
        r6 = r3;
        goto L_0x003a;
    L_0x011b:
        r5 = move-exception;
    L_0x011c:
        r5 = 6;
        r6 = TAG;	 Catch:{ all -> 0x0132 }
        r10 = "unknow exception";
        com.tencent.qqvideo.proxy.httpproxy.HttpproxyFacade.print(r5, r6, r10);	 Catch:{ all -> 0x0132 }
        if (r3 == 0) goto L_0x012a;
    L_0x0127:
        r3.close();	 Catch:{ IOException -> 0x0152 }
    L_0x012a:
        if (r2 == 0) goto L_0x0115;
    L_0x012c:
        r2.close();	 Catch:{ IOException -> 0x0130 }
        goto L_0x0115;
    L_0x0130:
        r5 = move-exception;
        goto L_0x0115;
    L_0x0132:
        r4 = move-exception;
        r5 = r2;
    L_0x0134:
        if (r3 == 0) goto L_0x0139;
    L_0x0136:
        r3.close();	 Catch:{ IOException -> 0x0154 }
    L_0x0139:
        if (r5 == 0) goto L_0x013e;
    L_0x013b:
        r5.close();	 Catch:{ IOException -> 0x0156 }
    L_0x013e:
        throw r4;
    L_0x013f:
        if (r3 == 0) goto L_0x0144;
    L_0x0141:
        r3.close();	 Catch:{ IOException -> 0x0158 }
    L_0x0144:
        r2.close();	 Catch:{ IOException -> 0x0148 }
        goto L_0x0115;
    L_0x0148:
        r5 = move-exception;
        goto L_0x0115;
    L_0x014a:
        r3 = move-exception;
        goto L_0x00e8;
    L_0x014c:
        r2 = move-exception;
        goto L_0x00eb;
    L_0x014e:
        r5 = move-exception;
        goto L_0x0110;
    L_0x0150:
        r5 = move-exception;
        goto L_0x0115;
    L_0x0152:
        r5 = move-exception;
        goto L_0x012a;
    L_0x0154:
        r2 = move-exception;
        goto L_0x0139;
    L_0x0156:
        r2 = move-exception;
        goto L_0x013e;
    L_0x0158:
        r5 = move-exception;
        goto L_0x0144;
    L_0x015a:
        r2 = move-exception;
        r4 = r2;
        r3 = r6;
        goto L_0x0134;
    L_0x015e:
        r2 = move-exception;
        r4 = r2;
        goto L_0x0134;
    L_0x0161:
        r2 = move-exception;
        r2 = r5;
        r3 = r6;
        goto L_0x011c;
    L_0x0165:
        r2 = move-exception;
        r2 = r5;
        goto L_0x011c;
    L_0x0168:
        r2 = move-exception;
        r2 = r5;
        r3 = r6;
        goto L_0x00f3;
    L_0x016c:
        r2 = move-exception;
        r2 = r5;
        goto L_0x00f3;
    L_0x016f:
        r7 = r17;
        goto L_0x0037;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqvideo.proxy.common.ConfigStorage.fetchTextFromUrl(java.lang.String, android.content.Context):java.lang.String");
    }

    private String getBkDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }
}
