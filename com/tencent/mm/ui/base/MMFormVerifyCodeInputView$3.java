package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.w.a.k;

class MMFormVerifyCodeInputView$3 implements a {
    final /* synthetic */ MMFormVerifyCodeInputView tuD;

    MMFormVerifyCodeInputView$3(MMFormVerifyCodeInputView mMFormVerifyCodeInputView) {
        this.tuD = mMFormVerifyCodeInputView;
    }

    public final boolean vD() {
        MMFormVerifyCodeInputView.f(this.tuD);
        MMFormVerifyCodeInputView.h(this.tuD).setText(this.tuD.getContext().getString(k.mobile_input_send_sms_timer_title, new Object[]{Integer.valueOf(MMFormVerifyCodeInputView.g(this.tuD))}));
        if (MMFormVerifyCodeInputView.g(this.tuD) == 0) {
            MMFormVerifyCodeInputView.i(this.tuD).SO();
            MMFormVerifyCodeInputView.a(this.tuD, MMFormVerifyCodeInputView.j(this.tuD));
            MMFormVerifyCodeInputView.k(this.tuD).setVisibility(0);
            MMFormVerifyCodeInputView.h(this.tuD).setVisibility(8);
        }
        return true;
    }
}
