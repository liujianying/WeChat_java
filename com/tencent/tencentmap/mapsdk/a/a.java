package com.tencent.tencentmap.mapsdk.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.os.Process;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class a {
    protected static String a = null;
    public static boolean b = false;
    private static String c = null;
    private static String d = null;
    private static Boolean e = null;
    private static int f = 0;
    private static String g = "";

    public static synchronized String a(Context context) {
        String str;
        Throwable th;
        InputStream inputStream;
        synchronized (a.class) {
            if (context == null) {
                str = "";
            } else {
                Object obj;
                String str2 = "";
                AssetManager assets = context.getAssets();
                InputStream inputStream2;
                try {
                    String string = context.getSharedPreferences("DENGTA_META", 0).getString("key_channelpath", "");
                    if (string.equals("")) {
                        string = "channel.ini";
                        context.getSharedPreferences("DENGTA_META", 0).edit().putString("key_channelpath", string).commit();
                    }
                    ct.a("channel path!! " + string, new Object[0]);
                    if (string.equals("")) {
                        inputStream2 = null;
                    } else {
                        inputStream2 = assets.open(string);
                        try {
                            Properties properties = new Properties();
                            properties.load(inputStream2);
                            str = properties.getProperty("CHANNEL", "");
                            try {
                                ct.a("channel !! " + str, new Object[0]);
                                if ("".equals(str)) {
                                    str2 = str;
                                } else if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Throwable e) {
                                        ct.a(e);
                                    }
                                }
                            } catch (Exception e2) {
                                str2 = str;
                            }
                        } catch (Exception e3) {
                        }
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                            str = str2;
                        } catch (Throwable e4) {
                            ct.a(e4);
                            str = str2;
                        }
                        obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
                        if (obj != null) {
                            str = obj.toString();
                        }
                    }
                } catch (Exception e5) {
                    inputStream2 = null;
                    try {
                        context.getSharedPreferences("DENGTA_META", 0).edit().putString("key_channelpath", "").commit();
                        ct.c("get app channel fail!", new Object[0]);
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                                str = str2;
                            } catch (Throwable e42) {
                                ct.a(e42);
                                str = str2;
                            }
                            obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
                            if (obj != null) {
                                str = obj.toString();
                            }
                            return str;
                        }
                        str = str2;
                        obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
                        if (obj != null) {
                            str = obj.toString();
                        }
                        return str;
                    } catch (Throwable e422) {
                        th = e422;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e4222) {
                                ct.a(e4222);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable e6) {
                    th = e6;
                    inputStream = null;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e42222) {
                            ct.a(e42222);
                        }
                    }
                    throw th;
                }
                str = str2;
                try {
                    obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
                    if (obj != null) {
                        str = obj.toString();
                    }
                } catch (Throwable th2) {
                    ct.a("no channel !!", new Object[0]);
                }
            }
        }
        return str;
    }

    public static synchronized boolean b(Context context) {
        boolean z = false;
        synchronized (a.class) {
            if (context == null) {
                ct.d("context == null return null", new Object[0]);
            } else {
                try {
                    String string = context.getSharedPreferences("DENGTA_META", 4).getString("APPKEY_DENGTA", null);
                    String d = da.d();
                    if (string == null || !string.equals(d)) {
                        z = true;
                        Editor edit = context.getSharedPreferences("DENGTA_META", 0).edit();
                        edit.putString("APPKEY_DENGTA", d);
                        edit.commit();
                    }
                } catch (Throwable e) {
                    ct.b("updateLocalAPPKEY fail!", new Object[0]);
                    ct.a(e);
                }
            }
        }
        return z;
    }

    public static boolean c(Context context) {
        boolean z;
        Throwable e;
        if (context == null) {
            ct.d("context == null return null", new Object[0]);
            return false;
        }
        try {
            String string = context.getSharedPreferences("DENGTA_META", 0).getString("APPVER_DENGTA", null);
            String j = j(context);
            if (string != null && string.equals(j)) {
                return false;
            }
            z = true;
            try {
                Editor edit = context.getSharedPreferences("DENGTA_META", 0).edit();
                edit.putString("APPVER_DENGTA", j);
                edit.commit();
                return true;
            } catch (Exception e2) {
                e = e2;
                ct.b("updateLocalAPPKEY fail!", new Object[0]);
                ct.a(e);
                return z;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            ct.b("updateLocalAPPKEY fail!", new Object[0]);
            ct.a(e);
            return z;
        }
    }

    public static String d(Context context) {
        if (context == null) {
            return null;
        }
        return context.getPackageName();
    }

    public static String e(Context context) {
        if (c == null) {
            c = j(context);
        }
        return c;
    }

    private static synchronized String j(Context context) {
        String valueOf;
        synchronized (a.class) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context == null ? null : context.getPackageName(), 0);
                String str = packageInfo.versionName;
                int i = packageInfo.versionCode;
                if (str == null || str.trim().length() <= 0) {
                    valueOf = String.valueOf(i);
                } else {
                    str = str.trim().replace(10, ' ').replace(13, ' ').replace("|", "%7C");
                    char[] toCharArray = str.toCharArray();
                    int i2 = 0;
                    for (char c : toCharArray) {
                        if (c == '.') {
                            i2++;
                        }
                    }
                    if (i2 < 3) {
                        ct.a("add versionCode: %s", Integer.valueOf(i));
                        valueOf = str + "." + i;
                    } else {
                        valueOf = str;
                    }
                    ct.a("version: %s", valueOf);
                }
            } catch (Throwable e) {
                ct.a(e);
                ct.d(e.toString(), new Object[0]);
                valueOf = "";
            }
        }
        return valueOf;
    }

    public static void a(String str) {
        synchronized (a.class) {
            a = str;
        }
        c m = c.m();
        if (m != null) {
            m.a(str);
        }
    }

    public static synchronized boolean f(Context context) {
        boolean booleanValue;
        synchronized (a.class) {
            ct.b("Read phone state permission check! start ", new Object[0]);
            if (e == null) {
                e = Boolean.valueOf(d(context, "android.permission.READ_PHONE_STATE"));
            }
            booleanValue = e.booleanValue();
        }
        return booleanValue;
    }

    public static boolean g(Context context) {
        return e(context, context.getPackageName());
    }

    public static String a() {
        if (!"".equals(g)) {
            return g;
        }
        try {
            if (f == 0) {
                f = Process.myPid();
            }
            g += f + "_";
            g += new Date().getTime();
        } catch (Exception e) {
        }
        return g;
    }

    public static int h(Context context) {
        try {
            if (f == 0) {
                f = Process.myPid();
            }
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == f) {
                    return runningAppProcessInfo.importance;
                }
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public static boolean a(Context context, int i) {
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == i && runningAppProcessInfo.processName.split(":")[0].equals(i(context).split(":")[0])) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static String i(Context context) {
        if (d != null) {
            return d;
        }
        try {
            if (f == 0) {
                f = Process.myPid();
            }
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == f) {
                    String str = runningAppProcessInfo.processName;
                    d = str;
                    return str;
                }
            }
        } catch (Throwable th) {
            ct.a(th);
        }
        return "";
    }

    private static boolean d(Context context, String str) {
        boolean z = true;
        if (context == null || str == null) {
            ct.d("context or permission is null.", new Object[0]);
            return false;
        }
        boolean z2 = context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        if (z2) {
            return z2;
        }
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (Object equals : strArr) {
                    if (str.equals(equals)) {
                        break;
                    }
                }
            }
            z = z2;
            ct.b("AppInfo.isContainReadLogPermission() end", new Object[0]);
            return z;
        } catch (Throwable th) {
            ct.b("AppInfo.isContainReadLogPermission() end", new Object[0]);
        }
    }

    private static boolean e(Context context, String str) {
        if (context == null || str == null || str.trim().length() <= 0) {
            return false;
        }
        try {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null || runningAppProcesses.size() == 0) {
                ct.b("no running proc", new Object[0]);
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100) {
                    for (Object equals : runningAppProcessInfo.pkgList) {
                        if (str.equals(equals)) {
                            return true;
                        }
                    }
                    continue;
                }
            }
            return false;
        } catch (Throwable th) {
            ct.a(th);
            ct.d("Failed to judge }[%s]", th.getLocalizedMessage());
        }
    }

    public static boolean a(Context context, String str, String str2) {
        return context.getSharedPreferences("DENGTA_META", 0).edit().putString(str, str2).commit();
    }

    public static String b(Context context, String str, String str2) {
        return context.getSharedPreferences("DENGTA_META", 0).getString(str, str2);
    }

    public static void a(Context context, String str) {
        context.getSharedPreferences("DENGTA_META", 0).edit().putString("querytimes", str).commit();
    }

    public static void b(Context context, String str) {
        context.getSharedPreferences("DENGTA_META", 0).edit().putString("initsdkdate", str).commit();
    }

    public static void c(Context context, String str) {
        context.getSharedPreferences("DENGTA_META", 0).edit().putString("pid_stat", str).commit();
    }
}
