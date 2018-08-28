package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class WxaLuckyMoneyPrepareUI$7 implements OnClickListener {
    final /* synthetic */ boolean eCF = false;
    final /* synthetic */ EditText eCH;
    final /* synthetic */ int eCJ;
    final /* synthetic */ WxaLuckyMoneyPrepareUI kMq;

    WxaLuckyMoneyPrepareUI$7(WxaLuckyMoneyPrepareUI wxaLuckyMoneyPrepareUI, int i, EditText editText) {
        this.kMq = wxaLuckyMoneyPrepareUI;
        this.eCJ = i;
        this.eCH = editText;
    }

    public final void onClick(View view) {
        if (!this.kMq.kMk.isShown() && !this.eCF) {
            this.kMq.kMk.setVisibility(0);
            this.kMq.mKeyboard.setInputEditText((EditText) view);
            WxaLuckyMoneyPrepareUI.b(this.kMq, this.eCJ);
        } else if (this.eCF) {
            this.kMq.kMk.setVisibility(8);
            ((InputMethodManager) this.kMq.mController.tml.getSystemService("input_method")).showSoftInput(this.eCH, 0);
        }
    }
}
