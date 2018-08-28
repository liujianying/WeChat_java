package com.tencent.tencentmap.mapsdk.a;

import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class be {
    static AtomicInteger d = new AtomicInteger();
    String a;
    String b;
    ba c;
    aq e;
    aw f;
    al g;
    volatile au h;
    ConcurrentHashMap<String, bf> i;
    ConcurrentHashMap<String, bf> j;
    a k;
    AtomicBoolean l;
    Object m;
    AtomicBoolean n;
    public ConcurrentLinkedQueue<li> o;
    private Boolean p;

    public String toString() {
        return this.a + "'s Router(ID=" + this.e.getID() + ")";
    }

    public void a() {
        if (!this.p.booleanValue()) {
            synchronized (this.p) {
                if (!this.p.booleanValue()) {
                    if (this.h.f().isEmpty()) {
                        ax.a(this + " initConfigs from registry");
                        try {
                            au c = av.a.c(this.e);
                            if (c == null || c.f().isEmpty()) {
                                a(this.h);
                            } else {
                                a(c);
                            }
                        } catch (Throwable th) {
                            ax.b(this + " init from registry error, and initConfigs from " + this.h);
                            a(this.h);
                        }
                    } else {
                        ax.a(this.a + " initConfigs from " + this.h);
                        a(this.h);
                    }
                    this.p = Boolean.valueOf(true);
                }
            }
        }
    }

    public void a(au auVar) {
        ax.c(this + " " + this.a + " refreshEndPoints start ");
        List<bb> a = auVar.a();
        for (Entry key : this.j.entrySet()) {
            boolean z;
            String str = (String) key.getKey();
            for (bb a2 : a) {
                if (a2.a().equals(str)) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (!z) {
                try {
                    a(str);
                    ax.a(this + " removeNotexistService " + str);
                } catch (Throwable e) {
                    ax.b(this + " removeNotexistService " + str + " error " + e, e);
                }
            }
        }
        for (bb bbVar : auVar.b()) {
            try {
                a(bbVar.a());
                ax.a(this + " refresh removeInactiveService " + bbVar.a());
            } catch (Throwable e2) {
                ax.b(this + " refresh removeInactiveService " + bbVar + " error " + e2, e2);
            }
        }
        this.h = auVar;
        f();
        this.l.set(false);
        ax.c(this + " refreshEndPoints end, serviceInfos=" + this.h);
    }

    private void a(String str) {
        bf bfVar = (bf) this.i.remove(str);
        if (bfVar != null) {
            this.h.a(bfVar);
            bfVar.c();
        }
        bfVar = (bf) this.j.remove(str);
        if (bfVar != null) {
            bfVar.c();
        }
    }

    public void a(int i) {
        if (this.l.get()) {
            throw new RuntimeException("all service conn is closed, can not set allConnNum.");
        }
        for (Entry value : this.i.entrySet()) {
            try {
                bf bfVar = (bf) value.getValue();
                bfVar.d().a(i);
                bfVar.a();
            } catch (Throwable e) {
                ax.b(this + " setConnNum(" + i + ") error", e);
            }
        }
    }

    public void a(am amVar) {
        bf c = c(amVar);
        c.b(amVar);
        ax.c(this.g.c() + " " + c.d() + " send msg " + amVar.e().h());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.tencent.tencentmap.mapsdk.a.am r7) {
        /*
        r6 = this;
        r5 = -8;
        r0 = r6.c(r7);	 Catch:{ Exception -> 0x0009, Throwable -> 0x006c }
        r0.b(r7);	 Catch:{ Exception -> 0x0009, Throwable -> 0x006c }
    L_0x0008:
        return;
    L_0x0009:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c0 }
        r1.<init>();	 Catch:{ all -> 0x00c0 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x00c0 }
        r2 = " tryAgainSend msg Exception ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x00c0 }
        r1 = r1.append(r0);	 Catch:{ all -> 0x00c0 }
        r1 = r1.toString();	 Catch:{ all -> 0x00c0 }
        com.tencent.tencentmap.mapsdk.a.ax.a(r1, r0);	 Catch:{ all -> 0x00c0 }
        r1 = r7.e();	 Catch:{ all -> 0x00c0 }
        r2 = new com.tencent.tencentmap.mapsdk.a.bj;	 Catch:{ all -> 0x00c0 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c0 }
        r4 = "second send ";
        r3.<init>(r4);	 Catch:{ all -> 0x00c0 }
        r4 = r0.toString();	 Catch:{ all -> 0x00c0 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c0 }
        r3 = r3.toString();	 Catch:{ all -> 0x00c0 }
        r2.<init>(r3, r0);	 Catch:{ all -> 0x00c0 }
        r1.a(r2);	 Catch:{ all -> 0x00c0 }
        r0 = r7.e();
        r0 = r0.g();
        if (r0 == 0) goto L_0x0008;
    L_0x004f:
        r0 = r7.e();
        r0 = r0.h();
        r0 = com.tencent.tencentmap.mapsdk.a.az.a(r5, r0);
        r1 = r7.e();
        r0.a(r1);
        r1 = r6.g;
        r1 = r1.e();
        r1.a(r0);
        goto L_0x0008;
    L_0x006c:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c0 }
        r1.<init>();	 Catch:{ all -> 0x00c0 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x00c0 }
        r2 = " tryAgainSend msg Throwable ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x00c0 }
        r1 = r1.append(r0);	 Catch:{ all -> 0x00c0 }
        r1 = r1.toString();	 Catch:{ all -> 0x00c0 }
        com.tencent.tencentmap.mapsdk.a.ax.a(r1, r0);	 Catch:{ all -> 0x00c0 }
        r1 = r7.e();	 Catch:{ all -> 0x00c0 }
        r2 = new com.tencent.tencentmap.mapsdk.a.bj;	 Catch:{ all -> 0x00c0 }
        r3 = r0.toString();	 Catch:{ all -> 0x00c0 }
        r2.<init>(r3, r0);	 Catch:{ all -> 0x00c0 }
        r1.a(r2);	 Catch:{ all -> 0x00c0 }
        r0 = r7.e();
        r0 = r0.g();
        if (r0 == 0) goto L_0x0008;
    L_0x00a2:
        r0 = r7.e();
        r0 = r0.h();
        r0 = com.tencent.tencentmap.mapsdk.a.az.a(r5, r0);
        r1 = r7.e();
        r0.a(r1);
        r1 = r6.g;
        r1 = r1.e();
        r1.a(r0);
        goto L_0x0008;
    L_0x00c0:
        r0 = move-exception;
        r1 = r7.e();
        r1 = r1.g();
        if (r1 == 0) goto L_0x00e7;
    L_0x00cb:
        r1 = r7.e();
        r1 = r1.h();
        r1 = com.tencent.tencentmap.mapsdk.a.az.a(r5, r1);
        r2 = r7.e();
        r1.a(r2);
        r2 = r6.g;
        r2 = r2.e();
        r2.a(r1);
    L_0x00e7:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.be.b(com.tencent.tencentmap.mapsdk.a.am):void");
    }

    public ao a(long j, boolean z) {
        ao aoVar = new ao(b(), j);
        aoVar.a(z);
        return aoVar;
    }

    protected int b() {
        return d.incrementAndGet();
    }

    private bf c(am amVar) {
        Object obj;
        bf bfVar;
        if (this.j.size() == 0) {
            if (this.h.a().isEmpty()) {
                synchronized (this) {
                    if (this.h.a().isEmpty()) {
                        this.h = av.a.c(this.e);
                        ax.a(this + " serviceInfos's activeService is null first, refresh from refresher");
                    }
                }
            }
            f();
        }
        if (this.j.size() == 0) {
            synchronized (this.m) {
                try {
                    this.m.wait(400);
                } catch (Throwable e) {
                    ax.a("interrupted wait", e);
                }
            }
            ax.a(this + " " + this.a + " try400 sleep ");
        }
        int size = this.h.c().size();
        int i = 0;
        if (this.h.a().isEmpty()) {
            synchronized (this) {
                if (this.h.a().isEmpty()) {
                    this.h = av.a.c(this.e);
                    ax.a(this + " serviceInfos's activeService is null, refresh from refresher");
                }
            }
            obj = null;
            bfVar = null;
        } else {
            obj = null;
            bfVar = null;
        }
        while (i < size) {
            bb a = this.f.a(this.h, amVar);
            if (a == null) {
                ax.a(this + " failed getAliveConn for " + this.a);
            } else if (bg.a(a, this)) {
                bfVar = (bf) this.j.get(a.a());
                if (bfVar != null) {
                    obj = a;
                    break;
                }
                ax.a(this + " can not find this service " + a + " " + this.j + " " + this.a + " i:" + i + " maxTryCount:" + size);
                bfVar = new bf(this, a, this.k);
                this.j.putIfAbsent(a.a(), bfVar);
            } else {
                a(a.a());
            }
            i++;
            synchronized (this.m) {
                try {
                    this.m.wait(100);
                } catch (Throwable e2) {
                    ax.a("interrupted wait", e2);
                }
            }
            bb obj2 = a;
        }
        if (bfVar != null) {
            return bfVar;
        }
        throw new bn("can not find this service " + obj2 + " " + this.j + " " + this.a);
    }

    private void f() {
        Throwable th;
        boolean z;
        boolean z2 = true;
        try {
            if (this.n.compareAndSet(false, true)) {
                try {
                    for (bb bbVar : this.h.f()) {
                        ax.a("check " + this.g.c() + " service " + bbVar);
                        if (bbVar.d || !bbVar.a.equals("udp")) {
                            bf bfVar;
                            if (this.i.containsKey(bbVar.a())) {
                                ax.a(this + " get " + bbVar + " from existServiceMap ");
                                bfVar = (bf) this.i.get(bbVar.a());
                            } else {
                                ax.a(this + " create " + bbVar + " to existServiceMap");
                                bfVar = new bf(this, bbVar, this.k);
                                this.i.putIfAbsent(bbVar.a(), bfVar);
                            }
                            if (this.h.c(bfVar)) {
                                ax.a(this + " add " + bfVar + " to aliveServiceMap");
                                this.j.putIfAbsent(bbVar.a(), bfVar);
                            }
                        } else {
                            ax.a("not check failed udp server " + bbVar);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                z2 = false;
            }
            if (z2) {
                this.n.set(false);
                return;
            }
            return;
        } catch (Throwable th3) {
            th = th3;
            z2 = false;
            if (z2) {
                this.n.set(false);
            }
            throw th;
        }
        try {
            ax.b(this.h.e() + " doConn error ", th);
            if (z) {
                this.n.set(false);
            }
        } catch (Throwable th4) {
            th = th4;
            z2 = z;
            if (z2) {
                this.n.set(false);
            }
            throw th;
        }
    }

    public void a(List<Integer> list) {
        ak.a().c(this.e);
    }

    public void a(aq aqVar) {
        this.e = aqVar;
    }

    public aq c() {
        return this.e;
    }

    public aw d() {
        return this.f;
    }

    public void a(aw awVar) {
        this.f = awVar;
    }

    public String e() {
        return this.b;
    }

    public void a(bf bfVar) {
        try {
            if (bfVar.a.isOpen()) {
                ax.b(bfVar.d().a() + " warn failed service has alive session,can not remove");
                return;
            }
            this.h.a(bfVar);
            if (((bf) this.j.remove(bfVar.d().a())) != null) {
                ax.a(this + " remove aliveServiceMap " + bfVar + " for " + this.a);
            }
        } catch (Exception e) {
            ax.b(this + " onAllSessoinClose error " + this.a + " " + e);
        }
    }

    public void b(bf bfVar) {
        try {
            if (this.j.containsKey(bfVar.d().a())) {
                ax.a(this + " also has alive service " + bfVar + " in map.");
            }
            this.h.b(bfVar);
            this.j.putIfAbsent(bfVar.d().a(), bfVar);
            synchronized (this.m) {
                this.m.notifyAll();
            }
            ax.a(this + " put aliveServiceMap " + bfVar + " for " + this.a);
        } catch (Exception e) {
            ax.b(this + " onSessionOpen error " + this.a + " " + e);
        }
    }
}
