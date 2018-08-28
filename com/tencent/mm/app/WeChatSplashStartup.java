package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.b.h.1;
import com.tencent.mm.kernel.b.h.6;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.h.2;
import com.tencent.mm.kernel.h.3;
import com.tencent.mm.kernel.j;
import com.tencent.mm.model.at;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.splash.m.a;
import com.tencent.mm.splash.o;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.p;
import com.tencent.mm.vending.h.d;
import junit.framework.Assert;

public class WeChatSplashStartup implements a {
    private Application app;
    h profile;
    private String thisProcess;

    public final void b(Application application, String str) {
        this.app = application;
        this.thisProcess = str;
        this.profile = q.bzn;
        g.a(this.profile);
        h hVar = this.profile;
        hVar.dsT.a(new 6(hVar, this.app));
    }

    public final void a(o.a aVar) {
        b(aVar);
    }

    public final void vj() {
        b(null);
    }

    private void b(o.a aVar) {
        d dVar;
        com.tencent.mm.blink.a.fm(2);
        boolean z = aVar == null;
        h hVar = this.profile;
        hVar.dsT.a(new 1(hVar));
        g gVar = new g();
        com.tencent.mm.kernel.a.a aVar2 = this.profile.dqh;
        Assert.assertNotNull(gVar);
        com.tencent.mm.kernel.h.Eo().Ef().DM();
        aVar2.drp = gVar;
        if (!z) {
            com.tencent.mm.splash.h.cjU();
            new 1(this, aVar).cht();
        }
        g Ek = g.Ek();
        if (z) {
            dVar = null;
        } else {
            if (i.byx == null) {
                i.byx = new i("initThread");
            }
            i iVar = i.byx;
            iVar.uW();
            g.Ek().a(new 5(this, iVar));
            c.Et().b(iVar.byy.getLooper());
            dVar = iVar.byz;
        }
        com.tencent.mm.kernel.h hVar2 = Ek.dqL;
        j.ey("startup");
        synchronized (hVar2.dre) {
            if (hVar2.drf) {
                com.tencent.mm.kernel.a.a.j("warning, mmskeleton has started up already.", new Object[0]);
            } else {
                com.tencent.mm.kernel.b.g DM = hVar2.Ef().DM();
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mm.kernel.a.a.j("mmskeleton boot startup for process [%s]...", new Object[]{DM.dox});
                com.tencent.mm.kernel.a.a aVar3 = DM.dqh;
                Assert.assertNotNull("You must call whichBootStep(BootStep defaultOne, BootStep ... bootSteps) to specify your BootStep instance first!", aVar3.drp);
                com.tencent.mm.vending.g.c mI = com.tencent.mm.vending.g.g.cBK().mI(true);
                com.tencent.mm.kernel.a.a.drr = SystemClock.elapsedRealtime();
                com.tencent.mm.kernel.a.a.j("hello WeChat.", new Object[0]);
                aVar3.drp.uQ();
                long currentTimeMillis2 = System.currentTimeMillis();
                com.tencent.mm.kernel.a.a.j("boot install plugins...", new Object[0]);
                aVar3.drp.uR();
                aVar3.mConfigured = true;
                com.tencent.mm.kernel.a.a.j("boot all installed plugins : %s...", new Object[]{com.tencent.mm.kernel.h.Eo().Ee().DL()});
                com.tencent.mm.kernel.a.a.j("boot install plugins done in [%s].", new Object[]{com.tencent.mm.kernel.a.a.aQ(currentTimeMillis2)});
                j.ey("installPlugins");
                currentTimeMillis2 = System.currentTimeMillis();
                com.tencent.mm.kernel.a.a.j("boot make dependency of plugins...", new Object[0]);
                aVar3.drp.Er();
                com.tencent.mm.kernel.a.a.j("boot make dependency of done in [%s].", new Object[]{com.tencent.mm.kernel.a.a.aQ(currentTimeMillis2)});
                currentTimeMillis2 = System.currentTimeMillis();
                com.tencent.mm.kernel.a.a.j("boot configure plugins...", new Object[0]);
                aVar3.drp.a(DM);
                com.tencent.mm.kernel.a.a.j("boot configure plugins done in [%s].", new Object[]{com.tencent.mm.kernel.a.a.aQ(currentTimeMillis2)});
                if (dVar != null) {
                    mI.a(dVar);
                }
                mI.c(new com.tencent.mm.kernel.h.1(hVar2, aVar3, DM));
                mI.c(new 2(hVar2, aVar3, DM));
                mI.a(d.uRC, new 3(hVar2, currentTimeMillis));
            }
        }
        com.tencent.mm.splash.h.a(new com.tencent.mm.splash.d() {
            p bzr = new p();

            public final boolean k(Intent intent) {
                if (intent == null || s.a(intent, "absolutely_exit_pid", 0) != Process.myPid()) {
                    return false;
                }
                x.i("MicroMsg.WeChatSplashStartup", "handle exit intent.");
                MMAppMgr.lE(s.a(intent, "kill_service", true));
                return true;
            }

            public final boolean a(Activity activity, Runnable runnable) {
                g.Eg();
                boolean z = !com.tencent.mm.kernel.a.Dw() && at.dBv.I("login_user_name", "").equals("");
                if (z && e.sFE) {
                    return MMAppMgr.a(activity, new 1(this, runnable));
                }
                return false;
            }

            public final boolean b(Activity activity, Runnable runnable) {
                return this.bzr.c(activity, runnable);
            }

            public final boolean a(Activity activity, int i, String[] strArr, int[] iArr) {
                return this.bzr.a(activity, i, strArr, iArr);
            }
        });
        g.Ek().a(new 3(this, z, aVar));
        g.Ek().a(new 4(this));
    }
}
