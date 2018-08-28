package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.i.a;
import java.util.LinkedList;

public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {
    private int aic;
    private final Thread aij;
    private final LinkedList<I> aik = new LinkedList();
    private final LinkedList<O> ail = new LinkedList();
    public final I[] aim;
    private final O[] ain;
    public int aio;
    private int aip;
    private I aiq;
    private boolean air;
    private E exception;
    private final Object lock = new Object();
    private boolean released;

    public abstract E a(I i, O o, boolean z);

    public abstract I jL();

    public abstract O jM();

    public final /* synthetic */ void W(Object obj) {
        e eVar = (e) obj;
        synchronized (this.lock) {
            jH();
            a.ao(eVar == this.aiq);
            this.aik.addLast(eVar);
            jI();
            this.aiq = null;
        }
    }

    public g(I[] iArr, O[] oArr) {
        int i = 0;
        this.aim = iArr;
        this.aio = 2;
        for (int i2 = 0; i2 < this.aio; i2++) {
            this.aim[i2] = jL();
        }
        this.ain = oArr;
        this.aip = 2;
        while (i < this.aip) {
            this.ain[i] = jM();
            i++;
        }
        this.aij = new 1(this);
        this.aij.start();
    }

    private I jF() {
        I i;
        synchronized (this.lock) {
            e eVar;
            jH();
            a.ap(this.aiq == null);
            if (this.aio == 0) {
                eVar = null;
            } else {
                e[] eVarArr = this.aim;
                int i2 = this.aio - 1;
                this.aio = i2;
                eVar = eVarArr[i2];
            }
            this.aiq = eVar;
            i = this.aiq;
        }
        return i;
    }

    private O jG() {
        O o;
        synchronized (this.lock) {
            jH();
            if (this.ail.isEmpty()) {
                o = null;
            } else {
                f o2 = (f) this.ail.removeFirst();
            }
        }
        return o2;
    }

    public void a(O o) {
        synchronized (this.lock) {
            b(o);
            jI();
        }
    }

    public final void flush() {
        synchronized (this.lock) {
            this.air = true;
            this.aic = 0;
            if (this.aiq != null) {
                a(this.aiq);
                this.aiq = null;
            }
            while (!this.aik.isEmpty()) {
                a((e) this.aik.removeFirst());
            }
            while (!this.ail.isEmpty()) {
                b((f) this.ail.removeFirst());
            }
        }
    }

    public final void release() {
        synchronized (this.lock) {
            this.released = true;
            this.lock.notify();
        }
        try {
            this.aij.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void jH() {
        if (this.exception != null) {
            throw this.exception;
        }
    }

    private void jI() {
        if (jK()) {
            this.lock.notify();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean jJ() {
        /*
        r6 = this;
        r1 = 0;
        r2 = r6.lock;
        monitor-enter(r2);
    L_0x0004:
        r0 = r6.released;	 Catch:{ all -> 0x0014 }
        if (r0 != 0) goto L_0x0017;
    L_0x0008:
        r0 = r6.jK();	 Catch:{ all -> 0x0014 }
        if (r0 != 0) goto L_0x0017;
    L_0x000e:
        r0 = r6.lock;	 Catch:{ all -> 0x0014 }
        r0.wait();	 Catch:{ all -> 0x0014 }
        goto L_0x0004;
    L_0x0014:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0014 }
        throw r0;
    L_0x0017:
        r0 = r6.released;	 Catch:{ all -> 0x0014 }
        if (r0 == 0) goto L_0x001e;
    L_0x001b:
        monitor-exit(r2);	 Catch:{ all -> 0x0014 }
        r0 = r1;
    L_0x001d:
        return r0;
    L_0x001e:
        r0 = r6.aik;	 Catch:{ all -> 0x0014 }
        r0 = r0.removeFirst();	 Catch:{ all -> 0x0014 }
        r0 = (com.google.android.exoplayer2.b.e) r0;	 Catch:{ all -> 0x0014 }
        r3 = r6.ain;	 Catch:{ all -> 0x0014 }
        r4 = r6.aip;	 Catch:{ all -> 0x0014 }
        r4 = r4 + -1;
        r6.aip = r4;	 Catch:{ all -> 0x0014 }
        r3 = r3[r4];	 Catch:{ all -> 0x0014 }
        r4 = r6.air;	 Catch:{ all -> 0x0014 }
        r5 = 0;
        r6.air = r5;	 Catch:{ all -> 0x0014 }
        monitor-exit(r2);	 Catch:{ all -> 0x0014 }
        r2 = r0.jy();
        if (r2 == 0) goto L_0x0050;
    L_0x003c:
        r1 = 4;
        r3.cf(r1);
    L_0x0040:
        r1 = r6.lock;
        monitor-enter(r1);
        r2 = r6.air;	 Catch:{ all -> 0x007e }
        if (r2 == 0) goto L_0x006e;
    L_0x0047:
        r6.b(r3);	 Catch:{ all -> 0x007e }
    L_0x004a:
        r6.a(r0);	 Catch:{ all -> 0x007e }
        monitor-exit(r1);	 Catch:{ all -> 0x007e }
        r0 = 1;
        goto L_0x001d;
    L_0x0050:
        r2 = r0.jx();
        if (r2 == 0) goto L_0x005b;
    L_0x0056:
        r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r3.cf(r2);
    L_0x005b:
        r2 = r6.a(r0, r3, r4);
        r6.exception = r2;
        r2 = r6.exception;
        if (r2 == 0) goto L_0x0040;
    L_0x0065:
        r2 = r6.lock;
        monitor-enter(r2);
        monitor-exit(r2);	 Catch:{ all -> 0x006b }
        r0 = r1;
        goto L_0x001d;
    L_0x006b:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x006b }
        throw r0;
    L_0x006e:
        r2 = r3.jx();	 Catch:{ all -> 0x007e }
        if (r2 == 0) goto L_0x0081;
    L_0x0074:
        r2 = r6.aic;	 Catch:{ all -> 0x007e }
        r2 = r2 + 1;
        r6.aic = r2;	 Catch:{ all -> 0x007e }
        r6.b(r3);	 Catch:{ all -> 0x007e }
        goto L_0x004a;
    L_0x007e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x007e }
        throw r0;
    L_0x0081:
        r2 = r6.aic;	 Catch:{ all -> 0x007e }
        r3.aic = r2;	 Catch:{ all -> 0x007e }
        r2 = 0;
        r6.aic = r2;	 Catch:{ all -> 0x007e }
        r2 = r6.ail;	 Catch:{ all -> 0x007e }
        r2.addLast(r3);	 Catch:{ all -> 0x007e }
        goto L_0x004a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.b.g.jJ():boolean");
    }

    private boolean jK() {
        return !this.aik.isEmpty() && this.aip > 0;
    }

    private void a(I i) {
        i.clear();
        e[] eVarArr = this.aim;
        int i2 = this.aio;
        this.aio = i2 + 1;
        eVarArr[i2] = i;
    }

    private void b(O o) {
        o.clear();
        f[] fVarArr = this.ain;
        int i = this.aip;
        this.aip = i + 1;
        fVarArr[i] = o;
    }
}
