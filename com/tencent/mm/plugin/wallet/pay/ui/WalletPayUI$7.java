package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.o.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.u;

class WalletPayUI$7 implements c {
    final /* synthetic */ WalletPayUI pgT;

    WalletPayUI$7(WalletPayUI walletPayUI) {
        this.pgT = walletPayUI;
    }

    public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
        String str2;
        this.pgT.YC();
        this.pgT.pfz = favorPayInfo;
        String str3 = "MicroMsg.WalletPayUI";
        String str4 = "WalletPwdDialog showAlert with favinfo %s isNeedChangeBankcard %s";
        Object[] objArr = new Object[2];
        if (this.pgT.pfz == null) {
            str2 = "";
        } else {
            str2 = this.pgT.pfz.toString();
        }
        objArr[0] = str2;
        objArr[1] = Boolean.valueOf(z);
        x.i(str3, str4, objArr);
        if (this.pgT.pfz == null || !z) {
            u.d(this.pgT.mCn == null ? 0 : this.pgT.mCn.bVY, this.pgT.mCn == null ? "" : this.pgT.mCn.bOd, 9, "");
            this.pgT.eWo = str;
            this.pgT.jp(false);
            com.tencent.mm.plugin.wallet_core.e.c.bQW();
            this.pgT.pfB = null;
            return;
        }
        this.pgT.W(-100, true);
    }
}
