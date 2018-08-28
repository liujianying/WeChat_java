package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.e;

class WalletPayUI$25 implements OnClickListener {
    final /* synthetic */ WalletPayUI pgT;

    WalletPayUI$25(WalletPayUI walletPayUI) {
        this.pgT = walletPayUI;
    }

    public final void onClick(View view) {
        if (this.pgT.pgq) {
            this.pgT.pgz.setImageResource(e.pay_dital_bill_guid_down);
            this.pgT.pgq = false;
        } else {
            this.pgT.pgz.setImageResource(e.pay_dital_bill_guid_up);
            this.pgT.pgq = true;
        }
        this.pgT.pgD.notifyDataSetChanged();
    }
}
