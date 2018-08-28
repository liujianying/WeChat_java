package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class cf {
    private static cf c = null;
    protected ch a = null;
    protected Context b = null;
    private boolean d = false;
    private int e = 0;
    private dr f = null;
    private Runnable g = null;
    private List<ce> h = new ArrayList(5);
    private SparseArray<ds> i = new SparseArray(5);
    private List<cj> j = new ArrayList(5);
    private SparseArray<ck> k = new SparseArray(2);
    private boolean l = false;
    private Runnable m = new 1(this);

    public static synchronized cf a(Context context) {
        cf cfVar;
        synchronized (cf.class) {
            if (c == null && context != null) {
                c = new cf(context);
            }
            cfVar = c;
        }
        return cfVar;
    }

    public final synchronized boolean a() {
        return this.l;
    }

    public final synchronized void b() {
        this.l = true;
    }

    public static synchronized ds c() {
        ds k;
        synchronized (cf.class) {
            if (c != null) {
                k = c.k();
            } else {
                k = null;
            }
        }
        return k;
    }

    private cf(Context context) {
        this.b = context;
        this.a = ch.a();
        b.a().a(this.m);
        this.f = new dr(context);
        this.g = new cg(context);
        b.a().a(this.g);
    }

    public final synchronized Runnable d() {
        return this.g;
    }

    public final synchronized ch e() {
        return this.a;
    }

    private synchronized ds k() {
        ds dsVar;
        if (this.i == null || this.i.size() <= 0) {
            dsVar = null;
        } else {
            dsVar = (ds) this.i.get(0);
        }
        return dsVar;
    }

    public final synchronized void a(int i, ds dsVar) {
        if (this.i != null) {
            if (dsVar == null) {
                this.i.remove(i);
            } else {
                this.i.put(i, dsVar);
                dsVar.a(f());
            }
        }
    }

    public final synchronized dr f() {
        return this.f;
    }

    public final synchronized boolean g() {
        return this.d;
    }

    protected final synchronized void h() {
        this.d = true;
        ct.f("isFirst }%b", Boolean.valueOf(true));
    }

    public final synchronized ce[] i() {
        ce[] ceVarArr;
        if (this.h == null || this.h.size() <= 0) {
            ceVarArr = null;
        } else {
            ceVarArr = (ce[]) this.h.toArray(new ce[0]);
        }
        return ceVarArr;
    }

    private synchronized cj[] l() {
        cj[] cjVarArr;
        if (this.j == null || this.j.size() <= 0) {
            cjVarArr = null;
        } else {
            cjVarArr = (cj[]) this.j.toArray(new cj[0]);
        }
        return cjVarArr;
    }

    public final synchronized int j() {
        return this.e;
    }

    public final synchronized void a(int i) {
        this.e = i;
        ct.f("step:%d", Integer.valueOf(i));
    }

    public final synchronized void a(ce ceVar) {
        if (ceVar != null) {
            if (this.h == null) {
                this.h = new ArrayList();
            }
            if (!this.h.contains(ceVar)) {
                this.h.add(ceVar);
                int j = j();
                if (g()) {
                    ct.e("add listener should notify app first run! %s", ceVar.toString());
                    b.a().a(new 2(ceVar));
                }
                if (j >= 2) {
                    ct.e("add listener should notify app start query! %s", ceVar.toString());
                    b.a().a(new 3(ceVar, j));
                }
            }
        }
    }

    public final synchronized void a(cj cjVar) {
        if (cjVar != null) {
            if (!(this.j == null || this.j.contains(cjVar))) {
                this.j.add(cjVar);
            }
        }
    }

    public final synchronized void a(ck ckVar) {
        if (ckVar != null) {
            if (this.k != null) {
                this.k.put(1, ckVar);
            }
        }
    }

    private synchronized SparseArray<ck> m() {
        return this.k;
    }

    public final void a(ch chVar) {
        cj[] l = l();
        if (l != null) {
            for (cj a : l) {
                try {
                    a.a(chVar);
                } catch (Throwable th) {
                    ct.a(th);
                    ct.d("com strategy changed error %s", th.toString());
                }
            }
        }
    }

    public final void a(int i, Map<String, String> map) {
        SparseArray m = m();
        if (m != null) {
            ck ckVar = (ck) m.get(i);
            if (ckVar != null) {
                ckVar.a(map);
            }
        }
    }
}
