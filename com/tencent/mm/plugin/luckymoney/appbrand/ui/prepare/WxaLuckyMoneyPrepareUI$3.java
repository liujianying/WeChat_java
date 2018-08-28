package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class WxaLuckyMoneyPrepareUI$3 implements OnClickListener {
    final /* synthetic */ EditText eCH;
    final /* synthetic */ WxaLuckyMoneyPrepareUI kMq;
    final /* synthetic */ EditText kMr;

    WxaLuckyMoneyPrepareUI$3(WxaLuckyMoneyPrepareUI wxaLuckyMoneyPrepareUI, EditText editText, EditText editText2) {
        this.kMq = wxaLuckyMoneyPrepareUI;
        this.eCH = editText;
        this.kMr = editText2;
    }

    public final void onClick(View view) {
        this.eCH.setOnClickListener(null);
        this.kMr.setOnClickListener(null);
        this.kMq.z(WxaLuckyMoneyPrepareUI.b(this.kMq), 2);
        this.kMq.z(WxaLuckyMoneyPrepareUI.c(this.kMq), 0);
        this.kMq.mKeyboard.setXMode(2);
        this.kMq.mKeyboard.setInputEditText(this.eCH);
        this.kMq.kMk.setVisibility(0);
    }
}
