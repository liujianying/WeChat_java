package c.t.m.g;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bz implements ax, bd {
    private static bz c = new bz();
    public Map<String, ay> a = new ConcurrentHashMap();
    public bw b;
    private Runnable d = new cb(this);
    private Runnable e = new cc(this);

    private bz() {
        bc bcVar = new bc();
        this.a.put(bcVar.a(), bcVar);
        bb bbVar = new bb();
        this.a.put(bbVar.a(), bbVar);
        az azVar = new az();
        this.a.put(azVar.a(), azVar);
        Runnable runnable = this.d;
        if (!m.f() && m.e) {
            ac.a().a(runnable);
            ac.a().a(runnable, true, 30000);
        }
        runnable = this.e;
        if (!m.f() && m.e) {
            ac.a().a(runnable);
            ac.a().a(runnable, true, 30000);
        }
    }

    public static bz c() {
        return c;
    }

    public final void a() {
        this.b.a();
    }

    public final void a(int i) {
        m.i().post(new ca(this, i));
    }

    public final void a(String str, String str2) {
        Runnable runnable = this.d;
        long a = (long) w.a("app_ipc_timertask_gap", 0, 3600000, 60000);
        if (!m.f() && m.e) {
            ac.a().a(runnable);
            ac.a().a(runnable, true, a);
        }
        for (ay a2 : this.a.values()) {
            a2.a(str, str2);
        }
    }

    public final void a(String str, byte[] bArr, String str2) {
        Runnable runnable = this.e;
        long a = (long) w.a("app_ipc_timertask_gap", 0, 3600000, 60000);
        if (!m.f() && m.e) {
            ac.a().a(runnable);
            ac.a().a(runnable, true, a);
        }
        for (ay a2 : this.a.values()) {
            a2.a(str, bArr, str2);
        }
    }

    public final void a_() {
        for (ay a_ : this.a.values()) {
            a_.a_();
        }
    }

    public final void b() {
        this.b.b();
    }

    public final s d() {
        return (s) this.a.get("accessscheduler");
    }
}
