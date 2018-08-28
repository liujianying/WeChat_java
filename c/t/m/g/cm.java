package c.t.m.g;

import android.content.Context;
import java.util.HashMap;
import java.util.Timer;

public class cm {
    private static cm b = null;
    private static Context c = null;
    public cl a = null;
    private volatile boolean d = false;
    private Timer e = null;

    private cm() {
        if (c == null || c.getApplicationContext() == null) {
            throw new IllegalStateException("Please invoke initial(context,...) first when app started!");
        }
    }

    public static void a(HashMap<String, String> hashMap) {
        cn.a(hashMap);
    }

    public static void a(Context context, String str, String str2) {
        if (context == null || context.getApplicationContext() == null) {
            throw new NullPointerException("context cannot be null!");
        }
        Context applicationContext = context.getApplicationContext();
        c = applicationContext;
        co.a(applicationContext, str);
        cn.a(str, str2);
        new 1().start();
    }

    public static void a(String str) {
        cn.a(str);
    }

    public static synchronized cm a() {
        cm cmVar;
        synchronized (cm.class) {
            if (b == null) {
                synchronized (cm.class) {
                    if (b == null) {
                        b = new cm();
                    }
                }
            }
            cmVar = b;
        }
        return cmVar;
    }

    public final synchronized void b() {
        if (!this.d) {
            this.d = true;
            cj.a("CC_", "startUp()");
            this.e = new Timer("CC_Timer");
            a(true);
        }
    }

    public final synchronized void c() {
        if (this.d) {
            this.d = false;
            try {
                cn.a().d.clear();
                cj.a("CC_", "shutdown:pull immediately");
                a(0);
                if (this.e != null) {
                    Timer timer = this.e;
                    this.e = null;
                    timer.schedule(new 2(timer), 100);
                }
            } catch (Throwable th) {
                cj.a("CC_", "shutdown error.", th);
            }
        }
        return;
    }

    private void a(boolean z) {
        try {
            int b = cn.a().b("cc_version");
            long f = b == -1 ? z ? 5000 : 10800000 : f();
            cj.a("CC_", "schedule : first[" + z + "],locVer[" + b + "],delayTime[" + f + "]");
            a(f);
        } catch (Throwable th) {
            cj.b("CC_", th.toString());
        }
    }

    private static long f() {
        long j = 86400000;
        long c = cn.a().c("cc_req_interval");
        if (c <= 86400000) {
            j = c;
        }
        if (j < 3600000) {
            return 3600000;
        }
        return j;
    }

    private void a(long j) {
        if (this.e != null) {
            Timer timer = this.e;
            a aVar = new a(this);
            if (j < 0) {
                j = 0;
            }
            timer.schedule(aVar, j);
        }
    }
}
