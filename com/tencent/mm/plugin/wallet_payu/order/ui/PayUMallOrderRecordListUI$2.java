package com.tencent.mm.plugin.wallet_payu.order.ui;

class PayUMallOrderRecordListUI$2 implements Runnable {
    final /* synthetic */ PayUMallOrderRecordListUI pFl;

    PayUMallOrderRecordListUI$2(PayUMallOrderRecordListUI payUMallOrderRecordListUI) {
        this.pFl = payUMallOrderRecordListUI;
    }

    public final void run() {
        PayUMallOrderRecordListUI.i(this.pFl).notifyDataSetChanged();
    }
}
