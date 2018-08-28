package com.tencent.mm.plugin.wallet_core.ui.view;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a.b;

class WalletPhoneInputView$3 implements b {
    final /* synthetic */ WalletPhoneInputView pzY;

    WalletPhoneInputView$3(WalletPhoneInputView walletPhoneInputView) {
        this.pzY = walletPhoneInputView;
    }

    public final boolean a(WalletFormView walletFormView) {
        if (this.pzY.bQM()) {
            return walletFormView.isPhoneNum();
        }
        if (bi.oW(WalletPhoneInputView.a(this.pzY)) || bi.oW(WalletPhoneInputView.b(this.pzY)) || bi.oW(WalletPhoneInputView.c(this.pzY).getText())) {
            return false;
        }
        return true;
    }

    public final boolean c(WalletFormView walletFormView, String str) {
        return false;
    }

    public final boolean d(WalletFormView walletFormView, String str) {
        return false;
    }

    public final boolean bqk() {
        return false;
    }

    public final String e(WalletFormView walletFormView, String str) {
        return null;
    }
}
