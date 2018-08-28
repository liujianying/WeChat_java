package com.tencent.mm.plugin.fav.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.sdk.platformtools.x;

class FavCleanUI$2 implements OnScrollListener {
    final /* synthetic */ FavCleanUI iYA;

    FavCleanUI$2(FavCleanUI favCleanUI) {
        this.iYA = favCleanUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && FavCleanUI.a(this.iYA)) {
            x.i("MicroMsg.FavCleanUI", "force bottom load data");
            FavCleanUI.b(this.iYA);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
