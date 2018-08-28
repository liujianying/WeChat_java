package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d {
    private static Map<Integer, String> jjK = new HashMap<Integer, String>() {
        {
            put(Integer.valueOf(-1), "CONNECT_STATE_NOT_CONNECT");
            put(Integer.valueOf(0), "CONNECT_STATE_NOT_WECHAT_WIFI");
            put(Integer.valueOf(1), "CONNECT_STATE_CONNECTING");
            put(Integer.valueOf(2), "CONNECT_STATE_CONNECT_SUCCESS");
            put(Integer.valueOf(3), "CONNECT_STATE_CONNECT_FAILED");
            put(Integer.valueOf(4), "CONNECT_STATE_WAIT_START");
        }
    };

    public static int BX(String str) {
        if (bi.oW(str)) {
            x.d("MicroMsg.FreeWifi.FreeWifiManager", "Illegal SSID");
            return 0;
        }
        c Cg = j.aOK().Cg(str);
        if (Cg == null || !str.equalsIgnoreCase(Cg.field_ssid)) {
            return 0;
        }
        if (Cg.field_connectState == 2 && Cg.field_expiredTime > 0 && Cg.field_expiredTime - bi.VE() <= 0) {
            Cg.field_connectState = 1;
            boolean c = j.aOK().c(Cg, new String[0]);
            x.i("MicroMsg.FreeWifi.FreeWifiManager", "Expired, re-auth, expired time : %d, current time : %d, ret : %b", new Object[]{Long.valueOf(Cg.field_expiredTime), Long.valueOf(bi.VE()), Boolean.valueOf(c)});
        }
        return Cg.field_connectState;
    }

    public static void release() {
    }

    public static boolean BY(String str) {
        x.i("MicroMsg.FreeWifi.FreeWifiManager", "check is wechat free wifi, ssid : %s", new Object[]{str});
        if (bi.oW(str)) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "ssid is null or nil");
            return false;
        }
        String aOz = aOz();
        if (bi.oW(aOz) || !aOz.equals(str)) {
            return false;
        }
        return true;
    }

    public static int BZ(String str) {
        WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService(TencentLocationListener.WIFI);
        if (wifiManager == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, get wifi manager failed");
            return -11;
        }
        int Cb = Cb(str);
        if (Cb > 0) {
            x.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, the network has exsited, just enable it");
        } else {
            WifiConfiguration wifiConfiguration = new WifiConfiguration();
            wifiConfiguration.allowedAuthAlgorithms.clear();
            wifiConfiguration.allowedGroupCiphers.clear();
            wifiConfiguration.allowedKeyManagement.clear();
            wifiConfiguration.allowedPairwiseCiphers.clear();
            wifiConfiguration.allowedProtocols.clear();
            wifiConfiguration.SSID = "\"" + str + "\"";
            x.i("MicroMsg.FreeWifi.FreeWifiManager", "check is the same ssid is exist, %b", new Object[]{Boolean.valueOf(Ca(str))});
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
            Cb = wifiManager.addNetwork(wifiConfiguration);
        }
        x.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork netid : %d, result : %b", new Object[]{Integer.valueOf(Cb), Boolean.valueOf(wifiManager.enableNetwork(Cb, true))});
        if (wifiManager.enableNetwork(Cb, true)) {
            return 0;
        }
        return -14;
    }

    public static int d(String str, String str2, int i, boolean z) {
        x.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt, ssid is : %s, password : %s, cryptType :%d, hideSSID = %b", new Object[]{str, str2, Integer.valueOf(i), Boolean.valueOf(z)});
        if (bi.oW(str)) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg failed, ssid is null");
            return -12;
        } else if (i == 0) {
            return BZ(str);
        } else {
            if (bi.oW(str2)) {
                x.e("MicroMsg.FreeWifi.FreeWifiManager", "encrypt type is not none, while password is null");
                return -15;
            }
            WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService(TencentLocationListener.WIFI);
            if (wifiManager == null) {
                x.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, get wifi manager failed");
                return -11;
            }
            int addNetwork;
            WifiConfiguration wifiConfiguration;
            if (com.tencent.mm.compatible.util.d.fR(21)) {
                if (!bi.oW(str)) {
                    List<WifiConfiguration> configuredNetworks = ((WifiManager) ad.getContext().getSystemService(TencentLocationListener.WIFI)).getConfiguredNetworks();
                    if (configuredNetworks != null) {
                        x.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", new Object[]{Integer.valueOf(configuredNetworks.size())});
                        for (WifiConfiguration wifiConfiguration2 : configuredNetworks) {
                            if (wifiConfiguration2.SSID.equals("\"" + str + "\"")) {
                                break;
                            }
                        }
                    }
                    x.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
                } else {
                    x.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
                }
                wifiConfiguration2 = null;
                if (wifiConfiguration2 == null) {
                    wifiConfiguration2 = v(str, str2, i);
                    wifiConfiguration2.hiddenSSID = z;
                    addNetwork = wifiManager.addNetwork(wifiConfiguration2);
                } else {
                    if (wifiConfiguration2 != null) {
                        wifiConfiguration2.SSID = "\"" + str + "\"";
                        wifiConfiguration2.status = 2;
                        switch (i) {
                            case 1:
                                wifiConfiguration2.wepKeys = new String[]{"\"" + str2 + "\""};
                                wifiConfiguration2.allowedKeyManagement.set(0);
                                break;
                            case 2:
                            case 3:
                                wifiConfiguration2.preSharedKey = "\"" + str2 + "\"";
                                wifiConfiguration2.allowedKeyManagement.set(1);
                                break;
                            default:
                                x.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", new Object[]{Integer.valueOf(i)});
                                break;
                        }
                    }
                    wifiConfiguration2.hiddenSSID = z;
                    addNetwork = wifiConfiguration2.networkId;
                }
                wifiManager.saveConfiguration();
            } else {
                addNetwork = Cb(str);
                if (addNetwork > 0) {
                    boolean removeNetwork = wifiManager.removeNetwork(addNetwork);
                    x.i("MicroMsg.FreeWifi.FreeWifiManager", "this network has exist : %s, try to remove it : %b", new Object[]{str, Boolean.valueOf(removeNetwork)});
                }
                wifiConfiguration2 = v(str, str2, i);
                wifiConfiguration2.hiddenSSID = z;
                addNetwork = wifiManager.addNetwork(wifiConfiguration2);
                wifiManager.saveConfiguration();
            }
            x.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, netid : %d, result : %b", new Object[]{Integer.valueOf(addNetwork), Boolean.valueOf(wifiManager.enableNetwork(addNetwork, true))});
            if (wifiManager.enableNetwork(addNetwork, true)) {
                return 0;
            }
            return -14;
        }
    }

    private static WifiConfiguration v(String str, String str2, int i) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.SSID = "\"" + str + "\"";
        wifiConfiguration.status = 2;
        switch (i) {
            case 1:
                wifiConfiguration.wepKeys = new String[]{"\"" + str2 + "\""};
                wifiConfiguration.allowedKeyManagement.set(0);
                break;
            case 2:
            case 3:
                wifiConfiguration.preSharedKey = "\"" + str2 + "\"";
                wifiConfiguration.allowedKeyManagement.set(1);
                break;
            default:
                x.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", new Object[]{Integer.valueOf(i)});
                break;
        }
        return wifiConfiguration;
    }

    public static boolean isWifiEnabled() {
        WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService(TencentLocationListener.WIFI);
        if (wifiManager == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            return false;
        }
        x.i("MicroMsg.FreeWifi.FreeWifiManager", "is wifi enalbe now : %b", new Object[]{Boolean.valueOf(wifiManager.isWifiEnabled())});
        return wifiManager.isWifiEnabled();
    }

    public static boolean aOw() {
        WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService(TencentLocationListener.WIFI);
        if (wifiManager != null) {
            return wifiManager.setWifiEnabled(true);
        }
        x.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
        return false;
    }

    public static boolean Ca(String str) {
        int Cb = Cb(str);
        x.i("MicroMsg.FreeWifi.FreeWifiManager", "get network id by ssid :%s, netid is %d", new Object[]{str, Integer.valueOf(Cb)});
        if (Cb == -1) {
            x.i("MicroMsg.FreeWifi.FreeWifiManager", "ssid is not exist : %s", new Object[]{str});
            return false;
        }
        WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService(TencentLocationListener.WIFI);
        boolean removeNetwork = wifiManager.removeNetwork(Cb);
        wifiManager.saveConfiguration();
        x.i("MicroMsg.FreeWifi.FreeWifiManager", "remove ssid : %s, ret = %b", new Object[]{str, Boolean.valueOf(removeNetwork)});
        return removeNetwork;
    }

    private static int Cb(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
            return -1;
        }
        List<WifiConfiguration> configuredNetworks = ((WifiManager) ad.getContext().getSystemService(TencentLocationListener.WIFI)).getConfiguredNetworks();
        if (configuredNetworks == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
            return -1;
        }
        x.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", new Object[]{Integer.valueOf(configuredNetworks.size())});
        for (WifiConfiguration wifiConfiguration : configuredNetworks) {
            if (wifiConfiguration.SSID.equals("\"" + str + "\"")) {
                return wifiConfiguration.networkId;
            }
        }
        return -1;
    }

    public static String pZ(int i) {
        String str = (String) jjK.get(Integer.valueOf(i));
        if (str == null) {
            return "";
        }
        return str;
    }

    public static void a(String str, int i, Intent intent) {
        x.i("MicroMsg.FreeWifi.FreeWifiManager", "sessionKey=%s, step=%d, method=FreeWifiManager.updateConnectState, desc=it changes the connect state of the model to %s. state=%d", new Object[]{m.E(intent), Integer.valueOf(m.F(intent)), pZ(i), Integer.valueOf(i)});
        c Cg = j.aOK().Cg(str);
        if (Cg != null) {
            Cg.field_connectState = i;
            boolean c = j.aOK().c(Cg, new String[0]);
            x.i("MicroMsg.FreeWifi.FreeWifiManager", "update %s, connect state : %d, return : %b", new Object[]{str, Integer.valueOf(i), Boolean.valueOf(c)});
        }
    }

    public static String aOx() {
        if (ao.getNetType(ad.getContext()) == 0) {
            WifiInfo aOA = aOA();
            if (!(aOA == null || aOA.getBSSID() == null)) {
                x.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiMacAddress, get bssid now : %s", new Object[]{aOA.getBSSID()});
                return aOA.getBSSID();
            }
        }
        return null;
    }

    public static int aOy() {
        if (ao.getNetType(ad.getContext()) == 0) {
            WifiInfo aOA = aOA();
            if (aOA != null) {
                x.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiSignal, get rssi now : %d", new Object[]{Integer.valueOf(aOA.getRssi())});
                return aOA.getRssi();
            }
        }
        return 0;
    }

    public static String aOz() {
        x.i("MicroMsg.FreeWifi.FreeWifiManager", "networkType = %d", new Object[]{Integer.valueOf(ao.getNetType(ad.getContext()))});
        if (ao.getNetType(ad.getContext()) == 0) {
            WifiInfo aOA = aOA();
            if (!(aOA == null || aOA.getSSID() == null)) {
                x.i("MicroMsg.FreeWifi.FreeWifiManager", "get ssid now : %s", new Object[]{aOA.getSSID().replace("\"", "")});
                return aOA.getSSID().replace("\"", "");
            }
        }
        return null;
    }

    public static WifiInfo aOA() {
        WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService(TencentLocationListener.WIFI);
        if (wifiManager == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            return null;
        }
        try {
            return wifiManager.getConnectionInfo();
        } catch (Exception e) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectionInfo failed : %s", new Object[]{e.getMessage()});
            return null;
        }
    }

    public static String aOB() {
        WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService(TencentLocationListener.WIFI);
        if (wifiManager == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            return "";
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return "";
            }
            String bssid = connectionInfo.getBSSID();
            if (bssid == null) {
                return "";
            }
            return bssid;
        } catch (Exception e) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiBssid failed : %s", new Object[]{e.getMessage()});
            return "";
        }
    }

    public static String aOC() {
        WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService(TencentLocationListener.WIFI);
        if (wifiManager == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            return "";
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return "";
            }
            String ssid = connectionInfo.getSSID();
            if (ssid == null) {
                return "";
            }
            return m.BQ(ssid);
        } catch (Exception e) {
            x.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiBssid failed : %s", new Object[]{e.getMessage()});
            return "";
        }
    }

    public static int getNetworkType() {
        return ao.getNetType(ad.getContext());
    }
}
