package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.w.a.f;

class MMFormVerifyCodeInputView$1 implements OnFocusChangeListener {
    final /* synthetic */ MMFormVerifyCodeInputView tuD;

    MMFormVerifyCodeInputView$1(MMFormVerifyCodeInputView mMFormVerifyCodeInputView) {
        this.tuD = mMFormVerifyCodeInputView;
    }

    public final void onFocusChange(View view, boolean z) {
        if (view == MMFormVerifyCodeInputView.a(this.tuD)) {
            MMFormVerifyCodeInputView.b(this.tuD);
            if (z) {
                this.tuD.setBackgroundResource(f.input_bar_bg_active);
            } else {
                this.tuD.setBackgroundResource(f.input_bar_bg_normal);
            }
            MMFormVerifyCodeInputView.c(this.tuD);
        }
        if (MMFormVerifyCodeInputView.d(this.tuD) != null) {
            MMFormVerifyCodeInputView.d(this.tuD).onFocusChange(view, z);
        }
    }
}
