package com.tencent.mm.plugin.luckymoney.ui;

import android.text.Editable;
import android.text.TextWatcher;

class LuckyMoneyWishFooter$1 implements TextWatcher {
    final /* synthetic */ LuckyMoneyWishFooter kXP;

    LuckyMoneyWishFooter$1(LuckyMoneyWishFooter luckyMoneyWishFooter) {
        this.kXP = luckyMoneyWishFooter;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (LuckyMoneyWishFooter.a(this.kXP).getText() != null) {
            LuckyMoneyWishFooter.a(this.kXP).requestFocus();
            boolean z = editable.length() > 0 && editable.toString().trim().length() > 0;
            if (z && this.kXP.kXL) {
                LuckyMoneyWishFooter.a(this.kXP, true);
                this.kXP.kXL = false;
            }
            if (!z) {
                LuckyMoneyWishFooter.a(this.kXP, false);
                this.kXP.kXL = true;
            }
        }
    }
}
