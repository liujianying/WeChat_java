package com.tencent.mm.modelstat;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.ab.v;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bfj;
import com.tencent.mm.protocal.c.bfk;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class o {
    private static al bAZ = new al(g.Em().lnJ.getLooper(), new 4(), false);
    private static final byte[] dsN = new byte[0];
    private static long ekC = 86400000;
    private static HashMap<String, Long> ekD = new HashMap();
    private static String ekE = null;
    private static long ekF = Long.MAX_VALUE;
    private static int ekG = 0;
    private static long ekH = 0;
    private static long ekI = 0;
    private static float ekJ = 0.0f;
    private static float ekK = 0.0f;
    private static int ekL = 0;
    private static int ekM = 0;
    private static long ekN = 0;
    private static String ekO = "";

    static /* synthetic */ void ix(int i) {
        long VF = bi.VF();
        if (ekH <= 0 || VF - ekH <= 5000) {
            String[] iv = iv(i);
            if (iv == null || iv.length != 4 || bi.oW(iv[0])) {
                x.e("MicroMsg.NetTypeReporter", "report get failed val");
                return;
            }
            x.d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", new Object[]{Integer.valueOf(i), Long.valueOf(bi.bH(VF)), Float.valueOf(0.0f), Float.valueOf(0.0f), Integer.valueOf(0), Long.valueOf(0), iv[0]});
            VF = bi.bH(ekH);
            if (VF > 600000 || VF < 0) {
                VF = 0;
            }
            h.mEJ.k(11747, iv[0] + "1,0.0,0.0,0,0," + (b.foreground ? "1" : String.valueOf(VF)) + "," + iv[1] + "," + iv[2] + "," + iv[3]);
            g.Ei().DT().a(a.sPu, Long.valueOf(bi.VF()));
            return;
        }
        x.e("MicroMsg.NetTypeReporter", "never  report (reportKV) at  background :%d diff:%d", new Object[]{Long.valueOf(ekH), Long.valueOf(VF - ekH)});
    }

    public static void bS(Context context) {
        if (context == null) {
            try {
                x.e("MicroMsg.NetTypeReporter", "registerReceiver ctx == null");
                return;
            } catch (Throwable th) {
                x.e("MicroMsg.NetTypeReporter", "registerReceiver : %s", new Object[]{bi.i(th)});
                return;
            }
        }
        a aVar = new a((byte) 0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.supplicant.CONNECTION_CHANGE");
        intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(aVar, intentFilter);
        x.i("MicroMsg.NetTypeReporter", "registerReceiver finish");
    }

    private static boolean g(ArrayList<String> arrayList) {
        Throwable e;
        Iterator it;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        if (arrayList.size() == 0) {
            x.w("MicroMsg.NetTypeReporter", "checkBssidShouldReport no value in list.");
            return false;
        }
        boolean z;
        if (bi.oW(ekE)) {
            ekE = g.Ei().cachePath + "bssidcache.bin";
        }
        if (ekD.size() == 0) {
            FileInputStream fileInputStream;
            ObjectInputStream objectInputStream;
            try {
                fileInputStream = new FileInputStream(ekE);
                try {
                    objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream));
                    try {
                        ekD = (HashMap) objectInputStream.readObject();
                        x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport read file size:%d", new Object[]{Integer.valueOf(ekD.size())});
                        try {
                            objectInputStream.close();
                            fileInputStream.close();
                        } catch (Throwable e2) {
                            x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", new Object[]{bi.i(e2)});
                            ekD = new HashMap();
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        try {
                            x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", new Object[]{bi.i(e2)});
                            ekD = new HashMap();
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Throwable e22) {
                                    x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", new Object[]{bi.i(e22)});
                                    ekD = new HashMap();
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", new Object[]{Integer.valueOf(ekD.size()), ekE});
                            e.deleteFile(ekE);
                            it = arrayList.iterator();
                            z = false;
                            while (it.hasNext()) {
                                boolean z2;
                                String str = (String) it.next();
                                long bH = bi.bH(bi.ch(ekD.get(str)));
                                x.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", new Object[]{str, Long.valueOf(bH)});
                                if (bH <= 0 || bH > ekC) {
                                    ekD.put(str, Long.valueOf(bi.VF()));
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                z = z2;
                            }
                            try {
                                fileOutputStream = new FileOutputStream(ekE);
                                try {
                                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                                    try {
                                        objectOutputStream.writeObject(ekD);
                                        fileOutputStream.flush();
                                        x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", new Object[]{Integer.valueOf(ekD.size())});
                                        try {
                                            objectOutputStream.close();
                                            fileOutputStream.close();
                                        } catch (Throwable e222) {
                                            x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", new Object[]{bi.i(e222)});
                                        }
                                    } catch (Exception e4) {
                                        e222 = e4;
                                        try {
                                            x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", new Object[]{bi.i(e222)});
                                            if (objectOutputStream != null) {
                                                try {
                                                    objectOutputStream.close();
                                                } catch (Throwable e2222) {
                                                    x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", new Object[]{bi.i(e2222)});
                                                }
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            return z;
                                        } catch (Throwable th) {
                                            e2222 = th;
                                            if (objectOutputStream != null) {
                                                try {
                                                    objectOutputStream.close();
                                                } catch (Throwable e5) {
                                                    x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", new Object[]{bi.i(e5)});
                                                    throw e2222;
                                                }
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            throw e2222;
                                        }
                                    }
                                } catch (Exception e6) {
                                    e2222 = e6;
                                    objectOutputStream = null;
                                    x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", new Object[]{bi.i(e2222)});
                                    if (objectOutputStream != null) {
                                        try {
                                            objectOutputStream.close();
                                        } catch (Throwable e22222) {
                                            x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", new Object[]{bi.i(e22222)});
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    return z;
                                } catch (Throwable th2) {
                                    e22222 = th2;
                                    objectOutputStream = null;
                                    if (objectOutputStream != null) {
                                        try {
                                            objectOutputStream.close();
                                        } catch (Throwable e52) {
                                            x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", new Object[]{bi.i(e52)});
                                            throw e22222;
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    throw e22222;
                                }
                            } catch (Exception e7) {
                                e22222 = e7;
                                objectOutputStream = null;
                                fileOutputStream = null;
                                x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", new Object[]{bi.i(e22222)});
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (Throwable e222222) {
                                        x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", new Object[]{bi.i(e222222)});
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                return z;
                            } catch (Throwable th3) {
                                e222222 = th3;
                                objectOutputStream = null;
                                fileOutputStream = null;
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (Throwable e522) {
                                        x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", new Object[]{bi.i(e522)});
                                        throw e222222;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw e222222;
                            }
                            return z;
                        } catch (Throwable th4) {
                            e222222 = th4;
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Throwable e5222) {
                                    x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", new Object[]{bi.i(e5222)});
                                    ekD = new HashMap();
                                    throw e222222;
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw e222222;
                        }
                    }
                } catch (Exception e8) {
                    e222222 = e8;
                    objectInputStream = null;
                    x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", new Object[]{bi.i(e222222)});
                    ekD = new HashMap();
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Throwable e2222222) {
                            x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", new Object[]{bi.i(e2222222)});
                            ekD = new HashMap();
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", new Object[]{Integer.valueOf(ekD.size()), ekE});
                    e.deleteFile(ekE);
                    it = arrayList.iterator();
                    z = false;
                    while (it.hasNext()) {
                        boolean z22;
                        String str2 = (String) it.next();
                        long bH2 = bi.bH(bi.ch(ekD.get(str2)));
                        x.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", new Object[]{str2, Long.valueOf(bH2)});
                        if (bH2 <= 0 || bH2 > ekC) {
                            ekD.put(str2, Long.valueOf(bi.VF()));
                            z22 = true;
                        } else {
                            z22 = z;
                        }
                        z = z22;
                    }
                    fileOutputStream = new FileOutputStream(ekE);
                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(ekD);
                    fileOutputStream.flush();
                    x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", new Object[]{Integer.valueOf(ekD.size())});
                    objectOutputStream.close();
                    fileOutputStream.close();
                    return z;
                } catch (Throwable th5) {
                    e2222222 = th5;
                    objectInputStream = null;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Throwable e52222) {
                            x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", new Object[]{bi.i(e52222)});
                            ekD = new HashMap();
                            throw e2222222;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e2222222;
                }
            } catch (Exception e9) {
                e2222222 = e9;
                objectInputStream = null;
                fileInputStream = null;
                x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", new Object[]{bi.i(e2222222)});
                ekD = new HashMap();
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Throwable e22222222) {
                        x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", new Object[]{bi.i(e22222222)});
                        ekD = new HashMap();
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", new Object[]{Integer.valueOf(ekD.size()), ekE});
                e.deleteFile(ekE);
                it = arrayList.iterator();
                z = false;
                while (it.hasNext()) {
                    boolean z222;
                    String str22 = (String) it.next();
                    long bH22 = bi.bH(bi.ch(ekD.get(str22)));
                    x.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", new Object[]{str22, Long.valueOf(bH22)});
                    if (bH22 <= 0 || bH22 > ekC) {
                        ekD.put(str22, Long.valueOf(bi.VF()));
                        z222 = true;
                    } else {
                        z222 = z;
                    }
                    z = z222;
                }
                fileOutputStream = new FileOutputStream(ekE);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(ekD);
                fileOutputStream.flush();
                x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", new Object[]{Integer.valueOf(ekD.size())});
                objectOutputStream.close();
                fileOutputStream.close();
                return z;
            } catch (Throwable th6) {
                e22222222 = th6;
                objectInputStream = null;
                fileInputStream = null;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Throwable e522222) {
                        x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", new Object[]{bi.i(e522222)});
                        ekD = new HashMap();
                        throw e22222222;
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e22222222;
            }
            if (ekD.size() <= 0 || ekD.size() > BaseReportManager.MAX_READ_COUNT) {
                x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", new Object[]{Integer.valueOf(ekD.size()), ekE});
                e.deleteFile(ekE);
            }
        }
        it = arrayList.iterator();
        z = false;
        while (it.hasNext()) {
            boolean z2222;
            String str222 = (String) it.next();
            long bH222 = bi.bH(bi.ch(ekD.get(str222)));
            x.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", new Object[]{str222, Long.valueOf(bH222)});
            if (bH222 <= 0 || bH222 > ekC) {
                ekD.put(str222, Long.valueOf(bi.VF()));
                z2222 = true;
            } else {
                z2222 = z;
            }
            z = z2222;
        }
        if (z && ekD.size() > 0) {
            fileOutputStream = new FileOutputStream(ekE);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(ekD);
            fileOutputStream.flush();
            x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", new Object[]{Integer.valueOf(ekD.size())});
            objectOutputStream.close();
            fileOutputStream.close();
        }
        return z;
    }

    private static String[] iv(int i) {
        String stringBuffer;
        Throwable e;
        String str;
        TelephonyManager telephonyManager;
        String str2;
        String str3;
        List fM;
        int i2;
        Throwable e2;
        x.i("MicroMsg.NetTypeReporter", "dkNetTypeRead scene:%d fg:%b time:%d diff:%d", new Object[]{Integer.valueOf(i), Boolean.valueOf(b.foreground), Long.valueOf(ekH), Long.valueOf(bi.bH(ekH))});
        if (i <= 0) {
            x.e("MicroMsg.NetTypeReporter", "ERROR PARAM: scene:%d", new Object[]{Integer.valueOf(i)});
            return null;
        }
        Context context = ad.getContext();
        if (context == null) {
            x.e("MicroMsg.NetTypeReporter", "ERROR Context is null scene:%d", new Object[]{Integer.valueOf(i)});
            return null;
        }
        int zQ;
        x.i("MicroMsg.NetTypeReporter", "read scene:%d foreground:%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(b.foreground)});
        int i3 = 0;
        try {
            zQ = w.zQ();
        } catch (Throwable e3) {
            x.e("MicroMsg.NetTypeReporter", "getNetType : %s", new Object[]{bi.i(e3)});
            zQ = i3;
        }
        x.i("MicroMsg.NetTypeReporter", "get netType :%d", new Object[]{Integer.valueOf(zQ)});
        String str4 = "";
        String str5 = "";
        String str6 = "";
        String str7;
        String str8;
        String str9;
        StringBuilder append;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            StringBuffer stringBuffer4 = new StringBuffer();
            int i4 = 0;
            ArrayList arrayList = new ArrayList();
            stringBuffer2.append(connectionInfo.getSSID());
            stringBuffer3.append(connectionInfo.getBSSID());
            String bssid = connectionInfo.getBSSID();
            arrayList.add(bssid);
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                Collections.sort(scanResults, new 1());
                int i5 = 20;
                for (ScanResult scanResult : scanResults) {
                    if (!(scanResult == null || bi.oW(scanResult.BSSID))) {
                        if (!scanResult.BSSID.equals(bssid)) {
                            int i6 = i5 - 1;
                            if (i5 <= 0) {
                                break;
                            }
                            stringBuffer2.append("|");
                            stringBuffer2.append(bi.oV(scanResult.SSID).replace("|", "").replace(" ", ""));
                            stringBuffer3.append("|");
                            stringBuffer3.append(bi.oV(scanResult.BSSID).replace("|", "").replace(" ", ""));
                            arrayList.add(scanResult.BSSID);
                            stringBuffer4.append("|");
                            stringBuffer4.append(scanResult.level);
                            i5 = i6;
                        } else {
                            i4 = scanResult.level;
                        }
                    }
                }
            }
            i3 = i4;
            if (i >= 2000 || g(arrayList)) {
                str4 = stringBuffer2.toString();
                stringBuffer = stringBuffer3.toString();
                try {
                    str6 = i3 + stringBuffer4.toString();
                } catch (Exception e4) {
                    e = e4;
                    str = stringBuffer;
                    x.e("MicroMsg.NetTypeReporter", "getWifiInfo : %s", new Object[]{bi.i(e)});
                    stringBuffer = str;
                    x.d("MicroMsg.NetTypeReporter", "get wifi :[%s] [%s]", new Object[]{stringBuffer, str4});
                    str7 = "";
                    telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        str = str7;
                    } else {
                        str = telephonyManager.getNetworkOperatorName();
                    }
                    str7 = str;
                    x.i("MicroMsg.NetTypeReporter", "get ispName: %s", new Object[]{str7});
                    str2 = "";
                    str3 = "";
                    str8 = "";
                    str9 = "";
                    str = "";
                    fM = ao.fM(context);
                    i2 = 0;
                    str5 = str;
                    while (i2 < fM.size()) {
                        try {
                            String str10;
                            ao.a aVar = (ao.a) fM.get(i2);
                            str2 = bi.aG(aVar.poa, "");
                            str3 = bi.aG(aVar.pob, "");
                            if (str8.length() > 0 && !bi.oW(aVar.poc)) {
                                str8 = str8 + "|";
                            }
                            if (!bi.oW(aVar.poc)) {
                                str8 = str8 + aVar.poc;
                            }
                            if (str9.length() > 0 && !bi.oW(aVar.pod)) {
                                str9 = str9 + "|";
                            }
                            if (!bi.oW(aVar.pod)) {
                                str9 = str9 + aVar.pod;
                            }
                            if (str5.length() > 0) {
                                str10 = str5 + "|";
                            } else {
                                str10 = str5;
                            }
                            try {
                                append = new StringBuilder().append(str10);
                                if (bi.oW(aVar.poh)) {
                                    str = "0";
                                } else {
                                    str = aVar.poh;
                                }
                                str5 = append.append(str).toString();
                                i2++;
                            } catch (Throwable e5) {
                                e2 = e5;
                                str = str10;
                            }
                        } catch (Exception e6) {
                            e2 = e6;
                            str = str5;
                            x.e("MicroMsg.NetTypeReporter", "getNetType : %s", new Object[]{bi.i(e2)});
                            x.d("MicroMsg.NetTypeReporter", "mcc:%s mnc:%s cell:%s", new Object[]{str2, str3, str8});
                            append = new StringBuilder();
                            append.append(bi.VE()).append(",");
                            append.append(i).append(",");
                            append.append(zQ).append(",");
                            append.append(str4.replace(",", " ")).append(",");
                            append.append(nm(stringBuffer.replace(",", " "))).append(",");
                            append.append(str7.replace(",", " ")).append(",");
                            append.append(nm(str2.replace(",", " "))).append(",");
                            append.append(nm(str3.replace(",", " "))).append(",");
                            append.append(nm(str8.replace(",", " "))).append(",");
                            if (Se() < 0) {
                                return null;
                            }
                            return new String[]{Se() + "," + append.toString(), nm(str6), nm(str9), nm(str)};
                        }
                    }
                    str = str5;
                    x.d("MicroMsg.NetTypeReporter", "mcc:%s mnc:%s cell:%s", new Object[]{str2, str3, str8});
                    append = new StringBuilder();
                    append.append(bi.VE()).append(",");
                    append.append(i).append(",");
                    append.append(zQ).append(",");
                    append.append(str4.replace(",", " ")).append(",");
                    append.append(nm(stringBuffer.replace(",", " "))).append(",");
                    append.append(str7.replace(",", " ")).append(",");
                    append.append(nm(str2.replace(",", " "))).append(",");
                    append.append(nm(str3.replace(",", " "))).append(",");
                    append.append(nm(str8.replace(",", " "))).append(",");
                    if (Se() < 0) {
                        return null;
                    }
                    return new String[]{Se() + "," + append.toString(), nm(str6), nm(str9), nm(str)};
                }
                x.d("MicroMsg.NetTypeReporter", "get wifi :[%s] [%s]", new Object[]{stringBuffer, str4});
                str7 = "";
                try {
                    telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        str = telephonyManager.getNetworkOperatorName();
                    } else {
                        str = str7;
                    }
                    str7 = str;
                } catch (Throwable e7) {
                    x.e("MicroMsg.NetTypeReporter", "getNetType : %s", new Object[]{bi.i(e7)});
                }
                x.i("MicroMsg.NetTypeReporter", "get ispName: %s", new Object[]{str7});
                str2 = "";
                str3 = "";
                str8 = "";
                str9 = "";
                str = "";
                try {
                    fM = ao.fM(context);
                    i2 = 0;
                    str5 = str;
                    while (i2 < fM.size()) {
                        try {
                            String str102;
                            ao.a aVar2 = (ao.a) fM.get(i2);
                            str2 = bi.aG(aVar2.poa, "");
                            str3 = bi.aG(aVar2.pob, "");
                            if (str8.length() > 0 && !bi.oW(aVar2.poc)) {
                                str8 = str8 + "|";
                            }
                            if (!bi.oW(aVar2.poc)) {
                                str8 = str8 + aVar2.poc;
                            }
                            if (str9.length() > 0 && !bi.oW(aVar2.pod)) {
                                str9 = str9 + "|";
                            }
                            if (!bi.oW(aVar2.pod)) {
                                str9 = str9 + aVar2.pod;
                            }
                            if (str5.length() > 0) {
                                str102 = str5 + "|";
                            } else {
                                str102 = str5;
                            }
                            try {
                                append = new StringBuilder().append(str102);
                                if (bi.oW(aVar2.poh)) {
                                    str = "0";
                                } else {
                                    str = aVar2.poh;
                                }
                                str5 = append.append(str).toString();
                                i2++;
                            } catch (Throwable e52) {
                                e2 = e52;
                                str = str102;
                            }
                        } catch (Exception e62) {
                            e2 = e62;
                            str = str5;
                            x.e("MicroMsg.NetTypeReporter", "getNetType : %s", new Object[]{bi.i(e2)});
                            x.d("MicroMsg.NetTypeReporter", "mcc:%s mnc:%s cell:%s", new Object[]{str2, str3, str8});
                            append = new StringBuilder();
                            append.append(bi.VE()).append(",");
                            append.append(i).append(",");
                            append.append(zQ).append(",");
                            append.append(str4.replace(",", " ")).append(",");
                            append.append(nm(stringBuffer.replace(",", " "))).append(",");
                            append.append(str7.replace(",", " ")).append(",");
                            append.append(nm(str2.replace(",", " "))).append(",");
                            append.append(nm(str3.replace(",", " "))).append(",");
                            append.append(nm(str8.replace(",", " "))).append(",");
                            if (Se() < 0) {
                                return null;
                            }
                            return new String[]{Se() + "," + append.toString(), nm(str6), nm(str9), nm(str)};
                        }
                    }
                    str = str5;
                } catch (Throwable e522) {
                    e2 = e522;
                    x.e("MicroMsg.NetTypeReporter", "getNetType : %s", new Object[]{bi.i(e2)});
                    x.d("MicroMsg.NetTypeReporter", "mcc:%s mnc:%s cell:%s", new Object[]{str2, str3, str8});
                    append = new StringBuilder();
                    append.append(bi.VE()).append(",");
                    append.append(i).append(",");
                    append.append(zQ).append(",");
                    append.append(str4.replace(",", " ")).append(",");
                    append.append(nm(stringBuffer.replace(",", " "))).append(",");
                    append.append(str7.replace(",", " ")).append(",");
                    append.append(nm(str2.replace(",", " "))).append(",");
                    append.append(nm(str3.replace(",", " "))).append(",");
                    append.append(nm(str8.replace(",", " "))).append(",");
                    if (Se() < 0) {
                        return null;
                    }
                    return new String[]{Se() + "," + append.toString(), nm(str6), nm(str9), nm(str)};
                }
                x.d("MicroMsg.NetTypeReporter", "mcc:%s mnc:%s cell:%s", new Object[]{str2, str3, str8});
                append = new StringBuilder();
                append.append(bi.VE()).append(",");
                append.append(i).append(",");
                append.append(zQ).append(",");
                append.append(str4.replace(",", " ")).append(",");
                append.append(nm(stringBuffer.replace(",", " "))).append(",");
                append.append(str7.replace(",", " ")).append(",");
                append.append(nm(str2.replace(",", " "))).append(",");
                append.append(nm(str3.replace(",", " "))).append(",");
                append.append(nm(str8.replace(",", " "))).append(",");
                if (Se() < 0) {
                    return null;
                }
                return new String[]{Se() + "," + append.toString(), nm(str6), nm(str9), nm(str)};
            }
            x.w("MicroMsg.NetTypeReporter", "checkBssid: find all report already  , give up. scene:%d ", new Object[]{Integer.valueOf(i)});
            return null;
        } catch (Throwable e8) {
            e = e8;
            str = str5;
            x.e("MicroMsg.NetTypeReporter", "getWifiInfo : %s", new Object[]{bi.i(e)});
            stringBuffer = str;
            x.d("MicroMsg.NetTypeReporter", "get wifi :[%s] [%s]", new Object[]{stringBuffer, str4});
            str7 = "";
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                str = telephonyManager.getNetworkOperatorName();
            } else {
                str = str7;
            }
            str7 = str;
            x.i("MicroMsg.NetTypeReporter", "get ispName: %s", new Object[]{str7});
            str2 = "";
            str3 = "";
            str8 = "";
            str9 = "";
            str = "";
            fM = ao.fM(context);
            i2 = 0;
            str5 = str;
            while (i2 < fM.size()) {
                try {
                    String str1022;
                    ao.a aVar22 = (ao.a) fM.get(i2);
                    str2 = bi.aG(aVar22.poa, "");
                    str3 = bi.aG(aVar22.pob, "");
                    if (str8.length() > 0 && !bi.oW(aVar22.poc)) {
                        str8 = str8 + "|";
                    }
                    if (!bi.oW(aVar22.poc)) {
                        str8 = str8 + aVar22.poc;
                    }
                    if (str9.length() > 0 && !bi.oW(aVar22.pod)) {
                        str9 = str9 + "|";
                    }
                    if (!bi.oW(aVar22.pod)) {
                        str9 = str9 + aVar22.pod;
                    }
                    if (str5.length() > 0) {
                        str1022 = str5 + "|";
                    } else {
                        str1022 = str5;
                    }
                    try {
                        append = new StringBuilder().append(str1022);
                        if (bi.oW(aVar22.poh)) {
                            str = "0";
                        } else {
                            str = aVar22.poh;
                        }
                        str5 = append.append(str).toString();
                        i2++;
                    } catch (Throwable e5222) {
                        e2 = e5222;
                        str = str1022;
                    }
                } catch (Exception e622) {
                    e2 = e622;
                    str = str5;
                    x.e("MicroMsg.NetTypeReporter", "getNetType : %s", new Object[]{bi.i(e2)});
                    x.d("MicroMsg.NetTypeReporter", "mcc:%s mnc:%s cell:%s", new Object[]{str2, str3, str8});
                    append = new StringBuilder();
                    append.append(bi.VE()).append(",");
                    append.append(i).append(",");
                    append.append(zQ).append(",");
                    append.append(str4.replace(",", " ")).append(",");
                    append.append(nm(stringBuffer.replace(",", " "))).append(",");
                    append.append(str7.replace(",", " ")).append(",");
                    append.append(nm(str2.replace(",", " "))).append(",");
                    append.append(nm(str3.replace(",", " "))).append(",");
                    append.append(nm(str8.replace(",", " "))).append(",");
                    if (Se() < 0) {
                        return null;
                    }
                    return new String[]{Se() + "," + append.toString(), nm(str6), nm(str9), nm(str)};
                }
            }
            str = str5;
            x.d("MicroMsg.NetTypeReporter", "mcc:%s mnc:%s cell:%s", new Object[]{str2, str3, str8});
            append = new StringBuilder();
            append.append(bi.VE()).append(",");
            append.append(i).append(",");
            append.append(zQ).append(",");
            append.append(str4.replace(",", " ")).append(",");
            append.append(nm(stringBuffer.replace(",", " "))).append(",");
            append.append(str7.replace(",", " ")).append(",");
            append.append(nm(str2.replace(",", " "))).append(",");
            append.append(nm(str3.replace(",", " "))).append(",");
            append.append(nm(str8.replace(",", " "))).append(",");
            if (Se() < 0) {
                return null;
            }
            return new String[]{Se() + "," + append.toString(), nm(str6), nm(str9), nm(str)};
        }
    }

    private static String nm(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (char c : str.toCharArray()) {
            if ((c < 'a' || c > 'z') && ((c < 'A' || c > 'Z') && ((c < '0' || c > '9') && c != '|' && c != '-' && c != ' ' && c != ':'))) {
                return "";
            }
        }
        return str;
    }

    private static long Se() {
        long a;
        synchronized (dsN) {
            try {
                a = bi.a((Long) g.Ei().DT().get(a.sPt, null), 1);
                g.Ei().DT().a(a.sPt, Long.valueOf(1 + a));
                g.Ei().DT().lm(true);
                long a2 = bi.a((Long) g.Ei().DT().get(a.sPt, null), 1);
                x.i("MicroMsg.NetTypeReporter", "incSeq after write  old:%d new:%d", new Object[]{Long.valueOf(a), Long.valueOf(a2)});
            } catch (Throwable e) {
                x.e("MicroMsg.NetTypeReporter", "incSeq :%s", new Object[]{bi.i(e)});
                return -1;
            }
        }
        return a;
    }

    private static void a(int i, float f, float f2, int i2, long j) {
        long VF = bi.VF();
        if (ekH <= 0 || VF - ekH <= 5000) {
            String[] iv = iv(i);
            if (iv == null || iv.length != 4 || bi.oW(iv[0])) {
                x.e("MicroMsg.NetTypeReporter", "report get failed val");
                return;
            }
            x.d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", new Object[]{Integer.valueOf(i), Long.valueOf(bi.bH(VF)), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2), Long.valueOf(j), iv[0]});
            com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
            aVar.dIG = new bfj();
            aVar.dIH = new bfk();
            aVar.uri = "/cgi-bin/micromsg-bin/rtkvreport";
            aVar.dIF = 716;
            com.tencent.mm.ab.b KT = aVar.KT();
            bfj bfj = (bfj) KT.dID.dIL;
            bfj.rjL = d.qVI;
            bfj.rjM = d.qVH;
            bfj.rjN = d.qVK;
            bfj.rjO = d.qVL;
            bfj.rjP = com.tencent.mm.sdk.platformtools.w.chP();
            bfj.rSt = 11747;
            VF = bi.bH(ekH);
            if (VF > 600000 || VF < 0) {
                VF = 0;
            }
            bfj.mEl = iv[0] + "0," + f + "," + f2 + "," + i2 + "," + j + "," + (b.foreground ? "1" : String.valueOf(VF)) + "," + iv[1] + "," + iv[2] + "," + iv[3];
            v.a(KT, new 2(bi.VF(), bfj, iv, f, f2, i2, j), true);
            return;
        }
        x.e("MicroMsg.NetTypeReporter", "never  report  at  background :%d diff:%d", new Object[]{Long.valueOf(ekH), Long.valueOf(VF - ekH)});
    }

    public static void u(int i, String str) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new bfj();
        aVar.dIH = new bfk();
        aVar.uri = "/cgi-bin/micromsg-bin/rtkvreport";
        aVar.dIF = 716;
        com.tencent.mm.ab.b KT = aVar.KT();
        bfj bfj = (bfj) KT.dID.dIL;
        bfj.rjL = d.qVI;
        bfj.rjM = d.qVH;
        bfj.rjN = d.qVK;
        bfj.rjO = d.qVL;
        bfj.rjP = com.tencent.mm.sdk.platformtools.w.chP();
        bfj.rSt = i;
        bfj.mEl = str;
        x.i("MicroMsg.NetTypeReporter", "reportCgi logId:%d, value:%s", new Object[]{Integer.valueOf(i), str});
        v.a(KT, new 3(bi.VF(), bfj));
    }

    private static void b(int i, float f, float f2, int i2, long j) {
        try {
            x.i("MicroMsg.NetTypeReporter", "checkTimeReport scene:%d diff:%d  time:%d", new Object[]{Integer.valueOf(i), Long.valueOf(bi.bH(ekF)), Long.valueOf(ekF)});
            if (i > 2000 || bi.bH(ekF) > 300000) {
                x.i("MicroMsg.NetTypeReporter", "force Run, scene:%d diff:%d time:%d ", new Object[]{Integer.valueOf(i), Long.valueOf(bi.bH(ekF)), Long.valueOf(ekF)});
                ekG = i;
                ekF = Long.MAX_VALUE;
                a(i, f, f2, i2, j);
                return;
            }
            if (ekF == Long.MAX_VALUE) {
                ekF = bi.VF() + 60000;
            }
            ekG = i;
            bAZ.J(60000, 60000);
        } catch (Throwable th) {
            x.e("MicroMsg.NetTypeReporter", "checkTimeReport error: %s", new Object[]{bi.i(th)});
        }
    }

    public static void bQ(boolean z) {
        if (z) {
            ekH = 0;
        } else if (!bAZ.ciq()) {
            x.i("MicroMsg.NetTypeReporter", "setToForeground user turn to background run report now");
            ekH = bi.VF();
            bAZ.J(0, 0);
        }
    }

    public static synchronized void a(int i, float f, float f2, int i2) {
        synchronized (o.class) {
            if (i < 2000 || f == 0.0f || f2 == 0.0f) {
                x.e("MicroMsg.NetTypeReporter", "reportGps, invalid args, scene = %d, lon = %f, lat = %f, pre = %d", new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2)});
            } else if (bi.bH(ekN) < 60000) {
                x.e("MicroMsg.NetTypeReporter", "reportGps, hit lastReportGpsLimit, request dropped, scene = %d, lon = %f, lat = %f, pre = %d", new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2)});
            } else {
                x.i("MicroMsg.NetTypeReporter", "reportGps scene:%d lon:%f lat:%f pre:%d last:%d", new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2), Long.valueOf(bi.bH(ekN))});
                ekN = bi.VF();
                ekM = i;
                ekI = bi.VF();
                ekL = i2;
                ekJ = f2;
                ekK = f;
                try {
                    ((WifiManager) ad.getContext().getSystemService("wifi")).startScan();
                    g.Em().h(new 5(), 5000);
                } catch (Throwable e) {
                    x.e("MicroMsg.NetTypeReporter", "reportGps :%s", new Object[]{bi.i(e)});
                }
            }
        }
        return;
    }

    public static synchronized void iw(int i) {
        synchronized (o.class) {
            x.i("MicroMsg.NetTypeReporter", "run scene:%d foreground:%b lastGpsTime:%d lastbssid:%s", new Object[]{Integer.valueOf(i), Boolean.valueOf(b.foreground), Long.valueOf(ekI), ekO});
            if (i == 1005) {
                try {
                    if (ekI > 0) {
                        x.d("MicroMsg.NetTypeReporter", "report gps scene:%d lastscene:%d [%f,%f,%d] lastGpsTime", new Object[]{Integer.valueOf(i), Integer.valueOf(ekM), Float.valueOf(ekK), Float.valueOf(ekJ), Integer.valueOf(ekL), Long.valueOf(ekI)});
                        long bH = bi.bH(ekI);
                        int i2 = ekM;
                        float f = ekJ;
                        float f2 = ekK;
                        int i3 = ekL;
                        ekI = 0;
                        ekJ = 0.0f;
                        ekK = 0.0f;
                        ekL = 0;
                        ekM = 0;
                        b(i2, f2, f, i3, bH);
                    }
                } catch (Throwable th) {
                    x.e("MicroMsg.NetTypeReporter", "run :%s", new Object[]{bi.i(th)});
                }
            }
            if (!b.foreground) {
                x.w("MicroMsg.NetTypeReporter", "run is not foreground give up %d ", new Object[]{Integer.valueOf(i)});
            } else if (i == 3) {
                String bssid = ((WifiManager) ad.getContext().getSystemService("wifi")).getConnectionInfo().getBSSID();
                x.d("MicroMsg.NetTypeReporter", "run scene:%d SCENE_TO_FOREGROUND_BSSID_CHANGE %s %s ", new Object[]{Integer.valueOf(i), bssid, ekO});
                if (!(bi.oW(bssid) || bssid.equals(ekO))) {
                    ekO = bssid;
                    b(i, 0.0f, 0.0f, 0, 0);
                }
            } else if (i == 4) {
                x.i("MicroMsg.NetTypeReporter", "run scene:%d SCENE_TO_FOREGROUND_TIMEOUT  diff:%d", new Object[]{Integer.valueOf(i), Long.valueOf(bi.bH(bi.a((Long) g.Ei().DT().get(a.sPu, null), 0)))});
                if (bi.bH(bi.a((Long) g.Ei().DT().get(a.sPu, null), 0)) >= 21600000) {
                    b(i, 0.0f, 0.0f, 0, 0);
                }
            } else {
                b(i, 0.0f, 0.0f, 0, 0);
            }
        }
        return;
    }
}
