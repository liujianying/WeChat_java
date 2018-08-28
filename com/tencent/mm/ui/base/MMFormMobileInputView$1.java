package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class MMFormMobileInputView$1 implements OnFocusChangeListener {
    final /* synthetic */ MMFormMobileInputView tux;

    MMFormMobileInputView$1(MMFormMobileInputView mMFormMobileInputView) {
        this.tux = mMFormMobileInputView;
    }

    public final void onFocusChange(View view, boolean z) {
        if (view == MMFormMobileInputView.a(this.tux) || view == MMFormMobileInputView.b(this.tux)) {
            this.tux.lI(z);
        }
    }
}
