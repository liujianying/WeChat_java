package com.tencent.mm.vending.g;

import android.os.Looper;
import android.util.Pair;
import com.tencent.mm.vending.h.f;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;
import com.tencent.mm.vending.j.k;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import junit.framework.Assert;

public class e<_Var> implements c<_Var> {
    private int mRetryCount = 0;
    private volatile boolean uQM = false;
    volatile d uQN = d.Idle;
    boolean uQO = false;
    private Queue<a> uQP = new LinkedList();
    private volatile com.tencent.mm.vending.h.d uQQ = this.uQR;
    private volatile com.tencent.mm.vending.h.d uQR = g.cBM();
    volatile Object uQS;
    volatile boolean uQT;
    volatile Object uQU;
    a uQV;
    a uQW;
    private long uQX = -1;
    private boolean uQY = false;
    private b uQZ = new b();
    f uQz = new f(this.uQR, this.uRb);
    private com.tencent.mm.vending.h.d uRa;
    private com.tencent.mm.vending.h.f.a uRb = new com.tencent.mm.vending.h.f.a() {
        public final void cBI() {
            f cBJ = f.cBJ();
            e eVar = e.this;
            Stack stack = (Stack) cBJ.uRA.get();
            if (stack == null) {
                stack = new Stack();
                cBJ.uRA.set(stack);
            }
            stack.push(eVar);
        }

        public final void cw(Object obj) {
            ((Stack) f.cBJ().uRA.get()).pop();
            synchronized (e.this) {
                e.this.uQV = e.this.uQW;
                e.this.uQW = null;
                if (e.this.uQO) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "gonna retry, do not store functional result.", new Object[0]);
                } else {
                    e.this.uQS = obj;
                }
                if (e.this.uQN == d.Interrupted) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, just return", new Object[0]);
                } else if (e.this.uQN == d.Pausing) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pausing, just return.", new Object[0]);
                } else {
                    e.this.uQN = d.Resolved;
                    e.this.cv(e.this.cu(obj));
                }
            }
        }

        public final void interrupt() {
            e.this.mJ(true);
        }
    };
    List<Pair<com.tencent.mm.vending.g.d.a, com.tencent.mm.vending.h.d>> uRc;
    private List<Pair<com.tencent.mm.vending.g.d.b, com.tencent.mm.vending.h.d>> uRd;
    private boolean uRe = false;
    boolean uRf = false;
    private boolean uRg = false;
    private Object uRh;
    Object uRi;

    private static class a {
        public com.tencent.mm.vending.h.d byz;
        public com.tencent.mm.vending.c.a dsn;
        public long mInterval;
        public boolean uRr;

        public a(com.tencent.mm.vending.c.a aVar, com.tencent.mm.vending.h.d dVar, long j, boolean z) {
            this.dsn = aVar;
            this.byz = dVar;
            this.mInterval = j;
            this.uRr = z;
        }
    }

    public static class c extends Error {
        public c(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    private enum d {
        Idle,
        Resolved,
        Invoking,
        Pausing,
        Interrupted,
        AllDone
    }

    class b implements b {
        b() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void ct(java.lang.Object r7) {
            /*
            r6 = this;
            r1 = com.tencent.mm.vending.g.e.this;
            monitor-enter(r1);
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0037 }
            r0 = r0.uQN;	 Catch:{ all -> 0x0037 }
            r2 = com.tencent.mm.vending.g.e.d.Interrupted;	 Catch:{ all -> 0x0037 }
            if (r0 != r2) goto L_0x0019;
        L_0x000b:
            r0 = "Vending.Pipeline";
            r2 = "interrupted, skip this interrupt.";
            r3 = 0;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0037 }
            com.tencent.mm.vending.f.a.i(r0, r2, r3);	 Catch:{ all -> 0x0037 }
            monitor-exit(r1);	 Catch:{ all -> 0x0037 }
        L_0x0018:
            return;
        L_0x0019:
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0037 }
            r0 = com.tencent.mm.vending.g.e.a(r0);	 Catch:{ all -> 0x0037 }
            if (r0 != 0) goto L_0x003a;
        L_0x0021:
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0037 }
            r0 = r0.uQN;	 Catch:{ all -> 0x0037 }
            r2 = com.tencent.mm.vending.g.e.d.Pausing;	 Catch:{ all -> 0x0037 }
            if (r0 == r2) goto L_0x003a;
        L_0x0029:
            r0 = "Vending.Pipeline";
            r2 = "interrupt not in func scope or pending, skip this retryOrInterrupt.";
            r3 = 0;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0037 }
            com.tencent.mm.vending.f.a.i(r0, r2, r3);	 Catch:{ all -> 0x0037 }
            monitor-exit(r1);	 Catch:{ all -> 0x0037 }
            goto L_0x0018;
        L_0x0037:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0037 }
            throw r0;
        L_0x003a:
            r0 = "Vending.Pipeline";
            r2 = "interrupt Pipeline(%s)";
            r3 = 1;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0037 }
            r4 = 0;
            r5 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0037 }
            r3[r4] = r5;	 Catch:{ all -> 0x0037 }
            com.tencent.mm.vending.f.a.i(r0, r2, r3);	 Catch:{ all -> 0x0037 }
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0037 }
            r2 = 0;
            r0.mJ(r2);	 Catch:{ all -> 0x0037 }
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0037 }
            r2 = 1;
            r0.uRf = r2;	 Catch:{ all -> 0x0037 }
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0037 }
            r0.uRi = r7;	 Catch:{ all -> 0x0037 }
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0037 }
            r0 = r0.uRc;	 Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x007a;
        L_0x0060:
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0037 }
            r0 = r0.uRc;	 Catch:{ all -> 0x0037 }
            r2 = r0.iterator();	 Catch:{ all -> 0x0037 }
        L_0x0068:
            r0 = r2.hasNext();	 Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x007a;
        L_0x006e:
            r0 = r2.next();	 Catch:{ all -> 0x0037 }
            r0 = (android.util.Pair) r0;	 Catch:{ all -> 0x0037 }
            r3 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0037 }
            r3.a(r0, r7);	 Catch:{ all -> 0x0037 }
            goto L_0x0068;
        L_0x007a:
            monitor-exit(r1);	 Catch:{ all -> 0x0037 }
            goto L_0x0018;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vending.g.e.b.ct(java.lang.Object):void");
        }

        public final void cBE() {
            synchronized (e.this) {
                synchronized (e.this) {
                    if (e.this.uQN == d.Interrupted || e.this.uQN == d.Idle) {
                        com.tencent.mm.vending.f.a.w("Vending.Pipeline", "current is state(%s), ignore pause.", e.this.uQN);
                    } else if (!e.a(e.this)) {
                        com.tencent.mm.vending.f.a.e("Vending.Pipeline", "you are using mario().pause() out of a functional scope on %s!", e.this);
                    } else if (e.b(e.this)) {
                        e.this.uQN = d.Pausing;
                    } else {
                        com.tencent.mm.vending.f.a.e("Vending.Pipeline", "you are using mario().pause() out of calling thread on %s!", e.this);
                    }
                }
            }
        }

        public final void v(Object... objArr) {
            synchronized (e.this) {
                if (e.this.uQN != d.Pausing) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "state is not pausing %s, skip this wormhole", e.this.uQN);
                    return;
                }
                e eVar = e.this;
                Object x = objArr.length == 0 ? null : objArr.length == 1 ? objArr[0] : k.x(objArr);
                eVar.uQU = x;
                e.this.uQT = true;
                com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pipline(%s) wormhole().", e.this);
                resume();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void resume() {
            /*
            r6 = this;
            r1 = com.tencent.mm.vending.g.e.this;
            monitor-enter(r1);
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0045 }
            r0 = r0.uQN;	 Catch:{ all -> 0x0045 }
            r2 = com.tencent.mm.vending.g.e.d.Pausing;	 Catch:{ all -> 0x0045 }
            if (r0 == r2) goto L_0x001e;
        L_0x000b:
            r0 = "Vending.Pipeline";
            r2 = "this Pipeline(%s) is not pausing! why call resume?";
            r3 = 1;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0045 }
            r4 = 0;
            r5 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0045 }
            r3[r4] = r5;	 Catch:{ all -> 0x0045 }
            com.tencent.mm.vending.f.a.e(r0, r2, r3);	 Catch:{ all -> 0x0045 }
            monitor-exit(r1);	 Catch:{ all -> 0x0045 }
        L_0x001d:
            return;
        L_0x001e:
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0045 }
            r0 = com.tencent.mm.vending.g.e.a(r0);	 Catch:{ all -> 0x0045 }
            if (r0 != 0) goto L_0x0048;
        L_0x0026:
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0045 }
            r2 = com.tencent.mm.vending.g.e.d.Resolved;	 Catch:{ all -> 0x0045 }
            r0.uQN = r2;	 Catch:{ all -> 0x0045 }
        L_0x002c:
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0045 }
            r0 = com.tencent.mm.vending.g.e.b(r0);	 Catch:{ all -> 0x0045 }
            if (r0 != 0) goto L_0x0043;
        L_0x0034:
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0045 }
            r2 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0045 }
            r3 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0045 }
            r3 = r3.uQS;	 Catch:{ all -> 0x0045 }
            r2 = r2.cu(r3);	 Catch:{ all -> 0x0045 }
            r0.cv(r2);	 Catch:{ all -> 0x0045 }
        L_0x0043:
            monitor-exit(r1);	 Catch:{ all -> 0x0045 }
            goto L_0x001d;
        L_0x0045:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0045 }
            throw r0;
        L_0x0048:
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0045 }
            r2 = com.tencent.mm.vending.g.e.d.Invoking;	 Catch:{ all -> 0x0045 }
            r0.uQN = r2;	 Catch:{ all -> 0x0045 }
            goto L_0x002c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vending.g.e.b.resume():void");
        }
    }

    public c<_Var> abE(String str) {
        if (str == null) {
            Assert.assertNotNull("schedulerTypeString should not be null!", str);
        } else {
            this.uQQ = g.abG(str);
            Assert.assertNotNull("mCurrentScheduler should not be null!", this.uQQ);
        }
        return this;
    }

    public c<_Var> a(com.tencent.mm.vending.h.d dVar) {
        if (dVar == null) {
            Assert.assertNotNull("scheduler should not be null!", dVar);
        } else {
            this.uQQ = dVar;
        }
        return this;
    }

    public c<_Var> b(com.tencent.mm.vending.e.b bVar) {
        Assert.assertNotNull("keeper should not be null!", bVar);
        bVar.keep(this);
        return this;
    }

    public synchronized c<_Var> gR(long j) {
        this.uQX = j;
        return this;
    }

    public c<_Var> mI(boolean z) {
        this.uQY = z;
        return this;
    }

    public synchronized c<_Var> a(final com.tencent.mm.vending.g.c.a<_Var> aVar) {
        w(new Object[0]);
        a(new com.tencent.mm.vending.c.a<_Var, _Var>() {
            public final _Var call(_Var _var) {
                return aVar.call();
            }
        }, true);
        return this;
    }

    public synchronized c<_Var> w(Object... objArr) {
        c<_Var> cVar;
        if (this.uQN != d.Idle) {
            cVar = this;
        } else {
            this.uQN = d.Resolved;
            Object x = objArr.length == 0 ? null : objArr.length == 1 ? objArr[0] : k.x(objArr);
            this.uQS = x;
            cv(this.uQS);
            x = this;
        }
        return cVar;
    }

    public void dead() {
        mJ(true);
    }

    public final b cBF() {
        return this.uQZ;
    }

    public <_Ret> c<_Ret> f(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        return abE("Vending.UI").c(aVar);
    }

    public <_Ret> c<_Ret> d(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        return abE("Vending.LOGIC").c(aVar);
    }

    public <_Ret> c<_Ret> e(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        return abE("Vending.HEAVY_WORK").c(aVar);
    }

    private synchronized <_Ret> c<_Ret> a(com.tencent.mm.vending.c.a<_Ret, _Var> aVar, boolean z) {
        c<_Ret> cVar;
        cBG();
        this.uQP.add(new a(aVar, this.uQQ, this.uQX, z));
        this.uQX = -1;
        Object cVar2;
        if (this.uQN == d.Idle) {
            cVar2 = this;
        } else if (this.uQN != d.Resolved) {
            cVar2 = this;
        } else {
            cv(this.uQS);
            cVar2 = this;
        }
        return cVar2;
    }

    public synchronized <_Ret> c<_Ret> c(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        return a((com.tencent.mm.vending.c.a) aVar, this.uQY);
    }

    private synchronized void cBG() {
        if (this.uQM) {
            throw new c("This Pipeline(%s) has terminate and do not allow any next().", this);
        }
    }

    final synchronized void a(final Pair<com.tencent.mm.vending.g.d.a, com.tencent.mm.vending.h.d> pair, final Object obj) {
        com.tencent.mm.vending.h.d dVar = (com.tencent.mm.vending.h.d) pair.second;
        Runnable anonymousClass3 = new Runnable() {
            public final void run() {
                ((com.tencent.mm.vending.g.d.a) pair.first).bd(obj);
            }
        };
        if (dVar == null) {
            com.tencent.mm.vending.f.a.e("Vending.Pipeline", "Default scheduler %s is not available!!!", this.uQR);
        }
        dVar.g(anonymousClass3);
    }

    private synchronized void b(final Pair<com.tencent.mm.vending.g.d.b, com.tencent.mm.vending.h.d> pair, final Object obj) {
        final RuntimeException runtimeException = new RuntimeException("object is not right: " + obj);
        new f((com.tencent.mm.vending.h.d) pair.second, null).a(new com.tencent.mm.vending.c.a<Void, Void>() {
            private Void acs() {
                try {
                    ((com.tencent.mm.vending.g.d.b) pair.first).aF(obj);
                    return uQG;
                } catch (Throwable e) {
                    if (runtimeException.getCause() == null) {
                        runtimeException.initCause(e);
                    }
                    throw runtimeException;
                }
            }
        }, null, this.uQY);
    }

    private synchronized void a(com.tencent.mm.vending.g.d.a aVar, com.tencent.mm.vending.h.d dVar) {
        cBH();
        if (this.uRc == null) {
            this.uRc = new LinkedList();
        }
        Pair pair = new Pair(aVar, dVar);
        if (this.uRf) {
            a(pair, this.uRi);
        } else {
            this.uRc.add(pair);
        }
    }

    private synchronized void a(com.tencent.mm.vending.g.d.b bVar, com.tencent.mm.vending.h.d dVar) {
        cBH();
        cv(this.uQS);
        if (this.uRd == null) {
            this.uRd = new LinkedList();
        }
        Pair pair = new Pair(bVar, dVar);
        if (this.uRe) {
            b(pair, this.uRh);
        } else {
            this.uRd.add(pair);
        }
    }

    public final synchronized d<_Var> cBH() {
        this.uQM = true;
        return this;
    }

    public final synchronized d<_Var> a(com.tencent.mm.vending.g.d.a aVar) {
        a(aVar, this.uQR);
        return this;
    }

    public final synchronized d<_Var> a(com.tencent.mm.vending.g.d.b<_Var> bVar) {
        a((com.tencent.mm.vending.g.d.b) bVar, this.uQR);
        return this;
    }

    public final synchronized d<_Var> a(com.tencent.mm.vending.h.d dVar, com.tencent.mm.vending.g.d.b<_Var> bVar) {
        a((com.tencent.mm.vending.g.d.b) bVar, dVar);
        return this;
    }

    final synchronized void mJ(boolean z) {
        if (!(this.uQN == d.Interrupted || this.uQN == d.AllDone)) {
            if (z) {
                if (this.uQP.size() > 0) {
                    com.tencent.mm.vending.f.a.w("Vending.Pipeline", "Pipe is not finish and be interrupt! %s pipes did not run", Integer.valueOf(this.uQP.size()));
                }
            }
            this.uQN = d.Interrupted;
            this.uQP.clear();
            this.uQS = null;
            if (this.uRa != null) {
                this.uRa.cancel();
            }
        }
    }

    final synchronized Object cu(Object obj) {
        if (this.uQO) {
            this.mRetryCount++;
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "Functional %s, gonna retry %s.", this.uQV.dsn.toString(), Integer.valueOf(this.mRetryCount));
            ((LinkedList) this.uQP).add(0, this.uQV);
            this.uQO = false;
        } else {
            if (this.uQT) {
                this.uQS = this.uQU;
                this.uQU = null;
                this.uQT = false;
            } else {
                this.uQS = obj;
            }
            this.mRetryCount = 0;
        }
        return this.uQS;
    }

    final synchronized void cv(final Object obj) {
        if (this.uQN == d.Resolved) {
            this.uQN = d.Invoking;
            a aVar = (a) this.uQP.peek();
            if (aVar != null) {
                final com.tencent.mm.vending.c.a aVar2 = aVar.dsn;
                com.tencent.mm.vending.h.d dVar = aVar.byz;
                long j = aVar.mInterval;
                final boolean z = aVar.uRr;
                if (this.uQN == d.Pausing) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "This pipeline is Pausing. We will stop dequeFunctionAndInvoke and waiting resume() call", new Object[0]);
                } else {
                    this.uQW = (a) this.uQP.poll();
                    this.uQz.b(dVar);
                    if (j < 0) {
                        this.uQz.a(aVar2, obj, z);
                    } else {
                        if (Looper.myLooper() == null) {
                            this.uRa = new com.tencent.mm.vending.h.c();
                        } else {
                            this.uRa = new h(Looper.myLooper(), Looper.myLooper().toString());
                        }
                        this.uRa.g(new Runnable() {
                            public final void run() {
                                e.this.uQz.a(aVar2, obj, z);
                            }
                        }, j);
                    }
                }
            } else if (this.uQM) {
                this.uQN = d.AllDone;
                this.uRe = true;
                this.uRh = obj;
                if (this.uRd != null) {
                    for (Pair b : this.uRd) {
                        b(b, this.uRh);
                    }
                }
            } else {
                this.uQN = d.Resolved;
            }
        }
    }
}
