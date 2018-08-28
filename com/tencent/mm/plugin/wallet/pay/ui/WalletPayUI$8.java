package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.u;

class WalletPayUI$8 implements OnClickListener {
    final /* synthetic */ WalletPayUI pgT;

    WalletPayUI$8(WalletPayUI walletPayUI) {
        this.pgT = walletPayUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletPayUI", "WalletPwdDialog event1 %s", bi.cjd().toString());
        this.pgT.pfz = (FavorPayInfo) view.getTag();
        if (this.pgT.pfz != null) {
            this.pgT.pfz.pnT = "";
        }
        u.d(this.pgT.mCn == null ? 0 : this.pgT.mCn.bVY, this.pgT.mCn == null ? "" : this.pgT.mCn.bOd, 10, "");
        this.pgT.c(false, 0, "");
        this.pgT.oZD.dismiss();
        this.pgT.eWo = null;
        this.pgT.oZD = null;
        this.pgT.pfB = null;
    }
}
