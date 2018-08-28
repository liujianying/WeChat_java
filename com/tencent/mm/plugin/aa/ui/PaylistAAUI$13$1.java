package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.model.q;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.aa.ui.PaylistAAUI.13;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class PaylistAAUI$13$1 implements c {
    final /* synthetic */ 13 eEq;

    PaylistAAUI$13$1(13 13) {
        this.eEq = 13;
    }

    public final void a(l lVar) {
        lVar.add(0, 1, 1, i.paylist_launch_new_aa);
        if (!bi.oW(PaylistAAUI.g(this.eEq.eEl)) && PaylistAAUI.g(this.eEq.eEl).equals(q.GF()) && this.eEq.eEp.state == a.ezI && this.eEq.eEp.qYE < this.eEq.eEp.qYC) {
            lVar.add(0, 2, 1, i.aa_close_paylist);
        }
    }
}
