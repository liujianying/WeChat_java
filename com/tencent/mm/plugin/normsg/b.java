package com.tencent.mm.plugin.normsg;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Debug;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.view.View;
import com.tencent.c.e.a.a.f;
import com.tencent.c.e.a.d;
import com.tencent.c.e.a.e;
import com.tencent.mm.c.c;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.plugin.normsg.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;

enum b implements a {
    ;
    
    private static final ah lFC = null;

    private b(String str) {
    }

    static {
        lFC = new ah("NormsgWorker");
    }

    public final void S(int i, int i2, int i3) {
        Context context = ad.getContext();
        if (i2 <= 0 || i2 > 4) {
            throw new IllegalArgumentException("action invalid: " + i2);
        }
        d.a aVar = new d.a(context, i, i2, (byte) 0);
        long j = (long) (i3 * BaseReportManager.MAX_READ_COUNT);
        if (j < f.vjV) {
            aVar.vjA = f.vjV;
        } else if (j > f.vjS * 12) {
            aVar.vjA = f.vjS * 12;
        }
        aVar.vjA = j;
        e.cFl().a(new d(aVar, (byte) 0));
    }

    public final String a(Object[][] objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<st>");
        for (Object[] objArr2 : objArr) {
            String IP = IP(IO((String) objArr2[0]));
            stringBuilder.append('<').append(IP).append('>').append(IP(String.valueOf(objArr2[1]))).append('<').append('/').append(IP).append('>');
        }
        stringBuilder.append("</st>");
        CRC32 crc32 = new CRC32();
        crc32.update(stringBuilder.toString().getBytes());
        stringBuilder.append("<ccdcc>").append(crc32.getValue()).append("</ccdcc>");
        stringBuilder.append("<ccdts>").append(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())).append("</ccdts>");
        return stringBuilder.toString();
    }

    public final String IO(String str) {
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append((char) ((str.charAt(i) ^ -89) ^ ((byte) (((i + 1) ^ length) ^ -1))));
        }
        return stringBuilder.toString();
    }

    private static String IP(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\"':
                    stringBuilder.append("&quot;");
                    break;
                case '&':
                    stringBuilder.append("&amp;");
                    break;
                case '\'':
                    stringBuilder.append("&apos;");
                    break;
                case f$k.AppCompatTheme_listDividerAlertDialog /*44*/:
                    stringBuilder.append("&#").append(charAt).append(';');
                    break;
                case f$k.AppCompatTheme_popupMenuStyle /*60*/:
                    stringBuilder.append("&lt;");
                    break;
                case f$k.AppCompatTheme_editTextColor /*62*/:
                    stringBuilder.append("&gt;");
                    break;
                default:
                    if (charAt <= '~') {
                        stringBuilder.append(charAt);
                        break;
                    }
                    stringBuilder.append("&#").append(charAt).append(';');
                    break;
            }
        }
        return stringBuilder.toString();
    }

    public final String ub(int i) {
        String str;
        String str2;
        Object obj;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        byte[] bjA;
        String q;
        int versionCode;
        String db;
        Map zM;
        StringBuilder stringBuilder;
        StringBuilder append;
        StringBuilder append2;
        NetworkInfo activeNetworkInfo;
        String str3 = "";
        if (g.Eg().Dx()) {
            str = (String) g.Ei().DT().get(79, "");
        } else {
            str = str3;
        }
        g.Em().h(new 1(this), 5000);
        str3 = "";
        if (g.Eg().Dx()) {
            str2 = g.Ei().dqq.tdM.tdm ? "1" : "0";
        } else {
            str2 = str3;
        }
        Context applicationContext = ad.getContext().getApplicationContext();
        WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
        String ssid = connectionInfo.getSSID();
        String bssid = connectionInfo.getBSSID();
        Context context = ad.getContext();
        if (context == null) {
            x.w("MicroMsg.NormsgSourceImpl", "Failed checking mock location: application context not initialized.");
        } else if (Secure.getInt(context.getContentResolver(), "mock_location", 0) != 0) {
            obj = 1;
            i2 = obj == null ? 1 : 0;
            i3 = com.tencent.mm.plugin.normsg.Normsg.b.bjz() ? 1 : 0;
            i4 = Debug.isDebuggerConnected() ? 1 : 0;
            i5 = (com.tencent.mm.plugin.normsg.b.f.lHa || com.tencent.mm.plugin.normsg.b.f.lHb || com.tencent.mm.plugin.normsg.b.f.lHc) ? 1 : 0;
            i6 = com.tencent.mm.plugin.normsg.b.e.lGW ? 1 : 0;
            i7 = com.tencent.mm.plugin.normsg.b.g.lHd ? 1 : 0;
            bjA = com.tencent.mm.plugin.normsg.Normsg.b.bjA();
            q = bjA == null ? com.tencent.mm.plugin.normsg.b.d.q(bjA, 0, bjA.length) : "";
            versionCode = getVersionCode();
            db = db(versionCode, i);
            zM = q.zM();
            stringBuilder = new StringBuilder();
            append = stringBuilder.append("<softtype><lctmoc>").append(i2).append("</lctmoc><level>").append(i3).append("</level>").append(str).append("<k1>");
            str3 = (String) zM.get("model name");
            if (str3 == null) {
                str3 = q.zF()[0];
            }
            append = append.append(str3).append("</k1><k2>").append(q.zH()).append("</k2><k3>").append(q.zI()).append("</k3><k4>").append(q.zy()).append("</k4><k5>").append(q.zJ()).append("</k5><k6>").append(q.zK()).append("</k6><k7>").append(q.getAndroidId()).append("</k7><k8>").append(q.zL()).append("</k8><k9>").append(q.zE()).append("</k9><k10>").append(q.zN()).append("</k10><k11>").append(bi.oV((String) zM.get("hardware"))).append("</k11><k12>").append(bi.oV((String) zM.get("revision"))).append("</k12><k13>").append(bi.oV((String) zM.get("serial"))).append("</k13><k14>").append(q.zB()).append("</k14><k15>").append(q.zG()).append("</k15><k16>");
            str3 = (String) zM.get("features");
            if (str3 == null) {
                str3 = (String) zM.get("flags");
            }
            append2 = append.append(bi.oV(str3)).append("</k16><k18>").append(q).append("</k18><k21>").append(bi.oV(ssid)).append("</k21><k22>").append(bi.oV(q.bs(applicationContext))).append("</k22><k24>").append(bi.oV(bssid)).append("</k24><k26>").append(i4).append("</k26><k30>");
            activeNetworkInfo = ((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                str3 = activeNetworkInfo.getExtraInfo();
            } else {
                str3 = null;
            }
            append = append2.append(bi.oV(str3)).append("</k30><k33>").append(ad.getPackageName()).append("</k33><k34>").append(bi.oV(y.get("ro.build.fingerprint"))).append("</k34><k35>").append(bi.oV(Build.BOARD)).append("</k35><k36>").append(bi.oV(Build.BOOTLOADER)).append("</k36><k37>").append(bi.oV(Build.BRAND)).append("</k37><k38>").append(bi.oV(Build.DEVICE)).append("</k38><k39>").append(bi.oV(Build.HARDWARE)).append("</k39><k40>").append(bi.oV(Build.PRODUCT)).append("</k40><k41>").append(i5).append("</k41><k42>").append(bi.oV(y.get("ro.product.manufacturer"))).append("</k42><k43>").append(System.getString(ad.getContext().getContentResolver(), "89884a87498ef44f")).append("</k43><k44>0</k44><k45>");
            str3 = bi.oV(bi.fR(ad.getContext()));
            if (str3.length() > 0) {
                str3 = com.tencent.mm.a.g.u(str3.getBytes());
            }
            append.append(str3).append("</k45><k46>").append(str2).append("</k46><k47>").append(bjC()).append("</k47><k48>").append(q.zy()).append("</k48><k49>").append(com.tencent.mm.compatible.util.e.duM).append("</k49><k52>").append(i6).append("</k52><k53>").append(i7).append("</k53><k57>").append(versionCode).append("</k57><k58>").append(bi.oV(db)).append("</k58><k59>").append(i).append("</k59><k61>").append(q.zA()).append("</k61></softtype>");
            return stringBuilder.toString();
        }
        obj = null;
        if (obj == null) {
        }
        if (com.tencent.mm.plugin.normsg.Normsg.b.bjz()) {
        }
        if (Debug.isDebuggerConnected()) {
        }
        if (!com.tencent.mm.plugin.normsg.b.f.lHa) {
        }
        if (com.tencent.mm.plugin.normsg.b.e.lGW) {
        }
        if (com.tencent.mm.plugin.normsg.b.g.lHd) {
        }
        bjA = com.tencent.mm.plugin.normsg.Normsg.b.bjA();
        if (bjA == null) {
        }
        versionCode = getVersionCode();
        db = db(versionCode, i);
        zM = q.zM();
        stringBuilder = new StringBuilder();
        append = stringBuilder.append("<softtype><lctmoc>").append(i2).append("</lctmoc><level>").append(i3).append("</level>").append(str).append("<k1>");
        str3 = (String) zM.get("model name");
        if (str3 == null) {
            str3 = q.zF()[0];
        }
        append = append.append(str3).append("</k1><k2>").append(q.zH()).append("</k2><k3>").append(q.zI()).append("</k3><k4>").append(q.zy()).append("</k4><k5>").append(q.zJ()).append("</k5><k6>").append(q.zK()).append("</k6><k7>").append(q.getAndroidId()).append("</k7><k8>").append(q.zL()).append("</k8><k9>").append(q.zE()).append("</k9><k10>").append(q.zN()).append("</k10><k11>").append(bi.oV((String) zM.get("hardware"))).append("</k11><k12>").append(bi.oV((String) zM.get("revision"))).append("</k12><k13>").append(bi.oV((String) zM.get("serial"))).append("</k13><k14>").append(q.zB()).append("</k14><k15>").append(q.zG()).append("</k15><k16>");
        str3 = (String) zM.get("features");
        if (str3 == null) {
            str3 = (String) zM.get("flags");
        }
        append2 = append.append(bi.oV(str3)).append("</k16><k18>").append(q).append("</k18><k21>").append(bi.oV(ssid)).append("</k21><k22>").append(bi.oV(q.bs(applicationContext))).append("</k22><k24>").append(bi.oV(bssid)).append("</k24><k26>").append(i4).append("</k26><k30>");
        activeNetworkInfo = ((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            str3 = null;
        } else {
            str3 = activeNetworkInfo.getExtraInfo();
        }
        append = append2.append(bi.oV(str3)).append("</k30><k33>").append(ad.getPackageName()).append("</k33><k34>").append(bi.oV(y.get("ro.build.fingerprint"))).append("</k34><k35>").append(bi.oV(Build.BOARD)).append("</k35><k36>").append(bi.oV(Build.BOOTLOADER)).append("</k36><k37>").append(bi.oV(Build.BRAND)).append("</k37><k38>").append(bi.oV(Build.DEVICE)).append("</k38><k39>").append(bi.oV(Build.HARDWARE)).append("</k39><k40>").append(bi.oV(Build.PRODUCT)).append("</k40><k41>").append(i5).append("</k41><k42>").append(bi.oV(y.get("ro.product.manufacturer"))).append("</k42><k43>").append(System.getString(ad.getContext().getContentResolver(), "89884a87498ef44f")).append("</k43><k44>0</k44><k45>");
        str3 = bi.oV(bi.fR(ad.getContext()));
        if (str3.length() > 0) {
            str3 = com.tencent.mm.a.g.u(str3.getBytes());
        }
        append.append(str3).append("</k45><k46>").append(str2).append("</k46><k47>").append(bjC()).append("</k47><k48>").append(q.zy()).append("</k48><k49>").append(com.tencent.mm.compatible.util.e.duM).append("</k49><k52>").append(i6).append("</k52><k53>").append(i7).append("</k53><k57>").append(versionCode).append("</k57><k58>").append(bi.oV(db)).append("</k58><k59>").append(i).append("</k59><k61>").append(q.zA()).append("</k61></softtype>");
        return stringBuilder.toString();
    }

    private static String db(int i, int i2) {
        PackageInfo packageInfo;
        String str = "";
        try {
            packageInfo = ad.getContext().getPackageManager().getPackageInfo(ad.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
            x.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + ad.getPackageName());
        }
        if (packageInfo == null) {
            return str;
        }
        com.tencent.mm.plugin.report.f fVar;
        Object[] objArr;
        try {
            str = c.p(new File(packageInfo.applicationInfo.sourceDir));
            if (!bi.oW(str)) {
                return str;
            }
            com.tencent.mm.plugin.report.f.mDy.a(322, 13, 1, true);
            fVar = com.tencent.mm.plugin.report.f.mDy;
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(4013);
            objArr[1] = String.format("%s|%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            fVar.h(11098, objArr);
            return str;
        } catch (Exception e2) {
            x.w("MicroMsg.NormsgSourceImpl", "summertoken getSecurityCode e: " + e2.getMessage());
            str = "0";
            com.tencent.mm.plugin.report.f.mDy.a(322, 12, 1, true);
            fVar = com.tencent.mm.plugin.report.f.mDy;
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(4012);
            objArr[1] = String.format("%s|%s|%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), r9.getMessage()});
            fVar.h(11098, objArr);
            return str;
        }
    }

    private static int getVersionCode() {
        PackageInfo packageInfo;
        try {
            packageInfo = ad.getContext().getPackageManager().getPackageInfo(ad.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
            x.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + ad.getPackageName());
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    private static String bjC() {
        String str = "";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            return activeNetworkInfo.getSubtype();
        } catch (Throwable e) {
            x.e("MicroMsg.NormsgSourceImpl", "getNetTypeStr: %s", new Object[]{bi.i(e)});
            return str;
        }
    }

    public final String gV(boolean z) {
        return com.tencent.mm.plugin.normsg.Normsg.b.aI(",", z);
    }

    public final String bjD() {
        List<PackageInfo> installedPackages = ad.getContext().getPackageManager().getInstalledPackages(0);
        StringBuilder stringBuilder = new StringBuilder(8192);
        for (PackageInfo packageInfo : installedPackages) {
            stringBuilder.append(packageInfo.packageName).append(10);
        }
        return stringBuilder.toString();
    }

    public final boolean bjz() {
        return com.tencent.mm.plugin.normsg.Normsg.b.bjz();
    }

    public final boolean cKL() {
        boolean z = false;
        try {
            return com.tencent.mm.plugin.normsg.Normsg.b.bjB();
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.NormsgSourceImpl", th, "unexpected error.", new Object[z]);
            return z;
        }
    }

    public final boolean c(Object obj, Class cls) {
        return Normsg.c.b(obj, cls);
    }

    public final byte[] bjE() {
        return com.tencent.mm.plugin.normsg.Normsg.b.h(false, false, false);
    }

    public final boolean bI(Object obj) {
        return Normsg.c.bI(obj);
    }

    public final void a(View view, Class<? extends com.tencent.mm.sdk.b.b> cls) {
        com.tencent.mm.plugin.normsg.b.c.a(view, cls);
    }

    public final void uc(int i) {
        com.tencent.mm.plugin.normsg.b.a.bjF().uc(i);
    }
}
