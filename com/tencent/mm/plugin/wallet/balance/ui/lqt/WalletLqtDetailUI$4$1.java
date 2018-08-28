package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.4;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.sj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;

class WalletLqtDetailUI$4$1 implements c {
    final /* synthetic */ 4 pbt;

    WalletLqtDetailUI$4$1(4 4) {
        this.pbt = 4;
    }

    public final void a(l lVar) {
        if (WalletLqtDetailUI.c(this.pbt.pbs).sfG != null && WalletLqtDetailUI.c(this.pbt.pbs).sfG.size() > 0) {
            Iterator it = WalletLqtDetailUI.c(this.pbt.pbs).sfG.iterator();
            int i = 0;
            while (it.hasNext()) {
                sj sjVar = (sj) it.next();
                if (!(bi.oW(sjVar.title) || bi.oW(sjVar.rvK))) {
                    lVar.add(0, i, 0, sjVar.title);
                }
                i++;
            }
        }
        if (!WalletLqtDetailUI.c(this.pbt.pbs).sfN) {
            lVar.add(0, -1, 0, i.wallet_lqt_close_account);
        }
    }
}
