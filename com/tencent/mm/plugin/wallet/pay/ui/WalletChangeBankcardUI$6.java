package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;

class WalletChangeBankcardUI$6 implements OnClickListener {
    final /* synthetic */ WalletChangeBankcardUI pfC;

    WalletChangeBankcardUI$6(WalletChangeBankcardUI walletChangeBankcardUI) {
        this.pfC = walletChangeBankcardUI;
    }

    public final void onClick(View view) {
        if (this.pfC.oZD != null) {
            this.pfC.oZD.dismiss();
        }
        this.pfC.jm(false);
        this.pfC.pfx.e(this.pfC.oZG, true);
        this.pfC.pfz = (FavorPayInfo) view.getTag();
        if (this.pfC.pfz != null) {
            this.pfC.pfz.pnT = "";
        }
        this.pfC.sy.putParcelable("key_favor_pay_info", this.pfC.pfz);
        this.pfC.aL();
        this.pfC.ux(0);
        this.pfC.pfB = null;
    }
}
