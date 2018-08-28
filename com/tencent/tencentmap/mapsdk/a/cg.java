package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;

public final class cg implements Runnable {
    private static long a = 0;
    private Context b = null;

    public cg(Context context) {
        this.b = context;
    }

    private static synchronized long a() {
        long j;
        synchronized (cg.class) {
            j = a;
        }
        return j;
    }

    public static synchronized void a(long j) {
        synchronized (cg.class) {
            a = j;
        }
    }

    public final void run() {
        ce[] i;
        cl h = e.h(this.b);
        if (!(h == null || h.b() != 101 || h.c() == null)) {
            try {
                dr f = cf.a(this.b).f();
                if (f != null) {
                    f.a(101, h.c(), false);
                    ct.e("common strategy setted by local db", new Object[0]);
                }
            } catch (Throwable th) {
                ct.a(th);
            }
        }
        cf a = cf.a(this.b);
        if (a.j() == 0) {
            ct.e("stepCheckApp", new Object[0]);
            a.a(1);
            ct.e("isAppFirstRun : %b", new Object[]{Boolean.valueOf(a.c(this.b))});
            if (a.c(this.b)) {
                ct.e("clear all ao: %d", new Object[]{Integer.valueOf(cb.a(this.b, null))});
                synchronized (a) {
                    ct.e("appfirstRun", new Object[0]);
                    i = a.i();
                    a.h();
                }
                if (i != null) {
                    ct.e("notify listener first run", new Object[0]);
                    for (ce c : i) {
                        c.c();
                    }
                }
            } else {
                long a2 = a();
                if (a2 > 0) {
                    ct.e("sleep: %d", new Object[]{Long.valueOf(a2)});
                    try {
                        Thread.sleep(a2);
                    } catch (Throwable th2) {
                        ct.a(th2);
                    }
                }
            }
        }
        synchronized (a) {
            ct.e("stepStartQuery", new Object[0]);
            i = a.i();
            a.a(2);
        }
        if (i != null) {
            ct.e("notify listener query start", new Object[0]);
            for (ce c2 : i) {
                c2.a();
            }
        }
        if (!ch.a().g()) {
            ds c3 = cf.c();
            int i2 = 0;
            while (c3 == null) {
                i2++;
                if (i2 >= 5) {
                    break;
                }
                try {
                    Thread.sleep(200);
                } catch (Throwable th22) {
                    ct.a(th22);
                }
                c3 = cf.c();
            }
            if (c3 == null) {
                ct.h("no uphandler ,no upload!", new Object[0]);
            } else if (a(this.b)) {
                ct.c("startQuery: query times arrive max, return!", new Object[0]);
                cf.a(this.b).b();
            } else {
                c3.a(new dp(this.b));
            }
        }
        ct.h("common query end!", new Object[0]);
        synchronized (a) {
            i = a.i();
            a.a(3);
        }
        if (i != null) {
            ct.e("notify listener query end", new Object[0]);
            for (ce b : i) {
                b.b();
            }
        }
        ch e = cf.a(this.b).e();
        if (e == null) {
            ct.d("magic should never null ? comStrategy", new Object[0]);
            return;
        }
        long c4 = (long) (e.c() * 60000);
        if (c4 > 0) {
            b.a().a(this, c4);
            ct.h("next time: %d", new Object[]{Long.valueOf(c4)});
            cf.a(this.b).a(4);
            return;
        }
        ct.h("stop loop query", new Object[0]);
    }

    private static boolean a(Context context) {
        boolean z;
        try {
            int parseInt = Integer.parseInt(a.b(context, "querytimes", "0"));
            if (!e.g().equals(a.b(context, "initsdkdate", ""))) {
                a.b(context, e.g());
                parseInt = 0;
            }
            if (parseInt <= ch.a().f()) {
                a.a(context, String.valueOf(parseInt + 1));
                return false;
            }
            z = true;
            try {
                ct.e(" sdk init max times", new Object[0]);
                return true;
            } catch (Exception e) {
                ct.c(" set init times failed! ", new Object[0]);
                return z;
            }
        } catch (Exception e2) {
            z = false;
            ct.c(" set init times failed! ", new Object[0]);
            return z;
        }
    }
}
