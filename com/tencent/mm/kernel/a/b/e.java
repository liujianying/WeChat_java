package com.tencent.mm.kernel.a.b;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.h.h;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import junit.framework.Assert;

public final class e<T> {
    private static e dsp = null;
    private Queue<c> dsi = new LinkedList();
    private int dsj;
    private volatile a dsk;
    private volatile boolean dsl = false;
    private final byte[] dsm = new byte[0];
    private volatile com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> dsn;
    private volatile c<T> dso;

    public interface a {
        void EG();

        void EJ();
    }

    public static class c {
        public HandlerThread byy;
        h dst;
        Handler handler;
    }

    public static class b implements a {
        private final byte[] dol = new byte[]{(byte) 0};

        public final void EG() {
            try {
                synchronized (this.dol) {
                    if (this.dol[0] == (byte) 0) {
                        j.i("MMSkeleton.Parallels", "Waiting for lock(%s)", this.dol);
                        this.dol.wait();
                    } else {
                        j.i("MMSkeleton.Parallels", "Not need wait for lock(%s)", this.dol);
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MMSkeleton.Parallels", e, "", new Object[0]);
            }
        }

        public final void EJ() {
            synchronized (this.dol) {
                this.dol[0] = (byte) 1;
                this.dol.notify();
                j.i("MMSkeleton.Parallels", "Lock(%s) notified", this.dol);
            }
        }
    }

    public static e EE() {
        return dsp;
    }

    public static e EF() {
        if (dsp == null) {
            dsp = new e();
        }
        return dsp;
    }

    private e() {
    }

    public final synchronized void init(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            Queue queue = this.dsi;
            HandlerThread handlerThread = new HandlerThread("parallels-" + i2, -8);
            handlerThread.start();
            c cVar = new c();
            cVar.byy = handlerThread;
            queue.add(cVar);
        }
        this.dsj = i;
    }

    public final synchronized void prepare() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dsj) {
                c cVar = (c) ((LinkedList) this.dsi).get(i2);
                Handler handler = new Handler(cVar.byy.getLooper());
                h hVar = new h(handler, cVar.byy.getName());
                cVar.handler = handler;
                cVar.dst = hVar;
                i = i2 + 1;
            }
        }
    }

    public final boolean a(a aVar, com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> aVar2, c<T> cVar) {
        synchronized (this.dsm) {
            if (this.dsl) {
                x.w("MMSkeleton.Parallels", "Arrange parallels task failed. It's busy on working.");
                Assert.assertTrue(false);
                return false;
            }
            this.dsk = aVar;
            this.dsn = aVar2;
            this.dso = cVar;
            return true;
        }
    }

    public final void a(a aVar, com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> aVar2, c<T> cVar, String str) {
        if (a(aVar, (com.tencent.mm.vending.c.a) aVar2, (c) cVar)) {
            cVar.prepare();
            start(str);
            EG();
        }
    }

    public final void EG() {
        this.dsk.EG();
    }

    public final void start(String str) {
        j.i("MMSkeleton.Parallels", "Start working. For %s", str);
        synchronized (this.dsm) {
            this.dsl = true;
        }
        active();
    }

    public final synchronized List<c> EH() {
        return new LinkedList(this.dsi);
    }

    private synchronized c EI() {
        return (c) this.dsi.poll();
    }

    private synchronized boolean a(c cVar) {
        boolean z = true;
        synchronized (this) {
            this.dsi.add(cVar);
            j.d("MMSkeleton.Parallels", "Parallels check threads idle. %s of %s", Integer.valueOf(this.dsi.size()), Integer.valueOf(this.dsj));
            if (this.dsi.size() != this.dsj) {
                z = false;
            }
        }
        return z;
    }

    private void b(c cVar) {
        if (a(cVar)) {
            synchronized (this.dsm) {
                if (this.dsl) {
                    j.i("MMSkeleton.Parallels", "Parallels notify done", new Object[0]);
                }
                this.dsl = false;
                this.dsk.EJ();
            }
        }
    }

    private void active() {
        while (true) {
            c EI = EI();
            if (EI != null) {
                com.tencent.mm.kernel.a.b.f.a ED = this.dso.ED();
                if (ED != null) {
                    a(EI, ED);
                } else {
                    b(EI);
                    return;
                }
            }
            return;
        }
    }

    private void a(final c cVar, final com.tencent.mm.kernel.a.b.f.a<T> aVar) {
        cVar.dst.g(new Runnable() {
            public final void run() {
                com.tencent.mm.kernel.a.a.a.a aVar = aVar;
                com.tencent.mm.vending.c.a a = e.this.dsn;
                if (!aVar.dsc) {
                    aVar.dsE.dsF.cDY();
                    if (!aVar.dsc) {
                        a.call(aVar);
                        x.d("MMSkeleton.ParallelsDependencies", "consume call functional %s, node %s", a, aVar);
                        aVar.dsc = true;
                    }
                    aVar.dsE.dsF.done();
                }
                e.this.dso.a(aVar);
                com.tencent.mm.kernel.a.b.f.a ED = e.this.dso.ED();
                if (ED == null) {
                    e.this.b(cVar);
                    return;
                }
                e.this.a(cVar, ED);
                e.this.active();
            }
        });
    }
}
