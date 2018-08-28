package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView.c;

class CollectBillListUI$10 implements c {
    final /* synthetic */ CollectBillListUI hXk;

    CollectBillListUI$10(CollectBillListUI collectBillListUI) {
        this.hXk = collectBillListUI;
    }

    public final boolean aCi() {
        if (CollectBillListUI.f(this.hXk).getVisibility() == 0) {
            x.d("MicroMsg.CollectBillListUI", "empty view");
            return true;
        }
        View childAt = CollectBillListUI.e(this.hXk).getChildAt(CollectBillListUI.e(this.hXk).getChildCount() - 1);
        if (childAt == null || childAt.getBottom() > CollectBillListUI.e(this.hXk).getHeight() || CollectBillListUI.e(this.hXk).getLastVisiblePosition() != CollectBillListUI.e(this.hXk).getAdapter().getCount() - 1) {
            return false;
        }
        return true;
    }
}
