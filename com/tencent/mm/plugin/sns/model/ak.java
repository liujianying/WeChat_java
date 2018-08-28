package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.protocal.c.bpo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ak {
    private static String byJ() {
        String stringBuffer;
        Throwable e;
        String str;
        TelephonyManager telephonyManager;
        Throwable e2;
        String str2;
        String str3;
        Throwable e3;
        StringBuilder stringBuilder;
        Context context = ad.getContext();
        if (context == null) {
            x.e("MicroMsg.SnsItemReportHelper", "ERROR Context is null scene");
            return null;
        }
        String str4;
        String str5;
        List fM;
        int i;
        int i2 = 0;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            int subtype = activeNetworkInfo.getSubtype();
            if (activeNetworkInfo.getType() == 1) {
                i2 = 1;
            } else if (subtype == 13 || subtype == 15 || subtype == 14) {
                i2 = 4;
            } else if (subtype == 3 || subtype == 4 || subtype == 5 || subtype == 6 || subtype == 12) {
                i2 = 3;
            } else if (subtype == 1 || subtype == 2) {
                i2 = 2;
            } else {
                i2 = 0;
            }
        } catch (Throwable e4) {
            x.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", new Object[]{bi.i(e4)});
        }
        x.i("MicroMsg.SnsItemReportHelper", "get netType :%d", new Object[]{Integer.valueOf(i2)});
        String str6 = "";
        String str7 = "";
        String str8 = "";
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            StringBuffer stringBuffer4 = new StringBuffer();
            int i3 = 0;
            ArrayList arrayList = new ArrayList();
            stringBuffer2.append(connectionInfo.getSSID());
            stringBuffer3.append(connectionInfo.getBSSID());
            String bssid = connectionInfo.getBSSID();
            arrayList.add(bssid);
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                Collections.sort(scanResults, new 1());
                int i4 = 20;
                for (ScanResult scanResult : scanResults) {
                    if (!(scanResult == null || bi.oW(scanResult.BSSID))) {
                        if (!scanResult.BSSID.equals(bssid)) {
                            int i5 = i4 - 1;
                            if (i4 <= 0) {
                                break;
                            }
                            stringBuffer2.append("|");
                            stringBuffer2.append(bi.oV(scanResult.SSID).replace("|", "").replace(" ", ""));
                            stringBuffer3.append("|");
                            stringBuffer3.append(bi.oV(scanResult.BSSID).replace("|", "").replace(" ", ""));
                            arrayList.add(scanResult.BSSID);
                            stringBuffer4.append("|");
                            stringBuffer4.append(scanResult.level);
                            i4 = i5;
                        } else {
                            i3 = scanResult.level;
                        }
                    }
                }
            }
            int i6 = i3;
            str6 = stringBuffer2.toString();
            stringBuffer = stringBuffer3.toString();
            try {
                str8 = i6 + stringBuffer4.toString();
            } catch (Exception e5) {
                e = e5;
                str = stringBuffer;
                x.e("MicroMsg.SnsItemReportHelper", "getWifiInfo : %s", new Object[]{bi.i(e)});
                stringBuffer = str;
                x.d("MicroMsg.SnsItemReportHelper", "get wifi :[%s] [%s] [%s]", new Object[]{stringBuffer, str6, str8});
                str4 = "";
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = str4;
                } else {
                    str = telephonyManager.getNetworkOperatorName();
                    try {
                        if (bi.oW(str)) {
                            str = "";
                        }
                    } catch (Throwable e6) {
                        e2 = e6;
                        x.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", new Object[]{bi.i(e2)});
                        str4 = str;
                        x.i("MicroMsg.SnsItemReportHelper", "get ispName: %s", new Object[]{str4});
                        str2 = "";
                        str3 = "";
                        str5 = "";
                        str = "";
                        fM = ao.fM(context);
                        i = 0;
                        while (true) {
                            try {
                                str7 = str;
                                if (i >= fM.size()) {
                                    break;
                                }
                                a aVar = (a) fM.get(i);
                                str2 = bi.aG(aVar.poa, "");
                                str3 = bi.aG(aVar.pob, "");
                                if (str5.length() > 0 && !bi.oW(aVar.poc)) {
                                    str5 = str5 + "|";
                                }
                                if (!bi.oW(aVar.poc)) {
                                    str5 = str5 + aVar.poc;
                                }
                                if (str7.length() > 0 && !bi.oW(aVar.pod)) {
                                    str7 = str7 + "|";
                                }
                                if (bi.oW(aVar.pod)) {
                                    str = str7;
                                } else {
                                    str = str7 + aVar.pod;
                                }
                                i++;
                            } catch (Exception e7) {
                                e3 = e7;
                                str = str7;
                                x.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", new Object[]{bi.i(e3)});
                                x.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", new Object[]{str2, str3, str5, str});
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(i2).append(",");
                                stringBuilder.append(str6.replace(",", " ")).append(",");
                                stringBuilder.append(stringBuffer.replace(",", " ")).append(",");
                                stringBuilder.append(str8.replace(",", " ")).append(",");
                                stringBuilder.append(str4.replace(",", " ")).append(",");
                                stringBuilder.append(str2.replace(",", " ")).append(",");
                                stringBuilder.append(str3.replace(",", " ")).append(",");
                                stringBuilder.append(str5.replace(",", " ")).append(",");
                                stringBuilder.append(str.replace(",", " "));
                                return stringBuilder.toString();
                            }
                        }
                        str = str7;
                        x.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", new Object[]{str2, str3, str5, str});
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(i2).append(",");
                        stringBuilder.append(str6.replace(",", " ")).append(",");
                        stringBuilder.append(stringBuffer.replace(",", " ")).append(",");
                        stringBuilder.append(str8.replace(",", " ")).append(",");
                        stringBuilder.append(str4.replace(",", " ")).append(",");
                        stringBuilder.append(str2.replace(",", " ")).append(",");
                        stringBuilder.append(str3.replace(",", " ")).append(",");
                        stringBuilder.append(str5.replace(",", " ")).append(",");
                        stringBuilder.append(str.replace(",", " "));
                        return stringBuilder.toString();
                    }
                }
                str4 = str;
                x.i("MicroMsg.SnsItemReportHelper", "get ispName: %s", new Object[]{str4});
                str2 = "";
                str3 = "";
                str5 = "";
                str = "";
                fM = ao.fM(context);
                i = 0;
                while (true) {
                    try {
                        str7 = str;
                        if (i >= fM.size()) {
                            break;
                        }
                        a aVar2 = (a) fM.get(i);
                        str2 = bi.aG(aVar2.poa, "");
                        str3 = bi.aG(aVar2.pob, "");
                        if (str5.length() > 0 && !bi.oW(aVar2.poc)) {
                            str5 = str5 + "|";
                        }
                        if (!bi.oW(aVar2.poc)) {
                            str5 = str5 + aVar2.poc;
                        }
                        if (str7.length() > 0 && !bi.oW(aVar2.pod)) {
                            str7 = str7 + "|";
                        }
                        if (bi.oW(aVar2.pod)) {
                            str = str7;
                        } else {
                            str = str7 + aVar2.pod;
                        }
                        i++;
                    } catch (Exception e72) {
                        e3 = e72;
                        str = str7;
                        x.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", new Object[]{bi.i(e3)});
                        x.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", new Object[]{str2, str3, str5, str});
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(i2).append(",");
                        stringBuilder.append(str6.replace(",", " ")).append(",");
                        stringBuilder.append(stringBuffer.replace(",", " ")).append(",");
                        stringBuilder.append(str8.replace(",", " ")).append(",");
                        stringBuilder.append(str4.replace(",", " ")).append(",");
                        stringBuilder.append(str2.replace(",", " ")).append(",");
                        stringBuilder.append(str3.replace(",", " ")).append(",");
                        stringBuilder.append(str5.replace(",", " ")).append(",");
                        stringBuilder.append(str.replace(",", " "));
                        return stringBuilder.toString();
                    }
                }
                str = str7;
                x.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", new Object[]{str2, str3, str5, str});
                stringBuilder = new StringBuilder();
                stringBuilder.append(i2).append(",");
                stringBuilder.append(str6.replace(",", " ")).append(",");
                stringBuilder.append(stringBuffer.replace(",", " ")).append(",");
                stringBuilder.append(str8.replace(",", " ")).append(",");
                stringBuilder.append(str4.replace(",", " ")).append(",");
                stringBuilder.append(str2.replace(",", " ")).append(",");
                stringBuilder.append(str3.replace(",", " ")).append(",");
                stringBuilder.append(str5.replace(",", " ")).append(",");
                stringBuilder.append(str.replace(",", " "));
                return stringBuilder.toString();
            }
        } catch (Throwable e8) {
            e6 = e8;
            str = str7;
            x.e("MicroMsg.SnsItemReportHelper", "getWifiInfo : %s", new Object[]{bi.i(e6)});
            stringBuffer = str;
            x.d("MicroMsg.SnsItemReportHelper", "get wifi :[%s] [%s] [%s]", new Object[]{stringBuffer, str6, str8});
            str4 = "";
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                str = telephonyManager.getNetworkOperatorName();
                try {
                    if (bi.oW(str)) {
                        str = "";
                    }
                } catch (Throwable e62) {
                    e2 = e62;
                    x.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", new Object[]{bi.i(e2)});
                    str4 = str;
                    x.i("MicroMsg.SnsItemReportHelper", "get ispName: %s", new Object[]{str4});
                    str2 = "";
                    str3 = "";
                    str5 = "";
                    str = "";
                    fM = ao.fM(context);
                    i = 0;
                    while (true) {
                        try {
                            str7 = str;
                            if (i >= fM.size()) {
                                break;
                            }
                            a aVar22 = (a) fM.get(i);
                            str2 = bi.aG(aVar22.poa, "");
                            str3 = bi.aG(aVar22.pob, "");
                            if (str5.length() > 0 && !bi.oW(aVar22.poc)) {
                                str5 = str5 + "|";
                            }
                            if (!bi.oW(aVar22.poc)) {
                                str5 = str5 + aVar22.poc;
                            }
                            if (str7.length() > 0 && !bi.oW(aVar22.pod)) {
                                str7 = str7 + "|";
                            }
                            if (bi.oW(aVar22.pod)) {
                                str = str7;
                            } else {
                                str = str7 + aVar22.pod;
                            }
                            i++;
                        } catch (Exception e722) {
                            e3 = e722;
                            str = str7;
                            x.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", new Object[]{bi.i(e3)});
                            x.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", new Object[]{str2, str3, str5, str});
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(i2).append(",");
                            stringBuilder.append(str6.replace(",", " ")).append(",");
                            stringBuilder.append(stringBuffer.replace(",", " ")).append(",");
                            stringBuilder.append(str8.replace(",", " ")).append(",");
                            stringBuilder.append(str4.replace(",", " ")).append(",");
                            stringBuilder.append(str2.replace(",", " ")).append(",");
                            stringBuilder.append(str3.replace(",", " ")).append(",");
                            stringBuilder.append(str5.replace(",", " ")).append(",");
                            stringBuilder.append(str.replace(",", " "));
                            return stringBuilder.toString();
                        }
                    }
                    str = str7;
                    x.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", new Object[]{str2, str3, str5, str});
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(i2).append(",");
                    stringBuilder.append(str6.replace(",", " ")).append(",");
                    stringBuilder.append(stringBuffer.replace(",", " ")).append(",");
                    stringBuilder.append(str8.replace(",", " ")).append(",");
                    stringBuilder.append(str4.replace(",", " ")).append(",");
                    stringBuilder.append(str2.replace(",", " ")).append(",");
                    stringBuilder.append(str3.replace(",", " ")).append(",");
                    stringBuilder.append(str5.replace(",", " ")).append(",");
                    stringBuilder.append(str.replace(",", " "));
                    return stringBuilder.toString();
                }
            }
            str = str4;
            str4 = str;
            x.i("MicroMsg.SnsItemReportHelper", "get ispName: %s", new Object[]{str4});
            str2 = "";
            str3 = "";
            str5 = "";
            str = "";
            fM = ao.fM(context);
            i = 0;
            while (true) {
                try {
                    str7 = str;
                    if (i >= fM.size()) {
                        break;
                    }
                    a aVar222 = (a) fM.get(i);
                    str2 = bi.aG(aVar222.poa, "");
                    str3 = bi.aG(aVar222.pob, "");
                    if (str5.length() > 0 && !bi.oW(aVar222.poc)) {
                        str5 = str5 + "|";
                    }
                    if (!bi.oW(aVar222.poc)) {
                        str5 = str5 + aVar222.poc;
                    }
                    if (str7.length() > 0 && !bi.oW(aVar222.pod)) {
                        str7 = str7 + "|";
                    }
                    if (bi.oW(aVar222.pod)) {
                        str = str7;
                    } else {
                        str = str7 + aVar222.pod;
                    }
                    i++;
                } catch (Exception e7222) {
                    e3 = e7222;
                    str = str7;
                    x.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", new Object[]{bi.i(e3)});
                    x.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", new Object[]{str2, str3, str5, str});
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(i2).append(",");
                    stringBuilder.append(str6.replace(",", " ")).append(",");
                    stringBuilder.append(stringBuffer.replace(",", " ")).append(",");
                    stringBuilder.append(str8.replace(",", " ")).append(",");
                    stringBuilder.append(str4.replace(",", " ")).append(",");
                    stringBuilder.append(str2.replace(",", " ")).append(",");
                    stringBuilder.append(str3.replace(",", " ")).append(",");
                    stringBuilder.append(str5.replace(",", " ")).append(",");
                    stringBuilder.append(str.replace(",", " "));
                    return stringBuilder.toString();
                }
            }
            str = str7;
            x.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", new Object[]{str2, str3, str5, str});
            stringBuilder = new StringBuilder();
            stringBuilder.append(i2).append(",");
            stringBuilder.append(str6.replace(",", " ")).append(",");
            stringBuilder.append(stringBuffer.replace(",", " ")).append(",");
            stringBuilder.append(str8.replace(",", " ")).append(",");
            stringBuilder.append(str4.replace(",", " ")).append(",");
            stringBuilder.append(str2.replace(",", " ")).append(",");
            stringBuilder.append(str3.replace(",", " ")).append(",");
            stringBuilder.append(str5.replace(",", " ")).append(",");
            stringBuilder.append(str.replace(",", " "));
            return stringBuilder.toString();
        }
        x.d("MicroMsg.SnsItemReportHelper", "get wifi :[%s] [%s] [%s]", new Object[]{stringBuffer, str6, str8});
        str4 = "";
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                str = telephonyManager.getNetworkOperatorName();
                try {
                    if (bi.oW(str)) {
                        str = "";
                    }
                } catch (Throwable e622) {
                    e2 = e622;
                    x.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", new Object[]{bi.i(e2)});
                    str4 = str;
                    x.i("MicroMsg.SnsItemReportHelper", "get ispName: %s", new Object[]{str4});
                    str2 = "";
                    str3 = "";
                    str5 = "";
                    str = "";
                    fM = ao.fM(context);
                    i = 0;
                    while (true) {
                        try {
                            str7 = str;
                            if (i >= fM.size()) {
                                break;
                            }
                            a aVar2222 = (a) fM.get(i);
                            str2 = bi.aG(aVar2222.poa, "");
                            str3 = bi.aG(aVar2222.pob, "");
                            if (str5.length() > 0 && !bi.oW(aVar2222.poc)) {
                                str5 = str5 + "|";
                            }
                            if (!bi.oW(aVar2222.poc)) {
                                str5 = str5 + aVar2222.poc;
                            }
                            if (str7.length() > 0 && !bi.oW(aVar2222.pod)) {
                                str7 = str7 + "|";
                            }
                            if (bi.oW(aVar2222.pod)) {
                                str = str7;
                            } else {
                                str = str7 + aVar2222.pod;
                            }
                            i++;
                        } catch (Exception e72222) {
                            e3 = e72222;
                            str = str7;
                            x.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", new Object[]{bi.i(e3)});
                            x.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", new Object[]{str2, str3, str5, str});
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(i2).append(",");
                            stringBuilder.append(str6.replace(",", " ")).append(",");
                            stringBuilder.append(stringBuffer.replace(",", " ")).append(",");
                            stringBuilder.append(str8.replace(",", " ")).append(",");
                            stringBuilder.append(str4.replace(",", " ")).append(",");
                            stringBuilder.append(str2.replace(",", " ")).append(",");
                            stringBuilder.append(str3.replace(",", " ")).append(",");
                            stringBuilder.append(str5.replace(",", " ")).append(",");
                            stringBuilder.append(str.replace(",", " "));
                            return stringBuilder.toString();
                        }
                    }
                    str = str7;
                    x.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", new Object[]{str2, str3, str5, str});
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(i2).append(",");
                    stringBuilder.append(str6.replace(",", " ")).append(",");
                    stringBuilder.append(stringBuffer.replace(",", " ")).append(",");
                    stringBuilder.append(str8.replace(",", " ")).append(",");
                    stringBuilder.append(str4.replace(",", " ")).append(",");
                    stringBuilder.append(str2.replace(",", " ")).append(",");
                    stringBuilder.append(str3.replace(",", " ")).append(",");
                    stringBuilder.append(str5.replace(",", " ")).append(",");
                    stringBuilder.append(str.replace(",", " "));
                    return stringBuilder.toString();
                }
            }
            str = str4;
            str4 = str;
        } catch (Exception e9) {
            e2 = e9;
            str = str4;
            x.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", new Object[]{bi.i(e2)});
            str4 = str;
            x.i("MicroMsg.SnsItemReportHelper", "get ispName: %s", new Object[]{str4});
            str2 = "";
            str3 = "";
            str5 = "";
            str = "";
            fM = ao.fM(context);
            i = 0;
            while (true) {
                try {
                    str7 = str;
                    if (i >= fM.size()) {
                        break;
                    }
                    a aVar22222 = (a) fM.get(i);
                    str2 = bi.aG(aVar22222.poa, "");
                    str3 = bi.aG(aVar22222.pob, "");
                    if (str5.length() > 0 && !bi.oW(aVar22222.poc)) {
                        str5 = str5 + "|";
                    }
                    if (!bi.oW(aVar22222.poc)) {
                        str5 = str5 + aVar22222.poc;
                    }
                    if (str7.length() > 0 && !bi.oW(aVar22222.pod)) {
                        str7 = str7 + "|";
                    }
                    if (bi.oW(aVar22222.pod)) {
                        str = str7;
                    } else {
                        str = str7 + aVar22222.pod;
                    }
                    i++;
                } catch (Exception e722222) {
                    e3 = e722222;
                    str = str7;
                    x.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", new Object[]{bi.i(e3)});
                    x.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", new Object[]{str2, str3, str5, str});
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(i2).append(",");
                    stringBuilder.append(str6.replace(",", " ")).append(",");
                    stringBuilder.append(stringBuffer.replace(",", " ")).append(",");
                    stringBuilder.append(str8.replace(",", " ")).append(",");
                    stringBuilder.append(str4.replace(",", " ")).append(",");
                    stringBuilder.append(str2.replace(",", " ")).append(",");
                    stringBuilder.append(str3.replace(",", " ")).append(",");
                    stringBuilder.append(str5.replace(",", " ")).append(",");
                    stringBuilder.append(str.replace(",", " "));
                    return stringBuilder.toString();
                }
            }
            str = str7;
            x.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", new Object[]{str2, str3, str5, str});
            stringBuilder = new StringBuilder();
            stringBuilder.append(i2).append(",");
            stringBuilder.append(str6.replace(",", " ")).append(",");
            stringBuilder.append(stringBuffer.replace(",", " ")).append(",");
            stringBuilder.append(str8.replace(",", " ")).append(",");
            stringBuilder.append(str4.replace(",", " ")).append(",");
            stringBuilder.append(str2.replace(",", " ")).append(",");
            stringBuilder.append(str3.replace(",", " ")).append(",");
            stringBuilder.append(str5.replace(",", " ")).append(",");
            stringBuilder.append(str.replace(",", " "));
            return stringBuilder.toString();
        }
        x.i("MicroMsg.SnsItemReportHelper", "get ispName: %s", new Object[]{str4});
        str2 = "";
        str3 = "";
        str5 = "";
        str = "";
        try {
            fM = ao.fM(context);
            i = 0;
            while (true) {
                try {
                    str7 = str;
                    if (i >= fM.size()) {
                        break;
                    }
                    a aVar222222 = (a) fM.get(i);
                    str2 = bi.aG(aVar222222.poa, "");
                    str3 = bi.aG(aVar222222.pob, "");
                    if (str5.length() > 0 && !bi.oW(aVar222222.poc)) {
                        str5 = str5 + "|";
                    }
                    if (!bi.oW(aVar222222.poc)) {
                        str5 = str5 + aVar222222.poc;
                    }
                    if (str7.length() > 0 && !bi.oW(aVar222222.pod)) {
                        str7 = str7 + "|";
                    }
                    if (bi.oW(aVar222222.pod)) {
                        str = str7;
                    } else {
                        str = str7 + aVar222222.pod;
                    }
                    i++;
                } catch (Exception e7222222) {
                    e3 = e7222222;
                    str = str7;
                    x.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", new Object[]{bi.i(e3)});
                    x.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", new Object[]{str2, str3, str5, str});
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(i2).append(",");
                    stringBuilder.append(str6.replace(",", " ")).append(",");
                    stringBuilder.append(stringBuffer.replace(",", " ")).append(",");
                    stringBuilder.append(str8.replace(",", " ")).append(",");
                    stringBuilder.append(str4.replace(",", " ")).append(",");
                    stringBuilder.append(str2.replace(",", " ")).append(",");
                    stringBuilder.append(str3.replace(",", " ")).append(",");
                    stringBuilder.append(str5.replace(",", " ")).append(",");
                    stringBuilder.append(str.replace(",", " "));
                    return stringBuilder.toString();
                }
            }
            str = str7;
        } catch (Throwable e22) {
            e3 = e22;
            x.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", new Object[]{bi.i(e3)});
            x.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", new Object[]{str2, str3, str5, str});
            stringBuilder = new StringBuilder();
            stringBuilder.append(i2).append(",");
            stringBuilder.append(str6.replace(",", " ")).append(",");
            stringBuilder.append(stringBuffer.replace(",", " ")).append(",");
            stringBuilder.append(str8.replace(",", " ")).append(",");
            stringBuilder.append(str4.replace(",", " ")).append(",");
            stringBuilder.append(str2.replace(",", " ")).append(",");
            stringBuilder.append(str3.replace(",", " ")).append(",");
            stringBuilder.append(str5.replace(",", " ")).append(",");
            stringBuilder.append(str.replace(",", " "));
            return stringBuilder.toString();
        }
        x.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", new Object[]{str2, str3, str5, str});
        stringBuilder = new StringBuilder();
        stringBuilder.append(i2).append(",");
        stringBuilder.append(str6.replace(",", " ")).append(",");
        stringBuilder.append(stringBuffer.replace(",", " ")).append(",");
        stringBuilder.append(str8.replace(",", " ")).append(",");
        stringBuilder.append(str4.replace(",", " ")).append(",");
        stringBuilder.append(str2.replace(",", " ")).append(",");
        stringBuilder.append(str3.replace(",", " ")).append(",");
        stringBuilder.append(str5.replace(",", " ")).append(",");
        stringBuilder.append(str.replace(",", " "));
        return stringBuilder.toString();
    }

    public static void eW(long j) {
        if (j != 0) {
            n fi = af.byo().fi(j);
            if (fi != null && fi.field_type == 1) {
                atf bAW = fi.bAW();
                if (bAW != null) {
                    List list = bAW.rWo;
                    List list2 = fi.bAJ().sqc.ruA;
                    int min = Math.min(list.size(), list2.size());
                    String str = "";
                    if (min > 0) {
                        str = byJ();
                        if (bi.oW(str)) {
                            return;
                        }
                    }
                    String str2 = str;
                    for (int i = 0; i < min; i++) {
                        bpo bpo = (bpo) list.get(i);
                        StringBuffer stringBuffer = new StringBuffer();
                        ate ate = (ate) list2.get(i);
                        stringBuffer.append("||index: " + i);
                        stringBuffer.append("||item poi lat " + bpo.snH + " " + bpo.snI);
                        stringBuffer.append("||item poi accuracy loctype " + bpo.biF + " " + bpo.nOD);
                        stringBuffer.append("||item pic lat " + bpo.snF + " " + bpo.snG);
                        stringBuffer.append("||item exitime:" + bpo.snK + " filetime: " + bpo.snL);
                        stringBuffer.append("||item source: " + bpo.snJ);
                        stringBuffer.append("||url" + ate.jPK);
                        String str3 = ate.jPK;
                        if (str3.startsWith("http://mmsns.qpic.cn/mmsns/")) {
                            int lastIndexOf = str3.lastIndexOf("/");
                            if (lastIndexOf > 27 && lastIndexOf < str3.length()) {
                                str3 = str3.substring(27, lastIndexOf);
                            }
                        }
                        x.d("MicroMsg.SnsItemReportHelper", "report:%s", new Object[]{str3 + "," + i.eF(j) + "," + i + "," + bi.VE() + "," + bpo.snJ + "," + bpo.snL + "," + bpo.snK + "," + bpo.snG + "," + bpo.snF + "," + bpo.snI + "," + bpo.snH + "," + str2 + "," + bpo.biF + "," + bpo.nOD});
                        h.mEJ.k(11985, str);
                    }
                }
            }
        }
    }
}
