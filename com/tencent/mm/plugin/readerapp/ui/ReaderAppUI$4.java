package com.tencent.mm.plugin.readerapp.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.c;

class ReaderAppUI$4 implements c {
    final /* synthetic */ ReaderAppUI mnQ;

    ReaderAppUI$4(ReaderAppUI readerAppUI) {
        this.mnQ = readerAppUI;
    }

    public final boolean aCi() {
        View childAt = ReaderAppUI.e(this.mnQ).getChildAt(ReaderAppUI.e(this.mnQ).getChildCount() - 1);
        if (childAt != null && childAt.getBottom() <= ReaderAppUI.e(this.mnQ).getHeight() && ReaderAppUI.e(this.mnQ).getLastVisiblePosition() == ReaderAppUI.e(this.mnQ).getAdapter().getCount() - 1) {
            return true;
        }
        return false;
    }
}
