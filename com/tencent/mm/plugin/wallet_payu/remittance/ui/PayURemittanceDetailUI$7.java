package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.ui.base.h;

class PayURemittanceDetailUI$7 implements a {
    final /* synthetic */ PayURemittanceDetailUI pGd;

    PayURemittanceDetailUI$7(PayURemittanceDetailUI payURemittanceDetailUI) {
        this.pGd = payURemittanceDetailUI;
    }

    public final void onClick(View view) {
        h.a(this.pGd, this.pGd.getString(a$i.remittance_detail_refund_tips, new Object[]{PayURemittanceDetailUI.PE(PayURemittanceDetailUI.f(this.pGd))}), this.pGd.getString(a$i.app_remind), this.pGd.getString(a$i.remittance_detail_refuse_btn_text), this.pGd.getString(a$i.app_cancel), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                PayURemittanceDetailUI$7.this.pGd.brC();
            }
        }, new 2(this));
    }
}
