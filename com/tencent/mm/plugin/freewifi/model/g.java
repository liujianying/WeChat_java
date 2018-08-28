package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;
import java.net.URL;

public final class g {
    int jjT = 5;

    static /* synthetic */ void b(String str, int i, Intent intent) {
        x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "update ssid  : %s to new state : %d", new Object[]{str, Integer.valueOf(i)});
        if (i == 3) {
            x.e("MicroMsg.FreeWifi.FreeWifiNetwork", "new state is connect failed, update local freewifiinfo expired time to now");
            c Cf = j.aOK().Cf(str);
            if (Cf != null) {
                Cf.field_expiredTime = bi.VE() - 10;
                boolean c = j.aOK().c(Cf, new String[0]);
                x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "update local freewifi info expired time : ssid is : %s, now time is : %d, update ret : %b", new Object[]{str, Long.valueOf(Cf.field_expiredTime), Boolean.valueOf(c)});
            }
        }
        d.a(str, i, intent);
    }

    static /* synthetic */ String cP(String str, String str2) {
        if (bi.oW(str)) {
            x.e("MicroMsg.FreeWifi.FreeWifiNetwork", "null or nil header");
        } else {
            String[] split = str.split("\\?");
            String[] split2 = str2.length() > 0 ? split[1].split("&") : split;
            if (split2 != null && split2.length > 0) {
                for (String str3 : split2) {
                    if (str3.startsWith(str2)) {
                        return str3.substring(str2.length());
                    }
                }
            }
        }
        return null;
    }

    static String Cc(String str) {
        Exception e;
        HttpURLConnection httpURLConnection;
        Throwable th;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(30000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection2.getResponseCode();
                    x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "code : %d, location : %s", new Object[]{Integer.valueOf(responseCode), httpURLConnection2.getHeaderField("Location")});
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return r1;
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                    try {
                        x.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get recirect location failed : %s", new Object[]{e.getMessage()});
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
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
            return null;
        } catch (Exception e3) {
            e = e3;
            httpURLConnection = null;
            x.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get recirect location failed : %s", new Object[]{e.getMessage()});
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        } catch (Throwable th22) {
            th = th22;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}
