package c.t.m.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;

public final class at {
    public static String a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";

    private static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            return "null";
        }
    }

    private static String b() {
        try {
            return VERSION.RELEASE;
        } catch (Throwable th) {
            return "null";
        }
    }

    private static String b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String str = packageInfo.versionName;
            int i = packageInfo.versionCode;
            if (str == null || str.trim().length() <= 0) {
                return String.valueOf(i);
            }
            str = str.trim().replace(10, ' ').replace(13, ' ').replace("|", "%7C");
            char[] toCharArray = str.toCharArray();
            int i2 = 0;
            for (char c : toCharArray) {
                if (c == '.') {
                    i2++;
                }
            }
            return i2 < 3 ? str + "." + i : str;
        } catch (Throwable th) {
            return "";
        }
    }

    private static String c() {
        try {
            return VERSION.SDK;
        } catch (Throwable th) {
            return "null";
        }
    }

    private static String d() {
        String str = null;
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            return str;
        }
    }

    public static void a(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a());
        stringBuffer.append(";Android ");
        stringBuffer.append(b());
        stringBuffer.append(",level ");
        stringBuffer.append(c());
        a = stringBuffer.toString();
        b = b(context);
        context.getPackageName();
        c = d();
        d = a();
    }
}
