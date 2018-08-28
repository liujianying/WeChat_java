package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class MMAutoCompleteTextView$3 implements OnFocusChangeListener {
    final /* synthetic */ MMAutoCompleteTextView ttE;

    MMAutoCompleteTextView$3(MMAutoCompleteTextView mMAutoCompleteTextView) {
        this.ttE = mMAutoCompleteTextView;
    }

    public final void onFocusChange(View view, boolean z) {
        MMAutoCompleteTextView.b(this.ttE);
    }
}
