package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.aw;
import com.tencent.mm.protocal.c.azh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.o;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;

public final class i {
    private static b pnV;
    private static i pnW;
    private static aw pnX = null;
    private static long pnY = 0;
    public JSONArray pnZ;

    public static class a {
        public String grI;
        public String poa;
        public String pob;
        public String poc;
        public String pod;
        public String poe;
        public String pof;
        public String pog;
        public String poh;
        public String poi;
        public String poj;
        public String pok;
        public String pol;
        public String systemId;
        public String type;
    }

    private i() {
        g.Ek();
        String str = (String) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sTh, "");
        x.i("MicroMsg.GpsReportHelper", "GpsReportHelper " + str);
        if (!bi.oW(str)) {
            try {
                this.pnZ = new JSONArray(str);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GpsReportHelper", e, "", new Object[0]);
                x.e("MicroMsg.GpsReportHelper", "parse lbs config error", new Object[]{e});
            }
        }
    }

    public static i bOG() {
        if (pnW == null) {
            pnW = new i();
        }
        return pnW;
    }

    private static String bOH() {
        long currentTimeMillis = System.currentTimeMillis();
        String str = "&scan_ssid%d=%s&scan_bssid%d=%s";
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Context context = ad.getContext();
            if (context == null) {
                return "";
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService(TencentExtraKeys.LOCATION_SOURCE_WIFI);
            wifiManager.getConnectionInfo();
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2 = new StringBuffer();
            int i = 0;
            for (ScanResult scanResult : wifiManager.getScanResults()) {
                stringBuffer.append(String.format(str, new Object[]{Integer.valueOf(i), wQ(scanResult.SSID), Integer.valueOf(i), wQ(scanResult.BSSID)}));
                int i2 = i + 1;
                if (i2 >= 5) {
                    break;
                }
                i = i2;
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            x.e("MicroMsg.GpsReportHelper", "RecordCostTime: readScanWifi cost %d ms", new Object[]{Long.valueOf(currentTimeMillis2)});
            return stringBuffer.toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GpsReportHelper", e, "", new Object[0]);
        }
    }

    private static String bOI() {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        if (!bOO()) {
            return "";
        }
        hashMap.put("is_ci_permitted", "0");
        hashMap.put("net_type", ao.fH(ad.getContext()));
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        x.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 01- %d ms", new Object[]{Long.valueOf(currentTimeMillis)});
        long currentTimeMillis2 = System.currentTimeMillis();
        if (bOJ()) {
            hashMap.put("is_ci_permitted", "1");
            hashMap.put("uuid", UUID.randomUUID().toString());
            hashMap.put("sample_time", (System.currentTimeMillis() / 1000));
            hashMap.put("phone_brand", Build.BRAND);
            hashMap.put("phone_model", Build.MODEL);
            try {
                if (ad.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        hashMap.put("net_subtype", activeNetworkInfo.getSubtype());
                    }
                }
            } catch (Exception e) {
            }
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
            x.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 02- %d ms", new Object[]{Long.valueOf(currentTimeMillis)});
            currentTimeMillis = System.currentTimeMillis();
            List es = es(ad.getContext());
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            x.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 03- %d ms", new Object[]{Long.valueOf(currentTimeMillis)});
            currentTimeMillis2 = System.currentTimeMillis();
            int size = es.size();
            for (int i = 0; i < size; i++) {
                a aVar = (a) es.get(i);
                if (aVar != null) {
                    hashMap.put("mcc_" + i, aVar.poa);
                    hashMap.put("mnc_" + i, aVar.pob);
                    hashMap.put("lac_" + i, aVar.pod);
                    hashMap.put("cell_id_" + i, aVar.poc);
                    hashMap.put("type_" + i, aVar.type);
                    hashMap.put("sid_" + i, aVar.pof);
                    hashMap.put("net_id_" + i, aVar.pog);
                    hashMap.put("sys_id_" + i, aVar.systemId);
                    hashMap.put("dbm_" + i, aVar.poh);
                    hashMap.put("tac_" + i, aVar.poe);
                    hashMap.put("arfcn_" + i, aVar.pok);
                    hashMap.put("earfcn_" + i, aVar.poi);
                    hashMap.put("uarfcn_" + i, aVar.poj);
                    hashMap.put("dbm_" + i, aVar.poh);
                }
            }
            hashMap.put("count", String.valueOf(size));
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for (String str : hashMap.keySet()) {
            if (!bi.oW((String) hashMap.get(str))) {
                stringBuilder.append(String.format("&%s=%s", new Object[]{(String) r7.next(), wQ((String) hashMap.get(str))}));
            }
        }
        String str2 = stringBuilder.toString();
        if (!bi.oW(str2) && str2.indexOf("&") == 0) {
            str2 = str2.substring(1);
        }
        currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
        x.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 03- %d ms", new Object[]{Long.valueOf(currentTimeMillis2)});
        return str2;
    }

    private static boolean bOJ() {
        if (VERSION.SDK_INT < 23 && !"MNC".equals(VERSION.CODENAME)) {
            return true;
        }
        try {
            if (android.support.v4.content.a.f(ad.getContext(), "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.GpsReportHelper", "check permission exception:%s.", new Object[]{e});
            return true;
        }
    }

    private static String wQ(String str) {
        try {
            return p.encode(str, "UTF-8");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GpsReportHelper", e, "", new Object[0]);
            return str;
        }
    }

    private static void fe(String str, String str2) {
        if (pnX == null) {
            pnX = new aw();
        }
        x.d("MicroMsg.GpsReportHelper", "encrypt data userInfo:%s, cellInfo:%s", new Object[]{str, str2});
        byte[] bArr = new byte[16];
        byte[] bytes = o.cDa().getBytes();
        if (bytes == null || bytes.length <= 0) {
            bytes = (System.currentTimeMillis()).getBytes();
        }
        int i = 0;
        int i2 = 0;
        do {
            bArr[i2] = bytes[i];
            i2++;
            i++;
            if (i >= bytes.length) {
                i = 0;
                continue;
            }
        } while (i2 < 16);
        bytes = Base64.encode(bArr, 0);
        aw awVar = pnX;
        if (l.pom == null) {
            l.pom = new l();
        }
        awVar.rbc = l.pom.aW(bytes);
        x.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_key %s", new Object[]{pnX.rbc});
        if (!bi.oW(str)) {
            bytes = Base64.encode(AesEcb.aesCryptEcb(str.getBytes(), bArr, true, true), 0);
            pnX.rbb = new String(bytes);
            x.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_userinfo %s", new Object[]{new String(bytes)});
        }
        if (!bi.oW(str2)) {
            bytes = Base64.encode(AesEcb.aesCryptEcb(str2.getBytes(), bArr, true, true), 0);
            pnX.rbd = new String(bytes);
            x.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_cellinfo %s", new Object[]{new String(bytes)});
        }
    }

    public static void zk(int i) {
        x.i("MicroMsg.GpsReportHelper", "reflashLocationInfo " + i);
        pnY = System.currentTimeMillis() / 1000;
        if (!bON()) {
            pnV = null;
            bOK();
            pnY = System.currentTimeMillis() / 1000;
        }
    }

    private static void bOK() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!bON()) {
            x.i("MicroMsg.WalletSwitchConfig", "isReportWifiSSid, ret = %s switchBit %s", new Object[]{Boolean.valueOf((o.bOW().bPw().prx & 262144) > 0), Integer.valueOf(o.bOW().bPw().prx)});
            if (((o.bOW().bPw().prx & 262144) > 0) || bOO()) {
                WifiInfo wifiInfo = ao.getWifiInfo(ad.getContext());
                String str = "";
                String str2 = "";
                String str3 = "";
                String str4 = "";
                if (wifiInfo != null) {
                    str = wifiInfo.getSSID();
                    str2 = System.currentTimeMillis();
                    str3 = wifiInfo.getBSSID();
                    str4 = wifiInfo.getMacAddress();
                }
                str3 = String.format("wifissid=%s&wifibssid=%s&wifimac=%s&ssid_timestamp=%s", new Object[]{wQ(str), wQ(str3), wQ(str4), str2}) + bOH();
                if (bOO()) {
                    str4 = bOI();
                } else {
                    str4 = null;
                }
                fe(str3, str4);
            }
            x.e("MicroMsg.GpsReportHelper", "RecordCostTime: refreshWifiAndCellInfo cost %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
    }

    public static aw bOL() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis - pnY > 300) {
            bOK();
            pnY = currentTimeMillis;
        }
        return pnX;
    }

    public static azh bOM() {
        if (pnX == null) {
            return null;
        }
        azh azh = new azh();
        azh.csL = pnX.csL;
        azh.csK = pnX.csK;
        azh.latitude = pnX.latitude;
        azh.longitude = pnX.longitude;
        azh.raY = pnX.raY;
        azh.rbc = pnX.rbc;
        azh.raZ = pnX.raZ;
        azh.rba = pnX.rba;
        azh.rbb = pnX.rbb;
        return azh;
    }

    private static boolean bON() {
        x.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[]{Boolean.valueOf((o.bOW().bPw().prx & 8192) > 0), Integer.valueOf(o.bOW().bPw().prx)});
        return (o.bOW().bPw().prx & 8192) > 0;
    }

    public static boolean bOO() {
        x.i("MicroMsg.WalletSwitchConfig", "isReportCellInfo, ret = %s switchBit %s", new Object[]{Boolean.valueOf((o.bOW().bPw().prx & 8388608) > 0), Integer.valueOf(o.bOW().bPw().prx)});
        return (o.bOW().bPw().prx & 8388608) > 0;
    }

    private static synchronized List<a> es(Context context) {
        List<a> linkedList;
        synchronized (i.class) {
            linkedList = new LinkedList();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            int i = VERSION.SDK_INT;
            try {
                List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                if (allCellInfo != null) {
                    for (CellInfo cellInfo : allCellInfo) {
                        int i2;
                        a aVar = new a();
                        aVar.grI = telephonyManager.getNetworkType();
                        int mnc;
                        if (cellInfo instanceof CellInfoGsm) {
                            CellSignalStrengthGsm cellSignalStrength = ((CellInfoGsm) cellInfo).getCellSignalStrength();
                            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
                            mnc = cellIdentity.getMnc();
                            aVar.poc = cellIdentity.getCid();
                            aVar.poa = cellIdentity.getMcc();
                            aVar.pob = cellIdentity.getMnc();
                            aVar.pod = cellIdentity.getLac();
                            aVar.poh = cellSignalStrength.getDbm();
                            aVar.pol = cellInfo.isRegistered() ? "1" : "0";
                            if (VERSION.SDK_INT >= 24) {
                                aVar.pok = cellIdentity.getArfcn();
                            }
                            i2 = mnc;
                        } else if (cellInfo instanceof CellInfoCdma) {
                            CellSignalStrengthCdma cellSignalStrength2 = ((CellInfoCdma) cellInfo).getCellSignalStrength();
                            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
                            mnc = cellIdentity2.getSystemId();
                            aVar.poc = cellIdentity2.getBasestationId();
                            aVar.pob = cellIdentity2.getSystemId();
                            aVar.pod = cellIdentity2.getNetworkId();
                            aVar.poh = cellSignalStrength2.getDbm();
                            aVar.pol = cellInfo.isRegistered() ? "1" : "0";
                            i2 = mnc;
                        } else if (cellInfo instanceof CellInfoLte) {
                            CellSignalStrengthLte cellSignalStrength3 = ((CellInfoLte) cellInfo).getCellSignalStrength();
                            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
                            mnc = cellIdentity3.getMnc();
                            aVar.poc = cellIdentity3.getCi();
                            aVar.poa = cellIdentity3.getMcc();
                            aVar.pob = cellIdentity3.getMnc();
                            aVar.poe = cellIdentity3.getTac();
                            aVar.poh = cellSignalStrength3.getDbm();
                            aVar.pol = cellInfo.isRegistered() ? "1" : "0";
                            if (VERSION.SDK_INT >= 24) {
                                aVar.poi = cellIdentity3.getEarfcn();
                            }
                            i2 = mnc;
                        } else if (i < 18 || !(cellInfo instanceof CellInfoWcdma)) {
                            x.i("MicroMsg.GpsReportHelper", "Unknown type of cell signal!\n ClassName: " + cellInfo.getClass().getSimpleName() + "\n ToString: " + cellInfo.toString());
                            i2 = 0;
                        } else {
                            CellSignalStrengthWcdma cellSignalStrength4 = ((CellInfoWcdma) cellInfo).getCellSignalStrength();
                            CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                            mnc = cellIdentity4.getMnc();
                            aVar.poc = cellIdentity4.getCid();
                            aVar.poa = cellIdentity4.getMcc();
                            aVar.pob = cellIdentity4.getMnc();
                            aVar.pod = cellIdentity4.getLac();
                            aVar.poh = cellSignalStrength4.getDbm();
                            aVar.pol = cellInfo.isRegistered() ? "1" : "0";
                            if (VERSION.SDK_INT >= 24) {
                                aVar.poj = cellIdentity4.getUarfcn();
                            }
                            i2 = mnc;
                        }
                        if (i2 != Integer.MAX_VALUE) {
                            linkedList.add(aVar);
                        }
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.GpsReportHelper", "loadCellInfo: Unable to obtain cell signal information: ", new Object[]{e});
            }
        }
        return linkedList;
    }
}
