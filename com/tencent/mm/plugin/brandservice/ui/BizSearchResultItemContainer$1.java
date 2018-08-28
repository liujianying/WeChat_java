package com.tencent.mm.plugin.brandservice.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class BizSearchResultItemContainer$1 implements OnScrollListener {
    boolean hoR = false;
    final /* synthetic */ BizSearchResultItemContainer hoS;

    BizSearchResultItemContainer$1(BizSearchResultItemContainer bizSearchResultItemContainer) {
        this.hoS = bizSearchResultItemContainer;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.hoR && BizSearchResultItemContainer.a(this.hoS)) {
            BizSearchResultItemContainer.a(this.hoS, BizSearchResultItemContainer.b(this.hoS).bHt, BizSearchResultItemContainer.b(this.hoS).offset, BizSearchResultItemContainer.c(this.hoS)[BizSearchResultItemContainer.c(this.hoS).length - 1]);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i + i2 == i3) {
            this.hoR = true;
        } else {
            this.hoR = false;
        }
    }
}
