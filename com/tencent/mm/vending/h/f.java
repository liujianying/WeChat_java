package com.tencent.mm.vending.h;

public final class f {
    private volatile d uQQ;
    volatile a uRb;

    public interface a {
        void cBI();

        void cw(Object obj);

        void interrupt();
    }

    public f(d dVar, a aVar) {
        b(dVar);
        this.uRb = aVar;
    }

    public final synchronized void b(d dVar) {
        c(dVar);
    }

    private synchronized void c(d dVar) {
        this.uQQ = dVar;
    }

    public synchronized void a(final com.tencent.mm.vending.c.a aVar, final Object obj, boolean z) {
        d abG;
        d dVar = this.uQQ;
        if (aVar instanceof e) {
            e eVar = (e) aVar;
            if (!"Vending.ANY".equals(eVar.xr())) {
                abG = g.abG(eVar.xr());
                if (abG == null) {
                    final RuntimeException runtimeException = new RuntimeException("object is not right: " + obj);
                    Runnable anonymousClass1 = new Runnable() {
                        public final void run() {
                            if (f.this.uRb != null) {
                                f.this.uRb.cBI();
                            }
                            try {
                                Object call = aVar.call(obj);
                                if (f.this.uRb != null) {
                                    f.this.uRb.cw(call);
                                }
                            } catch (Throwable e) {
                                runtimeException.initCause(e);
                                throw runtimeException;
                            }
                        }
                    };
                    if (-1 >= 0) {
                        abG.g(anonymousClass1, -1);
                    } else if (z && g.cBM() == abG) {
                        anonymousClass1.run();
                    } else {
                        abG.g(anonymousClass1);
                    }
                } else if (this.uRb != null) {
                    this.uRb.interrupt();
                }
            }
        }
        abG = dVar;
        if (abG == null) {
            final RuntimeException runtimeException2 = new RuntimeException("object is not right: " + obj);
            Runnable anonymousClass12 = /* anonymous class already generated */;
            if (-1 >= 0) {
                abG.g(anonymousClass12, -1);
            } else if (z && g.cBM() == abG) {
                anonymousClass12.run();
            } else {
                abG.g(anonymousClass12);
            }
        } else if (this.uRb != null) {
            this.uRb.interrupt();
        }
    }
}
