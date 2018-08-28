package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.u;

class WalletPayUI$2 implements OnClickListener {
    final /* synthetic */ WalletPayUI pgT;

    WalletPayUI$2(WalletPayUI walletPayUI) {
        this.pgT = walletPayUI;
    }

    public final void onClick(View view) {
        int i = 0;
        p.bNp();
        if (p.bNq().bPt()) {
            u.d(this.pgT.mCn == null ? 0 : this.pgT.mCn.bVY, this.pgT.mCn == null ? "" : this.pgT.mCn.bOd, 6, "");
        }
        if (this.pgT.mCZ.pph == 1) {
            p.bNp();
            if (p.bNq().bPt()) {
                if (this.pgT.mCn != null) {
                    i = this.pgT.mCn.bVY;
                }
                u.d(i, this.pgT.mCn == null ? "" : this.pgT.mCn.bOd, 5, "");
            }
            WalletPayUI.f(this.pgT);
            return;
        }
        x.i("MicroMsg.WalletPayUI", "SimpleReg , assigned userinfo pay! payWithNewBankcard");
        p.bNp();
        if (p.bNq().bPt()) {
            u.d(this.pgT.mCn == null ? 0 : this.pgT.mCn.bVY, this.pgT.mCn == null ? "" : this.pgT.mCn.bOd, 5, "");
        }
        this.pgT.b(false, 0, "");
    }
}
