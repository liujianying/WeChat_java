package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView$d;

class y$4 implements MMPullDownView$d {
    final /* synthetic */ y tMm;

    y$4(y yVar) {
        this.tMm = yVar;
    }

    public final boolean aCh() {
        View childAt = y.a(this.tMm).getChildAt(0);
        if (this.tMm.tMd.getFirstVisiblePosition() != 0 || childAt == null || childAt.getTop() < 0) {
            return false;
        }
        return true;
    }
}
