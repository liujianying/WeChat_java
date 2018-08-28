package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.view.View;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

class PayURemittanceDetailUI$3 implements a {
    final /* synthetic */ PayURemittanceDetailUI pGd;

    PayURemittanceDetailUI$3(PayURemittanceDetailUI payURemittanceDetailUI) {
        this.pGd = payURemittanceDetailUI;
    }

    public final void onClick(View view) {
        h.a(this.pGd, this.pGd.getString(i.remittance_detail_refund_tips, new Object[]{PayURemittanceDetailUI.PD(PayURemittanceDetailUI.e(this.pGd))}), this.pGd.getString(i.app_remind), this.pGd.getString(i.remittance_detail_refuse_btn_text), this.pGd.getString(i.app_cancel), new 1(this), new 2(this));
    }
}
