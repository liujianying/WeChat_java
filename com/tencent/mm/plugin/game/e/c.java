package com.tencent.mm.plugin.game.e;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.gq;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.n.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.plugin.game.f.j;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.vending.h.h;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c {
    private static volatile ah dJt;
    private static int ecH = -1;
    private static final Object gBw = new Object();
    private static DisplayMetrics jZh;
    private static int kdi = -1;
    private static int maxSize = -1;
    private static Rect rect = new Rect();

    public static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        if (jZh == null) {
            jZh = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(jZh);
        }
        return jZh.widthPixels;
    }

    public static int an(Context context, String str) {
        return r(context, str, null);
    }

    public static int r(Context context, String str, String str2) {
        if (bi.oW(str)) {
            return 0;
        }
        if (ao(context, str)) {
            return 30;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("show_bottom", false);
        intent.putExtra("geta8key_scene", 32);
        intent.putExtra("KPublisherId", str2);
        x(intent, context);
        return 7;
    }

    public static boolean ao(Context context, String str) {
        int i = 2;
        String queryParameter = Uri.parse(str).getQueryParameter("weapp");
        if (!bi.oW(queryParameter)) {
            try {
                Uri parse = Uri.parse(queryParameter);
                String authority = parse.getAuthority();
                if (bi.oW(authority)) {
                    x.w("MicroMsg.GameCenterUtil", "targetAppId is null");
                    return false;
                }
                String queryParameter2 = parse.getQueryParameter("env_version");
                String queryParameter3 = parse.getQueryParameter("path");
                queryParameter2 = bi.oV(queryParameter2);
                Object obj = -1;
                switch (queryParameter2.hashCode()) {
                    case 110628630:
                        if (queryParameter2.equals("trial")) {
                            int obj2 = 1;
                            break;
                        }
                        break;
                    case 1559690845:
                        if (queryParameter2.equals("develop")) {
                            obj2 = null;
                            break;
                        }
                        break;
                }
                switch (obj2) {
                    case null:
                        i = 1;
                        break;
                    case 1:
                        break;
                    default:
                        i = 0;
                        break;
                }
                x.i("MicroMsg.GameCenterUtil", "jumpWeApp, appId: %s, versionType: %d, path: %s", authority, Integer.valueOf(i), queryParameter3);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1079;
                ((d) g.l(d.class)).a(context, null, authority, i, 0, queryParameter3, appBrandStatObject);
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.GameCenterUtil", "checkJumpWeApp: " + e.getMessage());
            }
        }
        return false;
    }

    public static void a(Context context, s sVar, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", sVar.jMI.url);
        intent.putExtra("finishviewifloadfailed", true);
        intent.putExtra("show_full_screen", sVar.jMI.jMc);
        intent.putExtra("disable_progress_bar", sVar.jMI.jMc);
        int i = -1;
        switch (sVar.jMI.orientation) {
            case 1:
                i = 0;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                i = 1001;
                break;
            case 4:
                i = 1002;
                break;
        }
        intent.putExtra("screen_orientation", i);
        intent.putExtra("geta8key_scene", 32);
        intent.putExtra("KPublisherId", str);
        b kkVar = new kk();
        kkVar.bUK.type = 1;
        kkVar.bUK.context = context;
        kkVar.bUK.intent = intent;
        a.sFg.m(kkVar);
    }

    public static boolean a(View view, Context context) {
        if (view.getTag() == null || !(view.getTag() instanceof String)) {
            x.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
            return false;
        }
        String str = (String) view.getTag();
        if (bi.oW(str)) {
            x.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("show_bottom", false);
        x(intent, context);
        return true;
    }

    public static Dialog dD(Context context) {
        View inflate = View.inflate(context, f.game_progress_dialog_view, null);
        i iVar = new i(context, j.GameProgressDialogStyle);
        iVar.setContentView(inflate);
        iVar.setCancelable(true);
        iVar.setCanceledOnTouchOutside(false);
        iVar.setOnCancelListener(new 1(iVar));
        return iVar;
    }

    public static int DP(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.GameCenterUtil", "Null or Nil packageName");
            return 0;
        }
        PackageInfo packageInfo;
        try {
            packageInfo = ad.getContext().getPackageManager().getPackageInfo(str, 0);
        } catch (Exception e) {
            x.w("MicroMsg.GameCenterUtil", "Exception: %s", e.toString());
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    public static int DQ(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.GameCenterUtil", "Null or Nil path");
            return 0;
        }
        PackageInfo packageArchiveInfo = ad.getContext().getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo != null) {
            return packageArchiveInfo.versionCode;
        }
        return 0;
    }

    public static synchronized void DR(String str) {
        synchronized (c.class) {
            if (!bi.oW(str)) {
                x.d("MicroMsg.GameCenterUtil", "pre download entrance image : %s", str);
                gq gqVar = new gq();
                gqVar.bPN.nc = 1;
                gqVar.bPN.url = str;
                a.sFg.m(gqVar);
                if (gqVar.bPO.bPQ) {
                    String str2 = gqVar.bPO.bPP + com.tencent.mm.a.g.u(str.getBytes());
                    com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
                    aVar.dXy = true;
                    aVar.dXA = str2;
                    com.tencent.mm.ak.a.a.c Pt = aVar.Pt();
                    o.Pj().a(str, null, Pt, new 2(gqVar), new 3(gqVar));
                }
            }
        }
    }

    public static void R(LinkedList<String> linkedList) {
        if (!bi.cX(linkedList)) {
            List linkedList2 = new LinkedList();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                com.tencent.mm.pluginsdk.model.app.f bl = com.tencent.mm.pluginsdk.model.app.g.bl(str, true);
                if (bl != null && bi.oW(bl.field_openId)) {
                    linkedList2.add(str);
                }
            }
            if (!bi.cX(linkedList2)) {
                com.tencent.mm.plugin.ac.a.bmh().cS(linkedList2);
            }
        }
    }

    public static LinkedList<com.tencent.mm.pluginsdk.model.app.f> aVi() {
        Cursor cbP = com.tencent.mm.plugin.ac.a.bmf().cbP();
        LinkedList<com.tencent.mm.pluginsdk.model.app.f> linkedList = new LinkedList();
        if (cbP == null) {
            x.e("MicroMsg.GameCenterUtil", "getGameAppInfo failed: curosr is null");
        } else {
            if (cbP.moveToFirst()) {
                do {
                    com.tencent.mm.pluginsdk.model.app.f fVar = new com.tencent.mm.pluginsdk.model.app.f();
                    fVar.d(cbP);
                    linkedList.add(fVar);
                } while (cbP.moveToNext());
            }
            cbP.close();
        }
        return linkedList;
    }

    public static int b(Context context, String str, String str2, Bundle bundle) {
        if (!bi.oW(str)) {
            com.tencent.mm.plugin.game.model.b.a bt = com.tencent.mm.plugin.game.model.b.bt(str, bundle.getInt("game_report_from_scene", 0));
            if (bt.bWA == 2 && !bi.oW(bt.url)) {
                return r(context, bt.url, "game_center_detail");
            }
        }
        if (!bi.oW(str2)) {
            return r(context, str2, "game_center_detail");
        }
        int aTJ = com.tencent.mm.plugin.game.model.f.aTJ();
        if (aTJ == 2) {
            return ap(context, str);
        }
        if (aTJ == 1) {
            e(context, bundle);
            return 6;
        }
        String fS = bi.fS(context);
        if (bi.oW(fS) || fS.toLowerCase().equals("cn")) {
            return ap(context, str);
        }
        e(context, bundle);
        return 6;
    }

    public static int ap(Context context, String str) {
        if (bi.oW(str)) {
            return 0;
        }
        String aTI = com.tencent.mm.plugin.game.model.f.aTI();
        if (bi.oW(aTI)) {
            aTI = "game.weixin.qq.com/cgi-bin/h5/static/gamecenter/detail.html?appid=" + str;
        } else {
            aTI = aTI + "?appid=" + str;
        }
        return r(context, aTI, "game_center_detail");
    }

    public static void e(Context context, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.tencent.mm.plugin.game.ui.GameDetailUI2");
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void x(Intent intent, Context context) {
        b kkVar = new kk();
        kkVar.bUK.type = 0;
        kkVar.bUK.context = context;
        kkVar.bUK.intent = intent;
        a.sFg.m(kkVar);
    }

    public static void aox() {
        if (dJt != null) {
            synchronized (gBw) {
                if (dJt != null) {
                    com.tencent.mm.vending.h.g.abF("SubCoreGameCenter#WorkThread");
                    dJt.lnJ.quit();
                    dJt = null;
                }
            }
        }
    }

    public static ah Em() {
        if (dJt == null) {
            synchronized (gBw) {
                if (dJt == null) {
                    dJt = new ah("SubCoreGameCenter#WorkThread");
                    com.tencent.mm.vending.h.g.a("SubCoreGameCenter#WorkThread", new h(dJt.lnJ.getLooper(), "SubCoreGameCenter#WorkThread"));
                }
            }
        }
        return dJt;
    }

    public static int parseColor(String str) {
        int i = 0;
        try {
            return Color.parseColor(str);
        } catch (Exception e) {
            x.e("MicroMsg.GameCenterUtil", "parseColor: " + e.getMessage());
            return i;
        }
    }

    public static boolean dd(String str, String str2) {
        File file = new File(str);
        String m = com.tencent.mm.a.g.m(file);
        if (bi.oW(str2) || bi.oW(m)) {
            x.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 is null");
            return file.exists();
        }
        x.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 = %s, calculateMD5 = %s", str2, m);
        return str2.equalsIgnoreCase(m);
    }

    public static boolean a(String str, String str2, int i, long j, String str3) {
        if (!com.tencent.mm.plugin.downloader.e.a.yW(str)) {
            return false;
        }
        an.a(str2, i, 4, j, str3);
        return true;
    }
}
