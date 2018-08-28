package com.google.android.gms.common.api;

import android.os.Looper;
import android.util.Pair;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class j<R extends g> implements e<R> {
    private volatile R aKA;
    private volatile boolean aKB;
    private boolean aKC;
    private boolean aKD;
    private q aKE;
    private final Object aKv = new Object();
    protected final a<R> aKw;
    private final CountDownLatch aKx = new CountDownLatch(1);
    private final ArrayList<Object> aKy = new ArrayList();
    private h<R> aKz;

    protected j(Looper looper) {
        this.aKw = new a(looper);
    }

    private void b(R r) {
        this.aKA = r;
        this.aKE = null;
        this.aKx.countDown();
        g gVar = this.aKA;
        if (this.aKz != null) {
            this.aKw.removeMessages(2);
            if (!this.aKC) {
                a aVar = this.aKw;
                aVar.sendMessage(aVar.obtainMessage(1, new Pair(this.aKz, oH())));
            }
        }
        Iterator it = this.aKy.iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.aKy.clear();
    }

    private static void c(g gVar) {
        if (gVar instanceof f) {
            try {
                ((f) gVar).release();
            } catch (RuntimeException e) {
                new StringBuilder("Unable to release ").append(gVar);
            }
        }
    }

    private boolean hv() {
        return this.aKx.getCount() == 0;
    }

    private R oH() {
        R r;
        boolean z = true;
        synchronized (this.aKv) {
            if (this.aKB) {
                z = false;
            }
            w.d(z, "Result has already been consumed.");
            w.d(hv(), "Result is not ready.");
            r = this.aKA;
            this.aKA = null;
            this.aKz = null;
            this.aKB = true;
        }
        oG();
        return r;
    }

    public final void a(Status status) {
        synchronized (this.aKv) {
            if (!hv()) {
                a(b(status));
                this.aKD = true;
            }
        }
    }

    public final void a(R r) {
        boolean z = true;
        synchronized (this.aKv) {
            if (this.aKD || this.aKC) {
                c(r);
                return;
            }
            w.d(!hv(), "Results have already been set");
            if (this.aKB) {
                z = false;
            }
            w.d(z, "Result has already been consumed");
            b((g) r);
        }
    }

    public abstract R b(Status status);

    public final R b(TimeUnit timeUnit) {
        boolean z = true;
        boolean z2 = 2 <= 0 || Looper.myLooper() != Looper.getMainLooper();
        w.d(z2, "await must not be called on the UI thread when time is greater than zero.");
        if (this.aKB) {
            z = false;
        }
        w.d(z, "Result has already been consumed.");
        try {
            if (!this.aKx.await(2, timeUnit)) {
                a(Status.aKs);
            }
        } catch (InterruptedException e) {
            a(Status.aKq);
        }
        w.d(hv(), "Result is not ready.");
        return oH();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cancel() {
        /*
        r2 = this;
        r1 = r2.aKv;
        monitor-enter(r1);
        r0 = r2.aKC;	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.aKB;	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r2.aKA;	 Catch:{ all -> 0x0023 }
        c(r0);	 Catch:{ all -> 0x0023 }
        r0 = 0;
        r2.aKz = r0;	 Catch:{ all -> 0x0023 }
        r0 = 1;
        r2.aKC = r0;	 Catch:{ all -> 0x0023 }
        r0 = com.google.android.gms.common.api.Status.aKt;	 Catch:{ all -> 0x0023 }
        r0 = r2.b(r0);	 Catch:{ all -> 0x0023 }
        r2.b(r0);	 Catch:{ all -> 0x0023 }
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        goto L_0x000c;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.j.cancel():void");
    }

    public final R oE() {
        boolean z = true;
        w.d(Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread");
        if (this.aKB) {
            z = false;
        }
        w.d(z, "Result has already been consumed");
        try {
            this.aKx.await();
        } catch (InterruptedException e) {
            a(Status.aKq);
        }
        w.d(hv(), "Result is not ready.");
        return oH();
    }

    protected void oG() {
    }
}
