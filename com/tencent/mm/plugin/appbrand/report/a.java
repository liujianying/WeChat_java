package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public final class a {
    public static String cH(Context context) {
        if (!ao.isConnected(context)) {
            return "offline";
        }
        if (ao.isWifi(context)) {
            return "wifi";
        }
        if (ao.is4G(context)) {
            return "4g";
        }
        if (ao.is3G(context)) {
            return "3g";
        }
        if (ao.is2G(context)) {
            return "2g";
        }
        return "unknown";
    }

    public static void a(int i, String str, String str2, int i2, String str3, String str4) {
        x.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, appid %s, appversion %d, appidlist %snearbyAppIdCount %s, nearbyAppIdList %s", new Object[]{Integer.valueOf(13533), Integer.valueOf(i), bi.oV(str), Integer.valueOf(0), str2, Integer.valueOf(i2), str3});
        h.mEJ.h(13533, new Object[]{Integer.valueOf(i), bi.oV(str), Integer.valueOf(0), str2, Integer.valueOf(i2), str3, Integer.valueOf(0), str4});
    }

    public static void b(String str, int i, int i2, int i3, String str2) {
        int vn = vn(str);
        x.d("MicroMsg.AppBrandReporterManager", "stev report(%s), appId %s, appVersion %s, appState : %d, eventId %d, scene %d, sceneId %s, appType %s", new Object[]{Integer.valueOf(13801), str, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2, Integer.valueOf(vn)});
        h.mEJ.h(13801, new Object[]{str, Integer.valueOf(0), Integer.valueOf(i), Long.valueOf(bi.VE()), Integer.valueOf(i2), Integer.valueOf(i3), str2, Integer.valueOf(vn)});
    }

    public static void a(String str, int i, int i2, long j, boolean z) {
        String cH = cH(ad.getContext());
        if (bi.oW(cH)) {
            cH = "unknown";
        }
        x.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, sessionId %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, networkType %s, eventId %d,eventRusult %d, eventPercent %d, installCostTime %s, eventTime %s, useModule %b, appType %s", new Object[]{Integer.valueOf(13537), Integer.valueOf(BaseReportManager.MAX_READ_COUNT), "", "", str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", cH, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Long.valueOf(j), Long.valueOf(bi.VE()), Boolean.valueOf(z), Integer.valueOf(vn(str))});
        h hVar = h.mEJ;
        Object[] objArr = new Object[16];
        objArr[0] = Integer.valueOf(BaseReportManager.MAX_READ_COUNT);
        objArr[1] = "";
        objArr[2] = "";
        objArr[3] = str;
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(0);
        objArr[6] = Integer.valueOf(0);
        objArr[7] = "";
        objArr[8] = cH;
        objArr[9] = Integer.valueOf(i);
        objArr[10] = Integer.valueOf(i2);
        objArr[11] = Integer.valueOf(0);
        objArr[12] = Long.valueOf(j);
        objArr[13] = Long.valueOf(r2);
        objArr[14] = Integer.valueOf(z ? 1 : 0);
        objArr[15] = Integer.valueOf(r1);
        hVar.h(13537, objArr);
    }

    public static void a(String str, String str2, int i, String str3, long j, int i2, int i3) {
        AppBrandStatObject qb = com.tencent.mm.plugin.appbrand.a.qb(str);
        if (qb == null) {
            x.e("MicroMsg.AppBrandReporterManager", "statObject is Null!");
            return;
        }
        String str4 = "";
        if (!bi.oW(str2)) {
            if (str2.contains(".html")) {
                str4 = str2.substring(0, str2.lastIndexOf(".html") + 5);
            }
        }
        String str5 = "";
        try {
            str5 = p.encode(bi.oV(str4), "UTF-8");
        } catch (Throwable e) {
            x.e("MicroMsg.AppBrandReporterManager", "encode page path error!");
            x.printErrStackTrace("MicroMsg.AppBrandReporterManager", e, "", new Object[0]);
        }
        AppBrandSysConfig qa = com.tencent.mm.plugin.appbrand.a.qa(str);
        int i4 = qa == null ? 0 : qa.frm.fii;
        int i5 = qa == null ? 0 : qa.frm.fih + 1;
        String oV = bi.oV(str3);
        if (i == 18) {
            if (!bi.oW(str3)) {
                if (str3.contains(".html")) {
                    oV = str3.substring(0, str3.lastIndexOf(".html") + 5);
                }
            }
            try {
                oV = p.encode(bi.oV(oV), "UTF-8");
            } catch (Throwable e2) {
                x.e("MicroMsg.AppBrandReporterManager", "encode actionNote error!");
                x.printErrStackTrace("MicroMsg.AppBrandReporterManager", e2, "", new Object[0]);
            }
        }
        String oV2 = bi.oV(qb.bGG);
        String oV3 = bi.oV(j.qq(str).fdE);
        if (qb.scene == 0) {
            qb.scene = BaseReportManager.MAX_READ_COUNT;
        }
        int i6 = qb.cbB;
        String str6 = qb.cbC;
        int vn = vn(str);
        x.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote : %s, sessionId : %s, appid : %s, appversion : %d, appState : %d, usedState : %d, pagePath : %s, action : %d, actionNote : %s,actionTime : %s, actionResult : %d, actionErrorcode : %d, preScene : %d, preSceneNote : %s, appType : %d", new Object[]{Integer.valueOf(13539), Integer.valueOf(qb.scene), oV2, oV3, str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(qb.gqK), str4, Integer.valueOf(i), oV, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i6), str6, Integer.valueOf(vn)});
        h.mEJ.h(13539, new Object[]{Integer.valueOf(qb.scene), oV2, oV3, str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(qb.gqK), str5, Integer.valueOf(i), oV, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i6), str6, Integer.valueOf(vn)});
    }

    public static void G(String str, int i, int i2) {
        if (!"@LibraryAppId".equals(str)) {
            int i3;
            int i4;
            int i5 = BaseReportManager.MAX_READ_COUNT;
            String str2 = "";
            int i6 = 0;
            if (bi.oW(str)) {
                i3 = BaseReportManager.MAX_READ_COUNT;
                i4 = 0;
            } else {
                int i7;
                AppBrandStatObject qb = com.tencent.mm.plugin.appbrand.a.qb(str);
                if (qb != null) {
                    int i8 = qb.scene == 0 ? BaseReportManager.MAX_READ_COUNT : qb.scene;
                    str2 = bi.oV(qb.bGG);
                    i7 = qb.gqK;
                    i5 = i8;
                } else {
                    i7 = 0;
                }
                AppBrandSysConfig qa = com.tencent.mm.plugin.appbrand.a.qa(str);
                if (!(qa == null || qa.frm == null)) {
                    i6 = qa.frm.fii;
                }
                if (!(i2 != 0 || qa == null || qa.frm == null)) {
                    i2 = qa.frm.fih + 1;
                }
                i3 = vn(str);
                i4 = i7;
            }
            x.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %s, sceneNote %s, appId %s, appVersion %s, appState %s, usedState %s, pagetype %s, targetAction %s, appType %s", new Object[]{Integer.valueOf(13541), Integer.valueOf(i5), str2, str, Integer.valueOf(i6), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(3), Integer.valueOf(i3)});
            h.mEJ.h(13541, new Object[]{Integer.valueOf(i5), str2, str, Integer.valueOf(i6), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(3), "", Integer.valueOf(i3)});
            if (!TextUtils.isEmpty(str2) && str2.contains("isWidget=1")) {
                f.f(i, str, str2);
            }
        }
    }

    public static void a(String str, int i, int i2, int i3, int i4) {
        h.mEJ.h(14369, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(1)});
    }

    public static int vn(String str) {
        int i = 0;
        if ("@LibraryAppId".equals(str)) {
            return 0;
        }
        if (ad.cic()) {
            WxaAttributes f = e.aba().f(str, new String[]{"appInfo"});
            if (f != null) {
                i = f.aej().dCn;
            } else {
                x.i("MicroMsg.AppBrandReporterManager", "getServiceTypeForReport null = attrs!");
            }
        } else if (!bi.oW(str)) {
            g pY = com.tencent.mm.plugin.appbrand.a.pY(str);
            AppBrandInitConfig appBrandInitConfig = pY == null ? null : pY.fct;
            if (appBrandInitConfig != null) {
                i = appBrandInitConfig.bGM;
            } else {
                x.i("MicroMsg.AppBrandReporterManager", "getServiceTypeForReport null = initConfig! appServiceType:%s", new Object[]{Integer.valueOf(b.vo(str))});
                i = r1;
            }
        }
        return i + BaseReportManager.MAX_READ_COUNT;
    }
}
