package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

class WalletPwdConfirmUI$3 implements a {
    final /* synthetic */ WalletPwdConfirmUI pxf;

    WalletPwdConfirmUI$3(WalletPwdConfirmUI walletPwdConfirmUI) {
        this.pxf = walletPwdConfirmUI;
    }

    public final void fE(boolean z) {
        if (z) {
            String string = this.pxf.sy.getString("key_new_pwd1");
            String md5Value = this.pxf.kkY.getMd5Value();
            if (string == null || !string.equals(md5Value)) {
                com.tencent.mm.wallet_core.a.m(this.pxf, -1002);
                return;
            }
            WalletPwdConfirmUI.b(this.pxf).setEnabled(z);
            WalletPwdConfirmUI.b(this.pxf).setClickable(z);
            return;
        }
        WalletPwdConfirmUI.b(this.pxf).setEnabled(z);
        WalletPwdConfirmUI.b(this.pxf).setClickable(z);
    }
}
