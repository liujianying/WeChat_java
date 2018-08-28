package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;

public class fw {
    public static String a = "nonetwork";
    public static String b = "";
    public static volatile boolean c = false;
    private static final String d = fw.class.getSimpleName();
    private static String e = "cmwap";
    private static String f = "3gwap";
    private static String g = "uniwap";
    private static String h = "ctwap";
    private static String i = TencentExtraKeys.LOCATION_SOURCE_WIFI;
    private static Context j;
    private static volatile boolean k = true;
    private static String l = "";
    private static String m = "";
    private static volatile int n = 0;
    private static int o = 0;
    private static String p = "";

    public static synchronized String a() {
        String str;
        synchronized (fw.class) {
            switch (n) {
                case 1:
                    str = "ssid_" + l + m;
                    break;
                case 2:
                case 3:
                    str = "apn_" + b;
                    break;
                case 4:
                    str = "4Gapn_" + b;
                    break;
                default:
                    str = "unknown";
                    break;
            }
        }
        return str;
    }

    public static void a(Context context) {
        try {
            j = context;
            b();
            i();
        } catch (Throwable th) {
        }
    }

    public static void a(HttpClient httpClient) {
        if (!c || TextUtils.isEmpty(p)) {
            httpClient.getParams().setParameter("http.route.default-proxy", null);
            return;
        }
        httpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(p, 80));
        fx.a(d, "setProxy... sProxyAddress:" + p + ",apn:" + b);
    }

    public static synchronized boolean a(Integer num) {
        boolean z = true;
        synchronized (fw.class) {
            if (!(num.intValue() == 1 || num.intValue() == 2 || num.intValue() == 3)) {
                z = false;
            }
        }
        return z;
    }

    public static synchronized void b() {
        synchronized (fw.class) {
            try {
                fx.b(d, "updateApn");
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) j.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    b = "";
                    n = 0;
                    c = false;
                    p = "";
                    k = false;
                    b = a;
                } else {
                    if (activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                        k = true;
                    } else {
                        k = false;
                        b = a;
                    }
                    int type = activeNetworkInfo.getType();
                    if (type == 1) {
                        n = 1;
                        c = false;
                        p = "";
                        WifiInfo connectionInfo = ((WifiManager) j.getSystemService(TencentExtraKeys.LOCATION_SOURCE_WIFI)).getConnectionInfo();
                        l = connectionInfo.getSSID();
                        m = connectionInfo.getBSSID();
                        b = i;
                    } else {
                        String extraInfo = activeNetworkInfo.getExtraInfo();
                        if (extraInfo == null) {
                            b = "";
                            n = 0;
                            c = false;
                            p = "";
                        } else {
                            b = extraInfo.trim().toLowerCase();
                            if (type == 0) {
                                int subtype = activeNetworkInfo.getSubtype();
                                if (subtype == 1 || subtype == 2 || subtype == 4) {
                                    n = 2;
                                } else if (subtype == 13) {
                                    n = 4;
                                } else {
                                    n = 3;
                                }
                            }
                            o = j().intValue();
                            if (b.contains(f)) {
                                c = true;
                                p = "10.0.0.172";
                            } else if (b.contains(e)) {
                                c = true;
                                p = "10.0.0.172";
                            } else if (b.contains(g)) {
                                c = true;
                                p = "10.0.0.172";
                            } else if (b.contains(h)) {
                                c = true;
                                p = "10.0.0.200";
                            } else {
                                c = false;
                                p = "";
                            }
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    public static synchronized int c() {
        int i;
        synchronized (fw.class) {
            i = n;
        }
        return i;
    }

    public static synchronized int d() {
        int i;
        synchronized (fw.class) {
            i = o;
        }
        return i;
    }

    public static boolean e() {
        return k;
    }

    public static boolean f() {
        return n == 1;
    }

    public static boolean g() {
        return n == 2;
    }

    public static boolean h() {
        return n == 3;
    }

    private static synchronized void i() {
        synchronized (fw.class) {
            fx.b(d, "showApnInfo... Apn:" + b + ",sIsNetworkOk:" + k + ",sNetType:" + n + ",sIsProxy:" + c + ",sProxyAddress:" + p);
        }
    }

    private static synchronized Integer j() {
        Integer valueOf;
        int i = 3;
        int i2 = 2;
        int i3 = 1;
        synchronized (fw.class) {
            if (n == 1) {
                String str = l;
                if (str == null || str.length() <= 0) {
                    valueOf = Integer.valueOf(0);
                } else {
                    str = str.toLowerCase();
                    if (!str.contains("cmcc")) {
                        i3 = 0;
                    }
                    if (!str.contains("chinanet")) {
                        i = i3;
                    }
                    if (!str.contains("chinaunicom")) {
                        i2 = i;
                    }
                    valueOf = Integer.valueOf(i2);
                }
                o = valueOf.intValue();
            } else if (n == 2 || n == 3) {
                String simOperator;
                Context context = j;
                String str2 = b;
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null && telephonyManager.getSimState() == 5) {
                    simOperator = telephonyManager.getSimOperator();
                    if (simOperator.length() > 0) {
                        if (simOperator.equals("46000") || simOperator.equals("46002")) {
                            valueOf = Integer.valueOf(1);
                            o = valueOf.intValue();
                        } else {
                            if (simOperator.equals("46001")) {
                                valueOf = Integer.valueOf(2);
                            } else if (simOperator.equals("46003")) {
                                valueOf = Integer.valueOf(3);
                            }
                            o = valueOf.intValue();
                        }
                    }
                }
                if (str2 != null) {
                    simOperator = str2.toLowerCase();
                    if (simOperator.contains("cmnet") || simOperator.contains("cmwap")) {
                        valueOf = Integer.valueOf(1);
                        o = valueOf.intValue();
                    } else if (simOperator.contains("uninet") || simOperator.contains("uniwap") || simOperator.contains("3gnet") || simOperator.contains("3gwap")) {
                        valueOf = Integer.valueOf(2);
                        o = valueOf.intValue();
                    } else if (simOperator.contains("ctnet") || simOperator.contains("ctwap")) {
                        valueOf = Integer.valueOf(3);
                        o = valueOf.intValue();
                    }
                }
                valueOf = Integer.valueOf(0);
                o = valueOf.intValue();
            } else {
                o = 0;
            }
            valueOf = Integer.valueOf(o);
        }
        return valueOf;
    }
}
