package com.tencent.tencentmap.mapsdk.a;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import java.util.Date;
import java.util.Map;

public class da {
    protected static Map<String, String> a = null;
    private static Context b = null;
    private static String c = "";
    private static String d = "10000";
    private static String e = "";
    private static Runnable f = new 1();

    public static void a(Context context) {
        a(context, null, true, 0);
    }

    @TargetApi(14)
    private static void a(Context context, dm dmVar, boolean z, long j) {
        if (context == null) {
            ct.c(" the context is null! init beacon sdk failed!", new Object[0]);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            b = applicationContext;
        } else {
            b = context;
        }
        if (j > 0) {
            if (j > 10000) {
                j = 10000;
            }
            cg.a(j);
        }
        long time = new Date().getTime();
        if (Integer.valueOf(VERSION.SDK).intValue() >= 14) {
            ((Application) b).registerActivityLifecycleCallbacks(new f());
        }
        ct.a("initUserAction t1:" + (new Date().getTime() - time), new Object[0]);
        dl.a(b, dl.a(b, a(z)), dmVar);
        ct.a("initUserAction t1:" + (new Date().getTime() - time), new Object[0]);
    }

    private static boolean a(boolean z) {
        if (!z) {
            return false;
        }
        String b = a.b(b, "pid_stat", "");
        int myPid = Process.myPid();
        if ("".equals(b)) {
            a.c(b, String.valueOf(myPid));
            return true;
        }
        int i = -1;
        try {
            i = Integer.valueOf(b).intValue();
        } catch (Exception e) {
        }
        if (i == myPid) {
            return true;
        }
        if (a.a(b, i)) {
            return false;
        }
        a.c(b, b);
        return true;
    }

    public static void a(String str) {
        if (str != null && !str.trim().equals("")) {
            a.a(str);
        }
    }

    public static String a() {
        return d;
    }

    public static String b() {
        return c;
    }

    public static Map<String, String> c() {
        return a;
    }

    public static void b(String str) {
        if (str != null && !str.equals("")) {
            e = str;
        }
    }

    public static String d() {
        return e;
    }

    public static void c(String str) {
        c m = c.m();
        if (m == null) {
            c.a(b);
            m = c.m();
        }
        if (m == null) {
            ct.d("please set the channelID after call initUserAction!", new Object[0]);
        } else {
            m.c(e.b(str));
        }
    }

    public static boolean a(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2) {
        return a(str, z, j, j2, map, z2, false);
    }

    public static boolean a(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        if (str == null || "".equals(str.trim())) {
            ct.c("param eventName is null or \"\", please check it, return false! ", new Object[0]);
            return false;
        }
        String trim = str.replace('|', '_').trim();
        if (trim.length() == 0) {
            ct.c("eventName is invalid!! eventName length == 0!", new Object[0]);
            trim = null;
        } else if (!e.c(trim)) {
            ct.c("eventName is invalid!! eventName should be ASCII code in 32-126! eventName:" + str, new Object[0]);
            trim = null;
        } else if (trim.length() > 128) {
            ct.c("eventName is invalid!! eventName length should be less than 128! eventName:" + str, new Object[0]);
            trim = trim.substring(0, 128);
        }
        if (trim == null) {
            return false;
        }
        return dl.a(trim, z, j, j2, map, z2, z3);
    }

    public static void a(boolean z, boolean z2) {
        ct.a = z;
        ct.b = z2;
    }
}
