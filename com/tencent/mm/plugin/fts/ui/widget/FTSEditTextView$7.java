package com.tencent.mm.plugin.fts.ui.widget;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class FTSEditTextView$7 implements OnFocusChangeListener {
    final /* synthetic */ FTSEditTextView jzA;

    FTSEditTextView$7(FTSEditTextView fTSEditTextView) {
        this.jzA = fTSEditTextView;
    }

    public final void onFocusChange(View view, boolean z) {
        if (FTSEditTextView.h(this.jzA) != null) {
            FTSEditTextView.h(this.jzA).fg(z);
        }
    }
}
