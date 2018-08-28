package com.tencent.mm.kernel;

import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.kernel.c.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class c {
    private final ConcurrentHashMap<Class<? extends com.tencent.mm.kernel.b.a>, f> dpZ = new ConcurrentHashMap();
    private final ArrayList<f> dqa = new ArrayList();
    private final ConcurrentHashMap<Class<? extends f>, ArrayList<Class<? extends com.tencent.mm.kernel.b.a>>> dqb = new ConcurrentHashMap();
    private final ConcurrentHashMap<Class<? extends com.tencent.mm.kernel.b.a>, Class<? extends f>> dqc = new ConcurrentHashMap();
    public com.tencent.mm.kernel.a.a.a<Class<? extends f>> dqd = new com.tencent.mm.kernel.a.a.a();
    private d dqe = new d();
    protected a dqf;
    public Class<? extends com.tencent.mm.kernel.b.a> dqg = null;
    private com.tencent.mm.kernel.a.a dqh;

    public interface a {
        void b(f fVar);

        void b(com.tencent.mm.kernel.c.a aVar);

        void c(f fVar);

        void c(com.tencent.mm.kernel.c.a aVar);

        void d(com.tencent.mm.kernel.c.a aVar);
    }

    public final synchronized f j(Class<? extends f> cls) {
        return a((Class) cls, false);
    }

    private synchronized f a(Class<? extends f> cls, boolean z) {
        f fVar;
        Assert.assertNotNull(cls);
        try {
            fVar = (f) cls.newInstance();
            if (z) {
                fVar.markAsPendingPlugin();
            }
            fVar = a(fVar);
        } catch (Throwable e) {
            j.printErrStackTrace("MMSkeleton.CorePlugins", e, "Install plugin %s failed.", cls);
            fVar = null;
        }
        return fVar;
    }

    public final synchronized f gf(String str) {
        return r(str, false);
    }

    public final synchronized f r(String str, boolean z) {
        f a;
        try {
            Class cls = Class.forName(str);
            if (f.class.isAssignableFrom(cls)) {
                a = a(cls, z);
            } else {
                j.e("MMSkeleton.CorePlugins", "class string %s, not a Plugin", str);
                a = null;
            }
        } catch (ClassNotFoundException e) {
            j.e("MMSkeleton.CorePlugins", "plugin %s not found.", str);
            h.Eo().Ef().DM();
            new Object[1][0] = str;
        }
        return a;
    }

    private synchronized f a(f fVar) {
        f fVar2;
        if (k(fVar.getClass())) {
            j.w("MMSkeleton.CorePlugins", "Plugin %s has been installed.", fVar.getClass());
            fVar2 = (f) o(fVar.getClass());
        } else {
            Assert.assertNotNull(fVar);
            String[] ofProcesses = fVar.ofProcesses();
            if (ofProcesses != null && ofProcesses.length > 0) {
                g DM = h.Eo().Ef().DM();
                boolean z = false;
                for (String gn : ofProcesses) {
                    z = DM.gn(gn);
                    if (z) {
                        break;
                    }
                }
                if (!z) {
                    throw new IllegalStateException(String.format("Plugin %s can't install in process %s. It only support process %s.", new Object[]{fVar, DM.dox, Arrays.asList(ofProcesses)}));
                }
            }
            this.dpZ.put(fVar.getClass(), fVar);
            this.dqa.add(fVar);
            fVar.invokeInstalled();
            if (this.dqf != null) {
                this.dqf.b(fVar);
            }
            fVar2 = fVar;
        }
        return fVar2;
    }

    public final synchronized boolean k(Class<? extends com.tencent.mm.kernel.b.a> cls) {
        return this.dpZ.containsKey(cls);
    }

    public final synchronized void c(Class<? extends f> cls, Class<? extends com.tencent.mm.kernel.b.a> cls2) {
        Assert.assertNotNull(cls);
        Assert.assertNotNull(cls2);
        f fVar = (f) this.dpZ.get(cls);
        Assert.assertNotNull(fVar);
        ArrayList arrayList = (ArrayList) this.dqb.get(cls);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.dqb.put(cls, arrayList);
        }
        this.dqc.put(cls2, cls);
        arrayList.add(cls2);
        this.dpZ.put(cls2, fVar);
    }

    public final <T extends com.tencent.mm.kernel.c.a> T l(Class<T> cls) {
        T l;
        T l2 = this.dqe.l(cls);
        if (l2 == null) {
            int i;
            if (cls != null) {
                e eVar = (e) cls.getAnnotation(e.class);
                if (!(eVar == null || eVar.value() == null)) {
                    com.tencent.mm.kernel.b.a n = n(eVar.value());
                    i = (n == null || f.aE(n)) ? 0 : 1;
                    if (i != 0) {
                        j.i("MMSkeleton.CorePlugins", "Try load OwnerPlugin for service(%s)...", cls);
                        l = this.dqe.l(cls);
                        if (l != null) {
                            return l;
                        }
                        h.Eo().Ef().DM();
                        new Object[1][0] = cls;
                        return (com.tencent.mm.kernel.c.a) f.q(cls);
                    }
                }
            }
            i = 0;
            if (i != 0) {
                j.i("MMSkeleton.CorePlugins", "Try load OwnerPlugin for service(%s)...", cls);
                l = this.dqe.l(cls);
                if (l != null) {
                    return l;
                }
                h.Eo().Ef().DM();
                new Object[1][0] = cls;
                return (com.tencent.mm.kernel.c.a) f.q(cls);
            }
        }
        l = l2;
        if (l != null) {
            return l;
        }
        h.Eo().Ef().DM();
        new Object[1][0] = cls;
        return (com.tencent.mm.kernel.c.a) f.q(cls);
    }

    public final <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> cls, com.tencent.mm.kernel.c.c<N> cVar) {
        d dVar = this.dqe;
        dVar.dsX.put(cls, cVar);
        if (cVar instanceof b) {
            ((b) cVar).ET();
        }
        if (dVar.dsY != null) {
            dVar.dsY.a((com.tencent.mm.kernel.c.c) cVar);
        }
        x.i("MicroMsg.ServiceHub", "register service %s %s", cls, cVar);
    }

    public final void m(Class<? extends com.tencent.mm.kernel.c.a> cls) {
        d dVar = this.dqe;
        com.tencent.mm.kernel.c.c cVar = (com.tencent.mm.kernel.c.c) dVar.dsX.remove(cls);
        if (cVar instanceof b) {
            ((b) cVar).EU();
        }
        if (dVar.dsY != null) {
            dVar.dsY.b(cVar);
        }
    }

    public final synchronized <T extends com.tencent.mm.kernel.b.a> T n(Class<T> cls) {
        T t;
        T o = o(cls);
        if (this.dqf != null) {
            this.dqf.c((f) o);
        }
        if (o == null) {
            t = (com.tencent.mm.kernel.b.a) f.q(cls);
        } else {
            t = o;
        }
        return t;
    }

    private synchronized <T extends com.tencent.mm.kernel.b.a> T o(Class<T> cls) {
        Assert.assertNotNull(cls);
        return (com.tencent.mm.kernel.b.a) this.dpZ.get(cls);
    }

    private synchronized boolean p(Class<? extends com.tencent.mm.kernel.b.a> cls) {
        boolean z = false;
        synchronized (this) {
            Assert.assertNotNull(cls);
            if (k(cls)) {
                z = true;
            } else {
                j.w("MMSkeleton.CorePlugins", "Plugin " + cls + " must be installed!", new Object[0]);
            }
        }
        return z;
    }

    public final void d(Class<? extends f> cls, Class<? extends com.tencent.mm.kernel.b.a> cls2) {
        Assert.assertNotNull(cls);
        Assert.assertNotNull(cls2);
        if (p(cls2)) {
            Class cls22;
            if (this.dqc.containsKey(cls22)) {
                cls22 = (Class) this.dqc.get(cls22);
            }
            this.dqd.p(cls, cls22);
            if (this.dqh == null) {
                this.dqh = h.Eo().Ef().DM().dqh;
            }
            f fVar = (f) o(cls);
            f fVar2 = (f) o(cls22);
            this.dqh.dro.a(com.tencent.mm.kernel.b.b.class, fVar, fVar2);
            this.dqh.dro.a(com.tencent.mm.kernel.a.c.b.class, fVar, fVar2);
            return;
        }
        String format = String.format("depends plugin %s not install, plugin %s will not add in to dependency tree", new Object[]{cls22.getName(), cls.getName()});
        j.e("MMSkeleton.CorePlugins", format, new Object[0]);
        throw new IllegalAccessError(format);
    }

    public final synchronized void DK() {
        Iterator it = this.dqa.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar.isDependencyMade()) {
                com.tencent.mm.kernel.a.a.j("skip make dependency for plugin %s.", fVar);
            } else {
                com.tencent.mm.kernel.a.a.j("make dependency for plugin %s...", fVar);
                fVar.invokeDependency();
            }
        }
    }

    public final synchronized List<f> DL() {
        return this.dqa;
    }
}
