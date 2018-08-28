package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.c;

class NearbySayHiListUI$7 implements c {
    final /* synthetic */ NearbySayHiListUI lCB;

    NearbySayHiListUI$7(NearbySayHiListUI nearbySayHiListUI) {
        this.lCB = nearbySayHiListUI;
    }

    public final int cl(View view) {
        return NearbySayHiListUI.d(this.lCB).getPositionForView(view);
    }
}
