package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.ag;

class WxaLuckyMoneyPrepareUI$6 implements OnFocusChangeListener {
    final /* synthetic */ boolean eCF = false;
    final /* synthetic */ EditText eCH;
    final /* synthetic */ int eCJ;
    final /* synthetic */ WxaLuckyMoneyPrepareUI kMq;

    WxaLuckyMoneyPrepareUI$6(WxaLuckyMoneyPrepareUI wxaLuckyMoneyPrepareUI, int i, EditText editText) {
        this.kMq = wxaLuckyMoneyPrepareUI;
        this.eCJ = i;
        this.eCH = editText;
    }

    public final void onFocusChange(View view, boolean z) {
        if (!view.isFocused() || this.eCF) {
            new ag().postDelayed(new 2(this), 200);
            return;
        }
        ((InputMethodManager) this.kMq.mController.tml.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        new ag().postDelayed(new 1(this, view), 300);
    }
}
