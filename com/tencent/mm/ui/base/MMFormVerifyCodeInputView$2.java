package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;

class MMFormVerifyCodeInputView$2 implements OnClickListener {
    final /* synthetic */ MMFormVerifyCodeInputView tuD;

    MMFormVerifyCodeInputView$2(MMFormVerifyCodeInputView mMFormVerifyCodeInputView) {
        this.tuD = mMFormVerifyCodeInputView;
    }

    public final void onClick(View view) {
        if (MMFormVerifyCodeInputView.e(this.tuD) != null) {
            MMFormVerifyCodeInputView.e(this.tuD).onClick(view);
        }
    }
}
