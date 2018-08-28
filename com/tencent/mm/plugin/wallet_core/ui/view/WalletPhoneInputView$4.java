package com.tencent.mm.plugin.wallet_core.ui.view;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.al.b.a;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WalletPhoneInputView$4 implements TextWatcher {
    final /* synthetic */ WalletPhoneInputView pzY;

    WalletPhoneInputView$4(WalletPhoneInputView walletPhoneInputView) {
        this.pzY = walletPhoneInputView;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (bi.oW(editable.toString())) {
            WalletPhoneInputView.d(this.pzY).setText("");
            WalletPhoneInputView.d(this.pzY).setContentTextColorRes(a$c.normal_text_color);
            WalletPhoneInputView.e(this.pzY).setTextColor(this.pzY.getResources().getColor(a$c.normal_text_color));
        } else if (WalletPhoneInputView.f(this.pzY)) {
            a aVar = (a) WalletPhoneInputView.h(this.pzY).get(editable.toString());
            x.d("MicroMsg.WalletPhoneInputView", "cCode: %s, s: %s", new Object[]{aVar, editable.toString()});
            if (aVar != null) {
                WalletPhoneInputView.a(this.pzY, aVar.dYx);
                WalletPhoneInputView.b(this.pzY, aVar.dYy);
                WalletPhoneInputView.d(this.pzY).setText(aVar.dYy);
                WalletPhoneInputView.d(this.pzY).setContentTextColorRes(a$c.normal_text_color);
                WalletPhoneInputView.e(this.pzY).setTextColor(this.pzY.getResources().getColor(a$c.normal_text_color));
            } else {
                WalletPhoneInputView.a(this.pzY, "");
                WalletPhoneInputView.b(this.pzY, "");
                WalletPhoneInputView.d(this.pzY).setText(this.pzY.getContext().getString(i.wallet_phone_invalid_country_code));
            }
            WalletPhoneInputView.c(this.pzY).getInputValidChangeListener().fE(WalletPhoneInputView.c(this.pzY).ZF());
        } else {
            x.i("MicroMsg.WalletPhoneInputView", "manual pick don't search");
            WalletPhoneInputView.d(this.pzY).setContentTextColorRes(a$c.normal_text_color);
            WalletPhoneInputView.e(this.pzY).setTextColor(this.pzY.getResources().getColor(a$c.normal_text_color));
            WalletPhoneInputView.g(this.pzY);
        }
    }
}
