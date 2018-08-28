package com.tencent.mm.plugin.aa.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class AAQueryListUI$2 implements OnScrollListener {
    final /* synthetic */ AAQueryListUI eCd;

    AAQueryListUI$2(AAQueryListUI aAQueryListUI) {
        this.eCd = aAQueryListUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (AAQueryListUI.a(this.eCd).getLastVisiblePosition() == AAQueryListUI.a(this.eCd).getCount() - 1 && AAQueryListUI.a(this.eCd).getCount() > 0 && !AAQueryListUI.b(this.eCd) && !AAQueryListUI.c(this.eCd)) {
            AAQueryListUI.a(this.eCd).addFooterView(AAQueryListUI.d(this.eCd));
            AAQueryListUI.a(this.eCd, false, AAQueryListUI.e(this.eCd));
        }
    }
}
