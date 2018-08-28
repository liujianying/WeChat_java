package com.tencent.mm.kernel.a.b;

import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class f<T> extends com.tencent.mm.kernel.a.a.a<T> implements c<T> {
    private c<T> dso;
    d<T> dsu;
    public Class dsv;
    volatile boolean dsw = false;

    public static class b {
        public com.tencent.mm.by.b dsF = new com.tencent.mm.by.b();
    }

    public static class a<T> extends com.tencent.mm.kernel.a.a.a.a<T> {
        public volatile a dsA;
        public volatile a dsB;
        public h dsC;
        private c dsD;
        public b dsE;
        volatile int dsx;
        private boolean dsy;
        volatile boolean dsz;

        /* synthetic */ a(Object obj, Class cls, c cVar, byte b) {
            this(obj, cls, cVar);
        }

        private a(T t, Class cls, c cVar) {
            super(t);
            this.dsx = 0;
            this.dsy = false;
            this.dsz = false;
            this.dsC = new h();
            this.dsE = new b();
            this.dsC.dsf = cls;
            this.dsD = cVar;
        }

        public final void a(com.tencent.mm.kernel.a.a.a.a aVar) {
            super.a(aVar);
            synchronized (this) {
                this.dsx++;
            }
        }

        public final void a(com.tencent.mm.vending.c.a aVar) {
            if (!this.dsc) {
                if (!EN()) {
                    boolean z;
                    HashSet Ex = Ex();
                    Assert.assertNotNull(Ex);
                    Iterator it = Ex.iterator();
                    while (it.hasNext()) {
                        if (!((a) ((com.tencent.mm.kernel.a.a.a.a) it.next())).dsc) {
                            x.i("MMSkeleton.ParallelsDependencies", "ParallelsNode(%s) found it's depending node(%s) not consumed.", this, (com.tencent.mm.kernel.a.a.a.a) it.next());
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (z) {
                        EO();
                    }
                }
                this.dsE.dsF.cDY();
                if (!this.dsc) {
                    j.i("MMSkeleton.ParallelsDependencies", "Consume node(%s) on phase(%s) may after waiting resolved.", this, this.dsC.dsf);
                    aVar.call(this);
                    this.dsc = true;
                }
                this.dsE.dsF.done();
            }
        }

        private boolean EL() {
            return this.dsx == 0 && (this.dsA == null || this.dsA.dsc);
        }

        public final synchronized boolean EM() {
            boolean z = false;
            synchronized (this) {
                String str = "MMSkeleton.ParallelsDependencies";
                String str2 = "ParallelsDependencies checkIfResolvedAndSwallowIt for %s with type %s mProvided %s, %s, %s, %s, %s";
                Object[] objArr = new Object[7];
                objArr[0] = this.dsb;
                objArr[1] = this.dsC.dsf;
                objArr[2] = Boolean.valueOf(this.dsz);
                objArr[3] = Integer.valueOf(this.dsx);
                objArr[4] = this.dsA;
                objArr[5] = this.dsA != null ? Boolean.valueOf(this.dsA.dsc) : "";
                objArr[6] = this.dsC.dsO;
                x.d(str, str2, objArr);
                if (!this.dsz && EL()) {
                    x.i("MMSkeleton.ParallelsDependencies", "checkIfResolvedAndSwallowIt node %s, consumed %s, phase %s resolved!", this, Boolean.valueOf(this.dsc), this.dsC.dsf);
                    this.dsz = true;
                    notify();
                    z = true;
                }
            }
            return z;
        }

        private synchronized boolean EN() {
            boolean z = true;
            synchronized (this) {
                String str = "MMSkeleton.ParallelsDependencies";
                String str2 = "ParallelsDependencies checkIfResolved for %s with type %s mProvided %s, %s, %s, %s, %s";
                Object[] objArr = new Object[7];
                objArr[0] = this.dsb;
                objArr[1] = this.dsC.dsf;
                objArr[2] = Boolean.valueOf(this.dsz);
                objArr[3] = Integer.valueOf(this.dsx);
                objArr[4] = this.dsA;
                objArr[5] = this.dsA != null ? Boolean.valueOf(this.dsA.dsc) : "";
                objArr[6] = this.dsC.dsO;
                x.i(str, str2, objArr);
                if (!this.dsz) {
                    z = EL();
                }
            }
            return z;
        }

        private synchronized void EO() {
            try {
                if (this.dsz) {
                    x.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s resolved!", this, Boolean.valueOf(this.dsc), this.dsC.dsf);
                } else {
                    x.i("MMSkeleton.ParallelsDependencies", "waiting resolved");
                    x.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s", this, Boolean.valueOf(this.dsc), this.dsC.dsf);
                    wait();
                    x.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s done", this, Boolean.valueOf(this.dsc), this.dsC.dsf);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MMSkeleton.ParallelsDependencies", e, "", new Object[0]);
            }
            return;
        }

        public final synchronized boolean EP() {
            this.dsx--;
            return EM();
        }

        public final String toString() {
            return super.toString() + " - with type " + this.dsC.dsf;
        }
    }

    public f(Class cls, d<T> dVar, c cVar) {
        this.dsv = cls;
        this.dsu = dVar;
        if (cVar == null) {
            cVar = this;
        }
        this.dso = cVar;
    }

    protected final com.tencent.mm.kernel.a.a.a.a<T> aJ(T t) {
        if (!this.drY.containsKey(t)) {
            this.drY.putIfAbsent(t, new a(t, this.dsv, this.dso, (byte) 0));
        }
        return (com.tencent.mm.kernel.a.a.a.a) this.drY.get(t);
    }

    public final a<T> aO(T t) {
        return (a) this.drY.get(t);
    }

    public final void prepare() {
        x.i("MMSkeleton.ParallelsDependencies", "ParallelsDependencies for type %s", this.dsv);
        Assert.assertNotNull(this.dsu);
        this.dsw = true;
        for (com.tencent.mm.kernel.a.a.a.a aVar : this.drY.values()) {
            if (aVar.Ez()) {
                a aVar2 = (a) aVar;
                x.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare can provide %s", aVar2);
                if (aVar2.EM()) {
                    this.dsu.b(aVar2);
                }
                x.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare can provide %s done", aVar2);
            }
        }
        x.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare %s done", this.dsv);
    }

    public final a<T> ED() {
        return this.dsu.ED();
    }

    public final void a(a<T> aVar) {
        HashSet Ew = aVar.Ew();
        if (Ew != null) {
            Iterator it = Ew.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) ((com.tencent.mm.kernel.a.a.a.a) it.next());
                if (aVar2.EP()) {
                    this.dsu.b(aVar2);
                }
            }
        }
    }

    public final List<com.tencent.mm.kernel.a.a.a.a> EK() {
        List<com.tencent.mm.kernel.a.a.a.a> arrayList = new ArrayList(1);
        for (com.tencent.mm.kernel.a.a.a.a aVar : this.drY.values()) {
            if (!((a) aVar).dsc) {
                String str = "MMSkeleton.ParallelsDependencies";
                String str2 = "ParallelsDependencies node(%s) not consumed!!!! %s, %s, %s";
                Object[] objArr = new Object[4];
                objArr[0] = aVar;
                objArr[1] = Integer.valueOf(((a) aVar).dsx);
                objArr[2] = ((a) aVar).dsA;
                objArr[3] = ((a) aVar).dsA != null ? Boolean.valueOf(((a) aVar).dsA.dsc) : "";
                x.e(str, str2, objArr);
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
