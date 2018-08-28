package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class hk implements id, ie {
    private ArrayList<hi> a = new ArrayList();
    private ArrayList<hi> b = new ArrayList();
    private ArrayList<hi> c = new ArrayList();
    private LinkedList<Object> d;
    private b e;
    private int f = 60;
    private a g;
    private long h;
    private boolean i;
    private hg j;

    public hk(a aVar) {
        this.g = aVar;
        this.d = new LinkedList();
        gu.a(h());
    }

    public void a() {
        if (this.e != null) {
            this.e.destroy();
        }
        this.e = new b(this, null);
        this.e.start();
    }

    public void b() {
        if (this.e != null) {
            this.e.destroy();
        }
    }

    public void c() {
        if (this.e != null) {
            this.e.a();
        }
        j();
    }

    public void d() {
        if (this.e != null) {
            this.e.b();
        }
    }

    public void a(int i) {
        if (i > 0) {
            this.f = i;
        }
    }

    public void e() {
        this.f = 60;
    }

    public int f() {
        return this.f;
    }

    public void g() {
        if (this.e != null) {
        }
    }

    public long h() {
        long j = 1000 / ((long) this.f);
        if (j == 0) {
            return 1;
        }
        return j;
    }

    public void a(hg hgVar) {
        this.j = hgVar;
    }

    public void a(hi hiVar) {
        synchronized (this.a) {
            if (this.a.size() > 200) {
                this.a.clear();
            }
            this.a.add(hiVar);
        }
        i();
    }

    public void i() {
        synchronized (this.d) {
            this.d.add(hi.h);
        }
    }

    public void j() {
        synchronized (this.a) {
            this.c.clear();
            this.b.clear();
            Iterator it = this.a.iterator();
            Object obj = null;
            while (it.hasNext()) {
                hi hiVar = (hi) it.next();
                if (hiVar.e) {
                    obj = 1;
                    this.b.add(hiVar);
                } else {
                    this.c.add(hiVar);
                }
            }
            this.a.clear();
            if (obj != null) {
                ArrayList arrayList = this.a;
                this.a = this.b;
                this.b = arrayList;
            }
            if (this.c.size() > 0) {
                Iterator it2 = this.c.iterator();
                while (it2.hasNext()) {
                    ((hi) it2.next()).b();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean k() {
        /*
        r4 = this;
        r1 = 0;
        r2 = r4.a;
        monitor-enter(r2);
        r0 = r4.a;	 Catch:{ all -> 0x003d }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x003d }
        if (r0 == 0) goto L_0x000f;
    L_0x000c:
        monitor-exit(r2);	 Catch:{ all -> 0x003d }
        r0 = r1;
    L_0x000e:
        return r0;
    L_0x000f:
        r0 = r4.a;	 Catch:{ all -> 0x003d }
        r3 = 0;
        r0 = r0.get(r3);	 Catch:{ all -> 0x003d }
        r0 = (com.tencent.tencentmap.mapsdk.a.hi) r0;	 Catch:{ all -> 0x003d }
        monitor-exit(r2);	 Catch:{ all -> 0x003d }
        if (r0 == 0) goto L_0x002f;
    L_0x001b:
        r2 = r4.g;
        r2 = r0.a(r2);
        if (r2 == 0) goto L_0x002f;
    L_0x0023:
        r0.c();
        r2 = r4.a;
        monitor-enter(r2);
        r3 = r4.a;	 Catch:{ all -> 0x0040 }
        r3.remove(r0);	 Catch:{ all -> 0x0040 }
        monitor-exit(r2);	 Catch:{ all -> 0x0040 }
    L_0x002f:
        r2 = r4.a;
        monitor-enter(r2);
        r0 = r4.a;	 Catch:{ all -> 0x0043 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0043 }
        monitor-exit(r2);	 Catch:{ all -> 0x0043 }
        if (r0 != 0) goto L_0x0046;
    L_0x003b:
        r0 = 1;
        goto L_0x000e;
    L_0x003d:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x003d }
        throw r0;
    L_0x0040:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0040 }
        throw r0;
    L_0x0043:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0043 }
        throw r0;
    L_0x0046:
        r0 = r1;
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.hk.k():boolean");
    }

    public void a(ic icVar) {
        this.i = true;
        this.h = System.currentTimeMillis();
    }
}
