package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class SnsLuckyMoneyPrepareUI$12 implements OnClickListener {
    final /* synthetic */ boolean eCF = false;
    final /* synthetic */ EditText eCH;
    final /* synthetic */ int eCJ;
    final /* synthetic */ SnsLuckyMoneyPrepareUI kTy;

    SnsLuckyMoneyPrepareUI$12(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI, int i, EditText editText) {
        this.kTy = snsLuckyMoneyPrepareUI;
        this.eCJ = i;
        this.eCH = editText;
    }

    public final void onClick(View view) {
        if (!this.kTy.kMk.isShown() && !this.eCF) {
            SnsLuckyMoneyPrepareUI.k(this.kTy);
            SnsLuckyMoneyPrepareUI.b(this.kTy, this.eCJ);
        } else if (this.eCF) {
            this.kTy.Wq();
            ((InputMethodManager) this.kTy.mController.tml.getSystemService("input_method")).showSoftInput(this.eCH, 0);
        }
    }
}
