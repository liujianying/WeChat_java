package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

public final class dl extends Observable implements ce, cj, ck {
    private static dl a = null;
    private df b = null;
    private dh c = null;
    private dh d = null;
    private boolean e = true;
    private boolean f = false;
    private Context g;
    private ds h;
    private boolean i;
    private int j = 0;
    private List<de> k = null;
    private Object l = new Object();
    private g m = null;

    public static synchronized dl a(Context context, ds dsVar, dm dmVar) {
        dl dlVar;
        synchronized (dl.class) {
            if (a == null) {
                ct.e(" create ua instance ", new Object[0]);
                a = new dl(context, dsVar, dmVar);
            }
            ct.e(" return ua instance ", new Object[0]);
            dlVar = a;
        }
        return dlVar;
    }

    public static synchronized dl d() {
        dl dlVar;
        synchronized (dl.class) {
            dlVar = a;
        }
        return dlVar;
    }

    public static synchronized ds a(Context context, boolean z) {
        dt a;
        synchronized (dl.class) {
            a = dt.a(context, z);
        }
        return a;
    }

    public static boolean a(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        ct.e(" onUA: %s,%b,%d,%d,%b,%b", new Object[]{str, Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z2), Boolean.valueOf(z3)});
        dl d = d();
        if (d != null && !d.m()) {
            d.k.add(new de(str, z, j, j2, map, z2));
            return true;
        } else if (!i()) {
            return false;
        } else {
            if (d.b.a(str)) {
                ct.c("onUserAction return false, because eventName:[%s] is not allowed in server strategy!", new Object[]{str});
                return false;
            } else if (!z || (z && d.b.b(str))) {
                dh k = z2 ? d.k() : d.j();
                if (k == null) {
                    return false;
                }
                di a = e.a(d.g, str, z, j, j2, map, z3);
                if (a != null) {
                    return k.a(a);
                }
                ct.c("createdRecordBean bean is null, return false!", new Object[0]);
                return false;
            } else {
                ct.c("onUserAction return false, because eventName:[%s] is sampled by svr rate!", new Object[]{str});
                return false;
            }
        }
    }

    public static boolean a(boolean z) {
        dl d = d();
        if (d == null) {
            ct.c(" ua module not ready!", new Object[0]);
            return false;
        } else if (i()) {
            return d.b(z);
        } else {
            return false;
        }
    }

    private static boolean i() {
        dl d = d();
        if (d == null) {
            ct.d("isModuleAble:not init ua", new Object[0]);
            return false;
        }
        boolean e = d.e();
        if (e && d.l()) {
            return d.m();
        }
        return e;
    }

    public final synchronized boolean e() {
        return this.i;
    }

    private dl(Context context, ds dsVar, dm dmVar) {
        if (context == null) {
            ct.c(" the context is null! init UserActionRecord failed!", new Object[0]);
            this.g = null;
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.g = applicationContext;
        } else {
            this.g = context;
        }
        if (c.m() == null) {
            c.a(this.g);
        }
        if (this.k == null) {
            this.k = Collections.synchronizedList(new ArrayList(5));
        }
        this.h = dsVar;
        if (dsVar != null) {
            dsVar.a(dmVar);
        }
        cf a = cf.a(this.g);
        a.a(this);
        a.a(this);
        a.a(this);
        a.a(0, dsVar);
        a.a(1, dsVar);
        this.b = new df();
        this.c = new db(context);
        this.d = new dk(context);
        this.e = true;
        new d().a(this.g);
        this.m = new g();
    }

    private synchronized dh j() {
        return this.c;
    }

    private synchronized dh k() {
        return this.d;
    }

    private synchronized boolean l() {
        return this.e;
    }

    private synchronized boolean m() {
        return this.f;
    }

    private synchronized void n() {
        this.f = true;
    }

    public final boolean b(boolean z) {
        synchronized (this.l) {
            if ((e() ? e.j(this.g) : -1) > 0) {
                try {
                    if (this.h != null) {
                        dn dcVar = new dc(this.g);
                        dcVar.a(z);
                        this.h.a(dcVar);
                    }
                    return true;
                } catch (Throwable th) {
                    ct.c(" up common error: %s", new Object[]{th.toString()});
                    ct.a(th);
                    return false;
                }
            }
        }
    }

    public final void c() {
        Context context = this.g;
        ct.a(" RecordDAO.deleteRecords() start", new Object[0]);
        int a = cb.a(context, new int[]{1});
        ct.e(" ua first clean :%d", new Object[]{Integer.valueOf(a)});
        ct.e(" ua remove strategy :%d", new Object[]{Integer.valueOf(e.i(this.g))});
    }

    private synchronized void c(boolean z) {
        if (z != e()) {
            dh j = j();
            if (j != null) {
                j.a(z);
            }
            j = k();
            if (j != null) {
                j.a(z);
            }
            this.i = z;
        }
    }

    public final ds f() {
        return this.h;
    }

    public final df g() {
        return this.b;
    }

    public final void b() {
        n();
        try {
            ch e = cf.a(this.g).e();
            if (e != null) {
                ch$a b = e.b(1);
                if (!(b == null || this.b == null)) {
                    Set d = b.d();
                    if (d != null && d.size() > 0) {
                        this.b.a(d);
                    }
                    d = b.f();
                    if (d != null && d.size() > 0) {
                        this.b.b(d);
                    }
                }
                if (!e() || b == null) {
                    ct.b("event module is disable", new Object[0]);
                } else {
                    if (((e() ? e.j(this.g) : -1) > 0 ? 1 : 0) != 0) {
                        ct.e(" asyn up module %d", new Object[]{Integer.valueOf(1)});
                        b.a().a(new 1(this));
                    }
                }
            }
        } catch (Throwable th) {
            ct.a(th);
            ct.d(" common query end error %s", new Object[]{th.toString()});
        }
        o();
        if (h() < 2) {
            dt a = dt.a(this.g);
            if (a.a() && a.b()) {
                p();
                q();
                if (this.b.j()) {
                    this.m.setChanged();
                    this.m.notifyObservers(this.g);
                }
            }
        }
    }

    private synchronized void o() {
        if (this.k != null && this.k.size() > 0) {
            for (de deVar : this.k) {
                a(deVar.a, deVar.b, deVar.c, deVar.d, deVar.e, deVar.f, false);
            }
            this.k.clear();
        }
    }

    private void p() {
        try {
            if (e() || this.b.f()) {
                cf a = cf.a(this.g);
                if (a != null) {
                    ch$a b = a.e().b(1);
                    if (b != null) {
                        String b2 = b.b();
                        if (b2 != null && !"".equals(b2.trim())) {
                            new dg(this.g).b();
                        }
                    }
                }
            }
        } catch (Exception e) {
            ct.c(" startHeart failed! " + e.getMessage(), new Object[0]);
        }
    }

    private void q() {
        boolean z;
        if (this.b.i()) {
            if ("".equals(a.b(this.g, "LAUEVE_DENGTA", ""))) {
                z = true;
            } else {
                ct.a("AppLaunchedEvent has been uploaded!", new Object[0]);
                return;
            }
        }
        z = false;
        if (e.a(this.g) == null) {
            ct.c(" DeviceInfo == null?,return", new Object[0]);
            return;
        }
        Map hashMap = new HashMap();
        hashMap.put("A33", e.g(this.g));
        hashMap.put("A63", "Y");
        if (a.b(this.g)) {
            hashMap.put("A21", "Y");
        } else {
            hashMap.put("A21", "N");
        }
        if (cf.a(this.g).g()) {
            hashMap.put("A45", "Y");
        } else {
            hashMap.put("A45", "N");
        }
        if (a.g(this.g)) {
            hashMap.put("A66", "F");
        } else {
            hashMap.put("A66", "B");
        }
        hashMap.put("A68", a.h(this.g));
        hashMap.put("A85", a.b ? "Y" : "N");
        hashMap.put("A9", e.d());
        hashMap.put("A14", e.e());
        boolean a = a("rqd_applaunched", true, 0, 0, hashMap, true, false);
        if (z && a) {
            a.a(this.g, "LAUEVE_DENGTA", e.g());
        }
    }

    public final void a(ch chVar) {
        if (chVar != null) {
            ch$a b = chVar.b(1);
            if (b != null) {
                boolean a = b.a();
                if (e() != a) {
                    ct.f("UAR onCommonStrategyChange setUsable:%b ", new Object[]{Boolean.valueOf(a)});
                    c(a);
                }
            }
        }
    }

    public final void a() {
        a(h() + 1);
    }

    public final synchronized int h() {
        return this.j;
    }

    private synchronized void a(int i) {
        this.j = i;
    }

    public final void a(Map<String, String> map) {
        if (map != null && map.size() > 0 && this.b != null) {
            this.b.a(map);
        }
    }
}
