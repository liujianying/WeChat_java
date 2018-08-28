package com.tencent.mm.plugin.order.ui;

import android.widget.TextView;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class MallOrderRecordListUI$4 implements Runnable {
    final /* synthetic */ sy hYO;
    final /* synthetic */ MallOrderRecordListUI lPQ;

    MallOrderRecordListUI$4(MallOrderRecordListUI mallOrderRecordListUI, sy syVar) {
        this.lPQ = mallOrderRecordListUI;
        this.hYO = syVar;
    }

    public final void run() {
        if (bi.oW(this.hYO.cdP.cdQ)) {
            x.i("MicroMsg.WalletOrderListUI", "no bulletin data");
        } else {
            e.a((TextView) this.lPQ.findViewById(f.banner_tips), this.hYO.cdP.cdQ, this.hYO.cdP.content, this.hYO.cdP.url);
        }
    }
}
