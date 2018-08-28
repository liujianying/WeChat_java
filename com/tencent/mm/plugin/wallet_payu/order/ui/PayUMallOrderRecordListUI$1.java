package com.tencent.mm.plugin.wallet_payu.order.ui;

import com.tencent.mm.sdk.platformtools.x;

class PayUMallOrderRecordListUI$1 implements Runnable {
    final /* synthetic */ PayUMallOrderRecordListUI pFl;

    PayUMallOrderRecordListUI$1(PayUMallOrderRecordListUI payUMallOrderRecordListUI) {
        this.pFl = payUMallOrderRecordListUI;
    }

    public final void run() {
        if (PayUMallOrderRecordListUI.a(this.pFl)) {
            x.v("MicroMsg.PayUMallOrderRecordListUI", "has more");
            if (!PayUMallOrderRecordListUI.b(this.pFl)) {
                PayUMallOrderRecordListUI.c(this.pFl).crC();
                PayUMallOrderRecordListUI.e(this.pFl).setAdapter(PayUMallOrderRecordListUI.d(this.pFl));
                PayUMallOrderRecordListUI.f(this.pFl);
            }
        } else {
            x.v("MicroMsg.PayUMallOrderRecordListUI", "no more! dismiss footer view!");
            PayUMallOrderRecordListUI.g(this.pFl).crD();
        }
        PayUMallOrderRecordListUI.h(this.pFl).notifyDataSetChanged();
    }
}
