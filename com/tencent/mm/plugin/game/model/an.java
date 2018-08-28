package com.tencent.mm.plugin.game.model;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.model.am.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public final class an {
    private static String fMk = null;
    private static String jOh = "";

    public static void a(Context context, int i, int i2, int i3, String str, int i4, String str2) {
        x.i("MicroMsg.GameReportUtil", "reportExposureInfo : " + i + " , " + i2 + " , " + i3 + " , 1 , 0 , " + bi.oV(str) + " , " + i4 + " , 0 , " + bi.oV(null) + " , " + bi.oV(null) + " , " + bi.oV(str2));
        h.mEJ.h(13384, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(1), Integer.valueOf(0), str, Integer.valueOf(i4), Integer.valueOf(0), null, Integer.valueOf(bi.getInt(null, 0)), Integer.valueOf(getNetworkType(context)), str2});
    }

    public static void q(Context context, String str, String str2) {
        x.d("MicroMsg.GameReportUtil", "reportRegToWx, appId = " + str + ", pkgName = " + str2);
        if (bi.oW(str)) {
            x.e("MicroMsg.GameReportUtil", "reportRegToWx fail, appId is null");
            return;
        }
        h.mEJ.h(10534, new Object[]{str, Integer.valueOf(al(context, str2)), aUA(), Long.valueOf(System.currentTimeMillis() / 1000)});
    }

    public static void a(String str, String str2, int i, int i2, String str3, long j) {
        x.d("MicroMsg.GameReportUtil", "reportReadMsg, appId = " + str);
        if (bi.oW(str)) {
            x.e("MicroMsg.GameReportUtil", "reportReadMsg fail, appId is null");
            return;
        }
        x.d("MicroMsg.GameReportUtil", "reportReadMsg, unsignedlonglong = " + new BigInteger("00FFFFFFFFFFFFFFFF", 16).and(BigInteger.valueOf(j)).toString());
        h.mEJ.h(10532, new Object[]{str, r0, str2, Integer.valueOf(i), str3, Integer.valueOf(i2)});
    }

    public static void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, long j, String str5) {
        x.d("MicroMsg.GameReportUtil", "reportMsgClick 10531, appId = %s, pkgName = %s, msgSvrId:%d, snsOgjId:%s", new Object[]{str, str2, Long.valueOf(j), str5});
        if (bi.oW(str)) {
            x.e("MicroMsg.GameReportUtil", "reportMsgClick fail, appId is null");
            return;
        }
        if (context == null) {
            context = ad.getContext();
        }
        if (g.bl(str, false) == null) {
            x.e("MicroMsg.GameReportUtil", "reportMsgClick fail, appinfo is null");
            return;
        }
        ((b) com.tencent.mm.kernel.g.l(b.class)).aSg().a(a.g(10531, new Object[]{str, Integer.valueOf(al(context, str2)), aUA(), str3, Integer.valueOf(i), str4, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(getNetworkType(context)), bi.oV(r1.field_packageName), bi.oV(r1.field_signature), Long.toString(j), "", str5}));
    }

    public static void T(String str, int i, int i2) {
        x.d("MicroMsg.GameReportUtil", "reportGameDetail, appId = " + str + ", scene = " + i);
        if (bi.oW(str)) {
            x.e("MicroMsg.GameReportUtil", "reportGameDetail fail, appId is null");
            return;
        }
        h.mEJ.h(10700, new Object[]{str, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static void a(String str, String str2, int i, int i2, String str3, int i3) {
        x.d("MicroMsg.GameReportUtil", "rejectGameMsg, fromUserName = " + str + ", appId = " + str2 + ", msgType = " + i + ", scene = " + i2 + ", actionName = " + str3);
        if (bi.oW(str2)) {
            x.e("MicroMsg.GameReportUtil", "rejectGameMsg fail, appId is null");
            return;
        }
        h.mEJ.h(10546, new Object[]{str, str2, Integer.valueOf(i), aUA(), Integer.valueOf(i2), str3, Integer.valueOf(i3)});
    }

    public static void a(Context context, String str, String str2, String str3, int i, String str4, int i2) {
        x.d("MicroMsg.GameReportUtil", "reportMsgClick, appId = " + str + ", pkgName = " + str2);
        if (bi.oW(str)) {
            x.e("MicroMsg.GameReportUtil", "reportDelGameMsg fail, appId is null");
            return;
        }
        if (context == null) {
            context = ad.getContext();
        }
        ((b) com.tencent.mm.kernel.g.l(b.class)).aSg().a(a.g(10583, new Object[]{str, Integer.valueOf(al(context, str2)), aUA(), str3, Integer.valueOf(i), str4, Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(getNetworkType(context))}));
    }

    public static void a(Context context, int i, int i2, int i3, int i4, int i5, String str) {
        a(context, i, i2, i3, i4, 0, null, i5, 0, null, null, str);
    }

    public static void a(Context context, int i, int i2, int i3, int i4, String str, int i5, String str2) {
        a(context, i, i2, i3, i4, 0, str, i5, 0, null, null, str2);
    }

    public static void a(Context context, int i, int i2, int i3, int i4, String str, int i5, String str2, String str3) {
        a(context, i, i2, i3, i4, 0, str, i5, 0, null, str2, str3);
    }

    public static void a(Context context, int i, int i2, int i3, int i4, int i5, String str, int i6, int i7, String str2, String str3, String str4) {
        ((b) com.tencent.mm.kernel.g.l(b.class)).aSg().a(a.g(12909, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Integer.valueOf(i6), Integer.valueOf(i7), str2, Integer.valueOf(bi.getInt(str3, 0)), Integer.valueOf(getNetworkType(context)), str4}));
    }

    public static void a(Context context, int i, int i2, int i3, String str) {
        a g = a.g(12909, new Object[]{Integer.valueOf(18), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(2), Integer.valueOf(0), null, Integer.valueOf(i3), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(getNetworkType(context)), str});
        GameCrossProcessReportReceiver.H(g.eiF, g.jOg);
    }

    public static void a(int i, int i2, int i3, long j, String str, String str2, long j2, long j3) {
        ((b) com.tencent.mm.kernel.g.l(b.class)).aSg().a(a.g(14683, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), str, null, str2, Long.valueOf(j2), Long.valueOf(j3), null}));
    }

    public static void ao(int i, String str) {
        a aVar = new a();
        aVar.eiF = i;
        aVar.jOg = str;
        ((b) com.tencent.mm.kernel.g.l(b.class)).aSg().a(aVar);
    }

    public static String Dx(String str) {
        if (bi.oW(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            Exception exception = e;
            String str2 = "";
            x.e("MicroMsg.GameReportUtil", exception.getMessage());
            return str2;
        }
    }

    public static String D(Map<String, String> map) {
        if (map.size() == 0) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : map.entrySet()) {
            try {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (Exception e) {
                x.e("MicroMsg.GameReportUtil", e.getMessage());
                return "";
            }
        }
        try {
            return URLEncoder.encode(jSONObject.toString(), "UTF-8");
        } catch (Exception e2) {
            x.e("MicroMsg.GameReportUtil", e2.getMessage());
            return "";
        }
    }

    public static String da(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("function_type", str);
            jSONObject.put("function_value", str2);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GameReportUtil", e, "", new Object[0]);
        }
        return Dx(jSONObject.toString());
    }

    public static String Q(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str2, str3);
        } catch (Exception e) {
            x.e("MicroMsg.GameReportUtil", e.getMessage());
            jSONObject = null;
        }
        if (jSONObject != null) {
            str = db(str, jSONObject.toString());
        }
        return Dx(str);
    }

    private static String db(String str, String str2) {
        if (bi.oW(str)) {
            return str2;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str2);
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String str3 = (String) keys.next();
                        jSONObject2.put(str3, jSONObject.opt(str3));
                    } catch (Exception e2) {
                        return "";
                    }
                }
            }
            return jSONObject2.toString();
        } catch (JSONException e3) {
            return "";
        }
    }

    public static void a(String str, int i, int i2, String str2, String str3, String str4, String str5) {
        long currentTimeMillis = System.currentTimeMillis();
        ((b) com.tencent.mm.kernel.g.l(b.class)).aSg().a(a.g(10737, new Object[]{Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis), Integer.valueOf(1), str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(0), str2, "", str3, Integer.valueOf(getNetworkType(ad.getContext())), Integer.valueOf(0), Integer.valueOf(1), str4, str5}));
    }

    public static void a(String str, int i, int i2, long j, String str2) {
        a(str, i, i2, 0, 0, 0, "", 0, 0, str2, 0, 0, j, null);
    }

    public static void a(String str, int i, int i2, long j, long j2, long j3, String str2, int i3, int i4, String str3, long j4, int i5, long j5, String str4) {
        x.i("MicroMsg.GameReportUtil", "reportGameDownloadState, appId = %s, scene = %d, opId = %d, startSize = %d, downloadedSize = %d, totalSize = %d, downloadUrl = %s, errCode = %d, downloaderType = %d, chanelId = %s, costTime = %d, startState = %d, downloadId = %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str2, Integer.valueOf(i3), Integer.valueOf(i4), str3, Long.valueOf(j4), Integer.valueOf(i5), Long.valueOf(j5)});
        switch (i3) {
            case 603:
                h.mEJ.a(860, 10, 1, false);
                break;
            case 605:
                h.mEJ.a(860, 11, 1, false);
                break;
            case 606:
                h.mEJ.a(860, 12, 1, false);
                break;
            case 703:
                h.mEJ.a(860, 13, 1, false);
                break;
            case 709:
                h.mEJ.a(860, 14, 1, false);
                break;
            case 802:
                h.mEJ.a(860, 15, 1, false);
                break;
        }
        ((b) com.tencent.mm.kernel.g.l(b.class)).aSg().a(a.g(14567, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Dx(str2), Integer.valueOf(getNetworkType(ad.getContext())), Integer.valueOf(i3), Integer.valueOf(i4), str3, Long.valueOf(j4), Integer.valueOf(i5), Long.valueOf(j5), str4, aUB(), Long.valueOf(j)}));
        h.mEJ.h(15015, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Dx(str2), Integer.valueOf(getNetworkType(ad.getContext())), Integer.valueOf(i3), Integer.valueOf(i4), str3, Long.valueOf(j4), Integer.valueOf(i5), Long.valueOf(j5), str4});
    }

    public static void P(String str, String str2, String str3) {
        if (bi.oW(str) || bi.oW(str2)) {
            x.e("MicroMsg.GameReportUtil", "null open or null username");
            return;
        }
        h.mEJ.h(10738, new Object[]{str, str2, str, str3});
    }

    private static int al(Context context, String str) {
        PackageInfo packageInfo = p.getPackageInfo(context, str);
        return packageInfo == null ? 0 : packageInfo.versionCode;
    }

    private static String aUA() {
        if (fMk == null) {
            String zz = q.zz();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < zz.length() - 1; i++) {
                stringBuilder.append(Integer.toHexString(zz.charAt(i)));
            }
            stringBuilder.append("00");
            fMk = stringBuilder.toString();
        }
        return fMk;
    }

    public static int getNetworkType(Context context) {
        if (ao.is3G(context)) {
            return 4;
        }
        if (ao.is4G(context)) {
            return 5;
        }
        switch (ao.getNetType(context)) {
            case -1:
                return 255;
            case 0:
                return 1;
            case 5:
                return 2;
            case 6:
                return 3;
            default:
                return 6;
        }
    }

    public static void Dy(String str) {
        jOh = str;
    }

    private static String aUB() {
        String zy = q.zy();
        String zB = q.zB();
        String zG = zG();
        String zJ = q.zJ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("IMEI", zy);
            jSONObject.put("MAC_ADDRESS", zB);
            jSONObject.put("BLUETOOTH_ADDRESS", zG);
            jSONObject.put("IMSI", zJ);
        } catch (JSONException e) {
            x.e("MicroMsg.GameReportUtil", "getDeviceInfo: " + e.getMessage());
        }
        return Dx(jSONObject.toString());
    }

    private static String zG() {
        try {
            return bi.oV(BluetoothAdapter.getDefaultAdapter().getAddress());
        } catch (Throwable e) {
            x.e("MicroMsg.GameReportUtil", "getBlueToothAddress failed: %s", new Object[]{bi.i(e)});
            return "";
        }
    }
}
