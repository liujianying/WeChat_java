package com.tencent.mm.plugin.freewifi;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.mm.R;
import com.tencent.mm.al.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.ConnectException;
import java.net.NetworkInterface;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import org.xwalk.core.XWalkEnvironment;

public final class m {
    private static SimpleDateFormat gVk = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String BQ(String str) {
        if (isEmpty(str)) {
            return "";
        }
        if (str.startsWith("\"") && str.endsWith("\"")) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

    public static boolean aOd() {
        String bQ = bi.bQ(ad.getContext());
        return bQ != null && bQ.toLowerCase().startsWith(ad.getPackageName());
    }

    public static void D(Intent intent) {
        if (isEmpty(intent.getStringExtra("free_wifi_sessionkey"))) {
            d(intent, aOe());
        }
    }

    public static String aOe() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void d(Intent intent, String str) {
        intent.putExtra("free_wifi_sessionkey", str);
        intent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0);
    }

    public static String E(Intent intent) {
        return BR(intent.getStringExtra("free_wifi_sessionkey"));
    }

    public static int F(Intent intent) {
        int intExtra = intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0) + 1;
        intent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", intExtra);
        return intExtra;
    }

    public static int G(Intent intent) {
        return intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    }

    public static int H(Intent intent) {
        return intent.getIntExtra("free_wifi_channel_id", 0);
    }

    public static String I(Intent intent) {
        return intent.getStringExtra("free_wifi_ap_key");
    }

    public static String BR(String str) {
        return str == null ? "" : str;
    }

    public static String BS(String str) {
        if (aOh()) {
            WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return "";
            }
            String ssid = connectionInfo.getSSID();
            if (isEmpty(ssid)) {
                x.i(str, "getConnectedWifiSsid() is empty");
                return "";
            }
            x.i(str, "getConnectedWifiSsid()=" + BQ(ssid));
            return BQ(ssid);
        }
        x.i(str, "wifi not connected. getConnectedWifiSsid() is empty");
        return "";
    }

    public static String BT(String str) {
        if (aOh()) {
            WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return "";
            }
            String toLowerCase = BR(connectionInfo.getBSSID()).toLowerCase();
            x.i(str, "getConnectedWifiBssid()=" + toLowerCase);
            return toLowerCase;
        }
        x.i(str, "wifi not connected. getConnectedWifiBssid() is empty");
        return "";
    }

    public static String BU(String str) {
        WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            x.e(str, "error wifiManager is null!!");
            return "";
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            x.e(str, "error wifiInfo is null!!");
            return "";
        }
        String macAddress = connectionInfo.getMacAddress();
        if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
            macAddress = aOf();
        }
        macAddress = BR(macAddress).toLowerCase();
        x.i(str, "getConnectedWifiClientMac()=" + macAddress);
        return macAddress;
    }

    public static String aOf() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String str = "wlan0";
            if (NetworkInterface.getNetworkInterfaces() != null) {
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (networkInterface.getName().equalsIgnoreCase(str)) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        if (hardwareAddress == null) {
                            x.d("MicroMsg.FreeWifi.Utils", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
                            return "02:00:00:00:00:00";
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            stringBuilder.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                        }
                        if (stringBuilder.length() > 0) {
                            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                        }
                        x.d("MicroMsg.FreeWifi.Utils", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
                        return stringBuilder.toString();
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.FreeWifi.Utils", "get mobile mac from net fail!" + e);
        }
        x.d("MicroMsg.FreeWifi.Utils", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
        return "02:00:00:00:00:00";
    }

    public static String g(Exception exception) {
        Writer stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        String BR = BR(stringWriter.toString());
        if (BR.length() > 1024) {
            return BR.substring(0, 1024);
        }
        return BR;
    }

    public static String h(Exception exception) {
        Writer stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        return BR(stringWriter.toString());
    }

    public static String a(int i, k$b k_b, int i2) {
        Object format;
        x.i("MicroMsg.FreeWifi.Utils", "getUiErrorCode, protocol=%d, stageName=%s, stageCode=%d, errocode=%d", new Object[]{Integer.valueOf(i), k_b.name, Long.valueOf(k_b.jiQ), Integer.valueOf(i2)});
        int abs = Math.abs(i2);
        StringBuilder append = new StringBuilder().append(String.format("%02d", new Object[]{Integer.valueOf(i)})).append(String.format("%03d", new Object[]{Long.valueOf(k_b.jiQ)}));
        if (abs <= XWalkEnvironment.LOCAL_TEST_VERSION) {
            format = String.format("%03d", new Object[]{Integer.valueOf(abs)});
        } else {
            format = Integer.valueOf(abs);
        }
        return append.append(format).toString();
    }

    public static void a(Intent intent, String str, int i, int i2, FreeWifiFrontPageUI freeWifiFrontPageUI, String str2) {
        a(intent, str, i, i2, new 1(str2, freeWifiFrontPageUI, i), str2);
    }

    public static void a(Intent intent, String str, int i, int i2, a aVar, String str2) {
        j.aON().aOv().post(new 2(str2, str, intent, i, i2, aVar));
    }

    public static int aOg() {
        a XC = l.XC();
        if (XC == a.eKr || XC == a.eKs) {
            return 1;
        }
        au.HU();
        String str = (String) c.DT().get(6, null);
        if (isEmpty(str)) {
            return 1;
        }
        Object Fp;
        if (str.startsWith("+")) {
            Fp = ap.Fp(str);
        } else {
            Fp = "86";
        }
        if ("86".equals(Fp)) {
            return 2;
        }
        return 3;
    }

    public static void dm(Context context) {
        Intent intent = new Intent(context, BindMContactUI.class);
        intent.putExtra("is_bind_for_safe_device", false);
        intent.putExtra("is_bind_for_change_mobile", false);
        String simCountryIso = ((TelephonyManager) context.getSystemService("phone")).getSimCountryIso();
        if (!bi.oW(simCountryIso)) {
            b.a j = b.j(context, simCountryIso, context.getString(R.l.country_code));
            if (j != null) {
                intent.putExtra("country_name", j.dYy);
                intent.putExtra("couttry_code", j.dYx);
            }
        }
        MMWizardActivity.D(context, intent);
    }

    public static boolean cC(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return true;
        }
        return false;
    }

    public static boolean cD(int i, int i2) {
        if (i != 4 || i2 > -30000 || i2 <= -31000) {
            return false;
        }
        return true;
    }

    public static int i(Exception exception) {
        if (exception instanceof SocketTimeoutException) {
            String h = h(exception);
            if (h.indexOf(".read") != -1) {
                return s$l.AppCompatTheme_radioButtonStyle;
            }
            if (h.indexOf(".connect") != -1) {
                return 104;
            }
            return s$l.AppCompatTheme_buttonStyleSmall;
        } else if (exception instanceof ConnectException) {
            return s$l.AppCompatTheme_ratingBarStyle;
        } else {
            if (exception instanceof UnknownHostException) {
                return s$l.AppCompatTheme_checkboxStyle;
            }
            return s$l.AppCompatTheme_buttonStyleSmall;
        }
    }

    public static boolean l(Map<String, String> map, String str) {
        x.i(str, "CLIENT_VERSION=" + d.qVN);
        String str2 = (String) map.get(".sysmsg.apply_versions.version_desc.$minInclude");
        String str3 = (String) map.get(".sysmsg.apply_versions.version_desc.$maxInclude");
        x.i(str, "checkMsgPushedVersion. min0=%s,max0=%s", new Object[]{str2, str3});
        if (isEmpty(str2) && isEmpty(str3)) {
            return false;
        }
        if (cM(str2, str3)) {
            return true;
        }
        int i = 1;
        while (true) {
            str2 = (String) map.get(".sysmsg.apply_versions.version_desc#" + i + ".$minInclude");
            str3 = (String) map.get(".sysmsg.apply_versions.version_desc#" + i + ".$maxInclude");
            x.i(str, "checkMsgPushedVersion. min" + i + "=%s,max" + i + "=%s", new Object[]{str2, str3});
            if (isEmpty(str2) && isEmpty(str3)) {
                return false;
            }
            if (cM(str2, str3)) {
                return true;
            }
            i++;
        }
    }

    private static boolean cM(String str, String str2) {
        int i = bi.getInt(str, 0);
        int i2 = bi.getInt(str2, 0);
        if (i == 0 && i2 != 0 && d.qVN <= i2) {
            return true;
        }
        if (i != 0 && i2 == 0 && d.qVN >= i) {
            return true;
        }
        if (i == 0 || i2 == 0 || d.qVN < i || d.qVN > i2) {
            return false;
        }
        return true;
    }

    public static boolean aOh() {
        if (((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected()) {
            x.i("TAG", "isWifiConnected()=true");
            return true;
        }
        x.i("TAG", "isWifiConnected()=false");
        return false;
    }

    public static sf aOi() {
        sf sfVar = new sf();
        sfVar.deviceBrand = d.qVH;
        if (d.jhK == null || d.jhK.equals("")) {
            sfVar.rvD = BU("MicroMsg.FreeWifi.Utils");
        } else {
            sfVar.rvD = d.jhK;
        }
        sfVar.deviceModel = d.qVI;
        sfVar.osName = d.qVK;
        sfVar.osVersion = d.qVL;
        return sfVar;
    }

    public static String a(String str, LinkedHashMap<String, Class> linkedHashMap, i iVar, String str2) {
        String str3;
        if (linkedHashMap.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str).append("\r\n");
        StringBuilder stringBuilder2 = new StringBuilder();
        for (Entry key : linkedHashMap.entrySet()) {
            stringBuilder2.append((String) key.getKey()).append(",");
        }
        if (stringBuilder2.length() > 0) {
            stringBuilder2.delete(stringBuilder2.length() - 1, stringBuilder2.length());
        }
        String str4 = "select " + stringBuilder2.toString() + " from " + str;
        for (Entry key2 : linkedHashMap.entrySet()) {
            stringBuilder.append((String) key2.getKey()).append("\t");
        }
        stringBuilder.append("\r\n");
        Cursor rawQuery = iVar.rawQuery(str4, new String[0]);
        while (rawQuery.moveToNext()) {
            try {
                int i = 0;
                for (Entry key22 : linkedHashMap.entrySet()) {
                    Class cls = (Class) key22.getValue();
                    if (cls == String.class) {
                        stringBuilder.append(rawQuery.getString(i));
                    } else if (cls == Integer.TYPE) {
                        stringBuilder.append(rawQuery.getInt(i));
                    } else if (cls == Long.TYPE) {
                        stringBuilder.append(rawQuery.getLong(i));
                    } else if (cls == Float.TYPE) {
                        stringBuilder.append(rawQuery.getFloat(i));
                    } else if (cls == Double.TYPE) {
                        stringBuilder.append(rawQuery.getDouble(i));
                    } else {
                        x.e(str2, "unkonwn type " + cls.toString());
                        stringBuilder.append(rawQuery.getString(i));
                    }
                    stringBuilder.append("\t");
                    i++;
                }
                stringBuilder.append("\r\n");
            } catch (Exception e) {
                x.i(str2, "print " + str + "error." + e.getMessage());
                str3 = "";
                return str3;
            } finally {
                rawQuery.close();
            }
        }
        x.i(str2, stringBuilder.toString());
        str3 = stringBuilder.toString();
        return str3;
    }

    public static void BV(String str) {
        x.i("FreeWifi", str);
    }
}
