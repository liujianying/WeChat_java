package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.telephony.TelephonyManager;
import java.lang.reflect.InvocationTargetException;

public class t {
    public static String a = "TencentMapSDK";
    private static String b;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;

    public static void a(Context context) {
        String b;
        if (b == null) {
            b = b(context);
            b = b;
            b = a(b);
        }
        if (c == null) {
            b = c(context);
            c = b;
            c = a(b);
        }
        if (d == null) {
            b = Build.MODEL;
            d = b;
            d = a(b);
        }
        if (e == null) {
            e = VERSION.RELEASE;
        }
        if (f == null) {
            b = d(context);
            f = b;
            f = a(b);
        }
        if (g == null) {
            b = context.getPackageName();
            g = b;
            g = a(b);
        }
        if (h == null) {
            b = e(context);
            h = b;
            h = a(b);
        }
    }

    public static String a() {
        return b;
    }

    public static String b() {
        return c;
    }

    public static String c() {
        return d;
    }

    public static String d() {
        return e;
    }

    public static String e() {
        return f;
    }

    public static String f() {
        return g;
    }

    public static String g() {
        return h;
    }

    private static String b(Context context) {
        String str = "";
        if (VERSION.SDK_INT < 21) {
            return "armeabi-v7a";
        }
        if (VERSION.SDK_INT >= 21 && VERSION.SDK_INT < 23) {
            String str2;
            try {
                Object invoke = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[]{String.class}).invoke(context.getClassLoader(), new Object[]{"art"});
                if (invoke != null) {
                    str2 = ((String) invoke).contains("lib64") ? Build.SUPPORTED_64_BIT_ABIS[0] : Build.SUPPORTED_32_BIT_ABIS[0];
                    if (str2 != null) {
                        return Build.SUPPORTED_ABIS[0];
                    }
                    return str2;
                }
            } catch (NoSuchMethodException e) {
                str2 = str;
            } catch (IllegalAccessException e2) {
                str2 = str;
            } catch (InvocationTargetException e3) {
                str2 = str;
            } catch (NullPointerException e4) {
            }
            str2 = str;
            if (str2 != null) {
                return str2;
            }
            return Build.SUPPORTED_ABIS[0];
        } else if (VERSION.SDK_INT < 23) {
            return str;
        } else {
            if (Process.is64Bit()) {
                return Build.SUPPORTED_64_BIT_ABIS[0];
            }
            return Build.SUPPORTED_32_BIT_ABIS[0];
        }
    }

    private static String c(Context context) {
        if (context == null) {
            return "";
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        if (VERSION.SDK_INT <= 22) {
            return telephonyManager.getDeviceId();
        }
        if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return "no permission";
        }
        return telephonyManager.getDeviceId();
    }

    private static String d(Context context) {
        if (context == null) {
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
        } catch (NameNotFoundException e) {
        }
        return applicationInfo.loadLabel(packageManager).toString();
    }

    private static String e(Context context) {
        if (context == null) {
            return "";
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (NameNotFoundException e) {
        }
        if (applicationInfo == null) {
            return "";
        }
        if (applicationInfo.metaData == null) {
            return "";
        }
        return applicationInfo.metaData.getString(a);
    }

    private static String a(String str) {
        if (str == null) {
            return "";
        }
        return str.replace("&", "").replace("#", "").replace("?", "");
    }
}
