package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.6;

class WxaLuckyMoneyPrepareUI$6$1 implements Runnable {
    final /* synthetic */ 6 kMs;
    final /* synthetic */ View val$view;

    WxaLuckyMoneyPrepareUI$6$1(6 6, View view) {
        this.kMs = 6;
        this.val$view = view;
    }

    public final void run() {
        if (!this.kMs.kMq.kMk.isShown() && this.val$view.isShown()) {
            this.kMs.kMq.kMk.setVisibility(0);
        }
        WxaLuckyMoneyPrepareUI.b(this.kMs.kMq, this.kMs.eCJ);
        this.kMs.kMq.mKeyboard.setInputEditText((EditText) this.val$view);
        ((InputMethodManager) this.kMs.kMq.mController.tml.getSystemService("input_method")).hideSoftInputFromWindow(this.val$view.getWindowToken(), 0);
    }
}
