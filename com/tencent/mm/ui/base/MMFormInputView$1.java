package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.w.a.f;

class MMFormInputView$1 implements OnFocusChangeListener {
    final /* synthetic */ MMFormInputView tuq;

    MMFormInputView$1(MMFormInputView mMFormInputView) {
        this.tuq = mMFormInputView;
    }

    public final void onFocusChange(View view, boolean z) {
        if (view == MMFormInputView.a(this.tuq)) {
            MMFormInputView.b(this.tuq);
            if (z) {
                this.tuq.setBackgroundResource(f.input_bar_bg_active);
            } else {
                this.tuq.setBackgroundResource(f.input_bar_bg_normal);
            }
            MMFormInputView.c(this.tuq);
        }
        if (MMFormInputView.d(this.tuq) != null) {
            MMFormInputView.d(this.tuq).onFocusChange(view, z);
        }
    }
}
