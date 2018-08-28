package com.tencent.mm.plugin.collect.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class CollectBillUI$2 implements OnScrollListener {
    final /* synthetic */ CollectBillUI hXA;

    CollectBillUI$2(CollectBillUI collectBillUI) {
        this.hXA = collectBillUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (CollectBillUI.b(this.hXA).getLastVisiblePosition() == CollectBillUI.c(this.hXA).getCount() && CollectBillUI.c(this.hXA).getCount() > 0 && !CollectBillUI.d(this.hXA) && !CollectBillUI.e(this.hXA)) {
            CollectBillUI.f(this.hXA);
            CollectBillUI.g(this.hXA);
        }
    }
}
