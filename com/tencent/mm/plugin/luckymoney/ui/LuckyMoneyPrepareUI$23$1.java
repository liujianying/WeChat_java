package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.23;

class LuckyMoneyPrepareUI$23$1 implements Runnable {
    final /* synthetic */ 23 kXb;
    final /* synthetic */ View val$view;

    LuckyMoneyPrepareUI$23$1(23 23, View view) {
        this.kXb = 23;
        this.val$view = view;
    }

    public final void run() {
        if (!this.kXb.kWX.kMk.isShown() && this.val$view.isShown()) {
            this.kXb.kWX.kMk.setVisibility(0);
        }
        LuckyMoneyPrepareUI.b(this.kXb.kWX, this.kXb.eCJ);
        this.kXb.kWX.mKeyboard.setInputEditText((EditText) this.val$view);
        ((InputMethodManager) this.kXb.kWX.mController.tml.getSystemService("input_method")).hideSoftInputFromWindow(this.val$view.getWindowToken(), 0);
    }
}
