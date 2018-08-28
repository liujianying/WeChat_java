package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.collect.ui.CollectBillUI.1;
import com.tencent.mm.protocal.c.cq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;

class CollectBillUI$1$1 implements OnClickListener {
    final /* synthetic */ cq hXB;
    final /* synthetic */ 1 hXC;

    CollectBillUI$1$1(1 1, cq cqVar) {
        this.hXC = 1;
        this.hXB = cqVar;
    }

    public final void onClick(View view) {
        if (!bi.oW(this.hXB.url)) {
            e.l(this.hXC.hXA.mController.tml, this.hXB.url, true);
        }
    }
}
