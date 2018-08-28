package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.balance.a.a.p.c;
import com.tencent.mm.protocal.c.fe;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;

class WalletLqtSaveFetchUI$7 implements OnClickListener {
    final /* synthetic */ WalletLqtSaveFetchUI pcc;

    WalletLqtSaveFetchUI$7(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        this.pcc = walletLqtSaveFetchUI;
    }

    public final void onClick(View view) {
        if (bi.bI(WalletLqtSaveFetchUI.p(this.pcc)) < 800) {
            x.d("MicroMsg.WalletLqtSaveFetchUI", "saveButton click too soon");
            return;
        }
        WalletLqtSaveFetchUI.a(this.pcc, bi.VG());
        int fb = WalletLqtSaveFetchUI.fb(WalletLqtSaveFetchUI.c(this.pcc).getText(), "100");
        if (fb <= 0) {
            return;
        }
        if (WalletLqtSaveFetchUI.g(this.pcc) == 1) {
            x.i("MicroMsg.WalletLqtSaveFetchUI", "click save lqt");
            c cVar = WalletLqtSaveFetchUI.r(this.pcc).oZv;
            int q = WalletLqtSaveFetchUI.q(this.pcc);
            g.a(Integer.valueOf(fb), Integer.valueOf(q), WalletLqtSaveFetchUI.d(this.pcc)).c(cVar).f(new 2(this, fb)).a(new 1(this));
        } else if (WalletLqtSaveFetchUI.g(this.pcc) == 2) {
            x.i("MicroMsg.WalletLqtSaveFetchUI", "click fetch lqt");
            Object obj = null;
            if (!(WalletLqtSaveFetchUI.d(this.pcc) == null || WalletLqtSaveFetchUI.d(this.pcc).bOs())) {
                obj = new fe();
                obj.knE = WalletLqtSaveFetchUI.d(this.pcc).field_bankName;
                obj.lMV = WalletLqtSaveFetchUI.d(this.pcc).field_bankcardType;
                obj.rga = WalletLqtSaveFetchUI.d(this.pcc).field_bindSerial;
                obj.lNU = WalletLqtSaveFetchUI.d(this.pcc).field_bankcardTail;
            }
            g.a(Integer.valueOf(fb), Integer.valueOf(WalletLqtSaveFetchUI.q(this.pcc)), obj).c(WalletLqtSaveFetchUI.r(this.pcc).oZw).f(new 4(this, fb)).a(new 3(this));
        }
    }
}
