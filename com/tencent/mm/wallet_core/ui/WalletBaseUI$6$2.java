package com.tencent.mm.wallet_core.ui;

import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.wallet_core.ui.WalletBaseUI.6;

class WalletBaseUI$6$2 implements Runnable {
    final /* synthetic */ 6 uYV;

    WalletBaseUI$6$2(6 6) {
        this.uYV = 6;
    }

    public final void run() {
        this.uYV.uYT.Wq();
        if (this.uYV.eCF) {
            ((InputMethodManager) this.uYV.uYT.mController.tml.getSystemService("input_method")).showSoftInput(this.uYV.eCH, 0);
        }
    }
}
