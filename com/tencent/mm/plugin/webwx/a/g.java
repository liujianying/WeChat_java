package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ab.d;
import com.tencent.mm.bt.h;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public final class g implements ar {
    private a hdi = new 1(this);
    private f qmb = new f();
    private a qmc;
    private aq qmd = new 2(this);
    private c qme = new 3(this);
    private r qmf = new 4(this);

    public static g bYF() {
        au.HN();
        g gVar = (g) bs.iK("plugin.webwx");
        if (gVar != null) {
            return gVar;
        }
        gVar = new g();
        au.HN().a("plugin.webwx", gVar);
        return gVar;
    }

    public final void onAccountRelease() {
        d.c.b(Integer.valueOf(51), this.qmb);
        au.getSysCmdMsgExtension().b("pushloginurl", this.hdi, true);
        au.HU();
        com.tencent.mm.model.c.b(this.qmd);
        com.tencent.mm.sdk.b.a.sFg.c(this.qme);
        bYG();
        if (this.qmc != null) {
            a aVar = this.qmc;
            o.Ta().a(aVar);
            com.tencent.mm.kernel.g.DF().b(221, aVar);
        }
        t.a(this.qmf);
    }

    public final HashMap<Integer, h.d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        d.c.a(Integer.valueOf(51), this.qmb);
        au.getSysCmdMsgExtension().a("pushloginurl", this.hdi, true);
        au.HU();
        com.tencent.mm.model.c.a(this.qmd);
        com.tencent.mm.sdk.b.a.sFg.b(this.qme);
        this.qmc = null;
        t.a(5, this.qmf);
    }

    public final void bo(boolean z) {
    }

    static void bYG() {
        au.getNotification().cancel(38);
    }

    public final a bYH() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (this.qmc == null) {
            this.qmc = new a();
        }
        return this.qmc;
    }
}
