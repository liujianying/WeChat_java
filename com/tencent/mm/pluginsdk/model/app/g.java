package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.model.q;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g {

    public interface a {
        void cI(boolean z);
    }

    public static f Jn(String str) {
        return bl(str, true);
    }

    public static f cP(String str, int i) {
        f fVar = null;
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
        } else if (com.tencent.mm.plugin.ac.a.a.a.bmm() == null) {
            x.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
        } else {
            fVar = com.tencent.mm.plugin.ac.a.a.a.bmm().Jn(str);
            Object obj = (fVar == null || fVar.field_appVersion < i) ? 1 : null;
            if (obj != null) {
                com.tencent.mm.plugin.ac.a.a.a.bmm().Jp(str);
            }
        }
        return fVar;
    }

    public static f bk(String str, boolean z) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
            return null;
        }
        com.tencent.mm.plugin.ac.a.a bmm = com.tencent.mm.plugin.ac.a.a.a.bmm();
        if (bmm == null) {
            x.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
            return null;
        } else if (z) {
            return bmm.Jo(str);
        } else {
            f Jn = bmm.Jn(str);
            if (Jn == null) {
                return bmm.Jo(str);
            }
            bmm.Jp(str);
            return Jn;
        }
    }

    public static f bl(String str, boolean z) {
        f fVar = null;
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
        } else if (com.tencent.mm.plugin.ac.a.a.a.bmm() == null) {
            x.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
        } else {
            fVar = com.tencent.mm.plugin.ac.a.a.a.bmm().Jn(str);
            if (z) {
                Object obj = (fVar == null || fVar.field_appName == null || fVar.field_appName.length() == 0) ? 1 : null;
                if (obj != null) {
                    com.tencent.mm.plugin.ac.a.a.a.bmm().Jp(str);
                }
            }
        }
        return fVar;
    }

    public static Bitmap b(String str, int i, float f) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppInfoLogic", "getAppIcon, appId is null");
            return null;
        } else if (!com.tencent.mm.kernel.g.Eg().Dx()) {
            return null;
        } else {
            Bitmap a;
            if (com.tencent.mm.kernel.g.Ei().isSDCardAvailable()) {
                a = com.tencent.mm.plugin.ac.a.a.a.bmm().a(str, i, f);
                if (a == null) {
                    x.w("MicroMsg.AppInfoLogic", "getAppIcon, bm does not exist or has been recycled");
                    com.tencent.mm.plugin.ac.a.a.a.bmm().bS(str, i);
                    return null;
                } else if (a.isRecycled()) {
                    return null;
                } else {
                    return a;
                }
            } else if (ad.getContext() == null || ad.getContext().getResources() == null) {
                return null;
            } else {
                switch (i) {
                    case 1:
                    case 3:
                    case 4:
                    case 5:
                        a = BitmapFactory.decodeResource(ad.getContext().getResources(), d.sharemore_nosdcard_icon);
                        if (a == null || a.isRecycled()) {
                            return null;
                        }
                        return a;
                    case 2:
                        return null;
                    default:
                        x.e("MicroMsg.AppInfoLogic", "getAppIcon, unknown iconType = " + i);
                        return null;
                }
            }
        }
    }

    public static List<f> b(Context context, long j, boolean z) {
        List arrayList = new ArrayList();
        i bmf = com.tencent.mm.plugin.ac.a.bmf();
        StringBuilder stringBuilder = new StringBuilder(ab.CTRL_BYTE);
        stringBuilder.append("select * from AppInfo");
        stringBuilder.append(" where ");
        stringBuilder.append(" ( appSupportContentType & ").append(j).append(" ) != 0");
        stringBuilder.append(" and  ( svrAppSupportContentType & ").append(j).append(" ) != 0");
        stringBuilder.append(" and  ( appInfoFlag & 8192 ) != 0");
        stringBuilder.append(" and status != 4");
        if (!z) {
            stringBuilder.append(" and  ( appInfoFlag & 16384 ) == 0");
        }
        x.v("MicroMsg.AppInfoStorage", "getAppInfoByContentFlag sql %s", new Object[]{stringBuilder.toString()});
        Cursor rawQuery = bmf.rawQuery(stringBuilder.toString(), new String[0]);
        if (rawQuery == null) {
            x.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
            rawQuery = null;
        }
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                f fVar = new f();
                fVar.d(rawQuery);
                if (fVar.field_status == 1) {
                    if (!r(context, fVar.field_appId)) {
                        fVar.field_status = 4;
                        com.tencent.mm.plugin.ac.a.a.a.bmm().e(fVar);
                    } else if (!bi.oW(fVar.field_signature)) {
                        arrayList.add(fVar);
                    }
                } else if (fVar.field_signature != null) {
                    arrayList.add(fVar);
                }
            }
            rawQuery.close();
        }
        return arrayList;
    }

    public static boolean m(Context context, long j) {
        if (b(context, j, true).size() == 0) {
            return false;
        }
        return true;
    }

    public static boolean U(Context context, int i) {
        Long Sy = com.tencent.mm.pluginsdk.b.a.Sy(String.valueOf(i));
        if (Sy == null || b(context, Sy.longValue(), true).size() == 0) {
            return false;
        }
        return true;
    }

    public static List<f> eR(Context context) {
        List arrayList = new ArrayList();
        if (com.tencent.mm.plugin.ac.a.a.a.bmm() == null) {
            x.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
        } else {
            Cursor bmj = com.tencent.mm.plugin.ac.a.a.a.bmm().bmj();
            if (bmj != null) {
                while (bmj.moveToNext()) {
                    f fVar = new f();
                    fVar.d(bmj);
                    if (fVar.field_status == 1) {
                        if (!r(context, fVar.field_appId)) {
                            fVar.field_status = 4;
                            com.tencent.mm.plugin.ac.a.a.a.bmm().e(fVar);
                        } else if (!bi.oW(fVar.field_signature)) {
                            arrayList.add(fVar);
                        }
                    } else if (fVar.field_signature != null) {
                        arrayList.add(fVar);
                    }
                }
                bmj.close();
            }
        }
        return arrayList;
    }

    public static List<f> a(Context context, boolean z, int i) {
        List<f> arrayList = new ArrayList();
        if (com.tencent.mm.plugin.ac.a.a.a.bmm() == null) {
            x.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
        } else {
            arrayList = BI(i);
            int[] iArr = null;
            if (z) {
                iArr = new int[]{5};
            }
            if (iArr != null) {
                Cursor n = com.tencent.mm.plugin.ac.a.a.a.bmm().n(iArr);
                if (n != null) {
                    while (n.moveToNext()) {
                        f fVar = new f();
                        fVar.d(n);
                        if (fVar.field_status == 1) {
                            if (!r(context, fVar.field_appId)) {
                                fVar.field_status = 4;
                                com.tencent.mm.plugin.ac.a.a.a.bmm().e(fVar);
                            } else if (!bi.oW(fVar.field_signature)) {
                                arrayList.add(fVar);
                            }
                        } else if (fVar.field_signature != null) {
                            arrayList.add(fVar);
                        }
                    }
                    n.close();
                }
            }
        }
        return arrayList;
    }

    private static List<f> BI(int i) {
        List arrayList = new ArrayList();
        if (com.tencent.mm.plugin.ac.a.a.a.bmm() == null) {
            x.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
        } else {
            Cursor dh = com.tencent.mm.plugin.ac.a.a.a.bmm().dh(1, i);
            if (dh != null) {
                while (dh.moveToNext()) {
                    f fVar = new f();
                    fVar.d(dh);
                    if (!bi.oW(fVar.field_openId)) {
                        arrayList.add(fVar);
                    }
                }
                dh.close();
            }
        }
        return arrayList;
    }

    public static boolean r(Context context, String str) {
        if (context != null && str != null && str.length() != 0) {
            return a(context, bl(str, true));
        }
        x.e("MicroMsg.AppInfoLogic", "isAppInstalled, invalid arguments");
        return false;
    }

    public static boolean a(Context context, f fVar) {
        if (fVar == null) {
            x.w("MicroMsg.AppInfoLogic", "app is null");
            return false;
        } else if (fVar.field_packageName != null && fVar.field_packageName.length() != 0) {
            return p.r(context, fVar.field_packageName);
        } else {
            x.w("MicroMsg.AppInfoLogic", "field_packageName is null");
            return false;
        }
    }

    public static boolean cT(String str) {
        if (str == null || str.trim().length() == 0 || str.equals("weixinfile") || str.equals("invalid_appname")) {
            return false;
        }
        return true;
    }

    public static String q(Context context, String str) {
        return b(context, bl(str, true), null);
    }

    public static String b(Context context, f fVar, String str) {
        if (context == null || fVar == null) {
            return str;
        }
        String eS = eS(context);
        String str2 = null;
        if (eS.equalsIgnoreCase("zh_CN")) {
            str2 = fVar.field_appName;
        }
        if (eS.equalsIgnoreCase("en")) {
            str2 = bi.oW(fVar.field_appName_en) ? fVar.field_appName : fVar.field_appName_en;
        }
        if (eS.equalsIgnoreCase("zh_TW") || eS.equalsIgnoreCase("zh_HK")) {
            if (eS.equalsIgnoreCase("zh_HK")) {
                str2 = bi.oW(fVar.field_appName_hk) ? fVar.field_appName_tw : fVar.field_appName_hk;
            }
            if (bi.oW(str2)) {
                str2 = bi.oW(fVar.field_appName_tw) ? fVar.field_appName : fVar.field_appName_tw;
            }
        }
        if (bi.oW(str2)) {
            str2 = bi.oW(fVar.field_appName_en) ? fVar.field_appName : fVar.field_appName_en;
        }
        if (bi.oW(str2)) {
            return str;
        }
        return str2;
    }

    public static String eS(Context context) {
        String d = w.d(context.getSharedPreferences(ad.chY(), 0));
        if (d == null || d.length() == 0 || d.equalsIgnoreCase("zh_CN")) {
            return "zh_CN";
        }
        return d;
    }

    public static boolean cU(String str) {
        if (bi.oW(str)) {
            return false;
        }
        f bl = bl(str, false);
        if (bl != null) {
            return bl.aaq();
        }
        x.w("MicroMsg.AppInfoLogic", "app is null, appId = " + str);
        return false;
    }

    public static boolean g(f fVar) {
        if (fVar == null || bi.oW(fVar.field_appId) || (fVar.field_appInfoFlag & 1) <= 0) {
            return false;
        }
        return true;
    }

    public static boolean h(f fVar) {
        if (fVar == null || (fVar.field_appInfoFlag & 2) == 0) {
            return true;
        }
        return false;
    }

    public static boolean SS(String str) {
        if (bi.oW(str)) {
            return false;
        }
        f bl = bl(str, true);
        if (bl == null || bi.oW(bl.field_appId)) {
            return false;
        }
        if (bl.field_appId.equals("wx7fa037cc7dfabad5")) {
            return true;
        }
        if ((bl.field_appInfoFlag & 8) > 0) {
            return true;
        }
        return false;
    }

    public static boolean i(f fVar) {
        if (fVar == null || bi.oW(fVar.field_appId)) {
            return false;
        }
        boolean z;
        if ((fVar.field_appInfoFlag & 64) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.v("MicroMsg.AppInfoLogic", "canReadMMMsg, appid = %s, ret = %b", new Object[]{fVar.field_appId, Boolean.valueOf(z)});
        return z;
    }

    public static boolean a(f fVar, int i) {
        if (fVar == null || bi.oW(fVar.field_appId)) {
            return false;
        }
        boolean z;
        if ((fVar.field_appInfoFlag & i) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.AppInfoLogic", "isAppHasFlag, appid = %s, flag = %s, ret = %b", new Object[]{fVar.field_appId, Integer.valueOf(i), Boolean.valueOf(z)});
        x.i("MicroMsg.AppInfoLogic", "appInfoFlag = " + fVar.field_appInfoFlag);
        return z;
    }

    public static boolean j(f fVar) {
        if (fVar == null || bi.oW(fVar.field_appId)) {
            return false;
        }
        Object obj;
        if ((fVar.field_appInfoFlag & 128) > 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (1 != obj) {
            return false;
        }
        String str = fVar.field_appId;
        Map hashMap = new HashMap();
        q.q(hashMap);
        str = hashMap.containsKey(str) ? (String) hashMap.get(str) : null;
        if (str == null || str.equals("0")) {
            return true;
        }
        return false;
    }

    public static boolean a(Context context, String str, WXMediaMessage wXMediaMessage, int i, a aVar, Bundle bundle) {
        if (context == null) {
            x.e("MicroMsg.AppInfoLogic", "launch app failed: context is null");
            if (aVar == null) {
                return false;
            }
            aVar.cI(false);
            return false;
        } else if (bi.oW(str)) {
            x.e("MicroMsg.AppInfoLogic", "launch app failed: appid is null or nil");
            if (aVar == null) {
                return false;
            }
            aVar.cI(false);
            return false;
        } else if (wXMediaMessage == null) {
            x.e("MicroMsg.AppInfoLogic", "launch app failed: wxMsg is null");
            if (aVar == null) {
                return false;
            }
            aVar.cI(false);
            return false;
        } else {
            f cP;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                cP = cP(str, Integer.MAX_VALUE);
            } else {
                cP = bk(str, false);
            }
            if (cP == null) {
                x.e("MicroMsg.AppInfoLogic", "get appinfo is null, appid is : [%s]", new Object[]{str});
                if (aVar == null) {
                    return false;
                }
                aVar.cI(false);
                return false;
            } else if (cP.field_status == 3) {
                x.e("MicroMsg.AppInfoLogic", "requestAppShow fail, app is in blacklist, packageName = " + cP.field_packageName);
                if (aVar == null) {
                    return false;
                }
                aVar.cI(false);
                return false;
            } else {
                return a(context, cP.field_packageName, wXMediaMessage, str, cP.field_openId, i, aVar, bundle);
            }
        }
    }

    public static boolean a(Context context, String str, WXMediaMessage wXMediaMessage, String str2, String str3, int i, a aVar, Bundle bundle) {
        x.d("MicroMsg.AppInfoLogic", "request pkg = " + str + ", openId = " + str3);
        return a(context, str, str2, c(context, wXMediaMessage, str3), i, aVar, bundle);
    }

    public static boolean a(Context context, String str, String str2, Req req, int i, a aVar, Bundle bundle) {
        if (req == null) {
            x.i("MicroMsg.AppInfoLogic", "launchApp failed, req is null.");
            if (aVar != null) {
                aVar.cI(false);
            }
            return false;
        } else if (TextUtils.isEmpty(str) || !p.r(context, str)) {
            x.i("MicroMsg.AppInfoLogic", "launchApp failed, pkg is null or application has not installed.");
            h.bA(context, context.getString(com.tencent.mm.plugin.comm.a.h.chatting_send_app_not_installed));
            if (aVar != null) {
                aVar.cI(false);
            }
            return false;
        } else {
            x.i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) with appId(%s)", new Object[]{str, str2});
            if (bi.oV(ad.getPackageName()).equals(str)) {
                x.i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
                if (aVar != null) {
                    aVar.cI(false);
                }
                return false;
            }
            final Req req2 = req;
            final String str3 = str;
            final Context context2 = context;
            final a aVar2 = aVar;
            Runnable anonymousClass1 = new Runnable() {
                public final void run() {
                    Bundle bundle = new Bundle();
                    req2.toBundle(bundle);
                    p.ae(bundle);
                    p.af(bundle);
                    Args args = new Args();
                    args.targetPkgName = str3;
                    args.bundle = bundle;
                    boolean send = MMessageActV2.send(context2, args);
                    if (aVar2 != null) {
                        aVar2.cI(send);
                    }
                }
            };
            if (i == 2) {
                x.i("MicroMsg.AppInfoLogic", "launchApp with show confirm dialog(%s).", new Object[]{str});
                anonymousClass1.run();
                return true;
            }
            String string;
            String string2;
            String string3;
            String str4;
            if (bundle != null) {
                string = bundle.getString("current_page_url", "");
                string2 = bundle.getString("current_page_appid", "");
            } else {
                string = "";
                string2 = "";
            }
            if (bl(str2, true) != null) {
                string3 = context.getString(com.tencent.mm.plugin.comm.a.h.launch_3rd_detail_app_tips, new Object[]{b(context, r4, null)});
            } else {
                string3 = context.getString(com.tencent.mm.plugin.comm.a.h.launch_3rd_app_tips);
            }
            if (str2 == null) {
                str4 = "";
            } else {
                str4 = str2;
            }
            if ("wx073f4a4daff0abe8".equalsIgnoreCase(str4)) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(15413, new Object[]{Integer.valueOf(1), "", ""});
            }
            x.i("MicroMsg.AppInfoLogic", "launchApp with args(showType : %s, pkg : %s)", new Object[]{Integer.valueOf(i), str});
            h.a(context, string3, "", context.getString(com.tencent.mm.plugin.comm.a.h.launch_3rd_app_confirm), context.getString(com.tencent.mm.plugin.comm.a.h.app_cancel), false, (OnClickListener) new 2(str, string, string2, str4, anonymousClass1), (OnClickListener) new 3(str, string, string2, str4, aVar));
            return true;
        }
    }

    public static boolean f(Context context, Uri uri) {
        if (context == null || uri == null) {
            x.i("MicroMsg.AppInfoLogic", "launchApp failed, context or uri is null.");
            return false;
        }
        x.i("MicroMsg.AppInfoLogic", "try to launchApp with uri.");
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.addFlags(268435456);
        return a(context, intent, null, null, null);
    }

    public static boolean a(Context context, Intent intent, String str) {
        return a(context, intent, str, null, null);
    }

    public static boolean a(Context context, Intent intent, String str, a aVar) {
        return a(context, intent, str, aVar, null);
    }

    public static boolean a(Context context, Intent intent, String str, a aVar, Bundle bundle) {
        return a(context, intent, str, 0, aVar, bundle);
    }

    public static boolean a(Context context, Intent intent, String str, int i, a aVar, Bundle bundle) {
        if (context == null || intent == null) {
            x.i("MicroMsg.AppInfoLogic", "launchApp failed, context or intent is null.");
            if (aVar != null) {
                aVar.cI(false);
            }
            return false;
        }
        String string;
        String string2;
        if (bundle != null) {
            string = bundle.getString("current_page_url", "");
            string2 = bundle.getString("current_page_appid", "");
        } else {
            string = "";
            string2 = "";
        }
        List B = bi.B(context, intent);
        if (B == null || B.isEmpty()) {
            x.w("MicroMsg.AppInfoLogic", "launchApp failed, not activity can resolve the intent.");
            if (aVar != null) {
                aVar.cI(false);
            }
            return false;
        }
        String b;
        if (TextUtils.isEmpty(intent.getPackage()) && B.size() == 1) {
            b = b((ResolveInfo) B.get(0));
        } else {
            b = intent.getPackage();
        }
        x.d("MicroMsg.AppInfoLogic", "launchApp, wxpkg : %s.", new Object[]{ad.getPackageName()});
        if (bi.oV(ad.getPackageName()).equals(b)) {
            x.i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
            if (aVar != null) {
                aVar.cI(false);
            }
            return false;
        }
        x.i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) by wechat with intent", new Object[]{b});
        if (i == 2) {
            context.startActivity(intent);
            if (aVar != null) {
                aVar.cI(true);
            }
            return true;
        }
        String string3;
        if (TextUtils.isEmpty(str)) {
            string3 = context.getString(com.tencent.mm.plugin.comm.a.h.launch_3rd_app_tips);
        } else {
            string3 = context.getString(com.tencent.mm.plugin.comm.a.h.launch_3rd_detail_app_tips, new Object[]{str});
        }
        h.a(context, string3, "", context.getString(com.tencent.mm.plugin.comm.a.h.launch_3rd_app_confirm), context.getString(com.tencent.mm.plugin.comm.a.h.app_cancel), false, (OnClickListener) new 4(context, intent, b, string, string2, aVar), new 5(b, string, string2, aVar));
        return true;
    }

    public static Req c(Context context, WXMediaMessage wXMediaMessage, String str) {
        Req req = new Req();
        if (context == null) {
            context = ad.getContext();
        }
        req.message = wXMediaMessage;
        req.transaction = com.tencent.mm.a.g.u((bi.VF()).getBytes());
        req.openId = str;
        req.lang = w.d(context.getSharedPreferences(ad.chY(), 0));
        req.country = (String) com.tencent.mm.kernel.g.Ei().DT().get(274436, null);
        return req;
    }

    public static String b(ResolveInfo resolveInfo) {
        if (resolveInfo == null) {
            return null;
        }
        String str = resolveInfo.resolvePackageName;
        if (!TextUtils.isEmpty(str) || resolveInfo.activityInfo == null) {
            return str;
        }
        return resolveInfo.activityInfo.packageName;
    }

    public static void cbM() {
        SharedPreferences chZ = ad.chZ();
        if (chZ != null) {
            chZ.edit().putString("key_app_ids_registion_while_not_login", "").commit();
        }
    }
}
