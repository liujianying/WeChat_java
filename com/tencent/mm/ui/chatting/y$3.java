package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.c;

class y$3 implements c {
    final /* synthetic */ y tMm;

    y$3(y yVar) {
        this.tMm = yVar;
    }

    public final boolean aCi() {
        View childAt = y.a(this.tMm).getChildAt(y.a(this.tMm).getChildCount() - 1);
        if (childAt == null) {
            return true;
        }
        if (childAt.getBottom() > y.a(this.tMm).getHeight() || y.a(this.tMm).getLastVisiblePosition() != y.a(this.tMm).getAdapter().getCount() - 1) {
            return false;
        }
        return true;
    }
}
