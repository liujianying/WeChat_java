package com.tencent.mm.plugin.aa.ui;

import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity.1;

class BaseAAPresenterActivity$1$2 implements Runnable {
    final /* synthetic */ 1 eCL;

    BaseAAPresenterActivity$1$2(1 1) {
        this.eCL = 1;
    }

    public final void run() {
        this.eCL.eCK.Wq();
        if (this.eCL.eCF) {
            ((InputMethodManager) this.eCL.eCK.mController.tml.getSystemService("input_method")).showSoftInput(this.eCL.eCH, 0);
        }
    }
}
