package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.smtt.sdk.WebView;

public class r {
    private static String a = null;
    private static String b = "GA";
    private static String c = "GE";
    private static String d = "9422";
    private static String e = "0";
    private static String f = "";
    private static boolean g = false;
    private static boolean h = false;
    private static boolean i = false;

    private static String a() {
        return " " + Build.MODEL.replaceAll("[ |\\/|\\_|\\&|\\|]", "") + " ";
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String a = a(context, String.valueOf(WebView.getTbsSDKVersion(context)), "0", b, c, d, e, f, g);
        a = a;
        return a;
    }

    private static String a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
        Object str8;
        String str9 = "";
        String str10 = "";
        String str11 = "PHONE";
        StringBuilder stringBuilder = new StringBuilder();
        String str12 = b(context) + "*" + c(context);
        try {
            ApplicationInfo applicationInfo = context.getApplicationContext().getApplicationInfo();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
            str9 = applicationInfo.packageName;
            if (TextUtils.isEmpty(str7)) {
                str7 = packageInfo.versionName;
            }
        } catch (NameNotFoundException e) {
            str7 = str10;
        }
        String a = a(str9);
        if ("QB".equals(a)) {
            if (z) {
                str10 = "PAD";
            }
            str10 = str11;
        } else {
            if (d(context)) {
                str10 = "PAD";
            }
            str10 = str11;
        }
        stringBuilder.append("QV=3");
        a(stringBuilder, "PL", "ADR");
        a(stringBuilder, "PR", a);
        a(stringBuilder, "PP", str9);
        a(stringBuilder, "PPVN", str7);
        if (!TextUtils.isEmpty(str)) {
            a(stringBuilder, "TBSVC", str);
        }
        a(stringBuilder, "CO", "SYS");
        if (!TextUtils.isEmpty(str2)) {
            a(stringBuilder, "COVC", str2);
        }
        a(stringBuilder, "PB", str4);
        a(stringBuilder, "VE", str3);
        a(stringBuilder, "DE", str10);
        str10 = "CHID";
        if (TextUtils.isEmpty(str6)) {
            str6 = "0";
        }
        a(stringBuilder, str10, str6);
        a(stringBuilder, "LCID", str5);
        str9 = a();
        try {
            str8 = new String(str9.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e2) {
            str10 = str9;
        }
        if (!TextUtils.isEmpty(str8)) {
            a(stringBuilder, "MO", str8);
        }
        a(stringBuilder, "RL", str12);
        str9 = VERSION.RELEASE;
        try {
            str8 = new String(str9.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e3) {
            str10 = str9;
        }
        if (!TextUtils.isEmpty(str8)) {
            a(stringBuilder, "OS", str8);
        }
        a(stringBuilder, "API", VERSION.SDK_INT);
        return stringBuilder.toString();
    }

    private static String a(String str) {
        return str.equals("com.tencent.mm") ? "WX" : str.equals("com.tencent.mobileqq") ? "QQ" : str.equals("com.qzone") ? "QZ" : str.equals("com.tencent.mtt") ? "QB" : "TRD";
    }

    private static void a(StringBuilder stringBuilder, String str, String str2) {
        stringBuilder.append("&").append(str).append("=").append(str2);
    }

    private static int b(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        return defaultDisplay != null ? defaultDisplay.getWidth() : -1;
    }

    private static int c(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        return defaultDisplay != null ? defaultDisplay.getHeight() : -1;
    }

    private static boolean d(Context context) {
        boolean z = true;
        if (h) {
            return i;
        }
        try {
            if ((Math.min(b(context), c(context)) * 160) / e(context) < 700) {
                z = false;
            }
            i = z;
            h = true;
            return i;
        } catch (Throwable th) {
            return false;
        }
    }

    private static int e(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (defaultDisplay == null) {
            return 160;
        }
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }
}
