package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.report.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;

public final class c {
    final f gre;
    volatile String grf;
    public volatile long grg = 0;
    volatile long grh = 0;
    private final LinkedList<Runnable> gri = new LinkedList();
    volatile String mAppId;

    public c(int i) {
        this.gre = new f("MicroMsg.AppBrandPageViewStatistics[" + i + "]");
    }

    public final boolean iD() {
        return this.grg > 0 && this.grh <= 0;
    }

    public final void h(g gVar) {
        this.mAppId = gVar.mAppId;
    }

    public final void vq(String str) {
        this.grg = bi.VF();
        this.gre.amD();
        this.grf = str;
    }

    public final void amF() {
        this.grh = bi.VF() - this.grg;
    }

    public final void agK() {
        this.gre.amE();
        if (this.gre.amC()) {
            amG();
        } else {
            ah.A(new 1(this));
        }
    }

    public final void agL() {
        if (this.grg > 0) {
            this.gre.amD();
            this.gri.clear();
        }
    }

    public final void onDestroy() {
        this.gre.amE();
        f fVar = this.gre;
        fVar.quit();
        fVar.mStopped = true;
    }

    public final void t(Runnable runnable) {
        if (this.gre.amC()) {
            runnable.run();
        } else {
            this.gri.addLast(runnable);
        }
    }

    final void amG() {
        while (!this.gri.isEmpty()) {
            ((Runnable) this.gri.pollFirst()).run();
        }
    }
}
