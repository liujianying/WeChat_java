package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.10;

class SnsLuckyMoneyPrepareUI$10$1 implements Runnable {
    final /* synthetic */ 10 kTB;
    final /* synthetic */ View val$view;

    SnsLuckyMoneyPrepareUI$10$1(10 10, View view) {
        this.kTB = 10;
        this.val$view = view;
    }

    public final void run() {
        if (!this.kTB.kTy.kMk.isShown() && this.val$view.isShown()) {
            SnsLuckyMoneyPrepareUI.k(this.kTB.kTy);
        }
        this.kTB.kTy.mKeyboard.setXMode(this.kTB.eCJ);
        this.kTB.kTy.mKeyboard.setInputEditText((EditText) this.val$view);
        ((InputMethodManager) this.kTB.kTy.mController.tml.getSystemService("input_method")).hideSoftInputFromWindow(this.val$view.getWindowToken(), 0);
    }
}
