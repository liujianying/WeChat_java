package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.ag;

class LuckyMoneyPrepareUI$25 implements OnClickListener {
    final /* synthetic */ boolean eCF = false;
    final /* synthetic */ EditText eCH;
    final /* synthetic */ View eCI;
    final /* synthetic */ int eCJ;
    final /* synthetic */ LuckyMoneyPrepareUI kWX;

    LuckyMoneyPrepareUI$25(LuckyMoneyPrepareUI luckyMoneyPrepareUI, EditText editText, View view, int i) {
        this.kWX = luckyMoneyPrepareUI;
        this.eCH = editText;
        this.eCI = view;
        this.eCJ = i;
    }

    public final void onClick(View view) {
        if (!this.kWX.kMk.isShown() || this.eCF) {
            if (!this.kWX.kMk.isShown() && !this.eCF) {
                ((InputMethodManager) this.kWX.mController.tml.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                new ag().postDelayed(new 1(this), 200);
            } else if (this.eCF) {
                this.kWX.kMk.setVisibility(8);
                ((InputMethodManager) this.kWX.mController.tml.getSystemService("input_method")).showSoftInput(this.eCH, 0);
            }
        } else if (this.kWX.mKeyboard != null) {
            this.kWX.mKeyboard.setInputEditText(this.eCH);
        }
    }
}
