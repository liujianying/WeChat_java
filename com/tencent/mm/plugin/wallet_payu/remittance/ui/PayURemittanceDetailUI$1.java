package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

class PayURemittanceDetailUI$1 implements a {
    final /* synthetic */ PayURemittanceDetailUI pGd;

    PayURemittanceDetailUI$1(PayURemittanceDetailUI payURemittanceDetailUI) {
        this.pGd = payURemittanceDetailUI;
    }

    public final void onClick(View view) {
        h.a(this.pGd, this.pGd.getString(i.remittance_confirm_resend_msg), this.pGd.getString(i.app_remind), this.pGd.getString(i.remittance_resend), this.pGd.getString(i.app_cancel), new 1(this), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }
}
