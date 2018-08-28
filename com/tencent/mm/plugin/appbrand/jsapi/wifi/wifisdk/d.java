package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.WiFiConnector.2;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class d {
    private static boolean gdC = false;
    private static WeakReference<a> gdD = null;
    private static b gdE = null;
    private static a gdF;
    private static Context mContext;

    public static void cC(Context context) {
        if (!gdC && context != null) {
            mContext = context;
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null) {
                c.bgP = wifiManager;
                gdC = true;
            }
        }
    }

    public static b akv() {
        WifiInfo connectionInfo = c.getConnectionInfo();
        String str = "";
        String str2 = "";
        if (!(connectionInfo == null || TextUtils.isEmpty(connectionInfo.getSSID()))) {
            str = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.uj(connectionInfo.getSSID());
            str2 = bi.aG(connectionInfo.getBSSID(), "");
        }
        if (gdE != null && gdE.gdv.compareTo(str) == 0 && gdE.gdw.compareTo(str2) == 0) {
            return gdE;
        }
        if (connectionInfo == null) {
            return null;
        }
        akw();
        return gdE;
    }

    public static c akw() {
        c cVar = new c();
        gdE = null;
        if (gdC && c.isWifiEnabled()) {
            c.startScan();
            List<ScanResult> scanResults = c.getScanResults();
            cVar.gdB = new ArrayList();
            cVar.fHW = "ok";
            if (scanResults != null) {
                String str;
                x.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] ScanResult:%s, size:%d", new Object[]{scanResults, Integer.valueOf(scanResults.size())});
                WifiInfo connectionInfo = c.getConnectionInfo();
                x.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] currentWiFiInfo:%s", new Object[]{connectionInfo});
                String str2;
                if (connectionInfo == null || TextUtils.isEmpty(connectionInfo.getSSID())) {
                    str2 = null;
                    str = null;
                } else {
                    str = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.uj(connectionInfo.getSSID());
                    str2 = bi.aG(connectionInfo.getBSSID(), "");
                }
                for (ScanResult scanResult : scanResults) {
                    if (scanResult != null) {
                        int a = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.a(scanResult);
                        if (a == 0 || a == 2) {
                            boolean z;
                            b bVar = new b();
                            bVar.gdv = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.uj(scanResult.SSID);
                            bVar.gdw = bi.aG(scanResult.BSSID, "");
                            int i = scanResult.level;
                            i = i <= -100 ? 0 : i >= -55 ? 99 : (int) ((((float) (i + 100)) * 99.0f) / 45.0f);
                            bVar.gdx = i;
                            if (a == 2) {
                                z = true;
                            } else {
                                z = false;
                            }
                            bVar.gdy = z;
                            if (str == null || str2 == null || bVar.gdv.compareTo(str) != 0 || bVar.gdw.compareTo(str2) != 0) {
                                i = 0;
                            } else {
                                i = 1;
                            }
                            if (i != 0) {
                                gdE = bVar;
                            }
                            cVar.gdB.add(bVar);
                        }
                    }
                }
            } else {
                x.e("MicroMsg.WiFiManagerWrapper", "wifiList is null");
            }
        } else if (gdC) {
            cVar.fHW = "wifi is disable";
        } else {
            cVar.fHW = "sdk not init";
        }
        return cVar;
    }

    public static void F(String str, String str2, String str3) {
        int i;
        WifiConfiguration wifiConfiguration;
        WifiConfiguration wifiConfiguration2 = null;
        if (gdD != null) {
            a aVar = (a) gdD.get();
            if (!(aVar == null || aVar.akx())) {
                aVar.ui("duplicated request");
            }
        }
        a aVar2 = new a(gdF, mContext);
        new StringBuilder("ssid:").append(str).append(" bssid:").append(str2).append(" psw:").append(str3);
        aVar2.gdv = str;
        aVar2.gdw = str2;
        if (TextUtils.isEmpty(str3)) {
            i = 0;
        } else {
            i = 2;
        }
        if (str == null || str.length() <= 0) {
            wifiConfiguration = null;
        } else {
            wifiConfiguration = new WifiConfiguration();
            wifiConfiguration.allowedAuthAlgorithms.clear();
            wifiConfiguration.allowedGroupCiphers.clear();
            wifiConfiguration.allowedKeyManagement.clear();
            wifiConfiguration.allowedPairwiseCiphers.clear();
            wifiConfiguration.allowedProtocols.clear();
            wifiConfiguration.SSID = "\"" + str + "\"";
            wifiConfiguration.hiddenSSID = true;
            switch (i) {
                case 2:
                    if (str3.length() != 0) {
                        if (!str3.matches("[0-9A-Fa-f]{64}")) {
                            wifiConfiguration.preSharedKey = "\"" + str3 + '\"';
                            break;
                        } else {
                            wifiConfiguration.preSharedKey = str3;
                            break;
                        }
                    }
                    break;
                default:
                    wifiConfiguration.allowedKeyManagement.set(0);
                    break;
            }
            wifiConfiguration.status = 2;
        }
        List configuredNetworks = c.getConfiguredNetworks();
        if (configuredNetworks != null) {
            wifiConfiguration2 = b.a(str, i, configuredNetworks);
        }
        if (wifiConfiguration != null) {
            if (wifiConfiguration2 != null) {
                boolean z;
                if (b.aF(str, i)) {
                    c.saveConfiguration();
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    wifiConfiguration.networkId = b.b(wifiConfiguration);
                    if (wifiConfiguration.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.gdP) {
                        wifiConfiguration = wifiConfiguration2;
                    }
                }
            }
            if (wifiConfiguration.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.gdP) {
                wifiConfiguration.networkId = b.b(wifiConfiguration);
            }
            if (wifiConfiguration.networkId != com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.gdP && aVar2.a(wifiConfiguration)) {
                aVar2.kZ(1);
                aVar2.gdJ = wifiConfiguration;
                if (!aVar2.gdr) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
                    intentFilter.addAction("android.net.wifi.STATE_CHANGE");
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    intentFilter.setPriority(Integer.MAX_VALUE);
                    aVar2.gds = new 2(aVar2);
                    aVar2.gdG.registerReceiver(aVar2.gds, intentFilter);
                    aVar2.gdr = true;
                }
                aVar2.mHandler.sendEmptyMessageDelayed(1, 13000);
                gdD = new WeakReference(aVar2);
            }
        }
        aVar2.g(false, "fail to connect wifi:invalid network id");
        gdD = new WeakReference(aVar2);
    }

    public static void a(a aVar) {
        gdF = aVar;
    }
}
