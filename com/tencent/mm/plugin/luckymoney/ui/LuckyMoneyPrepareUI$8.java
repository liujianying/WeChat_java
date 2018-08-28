package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class LuckyMoneyPrepareUI$8 implements OnClickListener {
    final /* synthetic */ EditText eCH;
    final /* synthetic */ EditText kMr;
    final /* synthetic */ LuckyMoneyPrepareUI kWX;

    LuckyMoneyPrepareUI$8(LuckyMoneyPrepareUI luckyMoneyPrepareUI, EditText editText, EditText editText2) {
        this.kWX = luckyMoneyPrepareUI;
        this.eCH = editText;
        this.kMr = editText2;
    }

    public final void onClick(View view) {
        this.eCH.setOnClickListener(null);
        this.kMr.setOnClickListener(null);
        this.kWX.z(LuckyMoneyPrepareUI.b(this.kWX), 2);
        this.kWX.z(LuckyMoneyPrepareUI.a(this.kWX), 0);
        this.kWX.mKeyboard.setXMode(0);
        this.kWX.mKeyboard.setInputEditText((EditText) view);
        this.kWX.kMk.setVisibility(0);
    }
}
