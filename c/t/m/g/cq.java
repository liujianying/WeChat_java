package c.t.m.g;

import android.content.Context;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocationManager;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

final class cq {
    private static SimpleDateFormat a = null;
    private static String b = null;
    private static String c = null;
    private static String d = null;

    private static synchronized String a(long j, String str) {
        String str2;
        synchronized (cq.class) {
            if (TextUtils.isEmpty(str)) {
                str = "yyyy-MM-dd HH:mm:ss";
            }
            if (a == null) {
                a = new SimpleDateFormat(str, Locale.CHINA);
            } else {
                a.applyPattern(str);
            }
            if (j <= 0) {
                j = System.currentTimeMillis();
            }
            if (a == null) {
                str2 = "NULL";
            } else {
                str2 = a.format(Long.valueOf(j));
            }
        }
        return str2;
    }

    private static String a(ct ctVar) {
        String c = ej.c(ctVar);
        if (c != null) {
            try {
                JSONObject jSONObject = new JSONObject(c);
                c = jSONObject.optString("mac").replace(":", "").toLowerCase();
                String optString = jSONObject.optString("ssid");
                String optString2 = jSONObject.optString("rssi");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(c).append("&").append(optString).append("&").append(optString2);
                return stringBuilder.toString();
            } catch (Throwable th) {
            }
        }
        return "";
    }

    private static String a(Context context) {
        if (d == null) {
            try {
                d = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes).replaceAll("[_| ]", "");
            } catch (Throwable th) {
            }
        }
        return d == null ? "" : d;
    }

    public static String a(ct ctVar, Location location, List<ScanResult> list, List<dp> list2) {
        int i;
        int i2;
        cu cuVar = ctVar.b;
        String a = a(System.currentTimeMillis(), "");
        String f = cuVar.f();
        String version = TencentLocationManager.getInstance(ctVar.a).getVersion();
        String str = "209";
        StringBuilder stringBuilder = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("#.######");
        stringBuilder.append(0).append(",").append(decimalFormat.format(location.getLatitude())).append(",").append(decimalFormat.format(location.getLongitude())).append(",").append((int) location.getAltitude()).append(",").append((int) location.getAccuracy()).append(",").append((int) location.getBearing()).append(",").append(String.format("%.1f", new Object[]{Float.valueOf(location.getSpeed())})).append(",").append(location.getTime());
        String stringBuilder2 = stringBuilder.toString();
        String str2 = "";
        StringBuilder stringBuilder3 = new StringBuilder();
        if (list2 != null && list2.size() > 0) {
            i = 0;
            while (true) {
                i2 = i;
                if (i2 >= list2.size()) {
                    break;
                }
                stringBuilder3.append(((dp) list2.get(i2)).b).append(",").append(((dp) list2.get(i2)).c).append(",").append(((dp) list2.get(i2)).d).append(",").append(((dp) list2.get(i2)).e).append(",").append(((dp) list2.get(i2)).f);
                if (i2 < list2.size() - 1) {
                    stringBuilder3.append(";");
                }
                i = i2 + 1;
            }
        }
        String stringBuilder4 = stringBuilder3.toString();
        StringBuilder stringBuilder5 = new StringBuilder();
        if (list != null && list.size() > 0) {
            i = 0;
            while (true) {
                i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                stringBuilder5.append(((ScanResult) list.get(i2)).BSSID.replace(":", "")).append("&").append(((ScanResult) list.get(i2)).level);
                if (i2 < list.size() - 1) {
                    stringBuilder5.append("&");
                }
                i = i2 + 1;
            }
        }
        String stringBuilder6 = stringBuilder5.toString();
        String str3 = "tx_sdk";
        String a2 = a(ctVar);
        if (a2.equals("&&")) {
            a2 = "";
        }
        String str4 = "";
        String a3 = a(ctVar.a);
        String str5 = cuVar.h;
        StringBuilder stringBuilder7 = new StringBuilder();
        stringBuilder7.append(a3).append("_").append(str5);
        String stringBuilder8 = stringBuilder7.toString();
        if (b == null) {
            b = Build.MANUFACTURER.replaceAll("|", "").replaceAll(" ", "");
        }
        a3 = b == null ? "" : b;
        if (c == null) {
            c = Build.MODEL.replaceAll("|", "").replaceAll(" ", "");
        }
        if (c == null) {
            str5 = "";
        } else {
            str5 = c;
        }
        StringBuilder stringBuilder9 = new StringBuilder();
        stringBuilder9.append(a3).append("_").append(str5);
        a3 = stringBuilder9.toString();
        StringBuilder stringBuilder10 = new StringBuilder();
        stringBuilder10.append("[").append(a).append("]:").append(version).append("|").append(str).append("|").append(f).append("|||||||||").append(stringBuilder2).append("|").append(str2).append("|").append(stringBuilder4).append("|").append(stringBuilder6).append("||||||||||||||||").append(str3).append("||||").append(a2).append("||").append(str4).append("|").append(stringBuilder8).append("|||").append(a3);
        return stringBuilder10.toString();
    }
}
