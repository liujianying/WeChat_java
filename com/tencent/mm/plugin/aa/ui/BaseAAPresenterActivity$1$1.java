package com.tencent.mm.plugin.aa.ui;

import android.os.Build.VERSION;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity.1;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

class BaseAAPresenterActivity$1$1 implements Runnable {
    final /* synthetic */ 1 eCL;
    final /* synthetic */ View val$view;

    BaseAAPresenterActivity$1$1(1 1, View view) {
        this.eCL = 1;
        this.val$view = view;
    }

    public final void run() {
        c cVar;
        if (!BaseAAPresenterActivity.a(this.eCL.eCK).isShown() && this.val$view.isShown()) {
            if (this.eCL.eCG) {
                this.eCL.eCK.cDJ();
            } else if (!BaseAAPresenterActivity.b(this.eCL.eCK)) {
                this.eCL.eCK.cDJ();
            }
            BaseAAPresenterActivity.c(this.eCL.eCK);
            BaseAAPresenterActivity.a(this.eCL.eCK, this.eCL.eCH);
        }
        if ((this.eCL.eCI instanceof WalletFormView) && VERSION.SDK_INT >= 14) {
            WalletFormView walletFormView = (WalletFormView) this.eCL.eCI;
            if ((q.GS() || walletFormView.getEncrptType() == 100) && (!q.GS() || walletFormView.getEncrptType() == 0)) {
                BaseAAPresenterActivity.e(this.eCL.eCK).resetSecureAccessibility();
                this.eCL.eCH.setAccessibilityDelegate(null);
            } else {
                cVar = new c();
                BaseAAPresenterActivity.d(this.eCL.eCK).setSecureAccessibility(cVar);
                this.eCL.eCH.setAccessibilityDelegate(cVar);
            }
        }
        if ((this.eCL.eCI instanceof EditHintPasswdView) && VERSION.SDK_INT >= 14) {
            cVar = new c();
            BaseAAPresenterActivity.f(this.eCL.eCK).setSecureAccessibility(cVar);
            this.eCL.eCH.setAccessibilityDelegate(cVar);
        }
        BaseAAPresenterActivity.a(this.eCL.eCK, this.eCL.eCJ);
        BaseAAPresenterActivity.g(this.eCL.eCK).setInputEditText((EditText) this.val$view);
        ((InputMethodManager) this.eCL.eCK.mController.tml.getSystemService("input_method")).hideSoftInputFromWindow(this.val$view.getWindowToken(), 0);
    }
}
