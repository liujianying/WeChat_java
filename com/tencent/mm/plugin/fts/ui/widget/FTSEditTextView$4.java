package com.tencent.mm.plugin.fts.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;

class FTSEditTextView$4 implements OnClickListener {
    final /* synthetic */ FTSEditTextView jzA;

    FTSEditTextView$4(FTSEditTextView fTSEditTextView) {
        this.jzA = fTSEditTextView;
    }

    public final void onClick(View view) {
        this.jzA.clearText();
        if (FTSEditTextView.h(this.jzA) != null) {
            FTSEditTextView.h(this.jzA).onClickClearTextBtn(view);
        }
    }
}
