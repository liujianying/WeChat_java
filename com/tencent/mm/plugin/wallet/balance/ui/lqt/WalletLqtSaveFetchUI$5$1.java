package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.5;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;

class WalletLqtSaveFetchUI$5$1 implements c {
    final /* synthetic */ 5 pce;

    WalletLqtSaveFetchUI$5$1(5 5) {
        this.pce = 5;
    }

    public final void a(l lVar) {
        Iterator it = this.pce.pcd.iterator();
        int i = 0;
        while (it.hasNext()) {
            lVar.add(0, i, 0, ((String) it.next()).split("\\|\\|")[0]);
            i++;
        }
    }
}
