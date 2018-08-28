package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.al.b.a;
import com.tencent.mm.plugin.wxpay.a.c;

class WalletPhoneInputView$5 implements OnFocusChangeListener {
    final /* synthetic */ WalletPhoneInputView pzY;

    WalletPhoneInputView$5(WalletPhoneInputView walletPhoneInputView) {
        this.pzY = walletPhoneInputView;
    }

    public final void onFocusChange(View view, boolean z) {
        if (!z) {
            if (((a) WalletPhoneInputView.h(this.pzY).get(WalletPhoneInputView.e(this.pzY).getText().toString())) == null) {
                WalletPhoneInputView.d(this.pzY).setContentTextColorRes(c.red_text_color);
                WalletPhoneInputView.e(this.pzY).setTextColor(this.pzY.getResources().getColor(c.red_text_color));
                return;
            }
            WalletPhoneInputView.d(this.pzY).setContentTextColorRes(c.normal_text_color);
            WalletPhoneInputView.e(this.pzY).setTextColor(this.pzY.getResources().getColor(c.normal_text_color));
        }
    }
}
