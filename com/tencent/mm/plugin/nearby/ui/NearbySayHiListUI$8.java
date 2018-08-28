package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.g;

class NearbySayHiListUI$8 implements g {
    final /* synthetic */ NearbySayHiListUI lCB;

    NearbySayHiListUI$8(NearbySayHiListUI nearbySayHiListUI) {
        this.lCB = nearbySayHiListUI;
    }

    public final void t(View view, int i) {
        NearbySayHiListUI.d(this.lCB).performItemClick(view, i, 0);
    }
}
