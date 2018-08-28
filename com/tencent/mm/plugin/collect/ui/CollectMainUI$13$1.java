package com.tencent.mm.plugin.collect.ui;

import com.tencent.mm.plugin.collect.a.a;
import com.tencent.mm.plugin.collect.ui.CollectMainUI.13;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.protocal.c.atm;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class CollectMainUI$13$1 implements c {
    final /* synthetic */ 13 hYS;

    CollectMainUI$13$1(13 13) {
        this.hYS = 13;
    }

    public final void a(l lVar) {
        a.aBC();
        if (a.aBE()) {
            lVar.add(0, 1, 0, a$i.collect_main_close_ring_tone);
        } else {
            lVar.add(0, 1, 0, a$i.collect_main_open_ring_tone);
        }
        if (this.hYS.eRE != null) {
            for (int i = 0; i < this.hYS.eRE.size(); i++) {
                atm atm = (atm) this.hYS.eRE.get(i);
                if (!bi.oW(atm.bSc)) {
                    lVar.add(0, (i + 1) + 1, 0, atm.bSc);
                }
            }
        }
    }
}
