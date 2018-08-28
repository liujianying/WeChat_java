package com.tencent.mm.blink;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.h.h;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b {
    private static b cWf = new b();
    private final Queue<a> cWg = new LinkedList();
    private boolean cWh = false;
    private volatile boolean cWi = false;
    private boolean cWj = true;
    private volatile c cWk = g.cBK();
    private AtomicBoolean cWl = new AtomicBoolean(false);
    private ah cWm = new ah("pending-stage");

    private enum b {
        Now,
        Timeout,
        FirstScreen
    }

    private static class a implements e {
        private d byz;
        private Runnable mRunnable;

        public a(Runnable runnable, d dVar) {
            this.mRunnable = runnable;
            this.byz = dVar;
        }

        public final Object call(Object obj) {
            x.i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement tryConsumingWaitingQueue runnable %s, %s", this.mRunnable, this.byz.getType());
            this.mRunnable.run();
            return null;
        }

        public final String xr() {
            if (!(this.byz instanceof com.tencent.mm.vending.h.c)) {
                return this.byz.getType();
            }
            if (d.cBM() instanceof com.tencent.mm.vending.h.c) {
                return d.uRC.mType;
            }
            return d.cBM().getType();
        }
    }

    public static b xi() {
        return cWf;
    }

    public final synchronized void xj() {
        this.cWh = true;
    }

    public final synchronized void xk() {
        this.cWj = true;
        if (this.cWh) {
            xo();
        }
    }

    public final synchronized void xl() {
        this.cWj = false;
    }

    public final synchronized void xm() {
        if (this.cWh) {
            this.cWh = false;
            xo();
        }
    }

    public final synchronized void g(Runnable runnable) {
        d cBM = d.cBM();
        if (!(cBM instanceof com.tencent.mm.vending.h.c)) {
            com.tencent.mm.vending.h.g.a(cBM.getType(), cBM);
        }
        if (xn()) {
            x.i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement arrange runnable postToMainThread %s", runnable);
            this.cWk.c(new a(runnable, cBM));
        } else {
            x.i("MicroMsg.FirstScreenArrangement", "arrange first screen runnable: %s, %s, %s, %s", Boolean.valueOf(this.cWh), Boolean.valueOf(this.cWj), Boolean.valueOf(this.cWi), this.cWg);
            this.cWg.add(new a(runnable, cBM));
        }
    }

    private synchronized boolean xn() {
        boolean z;
        z = (!this.cWh || this.cWj) && this.cWi;
        return z;
    }

    private void xo() {
        a(b.FirstScreen);
        xp();
    }

    private synchronized void xp() {
        if (xn()) {
            while (true) {
                a aVar = (a) this.cWg.poll();
                if (aVar == null) {
                    break;
                }
                x.i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement tryConsumingWaitingQueue runnable %s, %s", aVar.mRunnable, aVar.byz.getType());
                this.cWk.c(aVar);
            }
        }
    }

    public final void a(final b bVar) {
        if (!this.cWl.compareAndSet(false, true)) {
            return;
        }
        if (bVar == b.Now) {
            x.i("MicroMsg.FirstScreenArrangement", "initialize pending plugins from %s", bVar);
            com.tencent.mm.kernel.a.c.Et().Eu();
            synchronized (this) {
                this.cWi = true;
                xp();
            }
            return;
        }
        d hVar = new h(new com.tencent.mm.by.d(this.cWm.cil()), "pending-stage");
        synchronized (this) {
            this.cWk.a(hVar).c(new com.tencent.mm.vending.c.a<Object, Void>() {
                private Object xq() {
                    x.i("MicroMsg.FirstScreenArrangement", "initialize pending plugins from %s", bVar);
                    com.tencent.mm.kernel.a.c.Et().Eu();
                    synchronized (this) {
                        b.this.cWi = true;
                        b.this.xp();
                    }
                    return null;
                }
            });
        }
    }
}
