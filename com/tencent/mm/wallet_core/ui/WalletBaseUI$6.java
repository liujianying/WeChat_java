package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.ag;

class WalletBaseUI$6 implements OnFocusChangeListener {
    final /* synthetic */ boolean eCF;
    final /* synthetic */ boolean eCG;
    final /* synthetic */ EditText eCH;
    final /* synthetic */ View eCI;
    final /* synthetic */ int eCJ;
    final /* synthetic */ WalletBaseUI uYT;
    final /* synthetic */ OnFocusChangeListener uYU;

    WalletBaseUI$6(WalletBaseUI walletBaseUI, boolean z, boolean z2, View view, EditText editText, int i, OnFocusChangeListener onFocusChangeListener) {
        this.uYT = walletBaseUI;
        this.eCF = z;
        this.eCG = z2;
        this.eCI = view;
        this.eCH = editText;
        this.eCJ = i;
        this.uYU = onFocusChangeListener;
    }

    public final void onFocusChange(View view, boolean z) {
        if (!view.isFocused() || this.eCF) {
            new ag().postDelayed(new 2(this), 200);
        } else {
            ((InputMethodManager) this.uYT.mController.tml.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            new ag().postDelayed(new 1(this, view), 300);
        }
        if (this.uYU != null) {
            this.uYU.onFocusChange(view, z);
        }
    }
}
