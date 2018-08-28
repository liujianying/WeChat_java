package com.tencent.mm.kernel.a;

import android.os.Looper;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.api.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ai;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public final class c implements com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.api.e, f {
    private static c drA = new c();
    public static com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> drD = new com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a>() {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.kernel.a.b.f.a aVar = (com.tencent.mm.kernel.a.b.f.a) obj;
            if (aVar.dsC.dsf == com.tencent.mm.kernel.b.b.class) {
                com.tencent.mm.kernel.b.f fVar = (com.tencent.mm.kernel.b.f) aVar.dsb;
                if (fVar.isConfigured()) {
                    x.i("MicroMsg.CallbacksProxy", "skip configure for plugin %s.", fVar);
                } else {
                    x.i("MicroMsg.CallbacksProxy", "configuring plugin [%s]...", fVar);
                    fVar.invokeConfigure(g.Ef().DM());
                }
            }
            return uQG;
        }
    };
    public static com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> drE = new com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a>() {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.kernel.a.b.f.a aVar = (com.tencent.mm.kernel.a.b.f.a) obj;
            if (aVar.dsC.dsf == com.tencent.mm.kernel.a.c.b.class) {
                c.a((com.tencent.mm.kernel.a.c.b) aVar.dsb, g.Ef().DM());
            }
            return uQG;
        }
    };
    public static com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> drF = new com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a>() {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.kernel.a.b.f.a aVar = (com.tencent.mm.kernel.a.b.f.a) obj;
            x.i("MicroMsg.CallbacksProxy", "before running %s", aVar.dsb);
            if (aVar.dsC.dsf == h.class) {
                ((h) aVar.dsb).Eq();
            } else if (aVar.dsC.dsf == com.tencent.mm.kernel.api.a.class) {
                g.Ei().a(g.Ei().dqq.cnZ(), ((com.tencent.mm.kernel.api.a) aVar.dsb).collectDatabaseFactory());
            } else if (aVar.dsC.dsf == com.tencent.mm.kernel.api.e.class) {
                ((com.tencent.mm.kernel.api.e) aVar.dsb).onDataBaseOpened(g.Ei().dqq, g.Ei().dqr);
            } else if (aVar.dsC.dsf == ai.class) {
                g.Ei().a((ai) aVar.dsb);
            } else if (aVar.dsC.dsf == com.tencent.mm.kernel.api.c.class) {
                ((com.tencent.mm.kernel.api.c) aVar.dsb).onAccountInitialized(g.Eg().dpt);
            }
            x.i("MicroMsg.CallbacksProxy", "[account-init] for phase(%s) subject(%s)", aVar.dsC.dsf, aVar.dsb);
            return uQG;
        }
    };
    private static Map<Integer, Map> drG = new ConcurrentHashMap();
    public volatile boolean drB = false;
    private AtomicBoolean drC = new AtomicBoolean(false);
    private Set<Looper> drH = new HashSet();
    private ConcurrentHashMap<Object, e> drI = new ConcurrentHashMap();
    public ConcurrentHashMap drJ = new ConcurrentHashMap();
    private boolean drs = true;
    public final com.tencent.mm.kernel.a.b.g drt = new com.tencent.mm.kernel.a.b.g();
    public final com.tencent.mm.kernel.a.b.g dru = new com.tencent.mm.kernel.a.b.g();
    public final com.tencent.mm.kernel.a.b.g drv = new com.tencent.mm.kernel.a.b.g();
    public final b drw = new b();
    public final c drx = new c();
    public final a dry = new a();
    public final d drz = new d();

    private static final class e {
        private long drV;
        private int mStatus;

        public e() {
            this.drV = 0;
            this.mStatus = 0;
            this.drV = Thread.currentThread().getId();
        }

        public final synchronized boolean Ev() {
            boolean z = false;
            synchronized (this) {
                if (!(this.mStatus == 1 && this.drV == Thread.currentThread().getId())) {
                    if (this.mStatus != 2) {
                        z = true;
                    }
                }
            }
            return z;
        }

        public final synchronized void gK(int i) {
            if (i > this.mStatus) {
                this.mStatus = i;
            }
        }
    }

    static class a extends com.tencent.mm.by.a<com.tencent.mm.kernel.api.b> implements com.tencent.mm.kernel.api.b {
        private boolean drL = false;

        a() {
        }

        /* renamed from: a */
        public final synchronized com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.b> aI(com.tencent.mm.kernel.api.b bVar) {
            com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.b> aI;
            aI = super.aI(bVar);
            if (this.drL) {
                List collectStoragePaths = bVar.collectStoragePaths();
                if (collectStoragePaths != null && collectStoragePaths.size() > 0) {
                    b(collectStoragePaths, g.Ei().dqp);
                }
                x.i("MicroMsg.CallbacksProxy", "collectStoragePaths has been called. cb %s", bVar);
            }
            return aI;
        }

        public final List<String> collectStoragePaths() {
            LinkedList cBB = cBB();
            List<String> linkedList = new LinkedList();
            Iterator it = cBB.iterator();
            while (it.hasNext()) {
                com.tencent.mm.vending.b.b bVar = (com.tencent.mm.vending.b.b) it.next();
                if (bVar != null) {
                    Collection collectStoragePaths = ((com.tencent.mm.kernel.api.b) bVar.uQB).collectStoragePaths();
                    if (collectStoragePaths != null) {
                        linkedList.addAll(collectStoragePaths);
                    }
                }
            }
            return linkedList;
        }

        public final synchronized void gk(String str) {
            List collectStoragePaths = collectStoragePaths();
            this.drL = true;
            x.i("MicroMsg.CallbacksProxy", "all account storage folder %s", collectStoragePaths.toString());
            b(collectStoragePaths, str);
        }

        private static void b(List<String> list, String str) {
            int i = 0;
            String[] strArr = new String[(list.size() + 1)];
            strArr[0] = str;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    strArr[i2 + 1] = str + ((String) list.get(i2));
                    i = i2 + 1;
                } else {
                    com.tencent.mm.a.e.d(strArr);
                    return;
                }
            }
        }
    }

    private static class b extends com.tencent.mm.by.a<com.tencent.mm.kernel.api.c> implements com.tencent.mm.kernel.api.c {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void onAccountInitialized(final com.tencent.mm.kernel.e.c cVar) {
            a(new com.tencent.mm.by.a.a<com.tencent.mm.kernel.api.c>() {
                public final /* synthetic */ void aD(Object obj) {
                    ((com.tencent.mm.kernel.api.c) obj).onAccountInitialized(cVar);
                }
            });
        }

        public final void onAccountRelease() {
            a(new com.tencent.mm.by.a.a<com.tencent.mm.kernel.api.c>() {
                public final /* synthetic */ void aD(Object obj) {
                    com.tencent.mm.kernel.api.c cVar = (com.tencent.mm.kernel.api.c) obj;
                    if (c.a(c.Et().drv, com.tencent.mm.kernel.api.c.class, cVar)) {
                        cVar.onAccountRelease();
                    }
                }
            });
        }
    }

    static class c extends com.tencent.mm.by.a<com.tencent.mm.kernel.api.e> implements com.tencent.mm.kernel.api.e {
        c() {
        }

        public final void onDataBaseOpened(final com.tencent.mm.bt.h hVar, final com.tencent.mm.bt.h hVar2) {
            a(new com.tencent.mm.by.a.a<com.tencent.mm.kernel.api.e>() {
                public final /* synthetic */ void aD(Object obj) {
                    ((com.tencent.mm.kernel.api.e) obj).onDataBaseOpened(hVar, hVar2);
                }
            });
        }

        public final void onDataBaseClosed(final com.tencent.mm.bt.h hVar, final com.tencent.mm.bt.h hVar2) {
            a(new com.tencent.mm.by.a.a<com.tencent.mm.kernel.api.e>() {
                public final /* synthetic */ void aD(Object obj) {
                    ((com.tencent.mm.kernel.api.e) obj).onDataBaseClosed(hVar, hVar2);
                }
            });
        }
    }

    static class d extends com.tencent.mm.by.a<f> implements f {
        private boolean drR = false;
        private String drS;

        d() {
        }

        public final void Ep() {
            a(new com.tencent.mm.by.a.a<f>() {
            });
        }

        /* renamed from: a */
        public final synchronized com.tencent.mm.vending.b.b<f> aI(f fVar) {
            com.tencent.mm.vending.b.b<f> aI;
            aI = super.aI(fVar);
            if (this.drR) {
                fVar.gj(this.drS);
                x.i("MicroMsg.CallbacksProxy", "onAccountPathChanged has been called. cb %s", fVar);
            }
            return aI;
        }

        public final synchronized void gj(final String str) {
            a(new com.tencent.mm.by.a.a<f>() {
                public final /* synthetic */ void aD(Object obj) {
                    ((f) obj).gj(str);
                }
            });
            this.drR = true;
            this.drS = str;
        }
    }

    static /* synthetic */ void a(com.tencent.mm.kernel.a.c.b bVar, com.tencent.mm.kernel.b.g gVar) {
        if (drG.containsKey(Integer.valueOf(bVar.hashCode()))) {
            a.j("skip task %s execution hash %s", bVar.name(), Integer.valueOf(bVar.hashCode()));
            return;
        }
        bVar.execute(gVar);
        drG.put(Integer.valueOf(bVar.hashCode()), drG);
        a.j("boot task executing [%s] hash %s...", bVar.name(), Integer.valueOf(bVar.hashCode()));
    }

    private c() {
    }

    public static c Et() {
        return drA;
    }

    public static boolean a(com.tencent.mm.kernel.a.b.g gVar, Class cls, Object obj) {
        com.tencent.mm.kernel.a.b.f.a aVar = (com.tencent.mm.kernel.a.b.f.a) gVar.s(cls).aK(obj);
        if (aVar == null) {
            return false;
        }
        return aVar.dsc;
    }

    public final void aG(Object obj) {
        if (!((com.tencent.mm.kernel.b.h) g.Ef().DM()).ES()) {
            x.d("MicroMsg.CallbacksProxy", "Not main process, skip making parallels dependencies.");
        } else if (com.tencent.mm.kernel.f.aE(obj)) {
            x.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "Found dummy subject!", new Object[0]);
        } else {
            this.drv.aP(obj);
        }
    }

    public final void Ep() {
        this.drz.Ep();
    }

    public final void gj(String str) {
        this.dry.gk(str);
        this.drz.gj(str);
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        if (this.drs) {
            com.tencent.mm.blink.a.ey("beforeAccountInit");
            this.drv.b(com.tencent.mm.kernel.api.c.class, true);
            com.tencent.mm.kernel.a.b.e EE = com.tencent.mm.kernel.a.b.e.EE();
            EE.a(new com.tencent.mm.kernel.a.b.e.b(), drF, this.drv);
            this.drv.EQ();
            EE.start("account-init from onAccountInitialized");
            EE.EG();
            return;
        }
        this.drw.onAccountInitialized(cVar);
    }

    public final void onAccountRelease() {
        this.drw.onAccountRelease();
        this.drv.b(h.class, true);
    }

    public final void onDataBaseOpened(com.tencent.mm.bt.h hVar, com.tencent.mm.bt.h hVar2) {
        if (!this.drs) {
            this.drx.onDataBaseOpened(hVar, hVar2);
        }
    }

    public final void onDataBaseClosed(com.tencent.mm.bt.h hVar, com.tencent.mm.bt.h hVar2) {
        this.drx.onDataBaseClosed(hVar, hVar2);
    }

    public final void add(Object obj) {
        if (obj instanceof com.tencent.mm.kernel.api.c) {
            this.drw.aI((com.tencent.mm.kernel.api.c) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.e) {
            this.drx.aI((com.tencent.mm.kernel.api.e) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.b) {
            this.dry.aI((com.tencent.mm.kernel.api.b) obj);
        }
        if (obj instanceof f) {
            this.drz.aI((f) obj);
        }
    }

    public final void b(Looper looper) {
        x.i("MicroMsg.CallbacksProxy", "Thread(%s) not allow load-alone.", looper);
        this.drH.add(looper);
    }

    public final void aH(Object obj) {
        if (this.drC.get() && !this.drB) {
            int i;
            if (!((com.tencent.mm.kernel.b.h) g.Ef().DM()).ES()) {
                i = 0;
            } else if (this.drH.contains(Looper.myLooper())) {
                x.d("MicroMsg.CallbacksProxy", "Invalidate scene, it not allows to load alone in this thread(%s), illegal.", Looper.myLooper());
                i = 0;
            } else if (g.Ek().dqL.drf) {
                i = 1;
            } else {
                x.e("MicroMsg.CallbacksProxy", "Invalidate scene, kernel does not startup done.");
                i = 0;
            }
            if (i == 0) {
                x.d("MicroMsg.CallbacksProxy", "Invalidate scene for subject %s to load account-init alone.", obj);
                return;
            }
            if (!this.drI.containsKey(obj)) {
                this.drI.putIfAbsent(obj, new e());
            }
            e eVar = (e) this.drI.get(obj);
            if (eVar.Ev()) {
                long currentTimeMillis = System.currentTimeMillis();
                x.i("MicroMsg.CallbacksProxy", "loadAlone for subject %s", obj);
                x.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "loadAlone", new Object[0]);
                a aVar = (a) this.drv.dsM.get(obj);
                int i2 = (aVar == null || !aVar.ER()) ? 0 : 1;
                if (i2 == 0) {
                    x.e("MicroMsg.CallbacksProxy", "This subject(%s) has not made dependency while loading alone.");
                    this.drv.aP(obj);
                }
                try {
                    com.tencent.mm.kernel.a.b.f.a aO;
                    eVar.gK(1);
                    if (obj instanceof com.tencent.mm.kernel.b.f) {
                        if (!((com.tencent.mm.kernel.b.f) obj).isConfigured()) {
                            aO = this.dru.s(com.tencent.mm.kernel.b.b.class).aO((com.tencent.mm.kernel.b.b) obj);
                            Assert.assertNotNull(aO);
                            aO.a(drD);
                        }
                        aO = this.drt.s(com.tencent.mm.kernel.a.c.b.class).aO((com.tencent.mm.kernel.a.c.b) obj);
                        Assert.assertNotNull(aO);
                        aO.a(drE);
                    }
                    if (g.Eg().Dx()) {
                        if (obj instanceof h) {
                            aO = this.drv.s(h.class).aO((h) obj);
                            Assert.assertNotNull(aO);
                            aO.a(drF);
                        }
                        if (obj instanceof com.tencent.mm.kernel.api.a) {
                            aO = this.drv.s(com.tencent.mm.kernel.api.a.class).aO((com.tencent.mm.kernel.api.a) obj);
                            Assert.assertNotNull(aO);
                            aO.a(drF);
                        }
                        if (obj instanceof ai) {
                            aO = this.drv.s(ai.class).aO((ai) obj);
                            Assert.assertNotNull(aO);
                            aO.a(drF);
                        }
                        if (obj instanceof com.tencent.mm.kernel.api.e) {
                            aO = this.drv.s(com.tencent.mm.kernel.api.e.class).aO((com.tencent.mm.kernel.api.e) obj);
                            Assert.assertNotNull(aO);
                            aO.a(drF);
                        }
                        if (obj instanceof com.tencent.mm.kernel.api.c) {
                            aO = this.drv.s(com.tencent.mm.kernel.api.c.class).aO((com.tencent.mm.kernel.api.c) obj);
                            Assert.assertNotNull(aO);
                            aO.a(drF);
                        }
                        eVar.gK(2);
                        x.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", obj, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        return;
                    }
                    x.i("MicroMsg.CallbacksProxy", "account not init, return.");
                    eVar.gK(2);
                    x.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", obj, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable th) {
                    eVar.gK(2);
                    x.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", obj, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    public final void Eu() {
        com.tencent.mm.blink.a.ey("initializePendingPlugins");
        if (this.drC.compareAndSet(false, true)) {
            x.i("MicroMsg.CallbacksProxy", "initialize pending plugins.");
            c cVar = drA;
            for (com.tencent.mm.kernel.b.f aG : g.Ee().DL()) {
                cVar.aG(aG);
            }
            com.tencent.mm.blink.a.ey("makePluginsParallelsDependency");
            for (Object next : this.drJ.keySet()) {
                g.Ek().a((com.tencent.mm.kernel.b.h) g.Ef().DM(), next);
                drA.aG(next);
            }
            com.tencent.mm.blink.a.ey("configureAndExecutePendingPlugins");
            this.dru.b(com.tencent.mm.kernel.b.b.class, false);
            com.tencent.mm.kernel.a.b.e.EE().a(new com.tencent.mm.kernel.a.b.e.b(), drD, this.dru, "configure-functional from pending plugins");
            this.drt.b(com.tencent.mm.kernel.a.c.b.class, false);
            com.tencent.mm.kernel.a.b.e.EE().a(new com.tencent.mm.kernel.a.b.e.b(), drE, this.drt, "task-functional from pending plugins");
            com.tencent.mm.blink.a.ey("configureAndExecutePendingPlugins done");
            if (((com.tencent.mm.kernel.b.h) g.Ef().DM()).ES() && g.Eg().Dx()) {
                this.drv.b(h.class, false);
                com.tencent.mm.kernel.a.b.e EE = com.tencent.mm.kernel.a.b.e.EE();
                EE.a(new com.tencent.mm.kernel.a.b.e.b(), drF, this.drv);
                this.drv.EQ();
                EE.start("account-init from pending plugins");
                EE.EG();
            }
            this.drB = true;
            if (((com.tencent.mm.kernel.b.h) g.Ef().DM()).ES()) {
                g.Eg().Do();
            }
            com.tencent.mm.blink.a.ey("initializePendingPlugins done");
            if ((com.tencent.mm.protocal.d.qVQ || com.tencent.mm.protocal.d.qVP) && ((com.tencent.mm.kernel.b.h) g.Ef().DM()).ES() && g.Eg().Dx()) {
                a(this.drt);
                a(this.dru);
                a(this.drv);
            }
            com.tencent.mm.blink.a.ey("checkAllUnConsumed done");
        }
    }

    private static void a(com.tencent.mm.kernel.a.b.g gVar) {
        Map hashMap = new HashMap();
        for (com.tencent.mm.kernel.a.b.f fVar : gVar.dsG.values()) {
            List EK = fVar.EK();
            if (EK.size() > 0) {
                hashMap.put(fVar, EK);
            }
        }
        String str = "MicroMsg.CallbacksProxy";
        String str2 = "do parallels result check, %s for %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(hashMap.size() > 0);
        objArr[1] = gVar;
        x.i(str, str2, objArr);
        if (hashMap.size() > 0) {
            com.tencent.mm.blink.a.j(0, 1);
            Map hashMap2 = new HashMap();
            String str3 = "BlinkStartup";
            StringBuilder stringBuilder = new StringBuilder();
            for (com.tencent.mm.kernel.a.b.f fVar2 : hashMap.keySet()) {
                List list = (List) hashMap.get(fVar2);
                stringBuilder.append(fVar2.dsv);
                stringBuilder.append(" : ");
                stringBuilder.append(list.toString());
                stringBuilder.append("\n");
            }
            x.e("MicroMsg.CallbacksProxy", "unconsumed message %s", stringBuilder.toString());
            x.e("MicroMsg.CallbacksProxy", "maybe cycle dependencies");
            com.tencent.mm.plugin.report.f.mDy.c(str3, r0, hashMap2);
        }
    }
}
