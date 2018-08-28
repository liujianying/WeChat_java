package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class SnsLuckyMoneyPrepareUI$21 implements OnClickListener {
    final /* synthetic */ EditText eCH;
    final /* synthetic */ EditText kMr;
    final /* synthetic */ SnsLuckyMoneyPrepareUI kTy;

    SnsLuckyMoneyPrepareUI$21(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI, EditText editText, EditText editText2) {
        this.kTy = snsLuckyMoneyPrepareUI;
        this.eCH = editText;
        this.kMr = editText2;
    }

    public final void onClick(View view) {
        this.eCH.setOnClickListener(null);
        this.kMr.setOnClickListener(null);
        this.kTy.z(this.kTy.kTn, 2);
        this.kTy.z(this.kTy.kMf, 0);
        this.kTy.mKeyboard.setXMode(0);
        this.kTy.mKeyboard.setInputEditText((EditText) view);
        SnsLuckyMoneyPrepareUI.k(this.kTy);
    }
}
