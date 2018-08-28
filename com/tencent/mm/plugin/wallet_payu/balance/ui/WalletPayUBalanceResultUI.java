package com.tencent.mm.plugin.wallet_payu.balance.ui;

import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;

public class WalletPayUBalanceResultUI extends WalletBalanceResultUI {
    protected final void initView() {
        super.initView();
        this.paH.setVisibility(8);
    }

    protected final void aL() {
        if (this.mCZ != null) {
            this.paF.setText(e.e(this.mCZ.mBj, this.mCZ.lNV));
            if (this.paI != null && !bi.oW(this.paI.field_bankName)) {
                if (bi.oW(this.paI.field_bankcardTail)) {
                    this.muz.setText(this.paI.field_bankName);
                } else {
                    this.muz.setText(this.paI.field_bankName + " " + getString(i.wallet_pay_bankcard_tail) + this.paI.field_bankcardTail);
                }
            }
        }
    }
}
