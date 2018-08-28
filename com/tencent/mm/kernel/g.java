package com.tencent.mm.kernel;

import android.app.Application;
import android.os.SystemClock;
import com.tencent.mm.ab.o;
import com.tencent.mm.bs.b;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.kernel.api.d;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.model.by;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class g {
    private static g dqK;
    public final a dpO = new a();
    public h<h> dqL;
    private ah dqM;
    private by dqN = null;
    public e dqO;
    public a dqP;
    public b dqQ;
    public b dqR;
    public final a dqS = new a();
    private final boolean dqT;
    private ConcurrentHashMap dqU = new ConcurrentHashMap();
    public volatile boolean dqV = false;

    private static class a extends com.tencent.mm.by.a<com.tencent.mm.ab.o.a> implements com.tencent.mm.ab.o.a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a(final o oVar, final boolean z) {
            a(new com.tencent.mm.by.a.a<com.tencent.mm.ab.o.a>() {
                public final /* synthetic */ void aD(Object obj) {
                    ((com.tencent.mm.ab.o.a) obj).a(oVar, z);
                }
            });
        }

        public final void a(final o oVar) {
            a(new com.tencent.mm.by.a.a<com.tencent.mm.ab.o.a>() {
                public final /* synthetic */ void aD(Object obj) {
                    ((com.tencent.mm.ab.o.a) obj).a(oVar);
                }
            });
        }
    }

    private g(final h hVar) {
        this.dqL = h.c(hVar);
        this.dqT = ((h) this.dqL.Ef().DM()).ES();
        if (this.dqT) {
            this.dqN = new by();
            this.dqM = new ah("worker");
            this.dqM.H(new Runnable() {
                public final void run() {
                    ao.fL(ad.getContext());
                }
            });
        }
        this.dqL.Ee().dqf = new com.tencent.mm.kernel.c.a() {
            public final void b(f fVar) {
                g.this.a(hVar, (Object) fVar);
            }

            public final void b(com.tencent.mm.kernel.c.a aVar) {
                g.this.a(hVar, (Object) aVar);
                c.Et().aG(aVar);
            }

            public final void c(com.tencent.mm.kernel.c.a aVar) {
                g gVar = g.this;
                h hVar = hVar;
                c Et = c.Et();
                if (aVar instanceof com.tencent.mm.kernel.api.c) {
                    Et.drw.remove((com.tencent.mm.kernel.api.c) aVar);
                }
                if (aVar instanceof e) {
                    Et.drx.remove((e) aVar);
                }
                if (aVar instanceof com.tencent.mm.kernel.api.b) {
                    Et.dry.remove((com.tencent.mm.kernel.api.b) aVar);
                }
                if (aVar instanceof com.tencent.mm.kernel.api.f) {
                    Et.drz.remove((com.tencent.mm.kernel.api.f) aVar);
                }
                if (aVar instanceof ApplicationLifeCycle) {
                    hVar.dsT.remove((ApplicationLifeCycle) aVar);
                }
                if (aVar instanceof d) {
                    gVar.dpO.remove((d) aVar);
                }
                if (aVar instanceof com.tencent.mm.kernel.api.g) {
                    gVar.dqL.b((com.tencent.mm.kernel.api.g) aVar);
                }
            }

            public final void c(f fVar) {
                c Et = c.Et();
                if (fVar != null) {
                    Et.aH(fVar);
                }
            }

            public final void d(com.tencent.mm.kernel.c.a aVar) {
                c Et = c.Et();
                if (aVar != null) {
                    Et.aH(aVar);
                }
            }
        };
    }

    public final void a(h hVar, Object obj) {
        if (this.dqU.containsKey(obj)) {
            x.i("MicroMsg.MMKernel", "Already add, skip it[%s].", obj);
        } else if (this.dqU.putIfAbsent(obj, this.dqU) != null) {
            x.i("MicroMsg.MMKernel", "Already add, skip[%s].", obj);
        } else {
            c.Et().add(obj);
            if (obj instanceof ApplicationLifeCycle) {
                hVar.dsT.aI((ApplicationLifeCycle) obj);
            }
            if (obj instanceof d) {
                this.dpO.aI((d) obj);
            }
            if (obj instanceof com.tencent.mm.kernel.api.g) {
                this.dqL.a((com.tencent.mm.kernel.api.g) obj);
            }
        }
    }

    public final void a(com.tencent.mm.kernel.api.g gVar) {
        this.dqL.a(gVar);
    }

    public final void b(com.tencent.mm.kernel.api.g gVar) {
        this.dqL.b(gVar);
    }

    public static c Ee() {
        Assert.assertNotNull("mCorePlugins not initialized!", Ek().dqL.Ee());
        return Ek().dqL.Ee();
    }

    public static d<h> Ef() {
        Assert.assertNotNull("mCoreProcess not initialized!", Ek().dqL.Ef());
        return Ek().dqL.Ef();
    }

    public static a Eg() {
        Assert.assertNotNull("mCoreAccount not initialized!", Ek().dqP);
        return Ek().dqP;
    }

    public static b Eh() {
        Assert.assertNotNull("mCoreNetwork not initialized!", Ek().dqQ);
        return Ek().dqQ;
    }

    public static e Ei() {
        Assert.assertNotNull("mCoreStorage not initialized!", Ek().dqO);
        return Ek().dqO;
    }

    public static b Ej() {
        Assert.assertNotNull("mCoreStatus not initialized!", Ek().dqR);
        return Ek().dqR;
    }

    public static g Ek() {
        Assert.assertNotNull("Kernel not initialized by MMApplication!", dqK);
        return dqK;
    }

    public static <T extends com.tencent.mm.kernel.b.a> T n(Class<T> cls) {
        Ek();
        return Ee().n(cls);
    }

    public static <T extends com.tencent.mm.kernel.c.a> T l(Class<T> cls) {
        Ek();
        return Ee().l(cls);
    }

    public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> cls, N n) {
        Ek();
        Ee().a((Class) cls, new com.tencent.mm.kernel.c.e(n));
    }

    public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> cls, com.tencent.mm.kernel.c.c<N> cVar) {
        Ek();
        Ee().a((Class) cls, (com.tencent.mm.kernel.c.c) cVar);
    }

    public static void m(Class<? extends com.tencent.mm.kernel.c.a> cls) {
        Ek();
        Ee().m(cls);
    }

    public static o DF() {
        Ek();
        return Eh().dpP;
    }

    public static by El() {
        Assert.assertTrue(Ek().dqT);
        return Ek().dqN;
    }

    public static ah Em() {
        Assert.assertTrue(Ek().dqT);
        return Ek().dqM;
    }

    public static synchronized void a(h hVar) {
        synchronized (g.class) {
            if (dqK != null) {
                h hVar2 = (h) dqK.dqL.Ef().DM();
                Application application = hVar.dsQ;
                hVar2.dsS = hVar.dsS;
                hVar2.dsQ = application;
                x.i("MicroMsg.MMKernel", "Kernel not null, has initialized.");
            } else {
                j.a(new com.tencent.mm.kernel.j.a() {
                    public final void e(String str, String str2, Object... objArr) {
                        x.e(str, str2, objArr);
                    }

                    public final void w(String str, String str2, Object... objArr) {
                        x.w(str, str2, objArr);
                    }

                    public final void i(String str, String str2, Object... objArr) {
                        x.i(str, str2, objArr);
                    }

                    public final void d(String str, String str2, Object... objArr) {
                        x.d(str, str2, objArr);
                    }

                    public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                        x.printErrStackTrace(str, th, str2, objArr);
                    }
                });
                x.i("MicroMsg.MMKernel", "Initialize kernel, create whole WeChat world.");
                dqK = new g(hVar);
            }
        }
    }

    public static void gJ(int i) {
        a Eg = Eg();
        if (a.gG(i) && a.dpp.Df() == i && Eg.Dx()) {
            x.w("MMKernel.CoreAccount", "loginUin, uin not changed, return :%d", Integer.valueOf(i));
            return;
        }
        synchronized (Eg.dpo) {
            a.dpp.eK(i);
            Eg.Dm();
            Eg.dpB = SystemClock.elapsedRealtime();
            Eg.bs(true);
        }
    }

    public final void gi(String str) {
        x.w("MicroMsg.MMKernel", "logoutAccount uin:%s info:%s stack:%s", com.tencent.mm.a.o.getString(a.Df()), str, bi.cjd());
        a.gc(bi.cjd().toString() + str);
        this.dqP.Dp().bc((long) a.Df());
        releaseAll();
        a.Dk();
        a.bt(false);
    }

    public final void releaseAll() {
        String str = "MicroMsg.MMKernel";
        String str2 = "release uin:%s ";
        Object[] objArr = new Object[1];
        objArr[0] = this.dqP != null ? com.tencent.mm.a.o.getString(a.Df()) : "-1";
        x.w(str, str2, objArr);
        if (this.dqQ.dpP != null) {
            this.dqQ.dpP.reset();
        }
        if (this.dqM != null) {
            this.dqM.a(new ah.b() {
                public final void En() {
                    if (g.this.dqP != null) {
                        g.this.dqP.release();
                    }
                }
            });
        }
    }
}
