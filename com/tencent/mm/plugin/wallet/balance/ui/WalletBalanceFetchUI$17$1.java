package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.17;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class WalletBalanceFetchUI$17$1 implements c {
    final /* synthetic */ 17 pam;

    WalletBalanceFetchUI$17$1(17 17) {
        this.pam = 17;
    }

    public final void a(l lVar) {
        b.c[] cVarArr = this.pam.pal.plE.plG;
        int length = cVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            b.c cVar = cVarArr[i];
            if (!bi.oW(cVar.title)) {
                if (bi.oW(cVar.desc)) {
                    lVar.e(i2, cVar.title);
                } else {
                    lVar.a(i2, cVar.title, cVar.desc);
                }
            }
            i++;
            i2++;
        }
    }
}
