package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

class WxaLuckyMoneyPrepareUI$5 implements OnFocusChangeListener {
    final /* synthetic */ EditText eCH;
    final /* synthetic */ WxaLuckyMoneyPrepareUI kMq;
    final /* synthetic */ EditText kMr;

    WxaLuckyMoneyPrepareUI$5(WxaLuckyMoneyPrepareUI wxaLuckyMoneyPrepareUI, EditText editText, EditText editText2) {
        this.kMq = wxaLuckyMoneyPrepareUI;
        this.eCH = editText;
        this.kMr = editText2;
    }

    public final void onFocusChange(View view, boolean z) {
        this.eCH.setOnClickListener(null);
        this.kMr.setOnClickListener(null);
        this.kMq.z(WxaLuckyMoneyPrepareUI.b(this.kMq), 2);
        this.kMq.z(WxaLuckyMoneyPrepareUI.c(this.kMq), 0);
    }
}
