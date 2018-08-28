package com.tencent.mm.kernel.a.b;

import com.tencent.mm.kernel.a.a.b;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g implements b, c<Object>, d<Object> {
    public Map<Class<?>, f<Object>> dsG = new ConcurrentHashMap();
    private Class<?>[] dsH;
    public volatile Class<?>[] dsI;
    public Map<Class, Object> dsJ = new ConcurrentHashMap();
    private int dsK = 0;
    private Queue<com.tencent.mm.kernel.a.b.f.a> dsL = new ConcurrentLinkedQueue();
    public ConcurrentHashMap<Object, a> dsM = new ConcurrentHashMap();

    private static class a {
        byte[] dsN;

        private a() {
            this.dsN = new byte[1];
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final boolean ER() {
            boolean z = false;
            synchronized (this.dsN) {
                if (this.dsN[0] == (byte) 2) {
                    z = true;
                }
            }
            return z;
        }
    }

    public final void a(Class... clsArr) {
        int i = 0;
        this.dsH = new Class[clsArr.length];
        System.arraycopy(clsArr, 0, this.dsH, 0, clsArr.length);
        while (i < this.dsH.length) {
            this.dsG.put(this.dsH[i], new f(this.dsH[i], this, this));
            i++;
        }
    }

    public final <T> f<T> s(Class<T> cls) {
        return (f) this.dsG.get(cls);
    }

    public final void b(Class cls, boolean z) {
        int i = 0;
        while (i < this.dsH.length) {
            if (this.dsH[i] == cls) {
                break;
            }
            i++;
        }
        i = -1;
        int min = Math.min(i, this.dsH.length - 1);
        if (min >= 0 && this.dsK > min) {
            for (int i2 = min; i2 < this.dsK; i2++) {
                for (com.tencent.mm.kernel.a.a.a.a aVar : s(this.dsH[i2]).drY.values()) {
                    com.tencent.mm.kernel.a.b.f.a aVar2 = (com.tencent.mm.kernel.a.b.f.a) aVar;
                    if (z) {
                        aVar2.dsc = false;
                    }
                    synchronized (aVar2) {
                        aVar2.dsx = aVar2.Ey();
                        aVar2.dsz = false;
                    }
                }
            }
            this.dsK = min;
        }
    }

    public final void prepare() {
        int i;
        j.i("MicroMsg.ParallelsManagement", "prepare()", new Object[0]);
        synchronized (this.dsH) {
            if (this.dsH.length > this.dsK) {
                i = this.dsK;
                this.dsK++;
            } else {
                i = -1;
            }
        }
        if (i != -1) {
            s(this.dsH[i]).prepare();
        }
    }

    public final void EQ() {
        while (true) {
            synchronized (this.dsH) {
                if (this.dsH.length <= this.dsK) {
                    return;
                }
            }
            prepare();
        }
        while (true) {
        }
    }

    public final com.tencent.mm.kernel.a.b.f.a ED() {
        com.tencent.mm.kernel.a.b.f.a aVar;
        synchronized (this.dsL) {
            aVar = (com.tencent.mm.kernel.a.b.f.a) this.dsL.poll();
        }
        return aVar;
    }

    public final void a(com.tencent.mm.kernel.a.b.f.a aVar) {
        x.i("MicroMsg.ParallelsManagement", "ParallelsManagement resolvedOne %s for type %s then next %s", aVar, aVar.dsC.dsf, aVar.dsC.dsP);
        s(aVar.dsC.dsf).a(aVar);
        if (aVar.dsC.dsP != null) {
            f s = s(aVar.dsC.dsP);
            com.tencent.mm.kernel.a.b.f.a aVar2 = (com.tencent.mm.kernel.a.b.f.a) s.drY.get(aVar);
            if (aVar2.dsb != aVar.dsb) {
                x.e("MMSkeleton.ParallelsDependencies", "not same!!!! %s, %s, %s, %s", aVar2, aVar2.dsb, aVar, s.drY.get(aVar));
            }
            if (s.dsw && aVar2.EM()) {
                s.dsu.b(aVar2);
            }
        }
    }

    public final void b(com.tencent.mm.kernel.a.b.f.a<Object> aVar) {
        synchronized (this.dsL) {
            this.dsL.offer(aVar);
        }
        x.d("MicroMsg.ParallelsManagement", "ParallelsManagement provideOne %s %s", aVar, aVar.dsC.dsf);
    }

    public final void a(Class cls, Object obj, Object obj2) {
        int i;
        if (this.dsI != null) {
            Class[] clsArr = this.dsI;
            int length = clsArr.length;
            i = 0;
            while (i < length) {
                if (clsArr[i] != cls) {
                    i++;
                }
            }
            i = 0;
            if (i == 0) {
                f s = s(cls);
                if (s != null) {
                    s.p(obj, obj2);
                }
            }
            j.w("MicroMsg.ParallelsManagement", "Not allow phase(%s) has dependency", cls);
            return;
        }
        i = 1;
        if (i == 0) {
            j.w("MicroMsg.ParallelsManagement", "Not allow phase(%s) has dependency", cls);
            return;
        }
        f s2 = s(cls);
        if (s2 != null) {
            s2.p(obj, obj2);
        }
    }

    public final void aP(Object obj) {
        int i = 0;
        if (!this.dsM.containsKey(obj)) {
            this.dsM.putIfAbsent(obj, new a());
        }
        a aVar = (a) this.dsM.get(obj);
        synchronized (aVar.dsN) {
            if (aVar.dsN[0] == (byte) 2) {
            } else {
                if (aVar.dsN[0] == (byte) 1) {
                    try {
                        aVar.dsN.wait();
                    } catch (InterruptedException e) {
                    }
                } else {
                    aVar.dsN[0] = (byte) 1;
                }
            }
        }
        if (aVar.ER()) {
            j.i("MicroMsg.ParallelsManagement", "%s Has done. return.", obj);
            return;
        }
        Class cls;
        j.d("MicroMsg.ParallelsManagement", "Make dependency on subject(%s), hashcode(%s)", obj, Integer.valueOf(obj.hashCode()));
        if (obj instanceof b) {
            a.start();
            ((b) obj).parallelsDependency();
            b EC = a.EC();
            if (EC.dsh != null) {
                for (com.tencent.mm.kernel.a.b.a.a aVar2 : EC.dsh.values()) {
                    for (Object next : aVar2.dsg) {
                        if (s(aVar2.dsf).aK(next) == null) {
                            j.i("MicroMsg.ParallelsManagement", "Traversal make dependency for %s by subject(%s)", next, obj);
                            aP(next);
                        }
                        a(aVar2.dsf, obj, next);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Class cls2 : this.dsH) {
            if (cls2.isInstance(obj)) {
                arrayList.add(cls2);
            }
        }
        Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
        com.tencent.mm.kernel.a.b.f.a aVar3 = null;
        com.tencent.mm.kernel.a.b.f.a aVar4 = null;
        while (i < clsArr.length) {
            Class cls3 = clsArr[i];
            cls2 = i < clsArr.length + -1 ? clsArr[i + 1] : null;
            com.tencent.mm.kernel.a.b.f.a a = aVar3 != null ? aVar3 : a(cls3, obj);
            aVar3 = cls2 != null ? a(cls2, obj) : null;
            a.dsA = aVar4;
            a.dsB = aVar3;
            if (aVar4 != null) {
                a.dsC.dsO = aVar4.dsC.dsf;
            }
            if (aVar3 != null) {
                a.dsC.dsP = aVar3.dsC.dsf;
            }
            i++;
            aVar4 = a;
        }
        synchronized (aVar.dsN) {
            if (aVar.dsN[0] == (byte) 1) {
                aVar.dsN[0] = (byte) 2;
                aVar.dsN.notifyAll();
            }
        }
    }

    private com.tencent.mm.kernel.a.b.f.a a(Class cls, Object obj) {
        f s = s(cls);
        com.tencent.mm.kernel.a.b.f.a aVar = (com.tencent.mm.kernel.a.b.f.a) s.aK(obj);
        x.d("MicroMsg.ParallelsManagement", "makeDependency on IDependency of type %s for %s with %s", cls, obj, s);
        if (aVar != null) {
            return aVar;
        }
        Object obj2 = this.dsJ.get(cls);
        if (obj2 == null) {
            obj2 = obj;
        }
        s.p(obj, obj2);
        return (com.tencent.mm.kernel.a.b.f.a) s.aK(obj);
    }
}
