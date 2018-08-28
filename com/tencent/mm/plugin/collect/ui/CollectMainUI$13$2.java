package com.tencent.mm.plugin.collect.ui;

import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.plugin.collect.a.a;
import com.tencent.mm.plugin.collect.ui.CollectMainUI.13;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.atm;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.e;

class CollectMainUI$13$2 implements d {
    final /* synthetic */ 13 hYS;

    CollectMainUI$13$2(13 13) {
        this.hYS = 13;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                a.aBC();
                if (a.aBE()) {
                    CollectMainUI.v(this.hYS.hYN);
                    Toast.makeText(this.hYS.hYN.mController.tml, i.collect_main_close_ring_tone_tips, 1).show();
                    h.mEJ.h(13944, new Object[]{Integer.valueOf(8)});
                    return;
                }
                CollectMainUI.w(this.hYS.hYN);
                Toast.makeText(this.hYS.hYN.mController.tml, i.collect_main_open_ring_tone_tips, 1).show();
                h.mEJ.h(13944, new Object[]{Integer.valueOf(7)});
                return;
            default:
                int itemId = (menuItem.getItemId() - 1) - 1;
                if (itemId < 0) {
                    x.w("MicroMsg.CollectMainUI", "illegal pos: %s", new Object[]{Integer.valueOf(itemId)});
                    return;
                }
                atm atm = (atm) this.hYS.eRE.get(itemId);
                if (atm.type == 1) {
                    x.w("MicroMsg.CollectMainUI", "wrong native type: %s", new Object[]{atm.url});
                    h.mEJ.h(14526, new Object[]{Integer.valueOf(2), Integer.valueOf(1), atm.bSc, "", "", "", Integer.valueOf(2)});
                    return;
                } else if (atm.type == 2) {
                    if (!bi.oW(atm.url)) {
                        e.l(this.hYS.hYN.mController.tml, atm.url, false);
                        h.mEJ.h(14526, new Object[]{Integer.valueOf(2), Integer.valueOf(2), atm.bSc, "", "", atm.url, Integer.valueOf(2)});
                        return;
                    }
                    return;
                } else if (atm.type == 3) {
                    qu quVar = new qu();
                    quVar.cbq.userName = atm.rWQ;
                    quVar.cbq.cbs = bi.aG(atm.rWR, "");
                    quVar.cbq.scene = 1072;
                    quVar.cbq.cbt = 0;
                    com.tencent.mm.sdk.b.a.sFg.m(quVar);
                    h.mEJ.h(14526, new Object[]{Integer.valueOf(2), Integer.valueOf(3), atm.bSc, atm.rWQ, atm.rWR, "", Integer.valueOf(2)});
                    return;
                } else {
                    return;
                }
        }
    }
}
