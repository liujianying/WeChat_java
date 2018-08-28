package com.tencent.mm.wallet_core.ui;

import android.os.Build.VERSION;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.model.q;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI.6;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

class WalletBaseUI$6$1 implements Runnable {
    final /* synthetic */ 6 uYV;
    final /* synthetic */ View val$view;

    WalletBaseUI$6$1(6 6, View view) {
        this.uYV = 6;
        this.val$view = view;
    }

    public final void run() {
        c cVar;
        if (!this.uYV.uYT.kMk.isShown() && this.val$view.isShown() && (this.uYV.eCG || this.uYV.uYT.uYS)) {
            this.uYV.uYT.uYS = true;
            this.uYV.uYT.cDJ();
        }
        if ((this.uYV.eCI instanceof WalletFormView) && VERSION.SDK_INT >= 14) {
            WalletFormView walletFormView = (WalletFormView) this.uYV.eCI;
            if ((q.GS() || walletFormView.getEncrptType() == 100) && (!q.GS() || walletFormView.getEncrptType() == 0)) {
                this.uYV.uYT.mKeyboard.resetSecureAccessibility();
                this.uYV.eCH.setAccessibilityDelegate(null);
            } else {
                cVar = new c();
                this.uYV.uYT.mKeyboard.setSecureAccessibility(cVar);
                this.uYV.eCH.setAccessibilityDelegate(cVar);
            }
        }
        if ((this.uYV.eCI instanceof EditHintPasswdView) && VERSION.SDK_INT >= 14) {
            cVar = new c();
            this.uYV.uYT.mKeyboard.setSecureAccessibility(cVar);
            this.uYV.eCH.setAccessibilityDelegate(cVar);
        }
        this.uYV.uYT.Hb(this.uYV.eCJ);
        this.uYV.uYT.mKeyboard.setInputEditText((EditText) this.val$view);
        ((InputMethodManager) this.uYV.uYT.mController.tml.getSystemService("input_method")).hideSoftInputFromWindow(this.val$view.getWindowToken(), 0);
    }
}
