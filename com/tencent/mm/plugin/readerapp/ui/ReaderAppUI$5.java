package com.tencent.mm.plugin.readerapp.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.d;

class ReaderAppUI$5 implements d {
    final /* synthetic */ ReaderAppUI mnQ;

    ReaderAppUI$5(ReaderAppUI readerAppUI) {
        this.mnQ = readerAppUI;
    }

    public final boolean aCh() {
        View childAt = ReaderAppUI.e(this.mnQ).getChildAt(ReaderAppUI.e(this.mnQ).getFirstVisiblePosition());
        if (childAt == null || childAt.getTop() != 0) {
            return false;
        }
        return true;
    }
}
