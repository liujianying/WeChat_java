package com.tencent.mm.kernel.a;

import com.tencent.mm.compatible.e.n;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.kernel.a.b.e;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ai;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;

public abstract class d implements b {
    public e<Object> drW = e.EF();
    private final HashSet<String> drX = new HashSet();

    public void uQ() {
        x.i("MicroMsg.ParallelsBootStep", "core num %s for parallels", Integer.valueOf((int) Math.min(Math.floor((((h) g.Ef().DM()).ES() ? 1.5d : 1.0d) * ((double) n.zs())), 6.0d)));
        this.drW.init(r0);
        c Et = c.Et();
        Et.dru.a(b.class);
        Et.drt.a(com.tencent.mm.kernel.a.c.b.class);
        Et.drv.a(com.tencent.mm.kernel.api.h.class, a.class, com.tencent.mm.kernel.api.e.class, ai.class, c.class);
        com.tencent.mm.kernel.a.b.g gVar = Et.drv;
        Object obj = new Class[]{c.class};
        gVar.dsI = new Class[1];
        System.arraycopy(obj, 0, gVar.dsI, 0, 1);
        ((h) g.Ef().DM()).dqh.dro = new com.tencent.mm.kernel.a.a.b() {
            public final void a(Class cls, Object obj, Object obj2) {
                if (cls == com.tencent.mm.kernel.a.c.b.class) {
                    c.Et().drt.a(cls, obj, obj2);
                } else if (cls == com.tencent.mm.kernel.b.b.class) {
                    c.Et().dru.a(cls, obj, obj2);
                }
            }
        };
        com.tencent.mm.blink.a.ey("helloWeChat");
    }

    public static void r(Class<? extends f> cls) {
        g.Ee().j(cls);
    }

    public static void gl(String str) {
        g.Ee().gf(str);
    }

    public final void gm(String str) {
        this.drX.add(str);
    }

    public final void Er() {
        g.Ee().DK();
        this.drW.prepare();
        for (e.c cVar : this.drW.EH()) {
            c.Et().b(cVar.byy.getLooper());
        }
        com.tencent.mm.blink.a.ey("makeDependency");
    }

    public void a(com.tencent.mm.kernel.b.g gVar) {
        this.drW.a(new e.b(), c.drD, c.Et().dru, "configure-functional plugins");
        com.tencent.mm.blink.a.ey("configurePlugins");
    }

    public final void Es() {
        this.drW.a(new e.b(), c.drE, c.Et().drt, "task-functional plugins");
        com.tencent.mm.blink.a.ey("executeTasks");
    }

    public void b(com.tencent.mm.kernel.b.g gVar) {
        a.j("startup final step, account initialize... for parallels", new Object[0]);
        if (gVar.ES()) {
            c Et = c.Et();
            for (f aG : g.Ee().DL()) {
                Et.aG(aG);
            }
            if (g.Eg().Dx()) {
                g.Eg().Dn();
            }
        }
        com.tencent.mm.blink.a.ey("installPendingPlugins");
        long nanoTime = System.nanoTime();
        if (this.drX.size() > 0) {
            Iterator it = this.drX.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                g.Ek();
                g.Ee().r(str, true);
            }
            this.drX.clear();
            com.tencent.mm.blink.a.i("installPendingPlugins installed", nanoTime);
            g.Ek();
            g.Ee().DK();
            com.tencent.mm.blink.a.ey("installPendingPlugins dependency made.");
            com.tencent.mm.sdk.b.a.sFg.m(new lt());
        }
        boolean uT = uT();
        boolean z = gVar.ES() && g.Eg().Dx();
        if (z && !uT) {
            g.Eg().Dy();
        }
        com.tencent.mm.blink.b xi = com.tencent.mm.blink.b.xi();
        x.i("MicroMsg.FirstScreenArrangement", "arrangeInitializePendingPlugins now? %s", Boolean.valueOf(uT));
        if (uT) {
            xi.a(b.Now);
        } else {
            ah.i(new Runnable() {
                public final void run() {
                    b.this.a(b.Timeout);
                }
            }, 1000);
        }
        if (z && uT) {
            g.Eg().Dy();
        }
        com.tencent.mm.blink.a.ey("afterAccountInit");
    }

    public boolean uT() {
        return true;
    }
}
