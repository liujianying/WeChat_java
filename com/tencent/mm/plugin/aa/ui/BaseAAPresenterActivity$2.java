package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class BaseAAPresenterActivity$2 implements OnClickListener {
    final /* synthetic */ boolean eCF;
    final /* synthetic */ EditText eCH;
    final /* synthetic */ int eCJ;
    final /* synthetic */ BaseAAPresenterActivity eCK;

    BaseAAPresenterActivity$2(BaseAAPresenterActivity baseAAPresenterActivity, boolean z, EditText editText, int i) {
        this.eCK = baseAAPresenterActivity;
        this.eCF = z;
        this.eCH = editText;
        this.eCJ = i;
    }

    public final void onClick(View view) {
        if (!BaseAAPresenterActivity.h(this.eCK).isShown() && !this.eCF) {
            this.eCK.cDJ();
            BaseAAPresenterActivity.a(this.eCK, this.eCH);
            BaseAAPresenterActivity.b(this.eCK, this.eCJ);
        } else if (this.eCF) {
            this.eCK.Wq();
            ((InputMethodManager) this.eCK.mController.tml.getSystemService("input_method")).showSoftInput(this.eCH, 0);
        }
    }
}
