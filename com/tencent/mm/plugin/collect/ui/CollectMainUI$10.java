package com.tencent.mm.plugin.collect.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.b.f$a;
import com.tencent.mm.protocal.c.atm;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.util.List;

class CollectMainUI$10 implements f$a {
    final /* synthetic */ CollectMainUI hYN;

    CollectMainUI$10(CollectMainUI collectMainUI) {
        this.hYN = collectMainUI;
    }

    public final void cl(String str, String str2) {
        x.i("MicroMsg.CollectMainUI", "get cache: %s, %s", new Object[]{str, str2});
        this.hYN.hYg = str;
        this.hYN.hYh = str2;
        atm aCw = CollectMainUI.aCw();
        List aCx = CollectMainUI.aCx();
        CollectMainUI.a(this.hYN, aCw);
        this.hYN.aM(aCx);
        if (CollectMainUI.t(this.hYN) == 1) {
            CollectMainUI collectMainUI = this.hYN;
            g.Ek();
            CollectMainUI.a(collectMainUI, ((Integer) g.Ei().DT().get(a.sYY, Integer.valueOf(-1))).intValue());
            collectMainUI = this.hYN;
            g.Ek();
            CollectMainUI.a(collectMainUI, (String) g.Ei().DT().get(a.sYZ, ""));
        }
    }

    public final void a(boolean z, lt ltVar) {
        x.i("MicroMsg.CollectMainUI", "get from cgi: %s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.hYN.hYg = ltVar.url;
            this.hYN.hYh = ltVar.plj;
            CollectMainUI.a(this.hYN, ltVar.myh);
            CollectMainUI.b(this.hYN, ltVar.myi);
            CollectMainUI.a(this.hYN, ltVar.myj);
            CollectMainUI.c(this.hYN, ltVar.rpR);
            CollectMainUI.a(this.hYN, ltVar.rpO);
            this.hYN.aM(ltVar.rpN);
            CollectMainUI.b(this.hYN, ltVar.rpS);
            CollectMainUI.a(this.hYN, ltVar.rpT);
            x.d("MicroMsg.CollectMainUI", "flag: %s", new Object[]{Integer.valueOf(CollectMainUI.b(this.hYN))});
            g.Ek();
            g.Ei().DT().a(a.sYY, Integer.valueOf(CollectMainUI.u(this.hYN)));
            g.Ek();
            g.Ei().DT().a(a.sYZ, CollectMainUI.a(this.hYN));
            this.hYN.aoV();
        }
    }
}
