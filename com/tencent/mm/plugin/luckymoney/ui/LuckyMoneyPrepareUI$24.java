package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class LuckyMoneyPrepareUI$24 implements OnClickListener {
    final /* synthetic */ boolean eCF = false;
    final /* synthetic */ EditText eCH;
    final /* synthetic */ int eCJ;
    final /* synthetic */ LuckyMoneyPrepareUI kWX;

    LuckyMoneyPrepareUI$24(LuckyMoneyPrepareUI luckyMoneyPrepareUI, int i, EditText editText) {
        this.kWX = luckyMoneyPrepareUI;
        this.eCJ = i;
        this.eCH = editText;
    }

    public final void onClick(View view) {
        if (!this.kWX.kMk.isShown() && !this.eCF) {
            this.kWX.kMk.setVisibility(0);
            this.kWX.mKeyboard.setInputEditText((EditText) view);
            LuckyMoneyPrepareUI.b(this.kWX, this.eCJ);
        } else if (this.eCF) {
            this.kWX.kMk.setVisibility(8);
            ((InputMethodManager) this.kWX.mController.tml.getSystemService("input_method")).showSoftInput(this.eCH, 0);
        }
    }
}
