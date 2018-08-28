package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

class PayURemittanceDetailUI$8 implements OnClickListener {
    final /* synthetic */ PayURemittanceDetailUI pGd;

    PayURemittanceDetailUI$8(PayURemittanceDetailUI payURemittanceDetailUI) {
        this.pGd = payURemittanceDetailUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.bA(this.pGd.mController.tml, this.pGd.getString(i.remittance_detail_msg_collect_suc));
    }
}
