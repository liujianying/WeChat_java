package com.tencent.mm.plugin.backup.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.a.n;
import com.tencent.mm.bk.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.backup.a.f.b;
import com.tencent.mm.plugin.backup.h.m;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bia;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.conn.util.InetAddressUtils;

public final class g {
    private static List<String> gRN = null;

    public static <T extends a> T a(T t, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            t.aG(bArr);
            return t;
        } catch (Throwable e) {
            x.e("MicroMsg.BackupUtil", "ERROR: parseProBuf [%s] [%s]", new Object[]{e.getMessage(), bi.i(e)});
            return null;
        }
    }

    public static void a(String str, com.tencent.mm.plugin.backup.h.x xVar) {
        Throwable e;
        RandomAccessFile randomAccessFile = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = str + xVar.hcI;
            File file2 = new File(str2);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str2, "rw");
            try {
                randomAccessFile2.setLength((long) xVar.hcK);
                randomAccessFile2.seek((long) xVar.hcL);
                randomAccessFile2.write(xVar.hbs.lR);
                try {
                    randomAccessFile2.close();
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                e = e3;
                randomAccessFile = randomAccessFile2;
                try {
                    x.printErrStackTrace("MicroMsg.BackupUtil", e, "writeMediaToFile fail with exception", new Object[0]);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e4) {
                        }
                    }
                } catch (Throwable th) {
                    e = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e52) {
                    }
                }
                throw e;
            }
        } catch (Exception e6) {
            e = e6;
            x.printErrStackTrace("MicroMsg.BackupUtil", e, "writeMediaToFile fail with exception", new Object[0]);
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e42) {
                }
            }
        }
    }

    public static long ws(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return -1;
        }
        if (!file.canRead()) {
            return -2;
        }
        if (file.canWrite()) {
            return file.length();
        }
        return -3;
    }

    public static void b(String str, com.tencent.mm.plugin.backup.h.x xVar) {
        if (TextUtils.isEmpty(str) || xVar == null) {
            x.e("MicroMsg.BackupUtil", "appendFile dir:%s req:%s ", new Object[]{str, xVar});
        } else if (TextUtils.isEmpty(xVar.hcI) || xVar.hbs == null || bi.bD(xVar.hbs.lR) <= 0) {
            String str2;
            String str3 = "MicroMsg.BackupUtil";
            String str4 = "appendFile dataid:%s data:%s  %s";
            Object[] objArr = new Object[3];
            objArr[0] = xVar.hcI;
            objArr[1] = xVar.hbs;
            if (xVar.hbs == null) {
                str2 = "null";
            } else {
                str2 = Integer.valueOf(bi.bD(xVar.hbs.lR));
            }
            objArr[2] = str2;
            x.e(str3, str4, objArr);
        } else {
            int i = 3;
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    long ws = ws(str + xVar.hcI);
                    File file = new File(str + xVar.hcI);
                    long length = file.exists() ? file.length() : 0;
                    int b = e.b(str, xVar.hcI, xVar.hbs.lR);
                    File file2 = new File(str + xVar.hcI);
                    if (length == (file2.exists() ? file2.length() : 0)) {
                        x.e("MicroMsg.BackupUtil", "append failed and try again:%s", new Object[]{str + xVar.hcI});
                        i = e.b(str, xVar.hcI, xVar.hbs.lR) * 10000;
                    } else {
                        i = b;
                    }
                    long ws2 = ws(str + xVar.hcI);
                    if (i != 0 || ws2 < ((long) xVar.hbs.lR.length)) {
                        x.e("MicroMsg.BackupUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(ws), Long.valueOf(ws2), Integer.valueOf(xVar.hbs.lR.length)});
                        i = i2;
                    } else {
                        x.d("MicroMsg.BackupUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(ws), Long.valueOf(ws2), Integer.valueOf(xVar.hbs.lR.length)});
                        return;
                    }
                }
                return;
            }
        }
    }

    public static String cQ(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager.getWifiState() == 3) {
            String ssid;
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                try {
                    ssid = connectionInfo.getSSID();
                } catch (Throwable e) {
                    x.e("MicroMsg.BackupUtil", "getConnectionInfo %s", new Object[]{e});
                    x.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
                    return "";
                }
            }
            ssid = "wifi";
            return (ssid.length() >= 2 && ssid.startsWith("\"") && ssid.endsWith("\"")) ? ssid.substring(1, ssid.length() - 1) : ssid;
        } else {
            int intValue;
            int i = 13;
            try {
                i = ((Integer) wifiManager.getClass().getField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
                intValue = ((Integer) wifiManager.getClass().getMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue();
            } catch (Throwable e2) {
                x.e("MicroMsg.BackupUtil", "getWifiApState %s", new Object[]{e2});
                x.printErrStackTrace("MicroMsg.BackupUtil", e2, "", new Object[0]);
                intValue = 0;
            }
            if (intValue == i) {
                x.i("MicroMsg.BackupUtil", "getWifiName apmode");
                try {
                    return ((WifiConfiguration) wifiManager.getClass().getMethod("getWifiApConfiguration", new Class[0]).invoke(wifiManager, new Object[0])).SSID;
                } catch (Throwable e3) {
                    x.e("MicroMsg.BackupUtil", "getWifiApConfiguration %s", new Object[]{e3});
                    x.printErrStackTrace("MicroMsg.BackupUtil", e3, "", new Object[0]);
                }
            }
            return "";
        }
    }

    public static String aqZ() {
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        return stringBuilder.append(c.Gq()).append("backupRecover/").toString();
    }

    public static String wt(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        return aqZ() + "backupItem/" + wv(str);
    }

    public static String wu(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        return aqZ() + "backupMeida/" + wv(str);
    }

    private static String wv(String str) {
        if (str == null) {
            return "";
        }
        String u = com.tencent.mm.a.g.u(str.getBytes());
        String str2 = "";
        String str3 = "";
        if (u.length() > 0) {
            str2 = u.charAt(0) + "/";
        }
        if (u.length() >= 2) {
            str3 = u.charAt(1) + "/";
        }
        return str2 + str3;
    }

    public static int ara() {
        Intent registerReceiver = ad.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return 100;
        }
        int intExtra = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
        boolean z = intExtra == 2 || intExtra == 5;
        x.i("MicroMsg.BackupUtil", "checkBatteryLevel, battery isCharging[%b]", new Object[]{Boolean.valueOf(z)});
        if (z) {
            return 100;
        }
        intExtra = registerReceiver.getIntExtra("level", -1);
        int intExtra2 = registerReceiver.getIntExtra("scale", -1);
        if (intExtra < 0 || intExtra2 <= 0) {
            intExtra = 100;
        } else {
            intExtra = (intExtra * 100) / intExtra2;
        }
        x.i("MicroMsg.BackupUtil", "checkBatteryLevel, battery level remaining[%d]", new Object[]{Integer.valueOf(intExtra)});
        return intExtra;
    }

    public static boolean ww(String str) {
        int ipAddress;
        int intValue;
        Throwable e;
        String[] split = str.split("\\.");
        int w = n.w(new byte[]{(byte) (bi.getInt(split[0], 0) & 255), (byte) (bi.getInt(split[1], 0) & 255), (byte) (bi.getInt(split[2], 0) & 255), (byte) (bi.getInt(split[3], 0) & 255)});
        int w2 = n.w(new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) 0});
        WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService("wifi");
        if (wifiManager.getWifiState() == 3) {
            ipAddress = wifiManager.getConnectionInfo().getIpAddress();
            String str2 = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
            x.i("MicroMsg.BackupUtil", "oldIpStr:%s, localIp:%s", new Object[]{str, str2});
            if ((w2 & w) == (ipAddress & w2)) {
                return true;
            }
            return false;
        }
        try {
            intValue = ((Integer) wifiManager.getClass().getField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
            try {
                ipAddress = ((Integer) wifiManager.getClass().getMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue();
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            intValue = 13;
        }
        if (ipAddress != intValue) {
            x.i("MicroMsg.BackupUtil", "matchip in apmode");
            return ce(w2, w);
        }
        x.i("MicroMsg.BackupUtil", "apState:%d", new Object[]{Integer.valueOf(ipAddress)});
        return false;
        x.e("MicroMsg.BackupUtil", "getWifiApState %s", new Object[]{e});
        x.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
        ipAddress = 0;
        if (ipAddress != intValue) {
            x.i("MicroMsg.BackupUtil", "apState:%d", new Object[]{Integer.valueOf(ipAddress)});
            return false;
        }
        x.i("MicroMsg.BackupUtil", "matchip in apmode");
        return ce(w2, w);
    }

    private static boolean ce(int i, int i2) {
        try {
            for (NetworkInterface inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                for (InetAddress inetAddress : Collections.list(inetAddresses.getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress()) {
                        String toUpperCase = inetAddress.getHostAddress().toUpperCase();
                        x.i("MicroMsg.BackupUtil", "check ip:%s, isIPv4:%b", new Object[]{toUpperCase, Boolean.valueOf(InetAddressUtils.isIPv4Address(toUpperCase))});
                        if (InetAddressUtils.isIPv4Address(toUpperCase)) {
                            String[] split = toUpperCase.split("\\.");
                            if ((i & i2) == (n.w(new byte[]{(byte) (bi.getInt(split[0], 0) & 255), (byte) (bi.getInt(split[1], 0) & 255), (byte) (bi.getInt(split[2], 0) & 255), (byte) (bi.getInt(split[3], 0) & 255)}) & i)) {
                                return true;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean wx(String str) {
        if (str == null) {
            return false;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        if (bl.z(str, "msg") != null) {
            return true;
        }
        return false;
    }

    public static String a(ey eyVar, int i) {
        return a(eyVar, i, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(com.tencent.mm.protocal.c.ey r5, int r6, java.lang.String r7) {
        /*
        r2 = 0;
        r0 = r5.rfA;
        if (r0 != r6) goto L_0x0014;
    L_0x0005:
        r0 = r5.rfy;
        if (r0 == 0) goto L_0x0014;
    L_0x0009:
        r0 = r5.rfy;
        r0 = r0.siK;
        r0 = r0.lR;
        r0 = com.tencent.mm.a.g.u(r0);
    L_0x0013:
        return r0;
    L_0x0014:
        r0 = 0;
        r1 = r5.rfx;
        if (r1 == 0) goto L_0x0071;
    L_0x0019:
        r1 = r5.rfw;
        if (r1 == 0) goto L_0x0071;
    L_0x001d:
        r1 = r5.rfx;
        r3 = r1.iterator();
        r1 = r0;
    L_0x0024:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0071;
    L_0x002a:
        r0 = r3.next();
        r0 = (com.tencent.mm.protocal.c.bia) r0;
        r0 = r0.siO;
        if (r0 != r6) goto L_0x006d;
    L_0x0034:
        r0 = r5.rfw;
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.protocal.c.bhz) r0;
        r0 = r0.siM;
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r7);
        if (r4 != 0) goto L_0x0050;
    L_0x0044:
        r4 = r0.endsWith(r7);
        if (r4 != 0) goto L_0x0050;
    L_0x004a:
        r0 = r1 + 1;
        r0 = r0 + 1;
        r1 = r0;
        goto L_0x0024;
    L_0x0050:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = wu(r0);
        r1 = r1.append(r3);
        r1 = r1.append(r0);
        r1 = r1.toString();
        r1 = com.tencent.mm.a.e.cn(r1);
        if (r1 != 0) goto L_0x0013;
    L_0x006b:
        r0 = r2;
        goto L_0x0013;
    L_0x006d:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0024;
    L_0x0071:
        r0 = r2;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.a.g.a(com.tencent.mm.protocal.c.ey, int, java.lang.String):java.lang.String");
    }

    public static int aR(String str, int i) {
        if (bi.oW(str)) {
            return i;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
            return i;
        }
    }

    public static boolean b(ey eyVar, int i, String str) {
        if (eyVar.rfA == i) {
            byte[] bArr = eyVar.rfy.siK.lR;
            if (bArr.length <= 0) {
                return false;
            }
            e.b(str, bArr, bArr.length);
            return true;
        }
        String a = a(eyVar, i, null);
        if (bi.oW(a)) {
            return false;
        }
        j.q(wu(a) + a, str, false);
        return true;
    }

    public static byte[] b(ey eyVar, int i) {
        if (eyVar.rfA == i && eyVar.rfy != null) {
            return eyVar.rfy.siK.lR;
        }
        if (!(eyVar.rfx == null || eyVar.rfw == null)) {
            Iterator it = eyVar.rfx.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (((bia) it.next()).siO == i) {
                    String str = ((bhz) eyVar.rfw.get(i2)).siM;
                    str = wu(str) + str;
                    i2 = e.cm(str);
                    if (i2 != 0 && i2 <= 1048576) {
                        return e.f(str, 0, -1);
                    }
                    x.e("MicroMsg.BackupUtil", "thumb not exist or  too big!");
                    return null;
                }
                i2++;
            }
        }
        return null;
    }

    public static int c(ey eyVar, int i) {
        if (eyVar.rfA == i) {
            if (eyVar.rfy == null) {
                return 0;
            }
            return eyVar.rfy.siK.lR.length;
        } else if (eyVar.rfx == null || eyVar.rfw == null) {
            return 0;
        } else {
            Iterator it = eyVar.rfx.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (((bia) it.next()).siO == i) {
                    String str = ((bhz) eyVar.rfw.get(i2)).siM;
                    return e.cm(wu(str) + str);
                }
                i2++;
            }
            return 0;
        }
    }

    public static boolean d(ey eyVar, int i) {
        if (eyVar.rfA == i && eyVar.rfy != null) {
            return true;
        }
        Iterator it = eyVar.rfx.iterator();
        while (it.hasNext()) {
            if (((bia) it.next()).siO == i) {
                return true;
            }
        }
        return false;
    }

    public static List<String> arb() {
        if (gRN != null) {
            return gRN;
        }
        gRN = new LinkedList();
        for (Object add : s.dAV) {
            gRN.add(add);
        }
        gRN.add("weixin");
        gRN.add("weibo");
        gRN.add("qqmail");
        gRN.add("fmessage");
        gRN.add("tmessage");
        gRN.add("qmessage");
        gRN.add("qqsync");
        gRN.add("floatbottle");
        gRN.add("lbsapp");
        gRN.add("shakeapp");
        gRN.add("medianote");
        gRN.add("qqfriend");
        gRN.add("readerapp");
        gRN.add("newsapp");
        gRN.add("blogapp");
        gRN.add("facebookapp");
        gRN.add("masssendapp");
        gRN.add("meishiapp");
        gRN.add("feedsapp");
        gRN.add("voipapp");
        gRN.add("officialaccounts");
        gRN.add("helper_entry");
        gRN.add("pc_share");
        gRN.add("cardpackage");
        gRN.add("voicevoipapp");
        gRN.add("voiceinputapp");
        gRN.add("linkedinplugin");
        gRN.add("appbrandcustomerservicemsg");
        return gRN;
    }

    public static boolean a(PLong pLong, PLong pLong2, String str) {
        StatFs statFs = new StatFs(h.getExternalStorageDirectory().getPath());
        pLong.value = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        File dataDirectory = h.getDataDirectory();
        statFs = new StatFs(dataDirectory.getPath());
        long blockCount = (long) statFs.getBlockCount();
        long availableBlocks = (long) statFs.getAvailableBlocks();
        pLong2.value = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        x.i("MicroMsg.BackupUtil", "checkDataFull, SDAvailSize:%d, DataAvailSize%d, dbSize:%d", new Object[]{Long.valueOf(pLong.value), Long.valueOf(pLong2.value), Long.valueOf(0)});
        if (blockCount <= 0) {
            return false;
        }
        if (blockCount - availableBlocks < 0) {
            return false;
        }
        if (pLong.value == pLong2.value || str.startsWith(dataDirectory.getPath())) {
            pLong.value = 0;
        }
        if (0 > pLong2.value) {
            return false;
        }
        return true;
    }

    public static long wy(String str) {
        long j = 0;
        try {
            return new SimpleDateFormat("yyyyMMddHHmmss").parse(str).getTime();
        } catch (ParseException e) {
            x.e("MicroMsg.BackupUtil", "dateToTimeStamp failed. date:%s, stack:%s", new Object[]{str, bi.cjd()});
            return j;
        }
    }

    public static LinkedList<String> x(LinkedList<b> linkedList) {
        LinkedList<String> linkedList2 = new LinkedList();
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                linkedList2.add(((b) it.next()).gRI);
            }
        }
        return linkedList2;
    }

    public static String a(String str, String str2, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return str;
        }
        StringBuilder stringBuilder;
        int i;
        if (str.equals("")) {
            stringBuilder = new StringBuilder(strArr[0]);
            i = 1;
        } else {
            stringBuilder = new StringBuilder(str);
            i = 0;
        }
        for (String str3 : strArr) {
            if (i != 0) {
                i = 0;
            } else {
                stringBuilder.append(str2).append(str3);
            }
        }
        return stringBuilder.toString();
    }

    public static String[] bQ(String str, String str2) {
        return str.split(str2);
    }

    public static m bU(long j) {
        m mVar = new m();
        String deviceID = q.getDeviceID(ad.getContext());
        if (deviceID == null) {
            deviceID = q.zz();
        }
        mVar.hbO = deviceID;
        mVar.hbP = Build.MANUFACTURER;
        mVar.hbQ = Build.MODEL;
        mVar.hbR = "Android";
        mVar.hbS = VERSION.RELEASE;
        mVar.hbT = d.qVN;
        mVar.hbU = j;
        x.i("MicroMsg.BackupUtil", "getBackupStartGeneralInfo WechatVersion[%s], freespace[%d], deviceId[%s]", new Object[]{Integer.valueOf(d.qVN), Long.valueOf(j), mVar.hbO});
        return mVar;
    }
}
