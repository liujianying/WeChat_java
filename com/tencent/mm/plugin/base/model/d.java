package com.tencent.mm.plugin.base.model;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcelable;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.a.g;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.aa.j;
import com.tencent.mm.aa.q;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.util.LinkedList;
import java.util.List;

public final class d {
    private static List<c> hdw = new LinkedList();

    public static void a(Context context, String str, String str2, a aVar) {
        if (context == null || bi.oW(str)) {
            x.e("MicroMsg.WebviewShrotcutManager", "context or username is null");
            if (aVar != null) {
                aVar.dF(false);
                return;
            }
            return;
        }
        x.d("MicroMsg.WebviewShrotcutManager", "addShortcut, username = %s", new Object[]{str});
        if (!au.HX() || au.Dr()) {
            x.e("MicroMsg.WebviewShrotcutManager", "acc not ready");
            if (aVar != null) {
                aVar.dF(false);
                return;
            }
            return;
        }
        au.HU();
        ab Yg = com.tencent.mm.model.c.FR().Yg(str);
        String str3 = "";
        if (Yg != null) {
            str3 = Yg.BK();
        }
        if (bi.oW(str3)) {
            x.e("MicroMsg.WebviewShrotcutManager", "displayname is nil, should pull from service");
            a.dBr.a(str, "", new 1(aVar, str, context, str2));
            return;
        }
        a(context, str, str2, str3, aVar);
    }

    public static void a(Context context, String str, String str2, String str3, a aVar) {
        if (X(context, str3)) {
            x.i("MicroMsg.WebviewShrotcutManager", "shortcut has exist");
            if (aVar != null) {
                aVar.dF(true);
                return;
            }
            return;
        }
        2 2 = new 2(str, context, aVar, str2, str3);
        hdw.add(2);
        q.Kp().a(2);
        Bitmap W = W(context, str);
        if (W == null || W.isRecycled()) {
            x.e("MicroMsg.WebviewShrotcutManager", "getAvatarBitmap fail, bmp is null, start timer.");
            new al(new b(new 3(2, aVar, str)), false).J(5000, 5000);
            return;
        }
        hdw.remove(2);
        q.Kp().b(2);
        Intent a = a(context, str, str2, str3, W, true);
        if (a == null) {
            x.e("MicroMsg.WebviewShrotcutManager", "intent is null");
            if (aVar != null) {
                aVar.dF(false);
                return;
            }
            return;
        }
        b.o(context, a);
        if (aVar != null) {
            aVar.dF(true);
        }
    }

    private static Bitmap W(Context context, String str) {
        Bitmap a = com.tencent.mm.aa.c.a(str, false, -1);
        if (a == null || a.isRecycled()) {
            return a;
        }
        int i = (int) (context.getResources().getDisplayMetrics().density * 48.0f);
        return Bitmap.createScaledBitmap(a, i, i, false);
    }

    public static void f(Context context, String str, String str2, String str3) {
        if (context == null || bi.oW(str3)) {
            x.e("MicroMsg.WebviewShrotcutManager", "remove failed, invalid params");
        }
        Intent a = a(context, str, str2, str3, null, false);
        if (a == null) {
            x.e("MicroMsg.WebviewShrotcutManager", "remove failed, intent is null");
        } else {
            b.p(context, a);
        }
    }

    public static Intent a(Context context, String str, String str2, String str3, Bitmap bitmap, boolean z) {
        x.i("MicroMsg.WebviewShrotcutManager", "buildIntent, install = %b", new Object[]{Boolean.valueOf(z)});
        if (bitmap == null && z) {
            x.e("MicroMsg.WebviewShrotcutManager", "no bmp");
            return null;
        }
        String wP = wP(str);
        if (bi.oW(wP)) {
            return null;
        }
        Intent intent = new Intent(z ? "com.android.launcher.action.INSTALL_SHORTCUT" : "com.android.launcher.action.UNINSTALL_SHORTCUT");
        intent.putExtra("android.intent.extra.shortcut.NAME", str3);
        intent.putExtra("duplicate", false);
        String str4 = "";
        j kc = q.KH().kc(str);
        if (kc != null) {
            str4 = g.u((str3 + kc.Ky()).getBytes());
        }
        Parcelable intent2 = new Intent("com.tencent.mm.action.WX_SHORTCUT");
        intent2.putExtra("type", 2);
        intent2.putExtra("id", wP);
        intent2.putExtra("ext_info", wP(str2));
        intent2.putExtra("ext_info_1", wP(str3));
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        intent2.putExtra("token", bU(str2, stringBuilder.append(com.tencent.mm.model.c.Df()).toString()));
        intent2.putExtra("digest", str4);
        intent2.setPackage(context.getPackageName());
        intent2.addFlags(67108864);
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        return intent;
    }

    private static String wP(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String bT = b.bT(str, com.tencent.mm.compatible.e.q.zy());
        if (bi.oW(bT)) {
            return null;
        }
        return "shortcut_" + b.aa(bT.getBytes());
    }

    public static String bU(String str, String str2) {
        return g.u((g.u(str.getBytes()) + b.bT(str2, str)).getBytes());
    }

    private static boolean X(Context context, String str) {
        try {
            String str2;
            ContentResolver contentResolver = context.getContentResolver();
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(8);
            if (installedPackages != null) {
                loop0:
                for (PackageInfo packageInfo : installedPackages) {
                    ProviderInfo[] providerInfoArr = packageInfo.providers;
                    if (providerInfoArr != null) {
                        int length = providerInfoArr.length;
                        int i = 0;
                        while (i < length) {
                            ProviderInfo providerInfo = providerInfoArr[i];
                            if ("com.android.launcher.permission.READ_SETTINGS".equals(providerInfo.readPermission)) {
                                str2 = providerInfo.authority;
                                break loop0;
                            } else if ("com.android.launcher.permission.READ_SETTINGS".equals(providerInfo.writePermission)) {
                                str2 = providerInfo.authority;
                                break loop0;
                            } else {
                                i++;
                            }
                        }
                        continue;
                    }
                }
            }
            str2 = null;
            Cursor query = contentResolver.query(Uri.parse("content://" + str2 + "/favorites?notify=true"), new String[]{SlookSmartClipMetaTag.TAG_TYPE_TITLE, "iconResource"}, "title=?", new String[]{str}, null);
            if (query == null) {
                return false;
            }
            boolean z;
            if (query.getCount() > 0) {
                z = true;
            } else {
                z = false;
            }
            query.close();
            return z;
        } catch (Exception e) {
            return false;
        }
    }
}
