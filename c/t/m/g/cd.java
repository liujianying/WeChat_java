package c.t.m.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Process;
import android.text.TextUtils;

public final class cd {
    private static String a = "";
    private static String b = "";

    public static int a(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo == null) {
                return -407;
            }
            if (applicationInfo.metaData == null) {
                return -408;
            }
            int i = applicationInfo.metaData.getInt("halley_appid", 0);
            return i <= 0 ? -408 : i;
        } catch (NameNotFoundException e) {
            return -407;
        }
    }

    public static a a(int i, Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(str, str2), 128);
            if (serviceInfo != null) {
                return new a(i, str, serviceInfo.enabled, serviceInfo.exported, serviceInfo.processName, serviceInfo.metaData);
            }
        } catch (NameNotFoundException e) {
        }
        return null;
    }

    public static String a() {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        String string = m.a().getSharedPreferences(a(false), 0).getString("deviceid", "");
        b = string;
        return string;
    }

    public static String a(int i) {
        return i == 2 ? "2g" : i == 3 ? "3g" : i == 4 ? "4g" : i == 1 ? "wifi" : "";
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String packageName = context.getPackageName();
        String a = ci.a(Process.myPid());
        if (TextUtils.isEmpty(a) || !a.startsWith(packageName)) {
            a = ci.a(context, Process.myPid());
        }
        a = a;
        return a;
    }

    private static String a(boolean z) {
        String str = "HalleyServicePreferences_" + m.b();
        return z ? str + "_" + m.h() : str;
    }

    public static void a(String str) {
        m.a().getSharedPreferences(a(false), 0).edit().putString("deviceid", str).commit();
        b = str;
    }

    public static void a(String str, int i) {
        m.a().getSharedPreferences(a(false), 0).edit().putInt(str, i).commit();
    }

    public static void a(String str, long j) {
        m.a().getSharedPreferences(a(false), 0).edit().putLong(str, j).commit();
    }

    public static void a(String str, String str2) {
        m.a().getSharedPreferences(a(true), 0).edit().putString(str, str2).commit();
    }

    public static long b(String str) {
        return m.a().getSharedPreferences(a(false), 0).getLong(str, 0);
    }

    public static String b(String str, String str2) {
        return m.a().getSharedPreferences(a(true), 0).getString(str, str2);
    }

    public static int c(String str) {
        return m.a().getSharedPreferences(a(false), 0).getInt(str, 0);
    }
}
