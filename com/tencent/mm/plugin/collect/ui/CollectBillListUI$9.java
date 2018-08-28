package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.d;

class CollectBillListUI$9 implements d {
    final /* synthetic */ CollectBillListUI hXk;

    CollectBillListUI$9(CollectBillListUI collectBillListUI) {
        this.hXk = collectBillListUI;
    }

    public final boolean aCh() {
        int firstVisiblePosition = CollectBillListUI.e(this.hXk).getFirstVisiblePosition();
        if (firstVisiblePosition == 0) {
            View childAt = CollectBillListUI.e(this.hXk).getChildAt(firstVisiblePosition);
            if (childAt != null && childAt.getX() == 0.0f) {
                return true;
            }
        }
        return false;
    }
}
