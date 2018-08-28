package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.ag;

class WxaLuckyMoneyPrepareUI$8 implements OnClickListener {
    final /* synthetic */ boolean eCF = false;
    final /* synthetic */ EditText eCH;
    final /* synthetic */ View eCI;
    final /* synthetic */ int eCJ;
    final /* synthetic */ WxaLuckyMoneyPrepareUI kMq;

    WxaLuckyMoneyPrepareUI$8(WxaLuckyMoneyPrepareUI wxaLuckyMoneyPrepareUI, EditText editText, View view, int i) {
        this.kMq = wxaLuckyMoneyPrepareUI;
        this.eCH = editText;
        this.eCI = view;
        this.eCJ = i;
    }

    public final void onClick(View view) {
        if (!this.kMq.kMk.isShown() || this.eCF) {
            if (!this.kMq.kMk.isShown() && !this.eCF) {
                ((InputMethodManager) this.kMq.mController.tml.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                new ag().postDelayed(new 1(this), 200);
            } else if (this.eCF) {
                this.kMq.kMk.setVisibility(8);
                ((InputMethodManager) this.kMq.mController.tml.getSystemService("input_method")).showSoftInput(this.eCH, 0);
            }
        } else if (this.kMq.mKeyboard != null) {
            this.kMq.mKeyboard.setInputEditText(this.eCH);
        }
    }
}
