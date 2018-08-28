package com.tencent.mm.ui.conversation;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.bv.d;

class k$1 implements OnScrollListener {
    final /* synthetic */ k uro;

    k$1(k kVar) {
        this.uro = kVar;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            d.cov().dh(j.class.getName() + ".Listview", 4);
        }
        if (i != 0) {
            this.uro.czb();
        } else if (this.uro.unh != null) {
            k.a(this.uro, -1);
        }
    }
}
