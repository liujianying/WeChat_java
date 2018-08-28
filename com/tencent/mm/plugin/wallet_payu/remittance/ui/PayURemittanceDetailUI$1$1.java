package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.1;

class PayURemittanceDetailUI$1$1 implements OnClickListener {
    final /* synthetic */ 1 pGe;

    PayURemittanceDetailUI$1$1(1 1) {
        this.pGe = 1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("transaction_id", PayURemittanceDetailUI.a(this.pGe.pGd));
        intent.putExtra("receiver_name", PayURemittanceDetailUI.b(this.pGe.pGd));
        intent.putExtra("total_fee", PayURemittanceDetailUI.c(this.pGe.pGd));
        intent.putExtra("fee_type", PayURemittanceDetailUI.d(this.pGe.pGd));
        this.pGe.pGd.X(intent);
    }
}
