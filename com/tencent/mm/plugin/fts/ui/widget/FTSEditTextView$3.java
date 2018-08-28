package com.tencent.mm.plugin.fts.ui.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class FTSEditTextView$3 implements OnEditorActionListener {
    final /* synthetic */ FTSEditTextView jzA;

    FTSEditTextView$3(FTSEditTextView fTSEditTextView) {
        this.jzA = fTSEditTextView;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (3 != i || FTSEditTextView.h(this.jzA) == null) {
            return false;
        }
        return FTSEditTextView.h(this.jzA).anx();
    }
}
