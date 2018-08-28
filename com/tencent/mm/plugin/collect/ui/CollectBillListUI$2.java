package com.tencent.mm.plugin.collect.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView.e;

class CollectBillListUI$2 implements e {
    final /* synthetic */ CollectBillListUI hXk;

    CollectBillListUI$2(CollectBillListUI collectBillListUI) {
        this.hXk = collectBillListUI;
    }

    public final boolean aCg() {
        x.d("MicroMsg.CollectBillListUI", "bottomLoad, isLoading: %s, isFinish: %s", new Object[]{Boolean.valueOf(CollectBillListUI.g(this.hXk)), Boolean.valueOf(CollectBillListUI.h(this.hXk))});
        if (CollectBillListUI.g(this.hXk) || CollectBillListUI.h(this.hXk)) {
            return true;
        }
        CollectBillListUI.i(this.hXk);
        CollectBillListUI.j(this.hXk);
        return false;
    }
}
