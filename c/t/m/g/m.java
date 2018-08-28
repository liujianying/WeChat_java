package c.t.m.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.SystemClock;

public final class m {
    public static String a = "null";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static boolean e = true;
    private static Context f = null;
    private static String g;
    private static long h;
    private static int i = 0;
    private static boolean j = false;
    private static String k = "";
    private static int l = 0;
    private static String m = "3.4.1.6";
    private static String n = "";
    private static int o = -1;
    private static boolean p = false;
    private static String q = "";
    private static Handler r;
    private static volatile boolean s = false;

    public static Context a() {
        return f;
    }

    public static void a(int i, b bVar, String str) {
        h = SystemClock.elapsedRealtime();
        o = Process.myPid();
        Context context = bVar.a;
        f = context.getApplicationContext();
        k = context.getPackageName();
        i = i;
        j = bVar.c;
        String str2 = bVar.d;
        if (ci.a(str2)) {
            str2 = "";
        }
        c = str2;
        str2 = bVar.e;
        if (ci.a(str2)) {
            str2 = "";
        }
        d = str2;
        m = "3.4.1.6";
        Handler handler = new Handler(f.getMainLooper());
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            a = packageInfo.versionName;
            l = packageInfo.versionCode;
            b = packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Throwable th) {
        }
        n = str;
        p = k.equals(n);
        g = ci.d();
        HandlerThread handlerThread = new HandlerThread("HalleyTempTaskThread");
        handlerThread.start();
        r = new Handler(handlerThread.getLooper());
        p.a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Print SDKBaseInfo on tag:" + "after initSDKBaseInfo");
        stringBuilder.append("\r\nPlatformProtocalType:2");
        stringBuilder.append("\r\nappContext:" + f);
        stringBuilder.append("\r\nbootSessionId:" + g);
        stringBuilder.append("\r\nbootTime:" + h);
        stringBuilder.append("\r\nappId:" + i);
        stringBuilder.append("\r\nisSDKMode:" + j);
        stringBuilder.append("\r\nbundle:" + k);
        stringBuilder.append("\r\nappVersionName:" + a);
        stringBuilder.append("\r\nappVersionCode:" + l);
        stringBuilder.append("\r\nappLabelName:" + b);
        stringBuilder.append("\r\nuuid:" + c);
        stringBuilder.append("\r\nchannelId:" + d);
        stringBuilder.append("\r\nsdkVersion:" + m);
        stringBuilder.append("\r\nsProcessName:" + n);
        stringBuilder.append("\r\npid:" + o);
        stringBuilder.append("\r\nsProcessNameSubfix:" + q);
        stringBuilder.append("\r\nsIsMainProcess:" + p);
        stringBuilder.append("\r\npsInRemoteProcess:" + e);
        stringBuilder.append("\r\nisTestMode:false");
        if (f != null) {
            stringBuilder.append("\r\ndeviceid:" + cd.a());
        }
        stringBuilder.append("\r\nfinger:" + Build.FINGERPRINT);
    }

    public static int b() {
        return i;
    }

    public static String c() {
        return g;
    }

    public static int d() {
        return (int) (SystemClock.elapsedRealtime() - h);
    }

    public static String e() {
        return k;
    }

    public static boolean f() {
        return j;
    }

    public static String g() {
        return m;
    }

    public static String h() {
        if (!ci.a(q)) {
            return q;
        }
        if (ci.a(n) || !n.contains(":")) {
            return "";
        }
        return n.substring(n.indexOf(":") + 1);
    }

    public static Handler i() {
        return r;
    }
}
