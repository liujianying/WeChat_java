package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

class LuckyMoneyPrepareUI$9 implements OnFocusChangeListener {
    final /* synthetic */ EditText eCH;
    final /* synthetic */ EditText kMr;
    final /* synthetic */ LuckyMoneyPrepareUI kWX;

    LuckyMoneyPrepareUI$9(LuckyMoneyPrepareUI luckyMoneyPrepareUI, EditText editText, EditText editText2) {
        this.kWX = luckyMoneyPrepareUI;
        this.eCH = editText;
        this.kMr = editText2;
    }

    public final void onFocusChange(View view, boolean z) {
        this.eCH.setOnClickListener(null);
        this.kMr.setOnClickListener(null);
        this.kWX.z(LuckyMoneyPrepareUI.b(this.kWX), 2);
        this.kWX.z(LuckyMoneyPrepareUI.a(this.kWX), 0);
    }
}
