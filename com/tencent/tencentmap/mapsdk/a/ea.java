package com.tencent.tencentmap.mapsdk.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.tencentmap.mapsdk.a.eq.a;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ea implements du, ej, Runnable {
    private Set a = null;
    private BlockingQueue b = null;
    private en c;

    public ea(String str, String str2, String str3) {
        fx.a("AccessSchedulerImpl", "new AccessSchedulerImpl...");
        this.a = new CopyOnWriteArraySet();
        this.a.add("dispatcher.3g.qq.com");
        this.b = new ArrayBlockingQueue(10);
        this.c = eo.a();
        try {
            if (c()) {
                a(true);
            } else {
                a(false);
            }
        } catch (Exception e) {
        }
        ef.a().a(this);
    }

    private static boolean c() {
        try {
            SharedPreferences sharedPreferences = em.a().getSharedPreferences("Access_Preferences", 0);
            if (sharedPreferences == null) {
                return false;
            }
            if (System.currentTimeMillis() - sharedPreferences.getLong("lastScheduleTime", 0) <= 86400000) {
                return false;
            }
            sharedPreferences.edit().putLong("lastScheduleTime", System.currentTimeMillis()).commit();
            fx.a("AccessSchedulerImpl", "force Schedule when init");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final a a(String str) {
        if (this.a.contains(str)) {
            a a = er.a().a(str);
            if (a != null) {
                if (!a.g()) {
                    return a;
                }
                fx.c("AccessSchedulerImpl", "iplist was expired");
                a(true);
            }
        }
        return null;
    }

    public final fm a() {
        return dx.a().b.f;
    }

    public final void a(List list) {
        if (list != null) {
            try {
                for (String add : list) {
                    this.a.add(add);
                }
            } catch (Exception e) {
            }
        }
    }

    public final void a(boolean z) {
        try {
            fx.a("AccessSchedulerImpl", "before add, queue size:" + this.b.size());
            fx.a("AccessSchedulerImpl", "addTask ret:" + this.b.add(new ee(z)));
        } catch (Throwable th) {
            fx.a("AccessSchedulerImpl", "addTask exception...", th);
        }
        fx.a("AccessSchedulerImpl", "after add, queue size:" + this.b.size());
    }

    public final void b() {
        fx.b("AccessSchedulerImpl", "onAccessSchedulerTriggered... try to addTask");
        a(false);
    }

    public final void run() {
        fx.b("AccessSchedulerImpl", "AccessSchedulerImpl run start...");
        try {
            er.a();
            while (true) {
                fx.a("AccessSchedulerImpl", "try take a task...");
                ee eeVar = (ee) this.b.take();
                fx.a("AccessSchedulerImpl", "task taked, try scheduler...");
                boolean a = eeVar.a();
                try {
                } catch (Exception e) {
                }
                fx.b("AccessSchedulerImpl", "scheduler...begin, isForce:" + a);
                Object a2 = fw.a();
                if (TextUtils.isEmpty(a2) || a2.equals("unknown")) {
                    fx.c("AccessSchedulerImpl", "can not get current apn, do not scheduler");
                } else if (ed.a) {
                    if (!a) {
                        Object obj = (er.a().a(this.a) || c()) ? 1 : null;
                        if (obj == null) {
                            fx.b("AccessSchedulerImpl", "scheduler...no need scheduler. return");
                        }
                    }
                    eb ebVar = new eb();
                    ebVar.b(em.b());
                    ebVar.c(em.c());
                    ebVar.a(em.d());
                    ebVar.a(em.f());
                    em.g();
                    ebVar.d(em.e());
                    ebVar.a(this.a);
                    ebVar.e(fw.a());
                    ebVar.b(fw.c());
                    ebVar.c(fw.d());
                    ec j = ebVar.j();
                    if (j != null) {
                        er.a().a(j.a());
                        dx a3 = dx.a();
                        dz b = j.b();
                        if (b != null) {
                            fx.b("AccessSchedulerConfiguration", "updateSdkCfInfo...SdkCfgInfo:" + b);
                            if (b.a < 2000 || b.a > 60000) {
                                fx.c("AccessSchedulerConfiguration", "updateSdkCfInfo...connectTimeout:" + b.a + " is checked to 20s");
                                b.a = 20000;
                            }
                            if (b.b < 2000 || b.b > 60000) {
                                fx.c("AccessSchedulerConfiguration", "updateSdkCfInfo...readTimeout:" + b.b + " is checked to 20s");
                                b.b = 20000;
                            }
                            a3.b = b;
                            a3.b.b();
                        }
                        a3 = dx.a();
                        dy c = j.c();
                        if (c != null) {
                            a3.a = c;
                            a3.a.b();
                        }
                    }
                    fx.b("AccessSchedulerImpl", "scheduler...end. apn:" + ebVar.g() + ", retCode:" + ebVar.m() + ",failInfo:" + ebVar.n());
                    this.c.a(ebVar);
                } else {
                    fx.b("AccessSchedulerImpl", "schedulerOn is off. return");
                }
            }
        } catch (Throwable th) {
        }
    }
}
