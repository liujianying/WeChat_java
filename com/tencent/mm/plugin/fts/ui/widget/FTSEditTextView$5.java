package com.tencent.mm.plugin.fts.ui.widget;

import android.view.inputmethod.InputMethodManager;

class FTSEditTextView$5 implements Runnable {
    final /* synthetic */ FTSEditTextView jzA;

    FTSEditTextView$5(FTSEditTextView fTSEditTextView) {
        this.jzA = fTSEditTextView;
    }

    public final void run() {
        ((InputMethodManager) this.jzA.getContext().getSystemService("input_method")).showSoftInput(FTSEditTextView.a(this.jzA), 0);
    }
}
