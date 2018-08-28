package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class WalletBaseUI$7 implements OnClickListener {
    final /* synthetic */ boolean eCF;
    final /* synthetic */ EditText eCH;
    final /* synthetic */ int eCJ;
    final /* synthetic */ WalletBaseUI uYT;

    WalletBaseUI$7(WalletBaseUI walletBaseUI, boolean z, int i, EditText editText) {
        this.uYT = walletBaseUI;
        this.eCF = z;
        this.eCJ = i;
        this.eCH = editText;
    }

    public final void onClick(View view) {
        if (!this.uYT.kMk.isShown() && !this.eCF) {
            this.uYT.cDJ();
            this.uYT.Hb(this.eCJ);
        } else if (this.eCF) {
            this.uYT.Wq();
            ((InputMethodManager) this.uYT.mController.tml.getSystemService("input_method")).showSoftInput(this.eCH, 0);
        }
    }
}
